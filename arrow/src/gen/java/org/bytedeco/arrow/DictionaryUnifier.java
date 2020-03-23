// Targeted by JavaCPP version 1.5.3-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.arrow;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.arrow.global.arrow.*;


/** \brief Helper class for incremental dictionary unification */
@Namespace("arrow") @Properties(inherit = org.bytedeco.arrow.presets.arrow.class)
public class DictionaryUnifier extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public DictionaryUnifier(Pointer p) { super(p); }


  /** \brief Construct a DictionaryUnifier
   *  @param pool [in] MemoryPool to use for memory allocations
   *  @param value_type [in] the data type of the dictionaries
   *  @param out [out] the constructed unifier */
  public static native @ByVal Status Make(MemoryPool pool, @SharedPtr @Cast({"", "std::shared_ptr<arrow::DataType>"}) DataType value_type,
                       @UniquePtr DictionaryUnifier out);

  /** \brief Append dictionary to the internal memo */
  public native @ByVal Status Unify(@Const @ByRef Array dictionary);

  /** \brief Append dictionary and compute transpose indices
   *  @param dictionary [in] the dictionary values to unify
   *  @param out_transpose [out] a Buffer containing computed transpose indices
   *  as int32_t values equal in length to the passed dictionary. The value in
   *  each slot corresponds to the new index value for each original index
   *  for a DictionaryArray with the old dictionary */
  public native @ByVal Status Unify(@Const @ByRef Array dictionary,
                         @SharedPtr @Cast({"", "std::shared_ptr<arrow::Buffer>*"}) ArrowBuffer out_transpose);

  /** \brief Return a result DictionaryType with the smallest possible index
   *  type to accommodate the unified dictionary. The unifier cannot be used
   *  after this is called */
  public native @ByVal Status GetResult(@SharedPtr @Cast({"", "std::shared_ptr<arrow::DataType>*"}) DataType out_type,
                             @SharedPtr Array out_dict);
}