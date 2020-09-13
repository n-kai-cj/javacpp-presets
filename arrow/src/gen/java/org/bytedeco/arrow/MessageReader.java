// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.arrow;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.arrow.global.arrow.*;


/** \brief Abstract interface for a sequence of messages
 *  @since 0.5.0 */
@Namespace("arrow::ipc") @Properties(inherit = org.bytedeco.arrow.presets.arrow.class)
public class MessageReader extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public MessageReader(Pointer p) { super(p); }


  /** \brief Create MessageReader that reads from InputStream */
  public static native @UniquePtr MessageReader Open(InputStream stream);

  /** \brief Create MessageReader that reads from owned InputStream */

  /** \brief Read next Message from the interface
   * 
   *  @return an arrow::ipc::Message instance */
  public native @ByVal MessageUniqueResult ReadNextMessage();
}
