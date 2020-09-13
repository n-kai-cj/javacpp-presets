// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.gandiva;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.arrow.*;
import static org.bytedeco.arrow.global.arrow.*;

import static org.bytedeco.arrow.global.gandiva.*;


/** \brief configuration builder for gandiva
 * 
 *  Provides a default configuration and convenience methods
 *  to override specific values and build a custom instance */
@Namespace("gandiva") @Properties(inherit = org.bytedeco.arrow.presets.gandiva.class)
public class ConfigurationBuilder extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public ConfigurationBuilder() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public ConfigurationBuilder(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public ConfigurationBuilder(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public ConfigurationBuilder position(long position) {
        return (ConfigurationBuilder)super.position(position);
    }
    @Override public ConfigurationBuilder getPointer(long i) {
        return new ConfigurationBuilder(this).position(position + i);
    }

  public native @SharedPtr Configuration build();

  public native @SharedPtr Configuration build(@Cast("bool") boolean optimize);

  public static native @SharedPtr Configuration DefaultConfiguration();
}
