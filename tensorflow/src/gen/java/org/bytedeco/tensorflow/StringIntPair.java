// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.tensorflow;

import org.bytedeco.tensorflow.Allocator;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.tensorflow.global.tensorflow.*;

@NoOffset @Name("std::pair<tensorflow::string,int>") @Properties(inherit = org.bytedeco.tensorflow.presets.tensorflow.class)
public class StringIntPair extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public StringIntPair(Pointer p) { super(p); }
    public StringIntPair(BytePointer firstValue, int secondValue) { this(); put(firstValue, secondValue); }
    public StringIntPair(String firstValue, int secondValue) { this(); put(firstValue, secondValue); }
    public StringIntPair()       { allocate();  }
    private native void allocate();
    public native @Name("operator =") @ByRef StringIntPair put(@ByRef StringIntPair x);


    @MemberGetter public native @StdString BytePointer first(); public native StringIntPair first(BytePointer first);
    @MemberGetter public native int second();  public native StringIntPair second(int second);
    @MemberSetter @Index public native StringIntPair first(@StdString String first);

    public StringIntPair put(BytePointer firstValue, int secondValue) {
        first(firstValue);
        second(secondValue);
        return this;
    }

    public StringIntPair put(String firstValue, int secondValue) {
        first(firstValue);
        second(secondValue);
        return this;
    }
}

