// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.arrow;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.arrow.global.arrow.*;


/** \brief File selector for filesystem APIs */
@Namespace("arrow::fs") @NoOffset @Properties(inherit = org.bytedeco.arrow.presets.arrow.class)
public class FileSelector extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public FileSelector(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public FileSelector(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public FileSelector position(long position) {
        return (FileSelector)super.position(position);
    }
    @Override public FileSelector getPointer(long i) {
        return new FileSelector(this).position(position + i);
    }

  /** The directory in which to select files.
   *  If the path exists but doesn't point to a directory, this should be an error. */
  public native @StdString String base_dir(); public native FileSelector base_dir(String setter);
  /** The behavior if {@code base_dir} isn't found in the filesystem.  If false,
   *  an error is returned.  If true, an empty selection is returned. */
  public native @Cast("bool") boolean allow_not_found(); public native FileSelector allow_not_found(boolean setter);
  /** Whether to recurse into subdirectories. */
  public native @Cast("bool") boolean recursive(); public native FileSelector recursive(boolean setter);
  /** The maximum number of subdirectories to recurse into. */
  public native int max_recursion(); public native FileSelector max_recursion(int setter);

  public FileSelector() { super((Pointer)null); allocate(); }
  private native void allocate();
}
