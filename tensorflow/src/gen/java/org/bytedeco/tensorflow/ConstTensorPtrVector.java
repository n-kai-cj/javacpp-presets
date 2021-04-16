// Targeted by JavaCPP version 1.5.5: DO NOT EDIT THIS FILE

package org.bytedeco.tensorflow;

import org.bytedeco.tensorflow.Allocator;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.tensorflow.global.tensorflow.*;

@Name("std::vector<const tensorflow::Tensor*>") @Properties(inherit = org.bytedeco.tensorflow.presets.tensorflow.class)
public class ConstTensorPtrVector extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public ConstTensorPtrVector(Pointer p) { super(p); }
    public ConstTensorPtrVector(Tensor value) { this(1); put(0, value); }
    public ConstTensorPtrVector(Tensor ... array) { this(array.length); put(array); }
    public ConstTensorPtrVector()       { allocate();  }
    public ConstTensorPtrVector(long n) { allocate(n); }
    private native void allocate();
    private native void allocate(@Cast("size_t") long n);
    public native @Name("operator =") @ByRef ConstTensorPtrVector put(@ByRef ConstTensorPtrVector x);

    public boolean empty() { return size() == 0; }
    public native long size();
    public void clear() { resize(0); }
    public native void resize(@Cast("size_t") long n);

    @Index(function = "at") public native @Const Tensor get(@Cast("size_t") long i);
    public native ConstTensorPtrVector put(@Cast("size_t") long i, Tensor value);

    public native @ByVal Iterator insert(@ByVal Iterator pos, @Const Tensor value);
    public native @ByVal Iterator erase(@ByVal Iterator pos);
    public native @ByVal Iterator begin();
    public native @ByVal Iterator end();
    @NoOffset @Name("iterator") public static class Iterator extends Pointer {
        public Iterator(Pointer p) { super(p); }
        public Iterator() { }

        public native @Name("operator ++") @ByRef Iterator increment();
        public native @Name("operator ==") boolean equals(@ByRef Iterator it);
        public native @Name("operator *") @Const Tensor get();
    }

    public Tensor[] get() {
        Tensor[] array = new Tensor[size() < Integer.MAX_VALUE ? (int)size() : Integer.MAX_VALUE];
        for (int i = 0; i < array.length; i++) {
            array[i] = get(i);
        }
        return array;
    }
    @Override public String toString() {
        return java.util.Arrays.toString(get());
    }

    public Tensor pop_back() {
        long size = size();
        Tensor value = get(size - 1);
        resize(size - 1);
        return value;
    }
    public ConstTensorPtrVector push_back(Tensor value) {
        long size = size();
        resize(size + 1);
        return put(size, value);
    }
    public ConstTensorPtrVector put(Tensor value) {
        if (size() != 1) { resize(1); }
        return put(0, value);
    }
    public ConstTensorPtrVector put(Tensor ... array) {
        if (size() != array.length) { resize(array.length); }
        for (int i = 0; i < array.length; i++) {
            put(i, array[i]);
        }
        return this;
    }
}

