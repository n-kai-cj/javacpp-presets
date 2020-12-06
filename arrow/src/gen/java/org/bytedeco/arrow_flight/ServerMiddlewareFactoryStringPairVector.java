// Targeted by JavaCPP version 1.5.5-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.arrow_flight;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.arrow.*;
import static org.bytedeco.arrow.global.arrow.*;

import static org.bytedeco.arrow.global.arrow_flight.*;

@Name("std::vector<std::pair<std::string,std::shared_ptr<arrow::flight::ServerMiddlewareFactory> > >") @Properties(inherit = org.bytedeco.arrow.presets.arrow_flight.class)
public class ServerMiddlewareFactoryStringPairVector extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public ServerMiddlewareFactoryStringPairVector(Pointer p) { super(p); }
    public ServerMiddlewareFactoryStringPairVector(String[] firstValue, ServerMiddlewareFactory[] secondValue) { this(Math.min(firstValue.length, secondValue.length)); put(firstValue, secondValue); }
    public ServerMiddlewareFactoryStringPairVector(BytePointer[] firstValue, ServerMiddlewareFactory[] secondValue) { this(Math.min(firstValue.length, secondValue.length)); put(firstValue, secondValue); }
    public ServerMiddlewareFactoryStringPairVector()       { allocate();  }
    public ServerMiddlewareFactoryStringPairVector(long n) { allocate(n); }
    private native void allocate();
    private native void allocate(@Cast("size_t") long n);
    public native @Name("operator =") @ByRef ServerMiddlewareFactoryStringPairVector put(@ByRef ServerMiddlewareFactoryStringPairVector x);

    public boolean empty() { return size() == 0; }
    public native long size();
    public void clear() { resize(0); }
    public native void resize(@Cast("size_t") long n);

    @Index(function = "at") public native @StdString String first(@Cast("size_t") long i); public native ServerMiddlewareFactoryStringPairVector first(@Cast("size_t") long i, String first);
    @Index(function = "at") public native @SharedPtr ServerMiddlewareFactory second(@Cast("size_t") long i);  public native ServerMiddlewareFactoryStringPairVector second(@Cast("size_t") long i, ServerMiddlewareFactory second);
    @MemberSetter @Index(function = "at") public native ServerMiddlewareFactoryStringPairVector first(@Cast("size_t") long i, @StdString BytePointer first);

    public ServerMiddlewareFactoryStringPairVector put(String[] firstValue, ServerMiddlewareFactory[] secondValue) {
        for (int i = 0; i < firstValue.length && i < secondValue.length; i++) {
            first(i, firstValue[i]);
            second(i, secondValue[i]);
        }
        return this;
    }

    public ServerMiddlewareFactoryStringPairVector put(BytePointer[] firstValue, ServerMiddlewareFactory[] secondValue) {
        for (int i = 0; i < firstValue.length && i < secondValue.length; i++) {
            first(i, firstValue[i]);
            second(i, secondValue[i]);
        }
        return this;
    }
}

