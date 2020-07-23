// Targeted by JavaCPP version 1.5.3: DO NOT EDIT THIS FILE

package org.bytedeco.tesseract;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.leptonica.*;
import static org.bytedeco.leptonica.global.lept.*;

import static org.bytedeco.tesseract.global.tesseract.*;
  // namespace tesseract

// A useful vector that uses operator== to do comparisons.
@Name("GenericVectorEqEq<int>") @Properties(inherit = org.bytedeco.tesseract.presets.tesseract.class)
public class IntGenericVectorEqEq extends IntGenericVector {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public IntGenericVectorEqEq(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public IntGenericVectorEqEq(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public IntGenericVectorEqEq position(long position) {
        return (IntGenericVectorEqEq)super.position(position);
    }

  public IntGenericVectorEqEq() { super((Pointer)null); allocate(); }
  private native void allocate();
  
}
