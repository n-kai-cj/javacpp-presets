// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.ale;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.ale.global.ale.*;


/**
  A cartridge is a device which contains the machine code for a 
  game and handles any bankswitching performed by the cartridge.
 
  @author  Bradford W. Mott
  @version $Id: Cart.hxx,v 1.19 2007/06/14 13:47:50 stephena Exp $
*/
@NoOffset @Properties(inherit = org.bytedeco.ale.presets.ale.class)
public class Cartridge extends Device {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public Cartridge(Pointer p) { super(p); }

    /**
      Create a new cartridge object allocated on the heap.  The
      type of cartridge created depends on the properties object.
      <p>
      @param image    A pointer to the ROM image
      @param size     The size of the ROM image 
      @param props    The properties associated with the game
      @param settings The settings associated with the system
      @return   Pointer to the new cartridge object allocated on the heap
    */

    /**
      Create a new cartridge
    */
 
    /**
      Destructor
    */

    /**
      Query some information about this cartridge.
    */
    public static native @StdString BytePointer about();

    /**
      Save the internal (patched) ROM image.
      <p>
      @param out  The output file stream to save the image
    */
    public native @Cast("bool") boolean save(@Cast("std::ofstream*") @ByRef Pointer out);

    /** MGB: Added to drop warning on overloaded save() method. */  
    public native @Cast("bool") boolean save(@ByRef Serializer out); 

    /**
      Lock/unlock bankswitching capability.
    */
    public native void lockBank();
    public native void unlockBank();
    //////////////////////////////////////////////////////////////////////
    // The following methods are cart-specific and must be implemented
    // in derived classes.
    //////////////////////////////////////////////////////////////////////
    /**
      Set the specified bank.
    */
    public native void bank(@Cast("uInt16") short bank);

    /**
      Get the current bank.
      <p>
      @return  The current bank, or -1 if bankswitching not supported
    */
    public native int bank();

    /**
      Query the number of banks supported by the cartridge.
    */
    public native int bankCount();

    /**
      Patch the cartridge ROM.
      <p>
      @param address  The ROM address to patch
      @param value    The value to place into the address
      @return    Success or failure of the patch operation
    */
    public native @Cast("bool") boolean patch(@Cast("uInt16") short _address, @Cast("uInt8") byte value);

    /**
      Access the internal ROM image for this cartridge.
      <p>
      @param size  Set to the size of the internal ROM image data
      @return  A pointer to the internal ROM image data
    */
    public native @Cast("uInt8*") BytePointer getImage(@ByRef IntPointer size);
    public native @Cast("uInt8*") ByteBuffer getImage(@ByRef IntBuffer size);
    public native @Cast("uInt8*") byte[] getImage(@ByRef int[] size);
}
