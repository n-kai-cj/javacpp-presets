// Targeted by JavaCPP version 1.5.5-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.arrow.global;

import org.bytedeco.arrow_dataset.*;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.arrow.*;
import static org.bytedeco.arrow.global.arrow.*;
import org.bytedeco.parquet.*;
import static org.bytedeco.arrow.global.parquet.*;

public class arrow_dataset extends org.bytedeco.arrow.presets.arrow_dataset {
    static { Loader.load(); }

// Targeting ../../arrow_dataset/ExpressionVector.java


// Targeting ../../arrow_dataset/FileFragmentVector.java


// Targeting ../../arrow_dataset/ScanTaskVector.java


// Targeting ../../arrow_dataset/StringUnorderedSet.java


// Parsed from arrow/util/iterator.h

// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

// #pragma once

// #include <cassert>
// #include <functional>
// #include <memory>
// #include <tuple>
// #include <type_traits>
// #include <utility>
// #include <vector>

// #include "arrow/result.h"
// #include "arrow/status.h"
// #include "arrow/util/compare.h"
// #include "arrow/util/functional.h"
// #include "arrow/util/macros.h"
// #include "arrow/util/optional.h"
// #include "arrow/util/visibility.h"
// Targeting ../../arrow_dataset/FragmentIterator.java


// Targeting ../../arrow_dataset/ScanTaskIterator.java



/** \brief Construct an Iterator which invokes a callable on Next() */

/** \brief Simple iterator which yields the elements of a std::vector */

/** \brief Simple iterator which yields *pointers* to the elements of a std::vector<T>.
 *  This is provided to support T where IterationTraits<T>::End is not specialized */

/** \brief MapIterator takes ownership of an iterator and a function to apply
 *  on every element. The mapped function is not allowed to fail. */

/** \brief MapIterator takes ownership of an iterator and a function to apply
 *  on every element. The mapped function is not allowed to fail. */
// Targeting ../../arrow_dataset/FilterIterator.java



/** \brief Like MapIterator, but where the function can fail or reject elements. */

/** \brief FlattenIterator takes an iterator generating iterators and yields a
 *  unified iterator that flattens/concatenates in a single stream. */
// Targeting ../../arrow_dataset/ReadaheadPromise.java


// Targeting ../../arrow_dataset/ReadaheadQueue.java



  // namespace detail

/** \brief Readahead iterator that iterates on the underlying iterator in a
 *  separate thread, getting up to N values in advance. */

