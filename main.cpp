/**
 * This file is part of DSO.
 * 
 * Copyright 2016 Technical University of Munich and Intel.
 * Developed by Jakob Engel <engelj at in dot tum dot de>,
 * for more information see <http://vision.in.tum.de/dso>.
 * If you use this code, please cite the respective publications as
 * listed on the above website.
 *
 * DSO is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * DSO is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with DSO. If not, see <http://www.gnu.org/licenses/>.
 */





#include <locale.h>
#include <signal.h>
#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>

#include "util/settings.h"
#include "FullSystem/FullSystem.h"
#include "util/Undistort.h"
#include "IOWrapper/Pangolin/PangolinDSOViewer.h"
#include "IOWrapper/OutputWrapper/SampleOutputWrapper.h"


#include <ros/ros.h>
#include <sensor_msgs/image_encodings.h>
#include <sensor_msgs/Image.h>
#include <sensor_msgs/CameraInfo.h>
#include <geometry_msgs/PoseStamped.h>
#include "cv_bridge/cv_bridge.h"

#include "std_msgs/Int64.h"
#include "std_msgs/Int64MultiArray.h"
#include "std_msgs/Float32MultiArray.h"
#include "std_msgs/Float64MultiArray.h"

#include <sensor_msgs/PointCloud2.h>
#include <geometry_msgs/PoseStamped.h>
#include <pcl_ros/point_cloud.h>



std::string calib = "";
std::string vignetteFile = "";
std::string gammaFile = "";
bool useSampleOutput=false;

using namespace dso;

// --------------------------------------------------
// DSO ROS Output Wrapper
class ROSOutputWrapper : public dso::IOWrap::Output3DWrapper {
public:
  ROSOutputWrapper(ros::NodeHandle& nh) {
    calib_pose_points_pub = nh.advertise<std_msgs::Float32MultiArray>("dso/KF_ID_calib_pose_points", 10);
    current_cam_pose_pub = nh.advertise<std_msgs::Float64MultiArray>("dso/current_pose", 10);
    active_pose_pub = nh.advertise<std_msgs::Float64MultiArray>("dso/active_poses", 10);
    inlier_points_pub = nh.advertise<std_msgs::Float64MultiArray>("dso/inlier_points", 10);

    pose_pub = nh.advertise<geometry_msgs::PoseStamped>("dso/vodom", 10);
    points_pub = nh.advertise<sensor_msgs::PointCloud2>("dso/points", 10);
  }

  ~ROSOutputWrapper() {
    printf("~ROSOutputWrapper()");
  }

  void publishCamPose(FrameShell* frame, CalibHessian* HCalib) override {
    //--------------------------------------------------
    // current_cam_pose_pub
    const Eigen::Matrix<Sophus::SE3Group<double>::Scalar, 3, 4> mTwc = frame->camToWorld.matrix3x4();
    std_msgs::Float64MultiArray dso_current_pose_msg;
    for (size_t i =0, size = mTwc.size(); i< size; i++) dso_current_pose_msg.data.push_back(*(mTwc.data()+i));
    current_cam_pose_pub.publish(dso_current_pose_msg);

    //--------------------------------------------------
    // pose_pub
    Eigen::Quaterniond quat(frame->camToWorld.rotationMatrix());
    Eigen::Vector3d trans = frame->camToWorld.translation();
    geometry_msgs::PoseStamped pose_msg;
    pose_msg.header.stamp = ros::Time(frame->timestamp);
    pose_msg.header.frame_id = "vodom";
    pose_msg.pose.position.x = trans.x();
    pose_msg.pose.position.y = trans.y();
    pose_msg.pose.position.z = trans.z();
    pose_msg.pose.orientation.w = quat.w();
    pose_msg.pose.orientation.x = quat.x();
    pose_msg.pose.orientation.y = quat.y();
    pose_msg.pose.orientation.z = quat.z();
    pose_pub.publish(pose_msg);
  }

