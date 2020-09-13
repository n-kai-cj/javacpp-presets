// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.hdf5;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.hdf5.global.hdf5.*;


/*
 * The main datatype for each driver. Public fields common to all drivers
 * are declared here and the driver appends private fields in memory.
 */
@Properties(inherit = org.bytedeco.hdf5.presets.hdf5.class)
public class H5FD_t extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public H5FD_t() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public H5FD_t(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public H5FD_t(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public H5FD_t position(long position) {
        return (H5FD_t)super.position(position);
    }
    @Override public H5FD_t getPointer(long i) {
        return new H5FD_t(this).position(position + i);
    }

    public native @Cast("hid_t") long driver_id(); public native H5FD_t driver_id(long setter);      /*driver ID for this file   */
    public native @Const H5FD_class_t cls(); public native H5FD_t cls(H5FD_class_t setter);            /*constant class info       */
    public native @Cast("unsigned long") long fileno(); public native H5FD_t fileno(long setter);         /* File 'serial' number     */
    public native @Cast("unsigned") int access_flags(); public native H5FD_t access_flags(int setter);   /* File access flags (from create or open) */
    public native @Cast("unsigned long") long feature_flags(); public native H5FD_t feature_flags(long setter);  /* VFL Driver feature Flags */
    public native @Cast("haddr_t") long maxaddr(); public native H5FD_t maxaddr(long setter);        /* For this file, overrides class */
    public native @Cast("haddr_t") long base_addr(); public native H5FD_t base_addr(long setter);      /* Base address for HDF5 data w/in file */

    /* Space allocation management fields */
    public native @Cast("hsize_t") long threshold(); public native H5FD_t threshold(long setter);      /* Threshold for alignment  */
    public native @Cast("hsize_t") long alignment(); public native H5FD_t alignment(long setter);      /* Allocation alignment     */
    public native @Cast("hbool_t") boolean paged_aggr(); public native H5FD_t paged_aggr(boolean setter);     /* Paged aggregation for file space is enabled or not */
}
