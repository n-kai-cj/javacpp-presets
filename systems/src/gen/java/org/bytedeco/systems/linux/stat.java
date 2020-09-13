// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.systems.linux;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.systems.global.linux.*;


@Name("struct stat") @Properties(inherit = org.bytedeco.systems.presets.linux.class)
public class stat extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public stat() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public stat(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public stat(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public stat position(long position) {
        return (stat)super.position(position);
    }
    @Override public stat getPointer(long i) {
        return new stat(this).position(position + i);
    }

    public native @Cast("__dev_t") long st_dev(); public native stat st_dev(long setter);		/* Device.  */
// #if __WORDSIZE == 32
// #endif
// #if __WORDSIZE == 64 || !defined __USE_FILE_OFFSET64
    public native @Cast("__ino_t") long st_ino(); public native stat st_ino(long setter);		/* File serial number.	*/
// #else
// #endif
// #if __WORDSIZE == 32
// #else
    public native @Cast("__nlink_t") long st_nlink(); public native stat st_nlink(long setter);		/* Link count.  */
    public native @Cast("__mode_t") int st_mode(); public native stat st_mode(int setter);		/* File mode.  */
// #endif
    public native @Cast("__uid_t") int st_uid(); public native stat st_uid(int setter);		/* User ID of the file's owner.	*/
    public native @Cast("__gid_t") int st_gid(); public native stat st_gid(int setter);		/* Group ID of the file's group.*/
// #if __WORDSIZE == 64
    public native int __pad0(); public native stat __pad0(int setter);
// #endif
    public native @Cast("__dev_t") long st_rdev(); public native stat st_rdev(long setter);		/* Device number, if device.  */
// #if __WORDSIZE == 32
// #endif
// #if __WORDSIZE == 64 || !defined __USE_FILE_OFFSET64
    public native @Cast("__off_t") long st_size(); public native stat st_size(long setter);			/* Size of file, in bytes.  */
// #else
// #endif
    public native @Cast("__blksize_t") long st_blksize(); public native stat st_blksize(long setter);	/* Optimal block size for I/O.  */
// #if __WORDSIZE == 64 || !defined __USE_FILE_OFFSET64
    public native @Cast("__blkcnt_t") long st_blocks(); public native stat st_blocks(long setter);		/* Number 512-byte blocks allocated. */
// #else
// #endif
// #if defined __USE_MISC || defined __USE_XOPEN2K8
    /* Nanosecond resolution timestamps are stored in a format
       equivalent to 'struct timespec'.  This is the type used
       whenever possible but the Unix namespace rules do not allow the
       identifier 'timespec' to appear in the <sys/stat.h> header.
       Therefore we have to handle the use of this header in strictly
       standard-compliant sources special.  */
    public native @ByRef timespec st_atim(); public native stat st_atim(timespec setter);		/* Time of last access.  */
    public native @ByRef timespec st_mtim(); public native stat st_mtim(timespec setter);		/* Time of last modification.  */
    public native @ByRef timespec st_ctim(); public native stat st_ctim(timespec setter);		/* Time of last status change.  */
// #else
// #endif
// #if __WORDSIZE == 64
    public native long __unused(int i); public native stat __unused(int i, long setter);
    @MemberGetter public native CLongPointer __unused();
// #else
// #endif
  }
