// Targeted by JavaCPP version 1.5.4-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.onnxruntime;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.dnnl.*;
import static org.bytedeco.dnnl.global.dnnl.*;

import static org.bytedeco.onnxruntime.global.onnxruntime.*;


@Namespace("Ort") @Properties(inherit = org.bytedeco.onnxruntime.presets.onnxruntime.class)
public class Value extends BaseValue {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public Value(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public Value(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public Value position(long position) {
        return (Value)super.position(position);
    }

  public static native @Name("CreateTensor<float>") @StdMove Value CreateTensorFloat(@Const OrtMemoryInfo info, FloatPointer p_data, @Cast("size_t") long p_data_element_count, @Cast("const int64_t*") LongPointer shape, @Cast("size_t") long shape_len);
  public static native @Name("CreateTensor<float>") @StdMove Value CreateTensorFloat(@Const OrtMemoryInfo info, FloatBuffer p_data, @Cast("size_t") long p_data_element_count, @Cast("const int64_t*") LongBuffer shape, @Cast("size_t") long shape_len);
  public static native @Name("CreateTensor<float>") @StdMove Value CreateTensorFloat(@Const OrtMemoryInfo info, float[] p_data, @Cast("size_t") long p_data_element_count, @Cast("const int64_t*") long[] shape, @Cast("size_t") long shape_len);
  public static native @Name("CreateTensor<double>") @StdMove Value CreateTensorDouble(@Const OrtMemoryInfo info, DoublePointer p_data, @Cast("size_t") long p_data_element_count, @Cast("const int64_t*") LongPointer shape, @Cast("size_t") long shape_len);
  public static native @Name("CreateTensor<double>") @StdMove Value CreateTensorDouble(@Const OrtMemoryInfo info, DoubleBuffer p_data, @Cast("size_t") long p_data_element_count, @Cast("const int64_t*") LongBuffer shape, @Cast("size_t") long shape_len);
  public static native @Name("CreateTensor<double>") @StdMove Value CreateTensorDouble(@Const OrtMemoryInfo info, double[] p_data, @Cast("size_t") long p_data_element_count, @Cast("const int64_t*") long[] shape, @Cast("size_t") long shape_len);
  public static native @Name("CreateTensor<int8_t>") @StdMove Value CreateTensorByte(@Const OrtMemoryInfo info, BytePointer p_data, @Cast("size_t") long p_data_element_count, @Cast("const int64_t*") LongPointer shape, @Cast("size_t") long shape_len);
  public static native @Name("CreateTensor<int8_t>") @StdMove Value CreateTensorByte(@Const OrtMemoryInfo info, ByteBuffer p_data, @Cast("size_t") long p_data_element_count, @Cast("const int64_t*") LongBuffer shape, @Cast("size_t") long shape_len);
  public static native @Name("CreateTensor<int8_t>") @StdMove Value CreateTensorByte(@Const OrtMemoryInfo info, byte[] p_data, @Cast("size_t") long p_data_element_count, @Cast("const int64_t*") long[] shape, @Cast("size_t") long shape_len);
  public static native @Name("CreateTensor<int16_t>") @StdMove Value CreateTensorShort(@Const OrtMemoryInfo info, ShortPointer p_data, @Cast("size_t") long p_data_element_count, @Cast("const int64_t*") LongPointer shape, @Cast("size_t") long shape_len);
  public static native @Name("CreateTensor<int16_t>") @StdMove Value CreateTensorShort(@Const OrtMemoryInfo info, ShortBuffer p_data, @Cast("size_t") long p_data_element_count, @Cast("const int64_t*") LongBuffer shape, @Cast("size_t") long shape_len);
  public static native @Name("CreateTensor<int16_t>") @StdMove Value CreateTensorShort(@Const OrtMemoryInfo info, short[] p_data, @Cast("size_t") long p_data_element_count, @Cast("const int64_t*") long[] shape, @Cast("size_t") long shape_len);
  public static native @Name("CreateTensor<int32_t>") @StdMove Value CreateTensorInt(@Const OrtMemoryInfo info, IntPointer p_data, @Cast("size_t") long p_data_element_count, @Cast("const int64_t*") LongPointer shape, @Cast("size_t") long shape_len);
  public static native @Name("CreateTensor<int32_t>") @StdMove Value CreateTensorInt(@Const OrtMemoryInfo info, IntBuffer p_data, @Cast("size_t") long p_data_element_count, @Cast("const int64_t*") LongBuffer shape, @Cast("size_t") long shape_len);
  public static native @Name("CreateTensor<int32_t>") @StdMove Value CreateTensorInt(@Const OrtMemoryInfo info, int[] p_data, @Cast("size_t") long p_data_element_count, @Cast("const int64_t*") long[] shape, @Cast("size_t") long shape_len);
  public static native @Name("CreateTensor<int64_t>") @StdMove Value CreateTensorLong(@Const OrtMemoryInfo info, @Cast("int64_t*") LongPointer p_data, @Cast("size_t") long p_data_element_count, @Cast("const int64_t*") LongPointer shape, @Cast("size_t") long shape_len);
  public static native @Name("CreateTensor<int64_t>") @StdMove Value CreateTensorLong(@Const OrtMemoryInfo info, @Cast("int64_t*") LongBuffer p_data, @Cast("size_t") long p_data_element_count, @Cast("const int64_t*") LongBuffer shape, @Cast("size_t") long shape_len);
  public static native @Name("CreateTensor<int64_t>") @StdMove Value CreateTensorLong(@Const OrtMemoryInfo info, @Cast("int64_t*") long[] p_data, @Cast("size_t") long p_data_element_count, @Cast("const int64_t*") long[] shape, @Cast("size_t") long shape_len);
  public static native @Name("CreateTensor<uint8_t>") @StdMove Value CreateTensorUByte(@Const OrtMemoryInfo info, @Cast("uint8_t*") BytePointer p_data, @Cast("size_t") long p_data_element_count, @Cast("const int64_t*") LongPointer shape, @Cast("size_t") long shape_len);
  public static native @Name("CreateTensor<uint8_t>") @StdMove Value CreateTensorUByte(@Const OrtMemoryInfo info, @Cast("uint8_t*") ByteBuffer p_data, @Cast("size_t") long p_data_element_count, @Cast("const int64_t*") LongBuffer shape, @Cast("size_t") long shape_len);
  public static native @Name("CreateTensor<uint8_t>") @StdMove Value CreateTensorUByte(@Const OrtMemoryInfo info, @Cast("uint8_t*") byte[] p_data, @Cast("size_t") long p_data_element_count, @Cast("const int64_t*") long[] shape, @Cast("size_t") long shape_len);
  public static native @Name("CreateTensor<uint16_t>") @StdMove Value CreateTensorUShort(@Const OrtMemoryInfo info, @Cast("uint16_t*") ShortPointer p_data, @Cast("size_t") long p_data_element_count, @Cast("const int64_t*") LongPointer shape, @Cast("size_t") long shape_len);
  public static native @Name("CreateTensor<uint16_t>") @StdMove Value CreateTensorUShort(@Const OrtMemoryInfo info, @Cast("uint16_t*") ShortBuffer p_data, @Cast("size_t") long p_data_element_count, @Cast("const int64_t*") LongBuffer shape, @Cast("size_t") long shape_len);
  public static native @Name("CreateTensor<uint16_t>") @StdMove Value CreateTensorUShort(@Const OrtMemoryInfo info, @Cast("uint16_t*") short[] p_data, @Cast("size_t") long p_data_element_count, @Cast("const int64_t*") long[] shape, @Cast("size_t") long shape_len);
  public static native @Name("CreateTensor<uint32_t>") @StdMove Value CreateTensorUInt(@Const OrtMemoryInfo info, @Cast("uint32_t*") IntPointer p_data, @Cast("size_t") long p_data_element_count, @Cast("const int64_t*") LongPointer shape, @Cast("size_t") long shape_len);
  public static native @Name("CreateTensor<uint32_t>") @StdMove Value CreateTensorUInt(@Const OrtMemoryInfo info, @Cast("uint32_t*") IntBuffer p_data, @Cast("size_t") long p_data_element_count, @Cast("const int64_t*") LongBuffer shape, @Cast("size_t") long shape_len);
  public static native @Name("CreateTensor<uint32_t>") @StdMove Value CreateTensorUInt(@Const OrtMemoryInfo info, @Cast("uint32_t*") int[] p_data, @Cast("size_t") long p_data_element_count, @Cast("const int64_t*") long[] shape, @Cast("size_t") long shape_len);
  public static native @Name("CreateTensor<uint64_t>") @StdMove Value CreateTensorULong(@Const OrtMemoryInfo info, @Cast("uint64_t*") LongPointer p_data, @Cast("size_t") long p_data_element_count, @Cast("const int64_t*") LongPointer shape, @Cast("size_t") long shape_len);
  public static native @Name("CreateTensor<uint64_t>") @StdMove Value CreateTensorULong(@Const OrtMemoryInfo info, @Cast("uint64_t*") LongBuffer p_data, @Cast("size_t") long p_data_element_count, @Cast("const int64_t*") LongBuffer shape, @Cast("size_t") long shape_len);
  public static native @Name("CreateTensor<uint64_t>") @StdMove Value CreateTensorULong(@Const OrtMemoryInfo info, @Cast("uint64_t*") long[] p_data, @Cast("size_t") long p_data_element_count, @Cast("const int64_t*") long[] shape, @Cast("size_t") long shape_len);
  public static native @Name("CreateTensor<bool>") @StdMove Value CreateTensorBool(@Const OrtMemoryInfo info, @Cast("bool*") BoolPointer p_data, @Cast("size_t") long p_data_element_count, @Cast("const int64_t*") LongPointer shape, @Cast("size_t") long shape_len);
  public static native @Name("CreateTensor<bool>") @StdMove Value CreateTensorBool(@Const OrtMemoryInfo info, @Cast("bool*") boolean[] p_data, @Cast("size_t") long p_data_element_count, @Cast("const int64_t*") LongBuffer shape, @Cast("size_t") long shape_len);
  public static native @Name("CreateTensor<bool>") @StdMove Value CreateTensorBool(@Const OrtMemoryInfo info, @Cast("bool*") BoolPointer p_data, @Cast("size_t") long p_data_element_count, @Cast("const int64_t*") long[] shape, @Cast("size_t") long shape_len);
  public static native @Name("CreateTensor<bool>") @StdMove Value CreateTensorBool(@Const OrtMemoryInfo info, @Cast("bool*") boolean[] p_data, @Cast("size_t") long p_data_element_count, @Cast("const int64_t*") LongPointer shape, @Cast("size_t") long shape_len);
  public static native @Name("CreateTensor<bool>") @StdMove Value CreateTensorBool(@Const OrtMemoryInfo info, @Cast("bool*") BoolPointer p_data, @Cast("size_t") long p_data_element_count, @Cast("const int64_t*") LongBuffer shape, @Cast("size_t") long shape_len);
  public static native @Name("CreateTensor<bool>") @StdMove Value CreateTensorBool(@Const OrtMemoryInfo info, @Cast("bool*") boolean[] p_data, @Cast("size_t") long p_data_element_count, @Cast("const int64_t*") long[] shape, @Cast("size_t") long shape_len);
  public static native @StdMove Value CreateTensor(@Const OrtMemoryInfo info, Pointer p_data, @Cast("size_t") long p_data_byte_count, @Cast("const int64_t*") LongPointer shape, @Cast("size_t") long shape_len,
                              @Cast("ONNXTensorElementDataType") int type);
  public static native @StdMove Value CreateTensor(@Const OrtMemoryInfo info, Pointer p_data, @Cast("size_t") long p_data_byte_count, @Cast("const int64_t*") LongBuffer shape, @Cast("size_t") long shape_len,
                              @Cast("ONNXTensorElementDataType") int type);
  public static native @StdMove Value CreateTensor(@Const OrtMemoryInfo info, Pointer p_data, @Cast("size_t") long p_data_byte_count, @Cast("const int64_t*") long[] shape, @Cast("size_t") long shape_len,
                              @Cast("ONNXTensorElementDataType") int type);
  public static native @Name("CreateTensor<float>") @StdMove Value CreateTensorFloat(OrtAllocator allocator, @Cast("const int64_t*") LongPointer shape, @Cast("size_t") long shape_len);
  public static native @Name("CreateTensor<float>") @StdMove Value CreateTensorFloat(OrtAllocator allocator, @Cast("const int64_t*") LongBuffer shape, @Cast("size_t") long shape_len);
  public static native @Name("CreateTensor<float>") @StdMove Value CreateTensorFloat(OrtAllocator allocator, @Cast("const int64_t*") long[] shape, @Cast("size_t") long shape_len);
  public static native @Name("CreateTensor<double>") @StdMove Value CreateTensorDouble(OrtAllocator allocator, @Cast("const int64_t*") LongPointer shape, @Cast("size_t") long shape_len);
  public static native @Name("CreateTensor<double>") @StdMove Value CreateTensorDouble(OrtAllocator allocator, @Cast("const int64_t*") LongBuffer shape, @Cast("size_t") long shape_len);
  public static native @Name("CreateTensor<double>") @StdMove Value CreateTensorDouble(OrtAllocator allocator, @Cast("const int64_t*") long[] shape, @Cast("size_t") long shape_len);
  public static native @Name("CreateTensor<int8_t>") @StdMove Value CreateTensorByte(OrtAllocator allocator, @Cast("const int64_t*") LongPointer shape, @Cast("size_t") long shape_len);
  public static native @Name("CreateTensor<int8_t>") @StdMove Value CreateTensorByte(OrtAllocator allocator, @Cast("const int64_t*") LongBuffer shape, @Cast("size_t") long shape_len);
  public static native @Name("CreateTensor<int8_t>") @StdMove Value CreateTensorByte(OrtAllocator allocator, @Cast("const int64_t*") long[] shape, @Cast("size_t") long shape_len);
  public static native @Name("CreateTensor<int16_t>") @StdMove Value CreateTensorShort(OrtAllocator allocator, @Cast("const int64_t*") LongPointer shape, @Cast("size_t") long shape_len);
  public static native @Name("CreateTensor<int16_t>") @StdMove Value CreateTensorShort(OrtAllocator allocator, @Cast("const int64_t*") LongBuffer shape, @Cast("size_t") long shape_len);
  public static native @Name("CreateTensor<int16_t>") @StdMove Value CreateTensorShort(OrtAllocator allocator, @Cast("const int64_t*") long[] shape, @Cast("size_t") long shape_len);
  public static native @Name("CreateTensor<int32_t>") @StdMove Value CreateTensorInt(OrtAllocator allocator, @Cast("const int64_t*") LongPointer shape, @Cast("size_t") long shape_len);
  public static native @Name("CreateTensor<int32_t>") @StdMove Value CreateTensorInt(OrtAllocator allocator, @Cast("const int64_t*") LongBuffer shape, @Cast("size_t") long shape_len);
  public static native @Name("CreateTensor<int32_t>") @StdMove Value CreateTensorInt(OrtAllocator allocator, @Cast("const int64_t*") long[] shape, @Cast("size_t") long shape_len);
  public static native @Name("CreateTensor<int64_t>") @StdMove Value CreateTensorLong(OrtAllocator allocator, @Cast("const int64_t*") LongPointer shape, @Cast("size_t") long shape_len);
  public static native @Name("CreateTensor<int64_t>") @StdMove Value CreateTensorLong(OrtAllocator allocator, @Cast("const int64_t*") LongBuffer shape, @Cast("size_t") long shape_len);
  public static native @Name("CreateTensor<int64_t>") @StdMove Value CreateTensorLong(OrtAllocator allocator, @Cast("const int64_t*") long[] shape, @Cast("size_t") long shape_len);
  public static native @Name("CreateTensor<uint8_t>") @StdMove Value CreateTensorUByte(OrtAllocator allocator, @Cast("const int64_t*") LongPointer shape, @Cast("size_t") long shape_len);
  public static native @Name("CreateTensor<uint8_t>") @StdMove Value CreateTensorUByte(OrtAllocator allocator, @Cast("const int64_t*") LongBuffer shape, @Cast("size_t") long shape_len);
  public static native @Name("CreateTensor<uint8_t>") @StdMove Value CreateTensorUByte(OrtAllocator allocator, @Cast("const int64_t*") long[] shape, @Cast("size_t") long shape_len);
  public static native @Name("CreateTensor<uint16_t>") @StdMove Value CreateTensorUShort(OrtAllocator allocator, @Cast("const int64_t*") LongPointer shape, @Cast("size_t") long shape_len);
  public static native @Name("CreateTensor<uint16_t>") @StdMove Value CreateTensorUShort(OrtAllocator allocator, @Cast("const int64_t*") LongBuffer shape, @Cast("size_t") long shape_len);
  public static native @Name("CreateTensor<uint16_t>") @StdMove Value CreateTensorUShort(OrtAllocator allocator, @Cast("const int64_t*") long[] shape, @Cast("size_t") long shape_len);
  public static native @Name("CreateTensor<uint32_t>") @StdMove Value CreateTensorUInt(OrtAllocator allocator, @Cast("const int64_t*") LongPointer shape, @Cast("size_t") long shape_len);
  public static native @Name("CreateTensor<uint32_t>") @StdMove Value CreateTensorUInt(OrtAllocator allocator, @Cast("const int64_t*") LongBuffer shape, @Cast("size_t") long shape_len);
  public static native @Name("CreateTensor<uint32_t>") @StdMove Value CreateTensorUInt(OrtAllocator allocator, @Cast("const int64_t*") long[] shape, @Cast("size_t") long shape_len);
  public static native @Name("CreateTensor<uint64_t>") @StdMove Value CreateTensorULong(OrtAllocator allocator, @Cast("const int64_t*") LongPointer shape, @Cast("size_t") long shape_len);
  public static native @Name("CreateTensor<uint64_t>") @StdMove Value CreateTensorULong(OrtAllocator allocator, @Cast("const int64_t*") LongBuffer shape, @Cast("size_t") long shape_len);
  public static native @Name("CreateTensor<uint64_t>") @StdMove Value CreateTensorULong(OrtAllocator allocator, @Cast("const int64_t*") long[] shape, @Cast("size_t") long shape_len);
  public static native @Name("CreateTensor<bool>") @StdMove Value CreateTensorBool(OrtAllocator allocator, @Cast("const int64_t*") LongPointer shape, @Cast("size_t") long shape_len);
  public static native @Name("CreateTensor<bool>") @StdMove Value CreateTensorBool(OrtAllocator allocator, @Cast("const int64_t*") LongBuffer shape, @Cast("size_t") long shape_len);
  public static native @Name("CreateTensor<bool>") @StdMove Value CreateTensorBool(OrtAllocator allocator, @Cast("const int64_t*") long[] shape, @Cast("size_t") long shape_len);
  public static native @StdMove Value CreateTensor(OrtAllocator allocator, @Cast("const int64_t*") LongPointer shape, @Cast("size_t") long shape_len, @Cast("ONNXTensorElementDataType") int type);
  public static native @StdMove Value CreateTensor(OrtAllocator allocator, @Cast("const int64_t*") LongBuffer shape, @Cast("size_t") long shape_len, @Cast("ONNXTensorElementDataType") int type);
  public static native @StdMove Value CreateTensor(OrtAllocator allocator, @Cast("const int64_t*") long[] shape, @Cast("size_t") long shape_len, @Cast("ONNXTensorElementDataType") int type);

  public static native @StdMove Value CreateMap(@ByRef Value keys, @ByRef Value values);
  public static native @StdMove Value CreateSequence(@ByRef ValueVector values);

  public Value() { super((Pointer)null); allocate(); }
  private native void allocate();
  public Value(OrtValue p) { super((Pointer)null); allocate(p); }
  private native void allocate(OrtValue p);
  public Value(@StdMove Value arg0) { super((Pointer)null); allocate(arg0); }
  private native void allocate(@StdMove Value arg0);
  public native @ByRef @Name("operator =") Value put(@StdMove Value arg0);

  public native @Cast("bool") boolean IsTensor();
  public native @Cast("size_t") long GetCount();  // If a non tensor, returns 2 for map and N for sequence, where N is the number of elements
  public native @StdMove Value GetValue(int index, OrtAllocator allocator);

  public native @Cast("size_t") long GetStringTensorDataLength();
  public native void GetStringTensorContent(Pointer buffer, @Cast("size_t") long buffer_length, @Cast("size_t*") SizeTPointer offsets, @Cast("size_t") long offsets_count);

  public native @Name("GetTensorMutableData<float>") FloatPointer GetTensorMutableDataFloat();

  public native @Name("GetTensorMutableData<double>") DoublePointer GetTensorMutableDataDouble();

  public native @Name("GetTensorMutableData<int8_t>") BytePointer GetTensorMutableDataByte();

  public native @Name("GetTensorMutableData<int16_t>") ShortPointer GetTensorMutableDataShort();

  public native @Name("GetTensorMutableData<int32_t>") IntPointer GetTensorMutableDataInt();

  public native @Cast("int64_t*") @Name("GetTensorMutableData<int64_t>") LongPointer GetTensorMutableDataLong();

  public native @Cast("uint8_t*") @Name("GetTensorMutableData<uint8_t>") BytePointer GetTensorMutableDataUByte();

  public native @Cast("uint16_t*") @Name("GetTensorMutableData<uint16_t>") ShortPointer GetTensorMutableDataUShort();

  public native @Cast("uint32_t*") @Name("GetTensorMutableData<uint32_t>") IntPointer GetTensorMutableDataUInt();

  public native @Cast("uint64_t*") @Name("GetTensorMutableData<uint64_t>") LongPointer GetTensorMutableDataULong();

  public native @Cast("bool*") @Name("GetTensorMutableData<bool>") BoolPointer GetTensorMutableDataBool();

  public native @ByVal TypeInfo GetTypeInfo();
  public native @ByVal TensorTypeAndShapeInfo GetTensorTypeAndShapeInfo();
}
