// Targeted by JavaCPP version 1.5.4-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.arrow;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.arrow.global.arrow.*;


// TODO Simplify this.  Subgroups don't seem necessary.

/** \brief A group of related tasks
 * 
 *  A TaskGroup executes tasks with the signature {@code Status()}.
 *  Execution can be serial or parallel, depending on the TaskGroup
 *  implementation.  When Finish() returns, it is guaranteed that all
 *  tasks have finished, or at least one has errored.
 *  */
@Namespace("arrow::internal") @Properties(inherit = org.bytedeco.arrow.presets.arrow.class)
public class TaskGroup extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public TaskGroup(Pointer p) { super(p); }

  /** Add a Status-returning function to execute.  Execution order is
   *  undefined.  The function may be executed immediately or later. */

  /** Wait for execution of all tasks (and subgroups) to be finished,
   *  or for at least one task (or subgroup) to error out.
   *  The returned Status propagates the error status of the first failing
   *  task (or subgroup). */
  public native @ByVal Status Finish();

  /** The current aggregate error Status.  Non-blocking, useful for stopping early. */
  public native @ByVal Status current_status();

  /** Whether some tasks have already failed.  Non-blocking , useful for stopping early. */
  public native @Cast("bool") boolean ok();

  /** How many tasks can typically be executed in parallel.
   *  This is only a hint, useful for testing or debugging. */
  public native int parallelism();

  /** Create a subgroup of this group.  This group can only finish
   *  when all subgroups have finished (this means you must be
   *  be careful to call Finish() on subgroups before calling it
   *  on the main group). */
  // XXX if a subgroup errors out, should it propagate immediately to the parent
  // and to children?
  public native @SharedPtr TaskGroup MakeSubGroup();

  public static native @SharedPtr TaskGroup MakeSerial();
  public static native @SharedPtr TaskGroup MakeThreaded(Executor arg0);
}