  // namespace arrow


// Parsed from arrow/result.h

//
// Copyright 2017 Asylo authors
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//

// Adapted from Asylo

// #pragma once

// #include <new>
// #include <string>
// #include <type_traits>
// #include <utility>

// #include "arrow/status.h"
// #include "arrow/util/compare.h"

// #if __cplusplus >= 201703L
// #else
// #endif

@Namespace("arrow::internal") public static native void DieWithMessage(@StdString String msg);
@Namespace("arrow::internal") public static native void DieWithMessage(@StdString BytePointer msg);

@Namespace("arrow::internal") public static native void InvalidValueOrDie(@Const @ByRef Status st);


// Targeting ../../arrow_dataset/DatasetResult.java


// Targeting ../../arrow_dataset/DatasetFactoryResult.java


// Targeting ../../arrow_dataset/ExpressionResult.java


// Targeting ../../arrow_dataset/FileSystemDatasetResult.java


// Targeting ../../arrow_dataset/FileFragmentResult.java


// Targeting ../../arrow_dataset/FileWriterResult.java


// Targeting ../../arrow_dataset/FragmentResult.java


// Targeting ../../arrow_dataset/ScannerResult.java


// Targeting ../../arrow_dataset/ScannerBuilderResult.java


// Targeting ../../arrow_dataset/ScanTaskResult.java


// Targeting ../../arrow_dataset/FileReaderResult.java


// Targeting ../../arrow_dataset/UnionDatasetResult.java


// Targeting ../../arrow_dataset/FragmentIteratorResult.java


// Targeting ../../arrow_dataset/ScanTaskIteratorResult.java


// Targeting ../../arrow_dataset/ScanTaskVectorResult.java


// Targeting ../../arrow_dataset/FragmentVectorResult.java



// #define ARROW_ASSIGN_OR_RAISE_IMPL(result_name, lhs, rexpr)
//   auto&& result_name = (rexpr);
//   ARROW_RETURN_NOT_OK((result_name).status());
//   lhs = std::move(result_name).ValueUnsafe();


///
///
///
// #define ARROW_ASSIGN_OR_RAISE_NAME(x, y) ARROW_CONCAT(x, y)

/** \brief Execute an expression that returns a Result, extracting its value
 *  into the variable defined by {@code lhs} (or returning a Status on error).
 * 
 *  Example: Assigning to a new value:
 *    ARROW_ASSIGN_OR_RAISE(auto value, MaybeGetValue(arg));
 * 
 *  Example: Assigning to an existing value:
 *    ValueType value;
 *    ARROW_ASSIGN_OR_RAISE(value, MaybeGetValue(arg));
 * 
 *  WARNING: ARROW_ASSIGN_OR_RAISE expands into multiple statements;
 *  it cannot be used in a single statement (e.g. as the body of an if
 *  statement without {})! */
// #define ARROW_ASSIGN_OR_RAISE(lhs, rexpr)
//   ARROW_ASSIGN_OR_RAISE_IMPL(ARROW_ASSIGN_OR_RAISE_NAME(_error_or_value, __COUNTER__),
//                              lhs, rexpr);

  // namespace internal

  // namespace arrow


// Parsed from arrow/dataset/api.h

// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

// This API is EXPERIMENTAL.

// #pragma once

// #include "arrow/dataset/dataset.h"
// #include "arrow/dataset/discovery.h"
// #include "arrow/dataset/file_base.h"
// #include "arrow/dataset/file_csv.h"
// #include "arrow/dataset/file_ipc.h"
// #include "arrow/dataset/file_parquet.h"
// #include "arrow/dataset/filter.h"
// #include "arrow/dataset/scanner.h"


// Parsed from arrow/dataset/visibility.h

// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

// This API is EXPERIMENTAL.

// #pragma once

// #if defined(_WIN32) || defined(__CYGWIN__)
// #if defined(_MSC_VER)
// #pragma warning(push)
// #pragma warning(disable : 4251)
// #else
// #pragma GCC diagnostic ignored "-Wattributes"
// #endif

// #ifdef ARROW_DS_STATIC
// #define ARROW_DS_EXPORT
// #elif defined(ARROW_DS_EXPORTING)
// #define ARROW_DS_EXPORT __declspec(dllexport)
// #else
// #define ARROW_DS_EXPORT __declspec(dllimport)
// #endif

// #define ARROW_DS_NO_EXPORT
// #else  // Not Windows
// #ifndef ARROW_DS_EXPORT
// #define ARROW_DS_EXPORT __attribute__((visibility("default")))
// #endif
// #ifndef ARROW_DS_NO_EXPORT
// #define ARROW_DS_NO_EXPORT __attribute__((visibility("hidden")))
// #endif
// #endif  // Non-Windows

// #if defined(_MSC_VER)
// #pragma warning(pop)
// #endif


// Parsed from arrow/dataset/type_fwd.h

// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

// This API is EXPERIMENTAL.

// #pragma once

// #include <memory>
// #include <vector>

// #include "arrow/dataset/visibility.h"
// #include "arrow/filesystem/type_fwd.h"  // IWYU pragma: export
// #include "arrow/type_fwd.h"             // IWYU pragma: export

  // namespace compute
// Targeting ../../arrow_dataset/CsvFileFormat.java



/** forward declared to facilitate scalar(true) as a default for Expression parameters */
@Namespace("arrow::dataset") public static native @SharedPtr @ByVal Expression scalar(@Cast("bool") boolean arg0);
// Targeting ../../arrow_dataset/Partitioning.java


// Targeting ../../arrow_dataset/PartitioningFactory.java


// Targeting ../../arrow_dataset/PartitioningOrFactory.java


// Targeting ../../arrow_dataset/RecordBatchProjector.java



