// Targeted by JavaCPP version 1.5.5-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.arrow;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.arrow.global.arrow.*;


/** \brief Synchronous batch stream reader that reads from io::InputStream
 * 
 *  This class reads the schema (plus any dictionaries) as the first messages
 *  in the stream, followed by record batches. For more granular zero-copy
 *  reads see the ReadRecordBatch functions */
@Namespace("arrow::ipc") @Properties(inherit = org.bytedeco.arrow.presets.arrow.class)
public class RecordBatchStreamReader extends RecordBatchReader {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public RecordBatchStreamReader(Pointer p) { super(p); }

  /** Create batch reader from generic MessageReader.
   *  This will take ownership of the given MessageReader.
   * 
   *  @param message_reader [in] a MessageReader implementation
   *  @param options [in] any IPC reading options (optional)
   *  @return the created batch reader */
  
  ///
  public static native @ByVal RecordBatchStreamReaderResult Open(
        @UniquePtr MessageReader message_reader,
        @Const @ByRef(nullValue = "arrow::ipc::IpcReadOptions::Defaults()") IpcReadOptions options);
  public static native @ByVal RecordBatchStreamReaderResult Open(
        @UniquePtr MessageReader message_reader);

  /** \brief Record batch stream reader from InputStream
   * 
   *  @param stream [in] an input stream instance. Must stay alive throughout
   *  lifetime of stream reader
   *  @param options [in] any IPC reading options (optional)
   *  @return the created batch reader */
  public static native @ByVal RecordBatchStreamReaderResult Open(
        InputStream stream,
        @Const @ByRef(nullValue = "arrow::ipc::IpcReadOptions::Defaults()") IpcReadOptions options);
  public static native @ByVal RecordBatchStreamReaderResult Open(
        InputStream stream);

  /** \brief Open stream and retain ownership of stream object
   *  @param stream [in] the input stream
   *  @param options [in] any IPC reading options (optional)
   *  @return the created batch reader */

  /** \brief Return current read statistics */
  public native @ByVal ReadStats stats();
}
