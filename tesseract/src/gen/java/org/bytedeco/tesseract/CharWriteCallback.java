// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.tesseract;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.leptonica.*;
import static org.bytedeco.leptonica.global.lept.*;

import static org.bytedeco.tesseract.global.tesseract.*;


@Name("TessResultCallback2<bool,FILE*,const char&>") @Properties(inherit = org.bytedeco.tesseract.presets.tesseract.class)
public class CharWriteCallback extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public CharWriteCallback() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public CharWriteCallback(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public CharWriteCallback(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public CharWriteCallback position(long position) {
        return (CharWriteCallback)super.position(position);
    }
    @Override public CharWriteCallback getPointer(long i) {
        return new CharWriteCallback(this).position(position + i);
    }

  @Virtual(true) public native @Cast("bool") boolean Run(@Cast("FILE*") Pointer arg0, @Cast("const char") @ByRef byte arg1);
}