  // namespace dataset
  // namespace arrow


// Parsed from arrow/dataset/dataset.h

// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

// This API is EXPERIMENTAL.

// #pragma once

// #include <functional>
// #include <memory>
// #include <string>
// #include <utility>
// #include <vector>

// #include "arrow/dataset/type_fwd.h"
// #include "arrow/dataset/visibility.h"
// #include "arrow/util/macros.h"
// #include "arrow/util/mutex.h"
// Targeting ../../arrow_dataset/Fragment.java


// Targeting ../../arrow_dataset/InMemoryFragment.java


// Targeting ../../arrow_dataset/Dataset.java


// Targeting ../../arrow_dataset/InMemoryDataset.java


// Targeting ../../arrow_dataset/UnionDataset.java



  // namespace dataset
  // namespace arrow


// Parsed from arrow/dataset/discovery.h

// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

/** Logic for automatically determining the structure of multi-file
 *  dataset with possible partitioning according to available
 *  partitioning */

// This API is EXPERIMENTAL.

// #pragma once

// #include <memory>
// #include <string>
// #include <vector>

// #include "arrow/dataset/partition.h"
// #include "arrow/dataset/type_fwd.h"
// #include "arrow/dataset/visibility.h"
// #include "arrow/filesystem/filesystem.h"
// #include "arrow/filesystem/path_forest.h"
// #include "arrow/result.h"
// #include "arrow/util/macros.h"
// #include "arrow/util/variant.h"
// Targeting ../../arrow_dataset/InspectOptions.java


// Targeting ../../arrow_dataset/FinishOptions.java


// Targeting ../../arrow_dataset/DatasetFactory.java


// Targeting ../../arrow_dataset/UnionDatasetFactory.java


// Targeting ../../arrow_dataset/FileSystemFactoryOptions.java


// Targeting ../../arrow_dataset/FileSystemDatasetFactory.java



  // namespace dataset
  // namespace arrow


// Parsed from arrow/dataset/scanner.h

// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

// This API is EXPERIMENTAL.

// #pragma once

// #include <memory>
// #include <string>
// #include <unordered_set>
// #include <utility>
// #include <vector>

// #include "arrow/dataset/dataset.h"
// #include "arrow/dataset/projector.h"
// #include "arrow/dataset/type_fwd.h"
// #include "arrow/dataset/visibility.h"
// #include "arrow/memory_pool.h"
// #include "arrow/type_fwd.h"
// #include "arrow/util/type_fwd.h"

@Namespace("arrow::dataset") @MemberGetter public static native @Cast("const int64_t") long kDefaultBatchSize();
// Targeting ../../arrow_dataset/ScanContext.java


// Targeting ../../arrow_dataset/ScanOptions.java


// Targeting ../../arrow_dataset/ScanTask.java


// Targeting ../../arrow_dataset/InMemoryScanTask.java




///
@Namespace("arrow::dataset") public static native @ByVal ScanTaskIteratorResult ScanTaskIteratorFromRecordBatch(
    @ByVal RecordBatchVector batches,
    @SharedPtr ScanOptions options, @SharedPtr ScanContext arg2);
// Targeting ../../arrow_dataset/Scanner.java


// Targeting ../../arrow_dataset/ScannerBuilder.java