  void publishKeyframes(std::vector<FrameHessian*> &frames, bool final, CalibHessian* HCalib) {
    if (!final) {
      return;
    }
    float fx = HCalib->fxl();
    float fy = HCalib->fyl();
    float cx = HCalib->cxl();
    float cy = HCalib->cyl();
    float fxi = 1/fx;
    float fyi = 1/fy;
    float cxi = -cx / fx;
    float cyi = -cy / fy;
    // Open stream to write in file "points.ply"
    std::ofstream output_points;
    output_points.open("points.ply", std::ios_base::app);
    // point cloud
    pcl::PointCloud<pcl::PointXYZ>::Ptr cloud(new pcl::PointCloud<pcl::PointXYZ>());
    for(FrameHessian* f : frames) {
      auto const & m =  f->shell->camToWorld.matrix3x4();
      auto const & points = f->pointHessiansMarginalized;
      for (auto const * p : points) {
    	float depth = 1.0f / p->idepth;
    	auto const x = (p->u * fxi + cxi) * depth;
    	auto const y = (p->v * fyi + cyi) * depth;
    	auto const z = depth * (1 + 2*fxi);
    	Eigen::Vector4d camPoint(x, y, z, 1.f);
    	Eigen::Vector3d worldPoint = m * camPoint;
    	output_points << worldPoint.transpose() << std::endl;
        pcl::PointXYZ pt;
        pt.getVector3fMap() = worldPoint.cast<float>();
        cloud->push_back(pt);
      }
    }
    // Close steam
    output_points.close();
    // publish point cloud
    cloud->header.frame_id = "world";
    cloud->width = cloud->size();
    cloud->height = 1;
    cloud->is_dense = false;
    points_pub.publish(cloud);
    

    // // Open stream to write in file "points.ply"
    // std::ofstream output_points;
    // output_points.open("points.ply", std::ios_base::app);
    // pcl::PointCloud<pcl::PointXYZ>::Ptr cloud(new pcl::PointCloud<pcl::PointXYZ>());
    // for(const auto* frame : frames) {
    //   double fxi = HCalib->fxli();
    //   double fyi = HCalib->fyli();
    //   double cxi = HCalib->cxli();
    //   double cyi = HCalib->cyli();
    //   auto const & cam2world=  frame->shell->camToWorld.matrix3x4();

    //   for (auto const* p : frame->pointHessiansMarginalized) {
    // 	// convert [u, v, depth] to [x, y, z]
    //     float depth = 1.0f / p->idepth;
    //     auto const x = (p->u * fxi + cxi) * depth;
    //     auto const y = (p->v * fyi + cyi) * depth;
    //     auto const z = depth * (1 + 2*fxi);

    //     Eigen::Vector3d world_point = cam2world * Eigen::Vector4d(x, y, z, 1.f);

    //     pcl::PointXYZ pt;
    //     pt.getVector3fMap() = world_point.cast<float>();
    //     cloud->push_back(pt);
    // 	output_points << world_point.transpose() << std::endl;
    //   }
    // }

    // output_points.close();

    // cloud->header.frame_id = "world";
    // cloud->width = cloud->size();
    // cloud->height = 1;
    // cloud->is_dense = false;
    // points_pub.publish(cloud);

    

    

    //--------------------------------------------------
    // todo current_cam_pose_pub
    
  }

private:
  ros::Publisher calib_pose_points_pub;
  ros::Publisher current_cam_pose_pub;
  ros::Publisher active_pose_pub;
  ros::Publisher inlier_points_pub;

  ros::Publisher pose_pub;
  ros::Publisher points_pub;
};

