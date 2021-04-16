// Targeted by JavaCPP version 1.5.5: DO NOT EDIT THIS FILE

package org.bytedeco.tvm;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.opencl.*;
import static org.bytedeco.opencl.global.OpenCL.*;
import org.bytedeco.dnnl.*;
import static org.bytedeco.dnnl.global.dnnl.*;
import org.bytedeco.llvm.LLVM.*;
import static org.bytedeco.llvm.global.LLVM.*;
import static org.bytedeco.mkl.global.mkl_rt.*;

import static org.bytedeco.tvm.global.tvm_runtime.*;


/**
 * \brief Base template for classes with array like memory layout.
 *
 *        It provides general methods to access the memory. The memory
 *        layout is ArrayType + [ElemType]. The alignment of ArrayType
 *        and ElemType is handled by the memory allocator.
 *
 * \tparam ArrayType The array header type, contains object specific metadata.
 * \tparam ElemType The type of objects stored in the array right after
 * ArrayType.
 *
 * <pre>{@code
 * // Example usage of the template to define a simple array wrapper
 * class ArrayObj : public InplaceArrayBase<ArrayObj, Elem> {
 * public:
 *  // Wrap EmplaceInit to initialize the elements
 *  template <typename Iterator>
 *  void Init(Iterator begin, Iterator end) {
 *   size_t num_elems = std::distance(begin, end);
 *   auto it = begin;
 *   this->size = 0;
 *   for (size_t i = 0; i < num_elems; ++i) {
 *     InplaceArrayBase::EmplaceInit(i, *it++);
 *     this->size++;
 *   }
 *  }
 * }
 *
 * void test_function() {
 *   vector<Elem> fields;
 *   auto ptr = make_inplace_array_object<ArrayObj, Elem>(fields.size());
 *   ptr->Init(fields.begin(), fields.end());
 *
 *   // Access the 0th element in the array.
 *   assert(ptr->operator[](0) == fields[0]);
 * }
 *
 * }</pre>
 */
@Name("tvm::runtime::InplaceArrayBase<tvm::runtime::ADTObj,tvm::runtime::ObjectRef>") @Properties(inherit = org.bytedeco.tvm.presets.tvm_runtime.class)
public class ADTObjBase extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public ADTObjBase() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public ADTObjBase(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public ADTObjBase(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public ADTObjBase position(long position) {
        return (ADTObjBase)super.position(position);
    }
    @Override public ADTObjBase getPointer(long i) {
        return new ADTObjBase((Pointer)this).position(position + i);
    }

  /**
   * \brief Access element at index
   * @param idx The index of the element.
   * @return Const reference to ElemType at the index.
   */

  /**
   * \brief Access element at index
   * @param idx The index of the element.
   * @return Reference to ElemType at the index.
   */
  public native @ByRef @Name("operator []") ObjectRef get(@Cast("size_t") long idx);

  /**
   * \brief Destroy the Inplace Array Base object
   */
}
