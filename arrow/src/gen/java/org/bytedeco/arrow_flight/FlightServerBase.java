// Targeted by JavaCPP version 1.5.4: DO NOT EDIT THIS FILE

package org.bytedeco.arrow_flight;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.arrow.*;
import static org.bytedeco.arrow.global.arrow.*;

import static org.bytedeco.arrow.global.arrow_flight.*;


/** \brief Skeleton RPC server implementation which can be used to create
 *  custom servers by implementing its abstract methods */
@Namespace("arrow::flight") @NoOffset @Properties(inherit = org.bytedeco.arrow.presets.arrow_flight.class)
public class FlightServerBase extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public FlightServerBase(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public FlightServerBase(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public FlightServerBase position(long position) {
        return (FlightServerBase)super.position(position);
    }
    @Override public FlightServerBase getPointer(long i) {
        return new FlightServerBase(this).position(position + i);
    }

  public FlightServerBase() { super((Pointer)null); allocate(); }
  private native void allocate();

  // Lifecycle methods.

  /** \brief Initialize a Flight server listening at the given location.
   *  This method must be called before any other method.
   *  @param options [in] The configuration for this server. */
  public native @ByVal Status Init(@Const @ByRef FlightServerOptions options);

  /** \brief Get the port that the Flight server is listening on.
   *  This method must only be called after Init().  Will return a
   *  non-positive value if no port exists (e.g. when listening on a
   *  domain socket). */
  public native int port();

  /** \brief Set the server to stop when receiving any of the given signal
   *  numbers.
   *  This method must be called before Serve(). */
  public native @ByVal Status SetShutdownOnSignals(@StdVector IntPointer sigs);
  public native @ByVal Status SetShutdownOnSignals(@StdVector IntBuffer sigs);
  public native @ByVal Status SetShutdownOnSignals(@StdVector int[] sigs);

  /** \brief Start serving.
   *  This method blocks until either Shutdown() is called or one of the signals
   *  registered in SetShutdownOnSignals() is received. */
  
  ///
  public native @ByVal Status Serve();

  /** \brief Query whether Serve() was interrupted by a signal.
   *  This method must be called after Serve() has returned.
   * 
   *  @return int the signal number that interrupted Serve(), if any, otherwise 0 */
  
  ///
  public native int GotSignal();

  /** \brief Shut down the server. Can be called from signal handler or another
   *  thread while Serve() blocks.
   * 
   *  TODO(wesm): Shutdown with deadline */
  public native @ByVal Status Shutdown();

  /** \brief Block until server is terminated with Shutdown. */
  public native @ByVal Status Wait();

  // Implement these methods to create your own server. The default
  // implementations will return a not-implemented result to the client

  /** \brief Retrieve a list of available fields given an optional opaque
   *  criteria
   *  @param context [in] The call context.
   *  @param criteria [in] may be null
   *  @param listings [out] the returned listings iterator
   *  @return Status */
  public native @ByVal Status ListFlights(@Const @ByRef ServerCallContext context, @Const Criteria criteria,
                               @UniquePtr FlightListing listings);

  /** \brief Retrieve the schema and an access plan for the indicated
   *  descriptor
   *  @param context [in] The call context.
   *  @param request [in] may be null
   *  @param info [out] the returned flight info provider
   *  @return Status */
  public native @ByVal Status GetFlightInfo(@Const @ByRef ServerCallContext context,
                                 @Const @ByRef FlightDescriptor request,
                                 @UniquePtr FlightInfo info);

  /** \brief Retrieve the schema for the indicated descriptor
   *  @param context [in] The call context.
   *  @param request [in] may be null
   *  @param schema [out] the returned flight schema provider
   *  @return Status */
  public native @ByVal Status GetSchema(@Const @ByRef ServerCallContext context,
                             @Const @ByRef FlightDescriptor request,
                             @UniquePtr SchemaResult schema);

  /** \brief Get a stream of IPC payloads to put on the wire
   *  @param context [in] The call context.
   *  @param request [in] an opaque ticket
   *  @param stream [out] the returned stream provider
   *  @return Status */
  public native @ByVal Status DoGet(@Const @ByRef ServerCallContext context, @Const @ByRef Ticket request,
                         @UniquePtr FlightDataStream stream);

  /** \brief Process a stream of IPC payloads sent from a client
   *  @param context [in] The call context.
   *  @param reader [in] a sequence of uploaded record batches
   *  @param writer [in] send metadata back to the client
   *  @return Status */
  public native @ByVal Status DoPut(@Const @ByRef ServerCallContext context,
                         @UniquePtr FlightMessageReader reader,
                         @UniquePtr FlightMetadataWriter writer);

  /** \brief Process a bidirectional stream of IPC payloads
   *  @param context [in] The call context.
   *  @param reader [in] a sequence of uploaded record batches
   *  @param writer [in] send data back to the client
   *  @return Status */
  public native @ByVal Status DoExchange(@Const @ByRef ServerCallContext context,
                              @UniquePtr FlightMessageReader reader,
                              @UniquePtr FlightMessageWriter writer);

  /** \brief Execute an action, return stream of zero or more results
   *  @param context [in] The call context.
   *  @param action [in] the action to execute, with type and body
   *  @param result [out] the result iterator
   *  @return Status */
  public native @ByVal Status DoAction(@Const @ByRef ServerCallContext context, @Const @ByRef Action action,
                            @UniquePtr ResultStream result);

  /** \brief Retrieve the list of available actions
   *  @param context [in] The call context.
   *  @param actions [out] a vector of available action types
   *  @return Status */
  public native @ByVal Status ListActions(@Const @ByRef ServerCallContext context,
                               @StdVector ActionType actions);
}