void parseArgument(char* arg)
{
  int option;
  char buf[1000];

  if(1==sscanf(arg,"sampleoutput=%d",&option))
    {
      if(option==1)
	{
	  useSampleOutput = true;
	  printf("USING SAMPLE OUTPUT WRAPPER!\n");
	}
      return;
    }

  if(1==sscanf(arg,"quiet=%d",&option))
    {
      if(option==1)
	{
	  setting_debugout_runquiet = true;
	  printf("QUIET MODE, I'll shut up!\n");
	}
      return;
    }


  if(1==sscanf(arg,"nolog=%d",&option))
    {
      if(option==1)
	{
	  setting_logStuff = false;
	  printf("DISABLE LOGGING!\n");
	}
      return;
    }

  if(1==sscanf(arg,"nogui=%d",&option))
    {
      if(option==1)
	{
	  disableAllDisplay = true;
	  printf("NO GUI!\n");
	}
      return;
    }
  if(1==sscanf(arg,"nomt=%d",&option))
    {
      if(option==1)
	{
	  multiThreading = false;
	  printf("NO MultiThreading!\n");
	}
      return;
    }
  if(1==sscanf(arg,"calib=%s",buf))
    {
      calib = buf;
      printf("loading calibration from %s!\n", calib.c_str());
      return;
    }
  if(1==sscanf(arg,"vignette=%s",buf))
    {
      vignetteFile = buf;
      printf("loading vignette from %s!\n", vignetteFile.c_str());
      return;
    }

  if(1==sscanf(arg,"gamma=%s",buf))
    {
      gammaFile = buf;
      printf("loading gammaCalib from %s!\n", gammaFile.c_str());
      return;
    }

  printf("could not parse argument \"%s\"!!\n", arg);
}




FullSystem* fullSystem = 0;
Undistort* undistorter = 0;
int frameID = 0;

void vidCb(const sensor_msgs::ImageConstPtr img)
{
  cv_bridge::CvImagePtr cv_ptr = cv_bridge::toCvCopy(img, sensor_msgs::image_encodings::MONO8);
  assert(cv_ptr->image.type() == CV_8U);
  assert(cv_ptr->image.channels() == 1);


  if(setting_fullResetRequested)
    {
      std::vector<IOWrap::Output3DWrapper*> wraps = fullSystem->outputWrapper;
      delete fullSystem;
      for(IOWrap::Output3DWrapper* ow : wraps) ow->reset();
      fullSystem = new FullSystem();
      fullSystem->linearizeOperation=false;
      fullSystem->outputWrapper = wraps;
      if(undistorter->photometricUndist != 0)
	fullSystem->setGammaFunction(undistorter->photometricUndist->getG());
      setting_fullResetRequested=false;
    }

  MinimalImageB minImg((int)cv_ptr->image.cols, (int)cv_ptr->image.rows,(unsigned char*)cv_ptr->image.data);
  ImageAndExposure* undistImg = undistorter->undistort<unsigned char>(&minImg, 1,0, 1.0f);
  fullSystem->addActiveFrame(undistImg, frameID);
  frameID++;
  delete undistImg;

}





int main( int argc, char** argv )
{
  ros::init(argc, argv, "dso_live");



  for(int i=1; i<argc;i++) parseArgument(argv[i]);


  setting_desiredImmatureDensity = 1000;
  setting_desiredPointDensity = 1200;
  setting_minFrames = 5;
  setting_maxFrames = 7;
  setting_maxOptIterations=4;
  setting_minOptIterations=1;
  setting_logStuff = false;
  setting_kfGlobalWeight = 1.3;


  printf("MODE WITH CALIBRATION, but without exposure times!\n");
  setting_photometricCalibration = 2;
  setting_affineOptModeA = 0;
  setting_affineOptModeB = 0;



  undistorter = Undistort::getUndistorterForFile(calib, gammaFile, vignetteFile);

  setGlobalCalib(
		 (int)undistorter->getSize()[0],
		 (int)undistorter->getSize()[1],
		 undistorter->getK().cast<float>());


  fullSystem = new FullSystem();
  fullSystem->linearizeOperation=false;


  if(!disableAllDisplay)
    fullSystem->outputWrapper.push_back(new IOWrap::PangolinDSOViewer(
								      (int)undistorter->getSize()[0],
								      (int)undistorter->getSize()[1]));


  if(useSampleOutput)
    fullSystem->outputWrapper.push_back(new IOWrap::SampleOutputWrapper());


  if(undistorter->photometricUndist != 0)
    fullSystem->setGammaFunction(undistorter->photometricUndist->getG());

  ros::NodeHandle nh;
  ros::Subscriber imgSub = nh.subscribe("image", 1, &vidCb);

  // register output wrapper
  fullSystem->outputWrapper.push_back(new ROSOutputWrapper(nh));

  ros::spin();

  for(IOWrap::Output3DWrapper* ow : fullSystem->outputWrapper)
    {
      ow->join();
      delete ow;
    }

  delete undistorter;
  delete fullSystem;

  return 0;
}