  // namespace dataset
  // namespace arrow


// Parsed from arrow/dataset/file_base.h

// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

// This API is EXPERIMENTAL.

// #pragma once

// #include <functional>
// #include <memory>
// #include <string>
// #include <unordered_map>
// #include <utility>
// #include <vector>

// #include "arrow/buffer.h"
// #include "arrow/dataset/dataset.h"
// #include "arrow/dataset/partition.h"
// #include "arrow/dataset/scanner.h"
// #include "arrow/dataset/type_fwd.h"
// #include "arrow/dataset/visibility.h"
// #include "arrow/filesystem/filesystem.h"
// #include "arrow/filesystem/path_forest.h"
// #include "arrow/io/file.h"
// #include "arrow/util/compression.h"
// Targeting ../../arrow_dataset/FileSource.java


// Targeting ../../arrow_dataset/FileFormat.java


// Targeting ../../arrow_dataset/FileFragment.java


// Targeting ../../arrow_dataset/FileSystemDataset.java


// Targeting ../../arrow_dataset/FileWriteOptions.java


// Targeting ../../arrow_dataset/FileWriter.java


// Targeting ../../arrow_dataset/FileSystemDatasetWriteOptions.java



  // namespace dataset
  // namespace arrow


// Parsed from arrow/dataset/file_ipc.h

// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

// This API is EXPERIMENTAL.

// #pragma once

// #include <memory>
// #include <string>

// #include "arrow/dataset/file_base.h"
// #include "arrow/dataset/type_fwd.h"
// #include "arrow/dataset/visibility.h"
// #include "arrow/result.h"

  // namespace ipc
// Targeting ../../arrow_dataset/IpcFileFormat.java


// Targeting ../../arrow_dataset/IpcFileWriteOptions.java


// Targeting ../../arrow_dataset/IpcFileWriter.java



  // namespace dataset
  // namespace arrow


// Parsed from arrow/dataset/file_parquet.h

// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

// This API is EXPERIMENTAL.

// #pragma once

// #include <memory>
// #include <string>
// #include <unordered_map>
// #include <unordered_set>
// #include <utility>
// #include <vector>

// #include "arrow/dataset/discovery.h"
// #include "arrow/dataset/file_base.h"
// #include "arrow/dataset/type_fwd.h"
// #include "arrow/dataset/visibility.h"
// #include "arrow/util/optional.h"
  // namespace arrow
  // namespace parquet
// Targeting ../../arrow_dataset/ParquetFileFormat.java


// Targeting ../../arrow_dataset/RowGroupInfo.java


// Targeting ../../arrow_dataset/ParquetFileFragment.java


// Targeting ../../arrow_dataset/ParquetFileWriteOptions.java


// Targeting ../../arrow_dataset/ParquetFileWriter.java


// Targeting ../../arrow_dataset/ParquetFactoryOptions.java


// Targeting ../../arrow_dataset/ParquetDatasetFactory.java



