// Targeted by JavaCPP version 1.5.5: DO NOT EDIT THIS FILE

package org.bytedeco.arrow;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.arrow.global.arrow.*;


@Namespace("arrow::io") @NoOffset @Properties(inherit = org.bytedeco.arrow.presets.arrow.class)
public class HadoopFileSystem extends IOFileSystem {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public HadoopFileSystem(Pointer p) { super(p); }


  // Connect to an HDFS cluster given a configuration
  //
  // @param config (in): configuration for connecting
  // @param fs (out): the created client
  // @returns Status
  public static native @ByVal Status Connect(@Const HdfsConnectionConfig config,
                          @SharedPtr HadoopFileSystem fs);

  // Create directory and all parents
  //
  // @param path (in): absolute HDFS path
  // @returns Status
  public native @ByVal Status MakeDirectory(@StdString String path);
  public native @ByVal Status MakeDirectory(@StdString BytePointer path);

  // Delete file or directory
  // @param path absolute path to data
  // @param recursive if path is a directory, delete contents as well
  // @returns error status on failure
  public native @ByVal Status Delete(@StdString String path, @Cast("bool") boolean recursive/*=false*/);
  public native @ByVal Status Delete(@StdString String path);
  public native @ByVal Status Delete(@StdString BytePointer path, @Cast("bool") boolean recursive/*=false*/);
  public native @ByVal Status Delete(@StdString BytePointer path);

  public native @ByVal Status DeleteDirectory(@StdString String path);
  public native @ByVal Status DeleteDirectory(@StdString BytePointer path);

  // Disconnect from cluster
  //
  // @returns Status
  public native @ByVal Status Disconnect();

  // @param path (in): absolute HDFS path
  // @returns bool, true if the path exists, false if not (or on error)
  public native @Cast("bool") boolean Exists(@StdString String path);
  public native @Cast("bool") boolean Exists(@StdString BytePointer path);

  // @param path (in): absolute HDFS path
  // @param info (out)
  // @returns Status
  public native @ByVal Status GetPathInfo(@StdString String path, HdfsPathInfo info);
  public native @ByVal Status GetPathInfo(@StdString BytePointer path, HdfsPathInfo info);

  // @param nbytes (out): total capacity of the filesystem
  // @returns Status
  public native @ByVal Status GetCapacity(@Cast("int64_t*") LongPointer nbytes);
  public native @ByVal Status GetCapacity(@Cast("int64_t*") LongBuffer nbytes);
  public native @ByVal Status GetCapacity(@Cast("int64_t*") long[] nbytes);

  // @param nbytes (out): total bytes used of the filesystem
  // @returns Status
  public native @ByVal Status GetUsed(@Cast("int64_t*") LongPointer nbytes);
  public native @ByVal Status GetUsed(@Cast("int64_t*") LongBuffer nbytes);
  public native @ByVal Status GetUsed(@Cast("int64_t*") long[] nbytes);

  
  ///
  public native @ByVal Status GetChildren(@StdString String path, StringVector listing);
  public native @ByVal Status GetChildren(@StdString BytePointer path, StringVector listing);

  /** List directory contents
   * 
   *  If path is a relative path, returned values will be absolute paths or URIs
   *  starting from the current working directory. */
  
  ///
  public native @ByVal Status ListDirectory(@StdString String path, @StdVector HdfsPathInfo listing);
  public native @ByVal Status ListDirectory(@StdString BytePointer path, @StdVector HdfsPathInfo listing);

  /** Return the filesystem's current working directory.
   * 
   *  The working directory is the base path for all relative paths given to
   *  other APIs.
   *  NOTE: this actually returns a URI. */
  
  ///
  public native @ByVal Status GetWorkingDirectory(@StdString @Cast({"char*", "std::string*"}) BytePointer out);

  /** Change
   * 
   *  @param path file path to change
   *  @param owner pass null for no change
   *  @param group pass null for no change */
  
  ///
  public native @ByVal Status Chown(@StdString String path, String owner, String group);
  public native @ByVal Status Chown(@StdString BytePointer path, @Cast("const char*") BytePointer owner, @Cast("const char*") BytePointer group);

  /** Change path permissions
   * 
   *  @param path Absolute path in file system
   *  @param mode Mode bitset
   *  @return Status */
  public native @ByVal Status Chmod(@StdString String path, int mode);
  public native @ByVal Status Chmod(@StdString BytePointer path, int mode);

  // Move file or directory from source path to destination path within the
  // current filesystem
  public native @ByVal Status Rename(@StdString String src, @StdString String dst);
  public native @ByVal Status Rename(@StdString BytePointer src, @StdString BytePointer dst);

  public native @ByVal Status Stat(@StdString String path, FileStatistics stat);
  public native @ByVal Status Stat(@StdString BytePointer path, FileStatistics stat);

  // TODO(wesm): GetWorkingDirectory, SetWorkingDirectory

  // Open an HDFS file in READ mode. Returns error
  // status if the file is not found.
  //
  // @param path complete file path
  public native @ByVal Status OpenReadable(@StdString String path, int buffer_size,
                        @SharedPtr HdfsReadableFile file);
  public native @ByVal Status OpenReadable(@StdString BytePointer path, int buffer_size,
                        @SharedPtr HdfsReadableFile file);

  public native @ByVal Status OpenReadable(@StdString String path, @SharedPtr HdfsReadableFile file);
  public native @ByVal Status OpenReadable(@StdString BytePointer path, @SharedPtr HdfsReadableFile file);

  // FileMode::WRITE options
  // @param path complete file path
  // @param buffer_size 0 by default
  // @param replication 0 by default
  // @param default_block_size 0 by default
  public native @ByVal Status OpenWritable(@StdString String path, @Cast("bool") boolean append, int buffer_size,
                        short replication, @Cast("int64_t") long default_block_size,
                        @SharedPtr HdfsOutputStream file);
  public native @ByVal Status OpenWritable(@StdString BytePointer path, @Cast("bool") boolean append, int buffer_size,
                        short replication, @Cast("int64_t") long default_block_size,
                        @SharedPtr HdfsOutputStream file);

  public native @ByVal Status OpenWritable(@StdString String path, @Cast("bool") boolean append,
                        @SharedPtr HdfsOutputStream file);
  public native @ByVal Status OpenWritable(@StdString BytePointer path, @Cast("bool") boolean append,
                        @SharedPtr HdfsOutputStream file);
}
