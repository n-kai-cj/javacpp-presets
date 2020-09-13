// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.tensorflow;

import org.bytedeco.tensorflow.Allocator;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.tensorflow.global.tensorflow.*;

@NoOffset @Name("std::pair<tensorflow::TensorSlice,tensorflow::string>") @Properties(inherit = org.bytedeco.tensorflow.presets.tensorflow.class)
public class TensorSlideStringPair extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public TensorSlideStringPair(Pointer p) { super(p); }
    public TensorSlideStringPair(TensorSlice firstValue, BytePointer secondValue) { this(); put(firstValue, secondValue); }
    public TensorSlideStringPair(TensorSlice firstValue, String secondValue) { this(); put(firstValue, secondValue); }
    public TensorSlideStringPair()       { allocate();  }
    private native void allocate();
    public native @Name("operator =") @ByRef TensorSlideStringPair put(@ByRef TensorSlideStringPair x);


    @MemberGetter public native @ByRef TensorSlice first(); public native TensorSlideStringPair first(TensorSlice first);
    @MemberGetter public native @StdString BytePointer second();  public native TensorSlideStringPair second(BytePointer second);
    @MemberSetter @Index public native TensorSlideStringPair second(@StdString String second);

    public TensorSlideStringPair put(TensorSlice firstValue, BytePointer secondValue) {
        first(firstValue);
        second(secondValue);
        return this;
    }

    public TensorSlideStringPair put(TensorSlice firstValue, String secondValue) {
        first(firstValue);
        second(secondValue);
        return this;
    }
}