  // namespace dataset
  // namespace arrow


// Parsed from arrow/dataset/filter.h

// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

// This API is EXPERIMENTAL.

// #pragma once

// #include <functional>
// #include <memory>
// #include <string>
// #include <utility>
// #include <vector>

// #include "arrow/compute/api_scalar.h"
// #include "arrow/compute/cast.h"
// #include "arrow/dataset/type_fwd.h"
// #include "arrow/dataset/visibility.h"
// #include "arrow/datum.h"
// #include "arrow/result.h"
// #include "arrow/scalar.h"
// #include "arrow/type_fwd.h"
// #include "arrow/util/checked_cast.h"
// #include "arrow/util/variant.h"
// Targeting ../../arrow_dataset/ExpressionType.java


// Targeting ../../arrow_dataset/Expression.java


// Targeting ../../arrow_dataset/CastExpressionImpl.java


// Targeting ../../arrow_dataset/InExpressionImpl.java


// Targeting ../../arrow_dataset/IsValidExpressionImpl.java


// Targeting ../../arrow_dataset/NotExpressionImpl.java


// Targeting ../../arrow_dataset/OrExpressionImpl.java


// Targeting ../../arrow_dataset/AndExpressionImpl.java


// Targeting ../../arrow_dataset/ComparisonExpressionImpl.java


// Targeting ../../arrow_dataset/UnaryExpression.java


// Targeting ../../arrow_dataset/BinaryExpression.java


// Targeting ../../arrow_dataset/ComparisonExpression.java


// Targeting ../../arrow_dataset/AndExpression.java


// Targeting ../../arrow_dataset/OrExpression.java


// Targeting ../../arrow_dataset/NotExpression.java


// Targeting ../../arrow_dataset/IsValidExpression.java


// Targeting ../../arrow_dataset/InExpression.java


// Targeting ../../arrow_dataset/CastExpression.java


// Targeting ../../arrow_dataset/ScalarExpression.java


// Targeting ../../arrow_dataset/FieldExpression.java


// Targeting ../../arrow_dataset/CustomExpression.java



@Namespace("arrow::dataset") public static native @SharedPtr @ByVal Expression and_(@SharedPtr @ByVal Expression lhs,
                                                 @SharedPtr @ByVal Expression rhs);

@Namespace("arrow::dataset") public static native @SharedPtr @ByVal Expression and_(@Const @ByRef ExpressionVector subexpressions);

@Namespace("arrow::dataset") public static native @ByVal @Name("operator &&") AndExpression and(@Const @ByRef Expression lhs, @Const @ByRef Expression rhs);

@Namespace("arrow::dataset") public static native @SharedPtr @ByVal Expression or_(@SharedPtr @ByVal Expression lhs,
                                                @SharedPtr @ByVal Expression rhs);

@Namespace("arrow::dataset") public static native @SharedPtr @ByVal Expression or_(@Const @ByRef ExpressionVector subexpressions);

@Namespace("arrow::dataset") public static native @ByVal @Name("operator ||") OrExpression or(@Const @ByRef Expression lhs, @Const @ByRef Expression rhs);

@Namespace("arrow::dataset") public static native @SharedPtr @ByVal Expression not_(@SharedPtr @ByVal Expression operand);

@Namespace("arrow::dataset") public static native @ByVal @Name("operator !") NotExpression not(@Const @ByRef Expression rhs);

@Namespace("arrow::dataset") public static native @SharedPtr @ByVal Expression scalar(@SharedPtr @Cast({"", "std::shared_ptr<arrow::Scalar>"}) Scalar value);

// #define COMPARISON_FACTORY(NAME, FACTORY_NAME, OP)
//   inline std::shared_ptr<ComparisonExpression> FACTORY_NAME(
//       const std::shared_ptr<Expression>& lhs, const std::shared_ptr<Expression>& rhs) {
//     return std::make_shared<ComparisonExpression>(CompareOperator::NAME, lhs, rhs);
//   }
// 
//   template <typename T, typename Enable = typename std::enable_if<!std::is_base_of<
//                             Expression, typename std::decay<T>::type>::value>::type>
//   ComparisonExpression operator OP(const Expression& lhs, T&& rhs) {
//     return ComparisonExpression(CompareOperator::NAME, lhs.Copy(),
//                                 scalar(std::forward<T>(rhs)));
//   }
// 
//   inline ComparisonExpression operator OP(const Expression& lhs,
//                                           const Expression& rhs) {
//     return ComparisonExpression(CompareOperator::NAME, lhs.Copy(), rhs.Copy());
//   }
@Namespace("arrow::dataset") public static native @SharedPtr ComparisonExpression equal(
      @Const @SharedPtr @ByRef Expression lhs, @Const @SharedPtr @ByRef Expression rhs);

  @Namespace("arrow::dataset") public static native @ByVal @Name("operator ==") ComparisonExpression equals(@Const @ByRef Expression lhs,
                                            @Const @ByRef Expression rhs);
@Namespace("arrow::dataset") public static native @SharedPtr ComparisonExpression not_equal(
      @Const @SharedPtr @ByRef Expression lhs, @Const @SharedPtr @ByRef Expression rhs);

  @Namespace("arrow::dataset") public static native @ByVal @Name("operator !=") ComparisonExpression notEquals(@Const @ByRef Expression lhs,
                                            @Const @ByRef Expression rhs);
@Namespace("arrow::dataset") public static native @SharedPtr ComparisonExpression greater(
      @Const @SharedPtr @ByRef Expression lhs, @Const @SharedPtr @ByRef Expression rhs);

