// Targeted by JavaCPP version 1.5.5-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.systems.macosx;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.systems.global.macosx.*;


// #endif /* __DARWIN_64_BIT_INO_T */

// #if !defined(_POSIX_C_SOURCE) || defined(_DARWIN_C_SOURCE)

// #if !__DARWIN_ONLY_64_BIT_INO_T

@Name("struct stat64") @Properties(inherit = org.bytedeco.systems.presets.macosx.class)
public class stat64 extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public stat64() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public stat64(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public stat64(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public stat64 position(long position) {
        return (stat64)super.position(position);
    }
    @Override public stat64 getPointer(long i) {
        return new stat64(this).position(position + i);
    }

	public native @Cast("dev_t") int st_dev(); public native stat64 st_dev(int setter);                 /* [XSI] ID of device containing file */
	public native @Cast("mode_t") short st_mode(); public native stat64 st_mode(short setter);                /* [XSI] Mode of file (see below) */
	public native @Cast("nlink_t") short st_nlink(); public native stat64 st_nlink(short setter);               /* [XSI] Number of hard links */
	public native @Cast("__darwin_ino64_t") long st_ino(); public native stat64 st_ino(long setter);                /* [XSI] File serial number */
	public native @Cast("uid_t") int st_uid(); public native stat64 st_uid(int setter);                 /* [XSI] User ID of the file */
	public native @Cast("gid_t") int st_gid(); public native stat64 st_gid(int setter);                 /* [XSI] Group ID of the file */
	public native @Cast("dev_t") int st_rdev(); public native stat64 st_rdev(int setter);                /* [XSI] Device ID */
	public native @ByRef timespec st_atimespec(); public native stat64 st_atimespec(timespec setter);           /* time of last access */
	public native @ByRef timespec st_mtimespec(); public native stat64 st_mtimespec(timespec setter);           /* time of last data modification */
	public native @ByRef timespec st_ctimespec(); public native stat64 st_ctimespec(timespec setter);           /* time of last status change */
	public native @ByRef timespec st_birthtimespec(); public native stat64 st_birthtimespec(timespec setter);       /* time of file creation(birth) */
	public native @Cast("off_t") long st_size(); public native stat64 st_size(long setter);                /* [XSI] file size, in bytes */
	public native @Cast("blkcnt_t") long st_blocks(); public native stat64 st_blocks(long setter);              /* [XSI] blocks allocated for file */
	public native @Cast("blksize_t") int st_blksize(); public native stat64 st_blksize(int setter);             /* [XSI] optimal blocksize for I/O */
	public native @Cast("__uint32_t") int st_flags(); public native stat64 st_flags(int setter);               /* user defined flags for file */
	public native @Cast("__uint32_t") int st_gen(); public native stat64 st_gen(int setter);                 /* file generation number */
	public native @Cast("__int32_t") int st_lspare(); public native stat64 st_lspare(int setter);              /* RESERVED: DO NOT USE! */
	public native @Cast("__int64_t") long st_qspare(int i); public native stat64 st_qspare(int i, long setter);
	@MemberGetter public native @Cast("__int64_t*") LongPointer st_qspare();           /* RESERVED: DO NOT USE! */
}
