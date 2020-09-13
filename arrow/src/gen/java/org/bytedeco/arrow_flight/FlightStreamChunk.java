// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.arrow_flight;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.arrow.*;
import static org.bytedeco.arrow.global.arrow.*;

import static org.bytedeco.arrow.global.arrow_flight.*;


/** \brief A holder for a RecordBatch with associated Flight metadata. */
@Namespace("arrow::flight") @Properties(inherit = org.bytedeco.arrow.presets.arrow_flight.class)
public class FlightStreamChunk extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public FlightStreamChunk() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public FlightStreamChunk(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public FlightStreamChunk(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public FlightStreamChunk position(long position) {
        return (FlightStreamChunk)super.position(position);
    }
    @Override public FlightStreamChunk getPointer(long i) {
        return new FlightStreamChunk(this).position(position + i);
    }

  public native @SharedPtr @Cast({"", "std::shared_ptr<arrow::RecordBatch>"}) RecordBatch data(); public native FlightStreamChunk data(RecordBatch setter);
  public native @SharedPtr ArrowBuffer app_metadata(); public native FlightStreamChunk app_metadata(ArrowBuffer setter);
}
