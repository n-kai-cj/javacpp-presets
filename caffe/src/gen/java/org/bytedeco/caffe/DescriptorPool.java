// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.caffe;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import static org.bytedeco.openblas.global.openblas_nolapack.*;
import static org.bytedeco.openblas.global.openblas.*;
import org.bytedeco.opencv.opencv_core.*;
import static org.bytedeco.opencv.global.opencv_core.*;
import org.bytedeco.opencv.opencv_imgproc.*;
import static org.bytedeco.opencv.global.opencv_imgproc.*;
import static org.bytedeco.opencv.global.opencv_imgcodecs.*;
import org.bytedeco.opencv.opencv_videoio.*;
import static org.bytedeco.opencv.global.opencv_videoio.*;
import org.bytedeco.opencv.opencv_highgui.*;
import static org.bytedeco.opencv.global.opencv_highgui.*;
import org.bytedeco.hdf5.*;
import static org.bytedeco.hdf5.global.hdf5.*;

import static org.bytedeco.caffe.global.caffe.*;



// ===================================================================

// Used to construct descriptors.
//
// Normally you won't want to build your own descriptors.  Message classes
// constructed by the protocol compiler will provide them for you.  However,
// if you are implementing Message on your own, or if you are writing a
// program which can operate on totally arbitrary types and needs to load
// them from some sort of database, you might need to.
//
// Since Descriptors are composed of a whole lot of cross-linked bits of
// data that would be a pain to put together manually, the
// DescriptorPool class is provided to make the process easier.  It can
// take a FileDescriptorProto (defined in descriptor.proto), validate it,
// and convert it to a set of nicely cross-linked Descriptors.
//
// DescriptorPool also helps with memory management.  Descriptors are
// composed of many objects containing static data and pointers to each
// other.  In all likelihood, when it comes time to delete this data,
// you'll want to delete it all at once.  In fact, it is not uncommon to
// have a whole pool of descriptors all cross-linked with each other which
// you wish to delete all at once.  This class represents such a pool, and
// handles the memory management for you.
//
// You can also search for descriptors within a DescriptorPool by name, and
// extensions by number.
@Namespace("google::protobuf") @NoOffset @Properties(inherit = org.bytedeco.caffe.presets.caffe.class)
public class DescriptorPool extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public DescriptorPool(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public DescriptorPool(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public DescriptorPool position(long position) {
        return (DescriptorPool)super.position(position);
    }
    @Override public DescriptorPool getPointer(long i) {
        return new DescriptorPool(this).position(position + i);
    }

  // Create a normal, empty DescriptorPool.
  public DescriptorPool() { super((Pointer)null); allocate(); }
  private native void allocate();

  // Constructs a DescriptorPool that, when it can't find something among the
  // descriptors already in the pool, looks for it in the given
  // DescriptorDatabase.
  // Notes:
  // - If a DescriptorPool is constructed this way, its BuildFile*() methods
  //   must not be called (they will assert-fail).  The only way to populate
  //   the pool with descriptors is to call the Find*By*() methods.
  // - The Find*By*() methods may block the calling thread if the
  //   DescriptorDatabase blocks.  This in turn means that parsing messages
  //   may block if they need to look up extensions.
  // - The Find*By*() methods will use mutexes for thread-safety, thus making
  //   them slower even when they don't have to fall back to the database.
  //   In fact, even the Find*By*() methods of descriptor objects owned by
  //   this pool will be slower, since they will have to obtain locks too.
  // - An ErrorCollector may optionally be given to collect validation errors
  //   in files loaded from the database.  If not given, errors will be printed
  //   to GOOGLE_LOG(ERROR).  Remember that files are built on-demand, so this
  //   ErrorCollector may be called from any thread that calls one of the
  //   Find*By*() methods.
  // - The DescriptorDatabase must not be mutated during the lifetime of
  //   the DescriptorPool. Even if the client takes care to avoid data races,
  //   changes to the content of the DescriptorDatabase may not be reflected
  //   in subsequent lookups in the DescriptorPool.
  public DescriptorPool(DescriptorDatabase fallback_database,
                            ErrorCollector error_collector/*=NULL*/) { super((Pointer)null); allocate(fallback_database, error_collector); }
  private native void allocate(DescriptorDatabase fallback_database,
                            ErrorCollector error_collector/*=NULL*/);
  public DescriptorPool(DescriptorDatabase fallback_database) { super((Pointer)null); allocate(fallback_database); }
  private native void allocate(DescriptorDatabase fallback_database);

  // Get a pointer to the generated pool.  Generated protocol message classes
  // which are compiled into the binary will allocate their descriptors in
  // this pool.  Do not add your own descriptors to this pool.
  public static native @Const DescriptorPool generated_pool();


  // Find a FileDescriptor in the pool by file name.  Returns NULL if not
  // found.
  public native @Const FileDescriptor FindFileByName(@StdString BytePointer name);
  public native @Const FileDescriptor FindFileByName(@StdString String name);

  // Find the FileDescriptor in the pool which defines the given symbol.
  // If any of the Find*ByName() methods below would succeed, then this is
  // equivalent to calling that method and calling the result's file() method.
  // Otherwise this returns NULL.
  public native @Const FileDescriptor FindFileContainingSymbol(
        @StdString BytePointer symbol_name);
  public native @Const FileDescriptor FindFileContainingSymbol(
        @StdString String symbol_name);

  // Looking up descriptors ------------------------------------------
  // These find descriptors by fully-qualified name.  These will find both
  // top-level descriptors and nested descriptors.  They return NULL if not
  // found.

  public native @Const Descriptor FindMessageTypeByName(@StdString BytePointer name);
  public native @Const Descriptor FindMessageTypeByName(@StdString String name);
  public native @Const FieldDescriptor FindFieldByName(@StdString BytePointer name);
  public native @Const FieldDescriptor FindFieldByName(@StdString String name);
  public native @Const FieldDescriptor FindExtensionByName(@StdString BytePointer name);
  public native @Const FieldDescriptor FindExtensionByName(@StdString String name);
  public native @Const OneofDescriptor FindOneofByName(@StdString BytePointer name);
  public native @Const OneofDescriptor FindOneofByName(@StdString String name);
  public native @Const EnumDescriptor FindEnumTypeByName(@StdString BytePointer name);
  public native @Const EnumDescriptor FindEnumTypeByName(@StdString String name);
  public native @Const EnumValueDescriptor FindEnumValueByName(@StdString BytePointer name);
  public native @Const EnumValueDescriptor FindEnumValueByName(@StdString String name);
  public native @Const ServiceDescriptor FindServiceByName(@StdString BytePointer name);
  public native @Const ServiceDescriptor FindServiceByName(@StdString String name);
  public native @Const MethodDescriptor FindMethodByName(@StdString BytePointer name);
  public native @Const MethodDescriptor FindMethodByName(@StdString String name);

  // Finds an extension of the given type by number.  The extendee must be
  // a member of this DescriptorPool or one of its underlays.
  public native @Const FieldDescriptor FindExtensionByNumber(@Const Descriptor extendee,
                                                 int number);

  // Finds extensions of extendee. The extensions will be appended to
  // out in an undefined order. Only extensions defined directly in
  // this DescriptorPool or one of its underlays are guaranteed to be
  // found: extensions defined in the fallback database might not be found
  // depending on the database implementation.
  public native void FindAllExtensions(@Const Descriptor extendee,
                           FieldDescriptorVector out);

  // Building descriptors --------------------------------------------

  // When converting a FileDescriptorProto to a FileDescriptor, various
  // errors might be detected in the input.  The caller may handle these
  // programmatically by implementing an ErrorCollector.
  public static class ErrorCollector extends Pointer {
      static { Loader.load(); }
      /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
      public ErrorCollector(Pointer p) { super(p); }
  

    // These constants specify what exact part of the construct is broken.
    // This is useful e.g. for mapping the error back to an exact location
    // in a .proto file.
    /** enum google::protobuf::DescriptorPool::ErrorCollector::ErrorLocation */
    public static final int
      NAME = 0,              // the symbol name, or the package name for files
      NUMBER = 1,            // field or extension range number
      TYPE = 2,              // field type
      EXTENDEE = 3,          // field extendee
      DEFAULT_VALUE = 4,     // field default value
      INPUT_TYPE = 5,        // method input type
      OUTPUT_TYPE = 6,       // method output type
      OPTION_NAME = 7,       // name in assignment
      OPTION_VALUE = 8,      // value in option assignment
      OTHER = 9;              // some other problem

    // Reports an error in the FileDescriptorProto. Use this function if the
    // problem occurred should interrupt building the FileDescriptorProto.
    public native void AddError(
          @StdString BytePointer filename,
          @StdString BytePointer element_name,
          @Const Message descriptor,
          @Cast("google::protobuf::DescriptorPool::ErrorCollector::ErrorLocation") int location,
          @StdString BytePointer message
          );
    public native void AddError(
          @StdString String filename,
          @StdString String element_name,
          @Const Message descriptor,
          @Cast("google::protobuf::DescriptorPool::ErrorCollector::ErrorLocation") int location,
          @StdString String message
          );

    // Reports a warning in the FileDescriptorProto. Use this function if the
    // problem occurred should NOT interrupt building the FileDescriptorProto.
    public native void AddWarning(
          @StdString BytePointer arg0,
          @StdString BytePointer arg1,
          @Const Message arg2,
          @Cast("google::protobuf::DescriptorPool::ErrorCollector::ErrorLocation") int arg3,
          @StdString BytePointer arg4
          );
    public native void AddWarning(
          @StdString String arg0,
          @StdString String arg1,
          @Const Message arg2,
          @Cast("google::protobuf::DescriptorPool::ErrorCollector::ErrorLocation") int arg3,
          @StdString String arg4
          );
  }

  // Convert the FileDescriptorProto to real descriptors and place them in
  // this DescriptorPool.  All dependencies of the file must already be in
  // the pool.  Returns the resulting FileDescriptor, or NULL if there were
  // problems with the input (e.g. the message was invalid, or dependencies
  // were missing).  Details about the errors are written to GOOGLE_LOG(ERROR).
  public native @Const FileDescriptor BuildFile(@Const @ByRef FileDescriptorProto proto);

  // Same as BuildFile() except errors are sent to the given ErrorCollector.
  public native @Const FileDescriptor BuildFileCollectingErrors(
      @Const @ByRef FileDescriptorProto proto,
      ErrorCollector error_collector);

  // By default, it is an error if a FileDescriptorProto contains references
  // to types or other files that are not found in the DescriptorPool (or its
  // backing DescriptorDatabase, if any).  If you call
  // AllowUnknownDependencies(), however, then unknown types and files
  // will be replaced by placeholder descriptors (which can be identified by
  // the is_placeholder() method).  This can allow you to
  // perform some useful operations with a .proto file even if you do not
  // have access to other .proto files on which it depends.  However, some
  // heuristics must be used to fill in the gaps in information, and these
  // can lead to descriptors which are inaccurate.  For example, the
  // DescriptorPool may be forced to guess whether an unknown type is a message
  // or an enum, as well as what package it resides in.  Furthermore,
  // placeholder types will not be discoverable via FindMessageTypeByName()
  // and similar methods, which could confuse some descriptor-based algorithms.
  // Generally, the results of this option should be handled with extreme care.
  public native void AllowUnknownDependencies();

  // By default, weak imports are allowed to be missing, in which case we will
  // use a placeholder for the dependency and convert the field to be an Empty
  // message field. If you call EnforceWeakDependencies(true), however, the
  // DescriptorPool will report a import not found error.
  public native void EnforceWeakDependencies(@Cast("bool") boolean enforce);

  // Internal stuff --------------------------------------------------
  // These methods MUST NOT be called from outside the proto2 library.
  // These methods may contain hidden pitfalls and may be removed in a
  // future library version.

  // Create a DescriptorPool which is overlaid on top of some other pool.
  // If you search for a descriptor in the overlay and it is not found, the
  // underlay will be searched as a backup.  If the underlay has its own
  // underlay, that will be searched next, and so on.  This also means that
  // files built in the overlay will be cross-linked with the underlay's
  // descriptors if necessary.  The underlay remains property of the caller;
  // it must remain valid for the lifetime of the newly-constructed pool.
  //
  // Example:  Say you want to parse a .proto file at runtime in order to use
  // its type with a DynamicMessage.  Say this .proto file has dependencies,
  // but you know that all the dependencies will be things that are already
  // compiled into the binary.  For ease of use, you'd like to load the types
  // right out of generated_pool() rather than have to parse redundant copies
  // of all these .protos and runtime.  But, you don't want to add the parsed
  // types directly into generated_pool(): this is not allowed, and would be
  // bad design anyway.  So, instead, you could use generated_pool() as an
  // underlay for a new DescriptorPool in which you add only the new file.
  //
  // WARNING:  Use of underlays can lead to many subtle gotchas.  Instead,
  //   try to formulate what you want to do in terms of DescriptorDatabases.
  public DescriptorPool(@Const DescriptorPool underlay) { super((Pointer)null); allocate(underlay); }
  private native void allocate(@Const DescriptorPool underlay);

  // Called by generated classes at init time to add their descriptors to
  // generated_pool.  Do NOT call this in your own code!  filename must be a
  // permanent string (e.g. a string literal).
  public static native void InternalAddGeneratedFile(
        @Const Pointer encoded_file_descriptor, int size);

  // Disallow [enforce_utf8 = false] in .proto files.
  public native void DisallowEnforceUtf8();


  // For internal use only:  Gets a non-const pointer to the generated pool.
  // This is called at static-initialization time only, so thread-safety is
  // not a concern.  If both an underlay and a fallback database are present,
  // the underlay takes precedence.
  public static native DescriptorPool internal_generated_pool();

  // For internal use only:  Changes the behavior of BuildFile() such that it
  // allows the file to make reference to message types declared in other files
  // which it did not officially declare as dependencies.
  public native void InternalDontEnforceDependencies();

  // For internal use only: Enables lazy building of dependencies of a file.
  // Delay the building of dependencies of a file descriptor until absolutely
  // necessary, like when message_type() is called on a field that is defined
  // in that dependency's file. This will cause functional issues if a proto
  // or one of it's dependencies has errors. Should only be enabled for the
  // generated_pool_ (because no descriptor build errors are guaranteed by
  // the compilation generation process), testing, or if a lack of descriptor
  // build errors can be guaranteed for a pool.
  public native void InternalSetLazilyBuildDependencies();

  // For internal use only.
  public native void internal_set_underlay(@Const DescriptorPool underlay);

  // For internal (unit test) use only:  Returns true if a FileDescriptor has
  // been constructed for the given file, false otherwise.  Useful for testing
  // lazy descriptor initialization behavior.
  public native @Cast("bool") boolean InternalIsFileLoaded(@StdString BytePointer filename);
  public native @Cast("bool") boolean InternalIsFileLoaded(@StdString String filename);


  // Add a file to unused_import_track_files_. DescriptorBuilder will log
  // warnings for those files if there is any unused import.
  public native void AddUnusedImportTrackFile(@StdString BytePointer file_name);
  public native void AddUnusedImportTrackFile(@StdString String file_name);
  public native void ClearUnusedImportTrackFiles();
}
