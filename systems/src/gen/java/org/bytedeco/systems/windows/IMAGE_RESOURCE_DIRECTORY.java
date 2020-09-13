// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.systems.windows;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.systems.global.windows.*;


//
// Resource Format.
//

//
// Resource directory consists of two counts, following by a variable length
// array of directory entries.  The first count is the number of entries at
// beginning of the array that have actual names associated with each entry.
// The entries are in ascending order, case insensitive strings.  The second
// count is the number of entries that immediately follow the named entries.
// This second count identifies the number of entries that have 16-bit integer
// Ids as their name.  These entries are also sorted in ascending order.
//
// This structure allows fast lookup by either name or number, but for any
// given resource entry only one form of lookup is supported, not both.
// This is consistant with the syntax of the .RC file and the .RES file.
//

@Properties(inherit = org.bytedeco.systems.presets.windows.class)
public class IMAGE_RESOURCE_DIRECTORY extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public IMAGE_RESOURCE_DIRECTORY() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public IMAGE_RESOURCE_DIRECTORY(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public IMAGE_RESOURCE_DIRECTORY(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public IMAGE_RESOURCE_DIRECTORY position(long position) {
        return (IMAGE_RESOURCE_DIRECTORY)super.position(position);
    }
    @Override public IMAGE_RESOURCE_DIRECTORY getPointer(long i) {
        return new IMAGE_RESOURCE_DIRECTORY(this).position(position + i);
    }

    public native @Cast("DWORD") int Characteristics(); public native IMAGE_RESOURCE_DIRECTORY Characteristics(int setter);
    public native @Cast("DWORD") int TimeDateStamp(); public native IMAGE_RESOURCE_DIRECTORY TimeDateStamp(int setter);
    public native @Cast("WORD") short MajorVersion(); public native IMAGE_RESOURCE_DIRECTORY MajorVersion(short setter);
    public native @Cast("WORD") short MinorVersion(); public native IMAGE_RESOURCE_DIRECTORY MinorVersion(short setter);
    public native @Cast("WORD") short NumberOfNamedEntries(); public native IMAGE_RESOURCE_DIRECTORY NumberOfNamedEntries(short setter);
    public native @Cast("WORD") short NumberOfIdEntries(); public native IMAGE_RESOURCE_DIRECTORY NumberOfIdEntries(short setter);
//  IMAGE_RESOURCE_DIRECTORY_ENTRY DirectoryEntries[];
}
