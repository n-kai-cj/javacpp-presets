// Targeted by JavaCPP version 1.5.5-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.arrow;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.arrow.global.arrow.*;

@Name("std::vector<std::pair<std::string,std::string> >") @Properties(inherit = org.bytedeco.arrow.presets.arrow.class)
public class StringStringPairVector extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public StringStringPairVector(Pointer p) { super(p); }
    public StringStringPairVector(String[] firstValue, String[] secondValue) { this(Math.min(firstValue.length, secondValue.length)); put(firstValue, secondValue); }
    public StringStringPairVector(BytePointer[] firstValue, BytePointer[] secondValue) { this(Math.min(firstValue.length, secondValue.length)); put(firstValue, secondValue); }
    public StringStringPairVector()       { allocate();  }
    public StringStringPairVector(long n) { allocate(n); }
    private native void allocate();
    private native void allocate(@Cast("size_t") long n);
    public native @Name("operator =") @ByRef StringStringPairVector put(@ByRef StringStringPairVector x);

    public boolean empty() { return size() == 0; }
    public native long size();
    public void clear() { resize(0); }
    public native void resize(@Cast("size_t") long n);

    @Index(function = "at") public native @StdString String first(@Cast("size_t") long i); public native StringStringPairVector first(@Cast("size_t") long i, String first);
    @Index(function = "at") public native @StdString String second(@Cast("size_t") long i);  public native StringStringPairVector second(@Cast("size_t") long i, String second);
    @MemberSetter @Index(function = "at") public native StringStringPairVector first(@Cast("size_t") long i, @StdString BytePointer first);
    @MemberSetter @Index(function = "at") public native StringStringPairVector second(@Cast("size_t") long i, @StdString BytePointer second);

    public StringStringPairVector put(String[] firstValue, String[] secondValue) {
        for (int i = 0; i < firstValue.length && i < secondValue.length; i++) {
            first(i, firstValue[i]);
            second(i, secondValue[i]);
        }
        return this;
    }

    public StringStringPairVector put(BytePointer[] firstValue, BytePointer[] secondValue) {
        for (int i = 0; i < firstValue.length && i < secondValue.length; i++) {
            first(i, firstValue[i]);
            second(i, secondValue[i]);
        }
        return this;
    }
}

