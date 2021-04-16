// Targeted by JavaCPP version 1.5.5: DO NOT EDIT THIS FILE

package org.bytedeco.arrow;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.arrow.global.arrow.*;


/** \brief A FileSystem implementation accessing files on the local machine.
 * 
 *  This class handles only {@code /}-separated paths.  If desired, conversion
 *  from Windows backslash-separated paths should be done by the caller.
 *  Details such as symlinks are abstracted away (symlinks are always
 *  followed, except when deleting an entry). */
@Namespace("arrow::fs") @NoOffset @Properties(inherit = org.bytedeco.arrow.presets.arrow.class)
public class LocalFileSystem extends FileSystem {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public LocalFileSystem(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public LocalFileSystem(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public LocalFileSystem position(long position) {
        return (LocalFileSystem)super.position(position);
    }
    @Override public LocalFileSystem getPointer(long i) {
        return new LocalFileSystem((Pointer)this).position(position + i);
    }

  public LocalFileSystem() { super((Pointer)null); allocate(); }
  private native void allocate();
  public LocalFileSystem(@Const @ByRef LocalFileSystemOptions arg0) { super((Pointer)null); allocate(arg0); }
  private native void allocate(@Const @ByRef LocalFileSystemOptions arg0);

  public native @StdString String type_name();

  public native @ByVal StringResult NormalizePath(@StdString String path);
  public native @ByVal StringResult NormalizePath(@StdString BytePointer path);

  public native @Cast("bool") boolean Equals(@Const @ByRef FileSystem other);

  public native @ByVal LocalFileSystemOptions options();

  /** \cond FALSE */
  /** \endcond */
  public native @ByVal FileInfoResult GetFileInfo(@StdString String path);
  public native @ByVal FileInfoResult GetFileInfo(@StdString BytePointer path);
  public native @ByVal FileInfoVectorResult GetFileInfo(@Const @ByRef FileSelector select);

  public native @ByVal Status CreateDir(@StdString String path, @Cast("bool") boolean recursive/*=true*/);
  public native @ByVal Status CreateDir(@StdString String path);
  public native @ByVal Status CreateDir(@StdString BytePointer path, @Cast("bool") boolean recursive/*=true*/);
  public native @ByVal Status CreateDir(@StdString BytePointer path);

  public native @ByVal Status DeleteDir(@StdString String path);
  public native @ByVal Status DeleteDir(@StdString BytePointer path);
  public native @ByVal Status DeleteDirContents(@StdString String path);
  public native @ByVal Status DeleteDirContents(@StdString BytePointer path);
  public native @ByVal Status DeleteRootDirContents();

  public native @ByVal Status DeleteFile(@StdString String path);
  public native @ByVal Status DeleteFile(@StdString BytePointer path);

  public native @ByVal Status Move(@StdString String src, @StdString String dest);
  public native @ByVal Status Move(@StdString BytePointer src, @StdString BytePointer dest);

  public native @ByVal Status CopyFile(@StdString String src, @StdString String dest);
  public native @ByVal Status CopyFile(@StdString BytePointer src, @StdString BytePointer dest);

  public native @ByVal InputStreamResult OpenInputStream(
        @StdString String path);
  public native @ByVal InputStreamResult OpenInputStream(
        @StdString BytePointer path);
  public native @ByVal RandomAccessFileResult OpenInputFile(
        @StdString String path);
  public native @ByVal RandomAccessFileResult OpenInputFile(
        @StdString BytePointer path);
  public native @ByVal OutputStreamResult OpenOutputStream(
        @StdString String path);
  public native @ByVal OutputStreamResult OpenOutputStream(
        @StdString BytePointer path);
  public native @ByVal OutputStreamResult OpenAppendStream(
        @StdString String path);
  public native @ByVal OutputStreamResult OpenAppendStream(
        @StdString BytePointer path);
}
