// Targeted by JavaCPP version 1.5.6-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.pytorch;

import org.bytedeco.pytorch.Allocator;
import org.bytedeco.pytorch.Function;
import org.bytedeco.pytorch.Module;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import static org.bytedeco.openblas.global.openblas_nolapack.*;
import static org.bytedeco.openblas.global.openblas.*;

import static org.bytedeco.pytorch.global.torch.*;


/** An exception thrown when a DataLoader's worker thread throws an exception,
 *  which is caught. A {@code WorkerException} stores an {@code exception_ptr} to the
 *  original exception thrown in the worker thread. */
@Namespace("torch::data") @NoOffset @Properties(inherit = org.bytedeco.pytorch.presets.torch.class)
public class WorkerException extends Pointer {
    static { Loader.load(); }

  /** Constructs a {@code WorkerException} from an {@code exception_ptr}. */
  public WorkerException(@ByVal @Cast("std::exception_ptr*") Pointer original) { super((Pointer)null); allocate(original); }
  private native void allocate(@ByVal @Cast("std::exception_ptr*") Pointer original);

  public native @NoException @Cast("const char*") BytePointer what();

  /** The original exception thrown in the worker thread. */
  public native @ByRef @Cast("std::exception_ptr*") Pointer original_exception(); public native WorkerException original_exception(Pointer setter);

  /** This exception's message (not the original exception's message). */
  public native @StdString BytePointer message(); public native WorkerException message(BytePointer setter);
}
