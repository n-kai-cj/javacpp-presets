// Targeted by JavaCPP version 1.5.3: DO NOT EDIT THIS FILE

package org.bytedeco.mkldnn;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import static org.bytedeco.mkldnn.global.mklml.*;

import static org.bytedeco.mkldnn.global.mkldnn.*;

@Name("std::vector<mkldnn_primitive_desc_t>") @Properties(inherit = org.bytedeco.mkldnn.presets.mkldnn.class)
public class mkldnn_primitive_desc_vector extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public mkldnn_primitive_desc_vector(Pointer p) { super(p); }
    public mkldnn_primitive_desc_vector(mkldnn_primitive_desc value) { this(1); put(0, value); }
    public mkldnn_primitive_desc_vector(mkldnn_primitive_desc ... array) { this(array.length); put(array); }
    public mkldnn_primitive_desc_vector()       { allocate();  }
    public mkldnn_primitive_desc_vector(long n) { allocate(n); }
    private native void allocate();
    private native void allocate(@Cast("size_t") long n);
    public native @Name("operator =") @ByRef mkldnn_primitive_desc_vector put(@ByRef mkldnn_primitive_desc_vector x);

    public boolean empty() { return size() == 0; }
    public native long size();
    public void clear() { resize(0); }
    public native void resize(@Cast("size_t") long n);

    @Index(function = "at") public native mkldnn_primitive_desc get(@Cast("size_t") long i);
    public native mkldnn_primitive_desc_vector put(@Cast("size_t") long i, mkldnn_primitive_desc value);

    public native @ByVal Iterator insert(@ByVal Iterator pos, mkldnn_primitive_desc value);
    public native @ByVal Iterator erase(@ByVal Iterator pos);
    public native @ByVal Iterator begin();
    public native @ByVal Iterator end();
    @NoOffset @Name("iterator") public static class Iterator extends Pointer {
        public Iterator(Pointer p) { super(p); }
        public Iterator() { }

        public native @Name("operator ++") @ByRef Iterator increment();
        public native @Name("operator ==") boolean equals(@ByRef Iterator it);
        public native @Name("operator *") mkldnn_primitive_desc get();
    }

    public mkldnn_primitive_desc[] get() {
        mkldnn_primitive_desc[] array = new mkldnn_primitive_desc[size() < Integer.MAX_VALUE ? (int)size() : Integer.MAX_VALUE];
        for (int i = 0; i < array.length; i++) {
            array[i] = get(i);
        }
        return array;
    }
    @Override public String toString() {
        return java.util.Arrays.toString(get());
    }

    public mkldnn_primitive_desc pop_back() {
        long size = size();
        mkldnn_primitive_desc value = get(size - 1);
        resize(size - 1);
        return value;
    }
    public mkldnn_primitive_desc_vector push_back(mkldnn_primitive_desc value) {
        long size = size();
        resize(size + 1);
        return put(size, value);
    }
    public mkldnn_primitive_desc_vector put(mkldnn_primitive_desc value) {
        if (size() != 1) { resize(1); }
        return put(0, value);
    }
    public mkldnn_primitive_desc_vector put(mkldnn_primitive_desc ... array) {
        if (size() != array.length) { resize(array.length); }
        for (int i = 0; i < array.length; i++) {
            put(i, array[i]);
        }
        return this;
    }
}

