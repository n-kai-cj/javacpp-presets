// Targeted by JavaCPP version 1.5.5-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.dnnl;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.opencl.*;
import static org.bytedeco.opencl.global.OpenCL.*;

import static org.bytedeco.dnnl.global.dnnl.*;


/** \} dnnl_api_attributes
 <p>
 *  \addtogroup dnnl_api_primitives_common
 *  \{
 <p>
 *  \struct dnnl_primitive
 *  An opaque structure to describe a primitive. */
@Opaque @Properties(inherit = org.bytedeco.dnnl.presets.dnnl.class)
public class dnnl_primitive extends Pointer {
    /** Empty constructor. Calls {@code super((Pointer)null)}. */
    public dnnl_primitive() { super((Pointer)null); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public dnnl_primitive(Pointer p) { super(p); }
}
