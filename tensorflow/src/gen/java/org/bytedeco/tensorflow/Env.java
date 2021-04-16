// Targeted by JavaCPP version 1.5.5: DO NOT EDIT THIS FILE

package org.bytedeco.tensorflow;

import org.bytedeco.tensorflow.Allocator;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.tensorflow.global.tensorflow.*;


/** \brief An interface used by the tensorflow implementation to
 *  access operating system functionality like the filesystem etc.
 * 
 *  Callers may wish to provide a custom Env object to get fine grain
 *  control.
 * 
 *  All Env implementations are safe for concurrent access from
 *  multiple threads without any external synchronization. */
@Namespace("tensorflow") @NoOffset @Properties(inherit = org.bytedeco.tensorflow.presets.tensorflow.class)
public class Env extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public Env(Pointer p) { super(p); }


  /** \brief Returns a default environment suitable for the current operating
   *  system.
   * 
   *  Sophisticated users may wish to provide their own Env
   *  implementation instead of relying on this default environment.
   * 
   *  The result of Default() belongs to this library and must never be deleted. */
  public static native Env Default();

  /** \brief Returns the FileSystem object to handle operations on the file
   *  specified by 'fname'. The FileSystem object is used as the implementation
   *  for the file system related (non-virtual) functions that follow.
   *  Returned FileSystem object is still owned by the Env object and will */
  // (might) be destroyed when the environment is destroyed.
  public native @ByVal Status GetFileSystemForFile(@StdString BytePointer fname, @Cast("tensorflow::FileSystem**") PointerPointer result);
  public native @ByVal Status GetFileSystemForFile(@StdString BytePointer fname, @ByPtrPtr FileSystem result);
  public native @ByVal Status GetFileSystemForFile(@StdString String fname, @ByPtrPtr FileSystem result);

  /** \brief Returns the file system schemes registered for this Env. */
  public native @ByVal Status GetRegisteredFileSystemSchemes(StringVector schemes);

  /** \brief Register a file system for a scheme. */
  public native @ByVal Status RegisterFileSystem(@StdString BytePointer scheme,
                                      @ByVal @Cast("tensorflow::FileSystemRegistry::Factory*") FactoryFn factory);
  public native @ByVal Status RegisterFileSystem(@StdString String scheme,
                                      @ByVal @Cast("tensorflow::FileSystemRegistry::Factory*") FactoryFn factory);

  /** \brief Flush filesystem caches for all registered filesystems. */
  
  ///
  ///
  public native @ByVal Status FlushFileSystemCaches();

  /** \brief Creates a brand new random access read-only file with the
   *  specified name.
   <p>
   *  On success, stores a pointer to the new file in
   *  *result and returns OK.  On failure stores NULL in *result and
   *  returns non-OK.  If the file does not exist, returns a non-OK
   *  status.
   * 
   *  The returned file may be concurrently accessed by multiple threads.
   * 
   *  The ownership of the returned RandomAccessFile is passed to the caller
   *  and the object should be deleted when is not used. The file object
   *  shouldn't live longer than the Env object. */
  
  ///
  ///
  ///
  public native @ByVal Status NewRandomAccessFile(@StdString BytePointer fname,
                               @UniquePtr RandomAccessFile result);
  public native @ByVal Status NewRandomAccessFile(@StdString String fname,
                               @UniquePtr RandomAccessFile result);

  /** \brief Creates an object that writes to a new file with the specified
   *  name.
   * 
   *  Deletes any existing file with the same name and creates a
   *  new file.  On success, stores a pointer to the new file in
   *  *result and returns OK.  On failure stores NULL in *result and
   *  returns non-OK.
   * 
   *  The returned file will only be accessed by one thread at a time.
   * 
   *  The ownership of the returned WritableFile is passed to the caller
   *  and the object should be deleted when is not used. The file object
   *  shouldn't live longer than the Env object. */
  
  ///
  ///
  ///
  public native @ByVal Status NewWritableFile(@StdString BytePointer fname,
                           @UniquePtr WritableFile result);
  public native @ByVal Status NewWritableFile(@StdString String fname,
                           @UniquePtr WritableFile result);

  /** \brief Creates an object that either appends to an existing file, or
   *  writes to a new file (if the file does not exist to begin with).
   * 
   *  On success, stores a pointer to the new file in *result and
   *  returns OK.  On failure stores NULL in *result and returns
   *  non-OK.
   * 
   *  The returned file will only be accessed by one thread at a time.
   * 
   *  The ownership of the returned WritableFile is passed to the caller
   *  and the object should be deleted when is not used. The file object
   *  shouldn't live longer than the Env object. */
  
  ///
  ///
  ///
  public native @ByVal Status NewAppendableFile(@StdString BytePointer fname,
                             @UniquePtr WritableFile result);
  public native @ByVal Status NewAppendableFile(@StdString String fname,
                             @UniquePtr WritableFile result);

  /** \brief Creates a readonly region of memory with the file context.
   * 
   *  On success, it returns a pointer to read-only memory region
   *  from the content of file fname. The ownership of the region is passed to
   *  the caller. On failure stores nullptr in *result and returns non-OK.
   * 
   *  The returned memory region can be accessed from many threads in parallel.
   * 
   *  The ownership of the returned ReadOnlyMemoryRegion is passed to the caller
   *  and the object should be deleted when is not used. The memory region
   *  object shouldn't live longer than the Env object. */
  public native @ByVal Status NewReadOnlyMemoryRegionFromFile(
        @StdString BytePointer fname, @UniquePtr ReadOnlyMemoryRegion result);
  public native @ByVal Status NewReadOnlyMemoryRegionFromFile(
        @StdString String fname, @UniquePtr ReadOnlyMemoryRegion result);

  /** Returns OK if the named path exists and NOT_FOUND otherwise. */
  public native @ByVal Status FileExists(@StdString BytePointer fname);
  public native @ByVal Status FileExists(@StdString String fname);

  /** Returns true if all the listed files exist, false otherwise.
   *  if status is not null, populate the vector with a detailed status
   *  for each file. */
  
  ///
  public native @Cast("bool") boolean FilesExist(@Const @ByRef StringVector files,
                    @StdVector Status status);

  /** \brief Stores in *result the names of the children of the specified
   *  directory. The names are relative to "dir".
   * 
   *  Original contents of *results are dropped. */
  public native @ByVal Status GetChildren(@StdString BytePointer dir, StringVector result);
  public native @ByVal Status GetChildren(@StdString String dir, StringVector result);

  /** \brief Returns true if the path matches the given pattern. The wildcards
   *  allowed in pattern are described in FileSystem::GetMatchingPaths. */
  
  ///
  public native @Cast("bool") boolean MatchPath(@StdString BytePointer path, @StdString BytePointer pattern);
  public native @Cast("bool") boolean MatchPath(@StdString String path, @StdString String pattern);

  /** \brief Given a pattern, stores in *results the set of paths that matches
   *  that pattern. *results is cleared.
   * 
   *  More details about {@code pattern} in FileSystem::GetMatchingPaths. */
  public native @ByVal Status GetMatchingPaths(@StdString BytePointer pattern,
                                    StringVector results);
  public native @ByVal Status GetMatchingPaths(@StdString String pattern,
                                    StringVector results);

  /** Deletes the named file. */
  
  ///
  ///
  ///
  ///
  ///
  public native @ByVal Status DeleteFile(@StdString BytePointer fname);
  public native @ByVal Status DeleteFile(@StdString String fname);

  /** \brief Deletes the specified directory and all subdirectories and files
   *  underneath it. This is accomplished by traversing the directory tree
   *  rooted at dirname and deleting entries as they are encountered.
   * 
   *  If dirname itself is not readable or does not exist, *undeleted_dir_count
   *  is set to 1, *undeleted_file_count is set to 0 and an appropriate status
   *  (e.g. NOT_FOUND) is returned.
   * 
   *  If dirname and all its descendants were successfully deleted, TF_OK is
   *  returned and both error counters are set to zero.
   * 
   *  Otherwise, while traversing the tree, undeleted_file_count and
   *  undeleted_dir_count are updated if an entry of the corresponding type
   *  could not be deleted. The returned error status represents the reason that
   *  any one of these entries could not be deleted.
   * 
   *  REQUIRES: undeleted_files, undeleted_dirs to be not null.
   * 
   *  Typical return codes:
   *   * OK - dirname exists and we were able to delete everything underneath.
   *   * NOT_FOUND - dirname doesn't exist
   *   * PERMISSION_DENIED - dirname or some descendant is not writable
   *   * UNIMPLEMENTED - Some underlying functions (like Delete) are not
   *                     implemented */
  public native @ByVal Status DeleteRecursively(@StdString BytePointer dirname, @Cast("tensorflow::int64*") LongPointer undeleted_files,
                             @Cast("tensorflow::int64*") LongPointer undeleted_dirs);
  public native @ByVal Status DeleteRecursively(@StdString String dirname, @Cast("tensorflow::int64*") LongBuffer undeleted_files,
                             @Cast("tensorflow::int64*") LongBuffer undeleted_dirs);
  public native @ByVal Status DeleteRecursively(@StdString BytePointer dirname, @Cast("tensorflow::int64*") long[] undeleted_files,
                             @Cast("tensorflow::int64*") long... undeleted_dirs);
  public native @ByVal Status DeleteRecursively(@StdString String dirname, @Cast("tensorflow::int64*") LongPointer undeleted_files,
                             @Cast("tensorflow::int64*") LongPointer undeleted_dirs);
  public native @ByVal Status DeleteRecursively(@StdString BytePointer dirname, @Cast("tensorflow::int64*") LongBuffer undeleted_files,
                             @Cast("tensorflow::int64*") LongBuffer undeleted_dirs);
  public native @ByVal Status DeleteRecursively(@StdString String dirname, @Cast("tensorflow::int64*") long[] undeleted_files,
                             @Cast("tensorflow::int64*") long... undeleted_dirs);

  /** \brief Creates the specified directory and all the necessary
   *  subdirectories. Typical return codes.
   *   * OK - successfully created the directory and sub directories, even if
   *          they were already created.
   *   * PERMISSION_DENIED - dirname or some subdirectory is not writable. */
  public native @ByVal Status RecursivelyCreateDir(@StdString BytePointer dirname);
  public native @ByVal Status RecursivelyCreateDir(@StdString String dirname);

  /** \brief Creates the specified directory. Typical return codes
   *   * OK - successfully created the directory.
   *   * ALREADY_EXISTS - directory already exists.
   *   * PERMISSION_DENIED - dirname is not writable. */
  public native @ByVal Status CreateDir(@StdString BytePointer dirname);
  public native @ByVal Status CreateDir(@StdString String dirname);

  /** Deletes the specified directory. */
  public native @ByVal Status DeleteDir(@StdString BytePointer dirname);
  public native @ByVal Status DeleteDir(@StdString String dirname);

  /** Obtains statistics for the given path. */
  public native @ByVal Status Stat(@StdString BytePointer fname, FileStatistics stat);
  public native @ByVal Status Stat(@StdString String fname, FileStatistics stat);

  /** \brief Returns whether the given path is a directory or not.
   *  Typical return codes (not guaranteed exhaustive):
   *   * OK - The path exists and is a directory.
   *   * FAILED_PRECONDITION - The path exists and is not a directory.
   *   * NOT_FOUND - The path entry does not exist.
   *   * PERMISSION_DENIED - Insufficient permissions.
   *   * UNIMPLEMENTED - The file factory doesn't support directories. */
  public native @ByVal Status IsDirectory(@StdString BytePointer fname);
  public native @ByVal Status IsDirectory(@StdString String fname);

  /** Stores the size of {@code fname} in {@code *file_size}. */
  public native @ByVal Status GetFileSize(@StdString BytePointer fname, @Cast("tensorflow::uint64*") LongPointer file_size);
  public native @ByVal Status GetFileSize(@StdString String fname, @Cast("tensorflow::uint64*") LongBuffer file_size);
  public native @ByVal Status GetFileSize(@StdString BytePointer fname, @Cast("tensorflow::uint64*") long... file_size);
  public native @ByVal Status GetFileSize(@StdString String fname, @Cast("tensorflow::uint64*") LongPointer file_size);
  public native @ByVal Status GetFileSize(@StdString BytePointer fname, @Cast("tensorflow::uint64*") LongBuffer file_size);
  public native @ByVal Status GetFileSize(@StdString String fname, @Cast("tensorflow::uint64*") long... file_size);

  /** \brief Renames file src to target. If target already exists, it will be
   *  replaced. */
  public native @ByVal Status RenameFile(@StdString BytePointer src, @StdString BytePointer target);
  public native @ByVal Status RenameFile(@StdString String src, @StdString String target);

  /** \brief Copy the src to target. */
  public native @ByVal Status CopyFile(@StdString BytePointer src, @StdString BytePointer target);
  public native @ByVal Status CopyFile(@StdString String src, @StdString String target);

  /** \brief Returns the absolute path of the current executable. It resolves
   *  symlinks if there is any. */
  public native @StdString BytePointer GetExecutablePath();

  /** Creates a local unique temporary file name. Returns true if success. */
  public native @Cast("bool") boolean LocalTempFilename(@StdString @Cast({"char*", "std::string*"}) BytePointer filename);

  /** Creates a local unique file name that starts with |prefix| and ends with
   *  |suffix|. Returns true if success. */
  public native @Cast("bool") boolean CreateUniqueFileName(@StdString @Cast({"char*", "std::string*"}) BytePointer prefix, @StdString BytePointer suffix);
  public native @Cast("bool") boolean CreateUniqueFileName(@StdString @Cast({"char*", "std::string*"}) BytePointer prefix, @StdString String suffix);

  /** \brief Return the runfiles directory if running under bazel. Returns
   *  the directory the executable is located in if not running under bazel. */
  public native @StdString BytePointer GetRunfilesDir();

  // TODO(jeff,sanjay): Add back thread/thread-pool support if needed.
  // TODO(jeff,sanjay): if needed, tighten spec so relative to epoch, or
  // provide a routine to get the absolute time.

  /** \brief Returns the number of nano-seconds since the Unix epoch. */
  public native @Cast("tensorflow::uint64") long NowNanos();

  /** \brief Returns the number of micro-seconds since the Unix epoch. */
  public native @Cast("tensorflow::uint64") long NowMicros();

  /** \brief Returns the number of seconds since the Unix epoch. */
  public native @Cast("tensorflow::uint64") long NowSeconds();

  /** Sleeps/delays the thread for the prescribed number of micro-seconds. */
  
  ///
  public native void SleepForMicroseconds(@Cast("tensorflow::int64") long micros);

  /** \brief Returns a new thread that is running fn() and is identified
   *  (for debugging/performance-analysis) by "name".
   * 
   *  Caller takes ownership of the result and must delete it eventually
   *  (the deletion will block until fn() stops running). */
  public native Thread StartThread(@Const @ByRef ThreadOptions thread_options,
                                @StdString BytePointer name,
                                @ByVal Fn fn);
  public native Thread StartThread(@Const @ByRef ThreadOptions thread_options,
                                @StdString String name,
                                @ByVal Fn fn);

  // Returns the thread id of calling thread.
  // Posix: Returns pthread id which is only guaranteed to be unique within a
  //        process.
  // Windows: Returns thread id which is unique.
  public native int GetCurrentThreadId();

  // Copies current thread name to "name". Returns true if success.
  public native @Cast("bool") boolean GetCurrentThreadName(@StdString @Cast({"char*", "std::string*"}) BytePointer name);

  // \brief Schedules the given closure on a thread-pool.
  //
  // NOTE(mrry): This closure may block.
  public native void SchedClosure(@ByVal Fn closure);

  // \brief Schedules the given closure on a thread-pool after the given number
  // of microseconds.
  //
  // NOTE(mrry): This closure must not block.
  public native void SchedClosureAfter(@Cast("tensorflow::int64") long micros,
                                   @ByVal Fn closure);

  // \brief Load a dynamic library.
  //
  // Pass "library_filename" to a platform-specific mechanism for dynamically
  // loading a library.  The rules for determining the exact location of the
  // library are platform-specific and are not documented here.
  //
  // On success, returns a handle to the library in "*handle" and returns
  // OK from the function.
  // Otherwise returns nullptr in "*handle" and an error status from the
  // function.
  public native @ByVal Status LoadLibrary(@Cast("const char*") BytePointer library_filename, @Cast("void**") PointerPointer handle);
  public native @ByVal Status LoadLibrary(@Cast("const char*") BytePointer library_filename, @Cast("void**") @ByPtrPtr Pointer handle);
  public native @ByVal Status LoadLibrary(String library_filename, @Cast("void**") @ByPtrPtr Pointer handle);

  // \brief Get a pointer to a symbol from a dynamic library.
  //
  // "handle" should be a pointer returned from a previous call to LoadLibrary.
  // On success, store a pointer to the located symbol in "*symbol" and return
  // OK from the function. Otherwise, returns nullptr in "*symbol" and an error
  // status from the function.
  public native @ByVal Status GetSymbolFromLibrary(Pointer handle, @Cast("const char*") BytePointer symbol_name,
                                        @Cast("void**") PointerPointer symbol);
  public native @ByVal Status GetSymbolFromLibrary(Pointer handle, @Cast("const char*") BytePointer symbol_name,
                                        @Cast("void**") @ByPtrPtr Pointer symbol);
  public native @ByVal Status GetSymbolFromLibrary(Pointer handle, String symbol_name,
                                        @Cast("void**") @ByPtrPtr Pointer symbol);

  // \brief build the name of dynamic library.
  //
  // "name" should be name of the library.
  // "version" should be the version of the library or NULL
  // returns the name that LoadLibrary() can use
  public native @StdString BytePointer FormatLibraryFileName(@StdString BytePointer name,
                                         @StdString BytePointer version);
  public native @StdString String FormatLibraryFileName(@StdString String name,
                                         @StdString String version);

  // Returns a possible list of local temporary directories.
  public native void GetLocalTempDirectories(StringVector list);
}