  @Namespace("arrow::dataset") public static native @ByVal @Name("operator >") ComparisonExpression greaterThan(@Const @ByRef Expression lhs,
                                            @Const @ByRef Expression rhs);
@Namespace("arrow::dataset") public static native @SharedPtr ComparisonExpression greater_equal(
      @Const @SharedPtr @ByRef Expression lhs, @Const @SharedPtr @ByRef Expression rhs);

  @Namespace("arrow::dataset") public static native @ByVal @Name("operator >=") ComparisonExpression greaterThanEquals(@Const @ByRef Expression lhs,
                                            @Const @ByRef Expression rhs);
@Namespace("arrow::dataset") public static native @SharedPtr ComparisonExpression less(
      @Const @SharedPtr @ByRef Expression lhs, @Const @SharedPtr @ByRef Expression rhs);

  @Namespace("arrow::dataset") public static native @ByVal @Name("operator <") ComparisonExpression lessThan(@Const @ByRef Expression lhs,
                                            @Const @ByRef Expression rhs);
@Namespace("arrow::dataset") public static native @SharedPtr ComparisonExpression less_equal(
      @Const @SharedPtr @ByRef Expression lhs, @Const @SharedPtr @ByRef Expression rhs);

  @Namespace("arrow::dataset") public static native @ByVal @Name("operator <=") ComparisonExpression lessThanEquals(@Const @ByRef Expression lhs,
                                            @Const @ByRef Expression rhs);
// #undef COMPARISON_FACTORY

@Namespace("arrow::dataset") public static native @SharedPtr @ByVal Expression field_ref(@StdString String name);
@Namespace("arrow::dataset") public static native @SharedPtr @ByVal Expression field_ref(@StdString BytePointer name);
// clang-format off

  // namespace string_literals



/** \brief Visit each subexpression of an arbitrarily nested conjunction.
 * 
 *  | given                          | visit                                       |
 *  |--------------------------------|---------------------------------------------|
 *  | a and b                        | visit(a), visit(b)                          |
 *  | c                              | visit(c)                                    |
 *  | (a and b) and ((c or d) and e) | visit(a), visit(b), visit(c or d), visit(e) | */
@Namespace("arrow::dataset") public static native @ByVal Status VisitConjunctionMembers(
    @Const @ByRef Expression expr, @Const @ByRef ExpressionVisitor visitor);

/** \brief Insert CastExpressions where necessary to make a valid expression. */
@Namespace("arrow::dataset") public static native @ByVal ExpressionResult InsertImplicitCasts(
    @Const @ByRef Expression expr, @Const @ByRef Schema schema);

/** \brief Returns field names referenced in the expression. */
@Namespace("arrow::dataset") public static native @ByVal StringVector FieldsInExpression(@Const @ByRef Expression expr);
// Targeting ../../arrow_dataset/ExpressionEvaluator.java


// Targeting ../../arrow_dataset/TreeEvaluator.java



/** \brief Assemble lists of indices of identical rows.
 * 
 *  @param by [in] A StructArray whose columns will be used as grouping criteria.
 *  @return A StructArray mapping unique rows (in field "values", represented as a
 *          StructArray with the same fields as {@code by}) to lists of indices where
 *          that row appears (in field "groupings"). */
@Namespace("arrow::dataset") public static native @ByVal StructArrayResult MakeGroupings(@Const @ByRef StructArray by);

/** \brief Produce slices of an Array which correspond to the provided groupings. */
@Namespace("arrow::dataset") public static native @ByVal ListArrayResult ApplyGroupings(@Const @ByRef ListArray groupings,
                                                  @Const @ByRef Array array);
@Namespace("arrow::dataset") public static native @ByVal RecordBatchVectorResult ApplyGroupings(@Const @ByRef ListArray groupings,
                                         @SharedPtr @Cast({"", "std::shared_ptr<arrow::RecordBatch>"}) RecordBatch batch);

  // namespace dataset
  // namespace arrow


}
