// Targeted by JavaCPP version 1.5.4-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.arrow_flight;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.arrow.*;
import static org.bytedeco.arrow.global.arrow.*;

import static org.bytedeco.arrow.global.arrow_flight.*;


/** \brief A request to retrieve or generate a dataset */
@Namespace("arrow::flight") @Properties(inherit = org.bytedeco.arrow.presets.arrow_flight.class)
public class FlightDescriptor extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public FlightDescriptor() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public FlightDescriptor(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public FlightDescriptor(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public FlightDescriptor position(long position) {
        return (FlightDescriptor)super.position(position);
    }

  public enum DescriptorType {
    UNKNOWN(0),  /** Unused */
    PATH(1),     /** Named path identifying a dataset */
    CMD(2);      /** Opaque command to generate a dataset */

      public final int value;
      private DescriptorType(int v) { this.value = v; }
      private DescriptorType(DescriptorType e) { this.value = e.value; }
      public DescriptorType intern() { for (DescriptorType e : values()) if (e.value == value) return e; return this; }
      @Override public String toString() { return intern().name(); }
  }

  /** The descriptor type */
  public native DescriptorType type(); public native FlightDescriptor type(DescriptorType setter);

  /** Opaque value used to express a command. Should only be defined when type
   *  is CMD */
  public native @StdString String cmd(); public native FlightDescriptor cmd(String setter);

  /** List of strings identifying a particular dataset. Should only be defined
   *  when type is PATH */
  public native @ByRef StringVector path(); public native FlightDescriptor path(StringVector setter);

  public native @Cast("bool") boolean Equals(@Const @ByRef FlightDescriptor other);

  /** \brief Get a human-readable form of this descriptor. */
  
  ///
  public native @StdString String ToString();

  /** \brief Get the wire-format representation of this type.
   * 
   *  Useful when interoperating with non-Flight systems (e.g. REST
   *  services) that may want to return Flight types. */
  
  ///
  public native @ByVal Status SerializeToString(@StdString @Cast({"char*", "std::string*"}) BytePointer out);

  /** \brief Parse the wire-format representation of this type.
   * 
   *  Useful when interoperating with non-Flight systems (e.g. REST
   *  services) that may want to return Flight types. */
  public static native @ByVal Status Deserialize(@StdString String serialized, FlightDescriptor out);
  public static native @ByVal Status Deserialize(@StdString BytePointer serialized, FlightDescriptor out);

  // Convenience factory functions

  public static native @ByVal FlightDescriptor Command(@StdString String c);
  public static native @ByVal FlightDescriptor Command(@StdString BytePointer c);

  public static native @ByVal FlightDescriptor Path(@Const @ByRef StringVector p);

  
  
}
