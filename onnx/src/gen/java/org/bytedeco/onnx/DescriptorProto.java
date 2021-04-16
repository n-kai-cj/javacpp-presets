// Targeted by JavaCPP version 1.5.5: DO NOT EDIT THIS FILE

package org.bytedeco.onnx;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.onnx.global.onnx.*;


// Defined in descriptor.proto
@Namespace("google::protobuf") @Opaque @Properties(inherit = org.bytedeco.onnx.presets.onnx.class)
public class DescriptorProto extends Pointer {
    /** Empty constructor. Calls {@code super((Pointer)null)}. */
    public DescriptorProto() { super((Pointer)null); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public DescriptorProto(Pointer p) { super(p); }
}
