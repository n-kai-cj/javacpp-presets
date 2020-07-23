// Targeted by JavaCPP version 1.5.4-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.arrow;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.arrow.global.arrow.*;


/** \brief A PathForest is a utility to transform a vector of FileInfo into a
 *  forest representation for tree traversal purposes. Note: there is no guarantee of a
 *  shared root. Each node in the graph wraps a FileInfo. Files are expected to be found
 *  only at leaves of the tree. */
@Namespace("arrow::fs") @NoOffset @Properties(inherit = org.bytedeco.arrow.presets.arrow.class)
public class PathForest extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public PathForest(Pointer p) { super(p); }

  /** \brief Transforms a FileInfo vector into a forest. The caller should ensure that
   *  infos does not contain duplicates.
   * 
   *  Vector(s) of associated objects (IE associated[i] is associated with infos[i]) may
   *  be passed for reordering. (After construction, associated[i] is associated with
   *  forest[i]). */

  /** Make a PathForest from a FileInfo vector which is already sorted in a
   *  depth first visitation order. */
  public static native @ByVal PathForestResult MakeFromPreSorted(@StdVector FileInfo sorted_infos);

  /** \brief Returns the number of nodes in this forest. */
  public native int size();

  public native @Cast("bool") boolean Equals(@Const @ByRef PathForest other);

  public native @StdString String ToString();

  /** Reference to a node in the forest */
  public static class Ref extends Pointer {
      static { Loader.load(); }
      /** Default native constructor. */
      public Ref() { super((Pointer)null); allocate(); }
      /** Native array allocator. Access with {@link Pointer#position(long)}. */
      public Ref(long size) { super((Pointer)null); allocateArray(size); }
      /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
      public Ref(Pointer p) { super(p); }
      private native void allocate();
      private native void allocateArray(long size);
      @Override public Ref position(long position) {
          return (Ref)super.position(position);
      }
  
    public native @Const @ByRef FileInfo info();

    public native int num_descendants();

    /** Returns a PathForest containing only nodes which are descendants of this node */
    public native @ByVal PathForest descendants();

    /** This node's parent or Ref{nullptr, 0} if this node has no parent */
    public native @ByVal Ref parent();

    public native @Cast("bool") @Name("operator bool") boolean asBoolean();

    public native @Const PathForest forest(); public native Ref forest(PathForest setter);
    public native int i(); public native Ref i(int setter);
  }

  public native @ByVal @Name("operator []") Ref get(int i);

  public native @StdVector Ref roots();

  public native @StdVector FileInfo infos();
  

  /** enum arrow::fs::PathForest:: */
  public static final int Continue = 0, Prune = 1;

  /** Visitors may return MaybePrune to enable eager pruning. Visitors will be called with
   *  the FileInfo of the currently visited node and the index of that node in depth
   *  first visitation order (useful for accessing parallel vectors of associated data). */
}
