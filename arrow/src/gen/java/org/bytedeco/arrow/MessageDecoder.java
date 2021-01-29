// Targeted by JavaCPP version 1.5.5-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.arrow;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.arrow.global.arrow.*;


/** \class MessageDecoder
 *  \brief Push style message decoder that receives data from user.
 * 
 *  This API is EXPERIMENTAL.
 * 
 *  @since 0.17.0 */
@Namespace("arrow::ipc") @NoOffset @Properties(inherit = org.bytedeco.arrow.presets.arrow.class)
public class MessageDecoder extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public MessageDecoder(Pointer p) { super(p); }

  /** \brief State for reading a message */
  public enum State {
    /** The initial state. It requires one of the followings as the next data:
     * 
     *    * int32_t continuation token
     *    * int32_t end-of-stream mark (== 0)
     *    * int32_t metadata length (backward compatibility for
     *      reading old IPC messages produced prior to version 0.15.0 */
    INITIAL(0),

    /** It requires int32_t metadata length. */
    METADATA_LENGTH(1),

    /** It requires metadata. */
    METADATA(2),

    /** It requires message body. */
    BODY(3),

    /** The end-of-stream state. No more data is processed. */
    EOS(4);

      public final int value;
      private State(int v) { this.value = v; }
      private State(State e) { this.value = e.value; }
      public State intern() { for (State e : values()) if (e.value == value) return e; return this; }
      @Override public String toString() { return intern().name(); }
  }

  /** \brief Construct a message decoder.
   * 
   *  @param listener [in] a MessageDecoderListener that responds events from
   *  the decoder
   *  @param pool [in] an optional MemoryPool to copy metadata on the
   *  CPU, if required */
  
  ///
  ///
  public MessageDecoder(@SharedPtr MessageDecoderListener listener,
                            MemoryPool pool/*=arrow::default_memory_pool()*/) { super((Pointer)null); allocate(listener, pool); }
  private native void allocate(@SharedPtr MessageDecoderListener listener,
                            MemoryPool pool/*=arrow::default_memory_pool()*/);
  public MessageDecoder(@SharedPtr MessageDecoderListener listener) { super((Pointer)null); allocate(listener); }
  private native void allocate(@SharedPtr MessageDecoderListener listener);

  /** \brief Construct a message decoder with the specified state.
   * 
   *  This is a construct for advanced users that know how to decode
   *  Message.
   * 
   *  @param listener [in] a MessageDecoderListener that responds events from
   *  the decoder
   *  @param initial_state [in] an initial state of the decode
   *  @param initial_next_required_size [in] the number of bytes needed
   *  to run the next action
   *  @param pool [in] an optional MemoryPool to copy metadata on the
   *  CPU, if required */
  public MessageDecoder(@SharedPtr MessageDecoderListener listener, State initial_state,
                   @Cast("int64_t") long initial_next_required_size,
                   MemoryPool pool/*=arrow::default_memory_pool()*/) { super((Pointer)null); allocate(listener, initial_state, initial_next_required_size, pool); }
  private native void allocate(@SharedPtr MessageDecoderListener listener, State initial_state,
                   @Cast("int64_t") long initial_next_required_size,
                   MemoryPool pool/*=arrow::default_memory_pool()*/);
  public MessageDecoder(@SharedPtr MessageDecoderListener listener, State initial_state,
                   @Cast("int64_t") long initial_next_required_size) { super((Pointer)null); allocate(listener, initial_state, initial_next_required_size); }
  private native void allocate(@SharedPtr MessageDecoderListener listener, State initial_state,
                   @Cast("int64_t") long initial_next_required_size);
  public MessageDecoder(@SharedPtr MessageDecoderListener listener, @Cast("arrow::ipc::MessageDecoder::State") int initial_state,
                   @Cast("int64_t") long initial_next_required_size,
                   MemoryPool pool/*=arrow::default_memory_pool()*/) { super((Pointer)null); allocate(listener, initial_state, initial_next_required_size, pool); }
  private native void allocate(@SharedPtr MessageDecoderListener listener, @Cast("arrow::ipc::MessageDecoder::State") int initial_state,
                   @Cast("int64_t") long initial_next_required_size,
                   MemoryPool pool/*=arrow::default_memory_pool()*/);
  public MessageDecoder(@SharedPtr MessageDecoderListener listener, @Cast("arrow::ipc::MessageDecoder::State") int initial_state,
                   @Cast("int64_t") long initial_next_required_size) { super((Pointer)null); allocate(listener, initial_state, initial_next_required_size); }
  private native void allocate(@SharedPtr MessageDecoderListener listener, @Cast("arrow::ipc::MessageDecoder::State") int initial_state,
                   @Cast("int64_t") long initial_next_required_size);

  /** \brief Feed data to the decoder as a raw data.
   * 
   *  If the decoder can decode one or more messages by the data, the
   *  decoder calls listener->OnMessageDecoded() with a decoded
   *  message multiple times.
   * 
   *  If the state of the decoder is changed, corresponding callbacks
   *  on listener is called:
   * 
   *  * MessageDecoder::State::INITIAL: listener->OnInitial()
   *  * MessageDecoder::State::METADATA_LENGTH: listener->OnMetadataLength()
   *  * MessageDecoder::State::METADATA: listener->OnMetadata()
   *  * MessageDecoder::State::BODY: listener->OnBody()
   *  * MessageDecoder::State::EOS: listener->OnEOS()
   * 
   *  @param data [in] a raw data to be processed. This data isn't
   *  copied. The passed memory must be kept alive through message
   *  processing.
   *  @param size [in] raw data size.
   *  @return Status */
  
  ///
  ///
  public native @ByVal Status Consume(@Cast("const uint8_t*") BytePointer data, @Cast("int64_t") long size);
  public native @ByVal Status Consume(@Cast("const uint8_t*") ByteBuffer data, @Cast("int64_t") long size);
  public native @ByVal Status Consume(@Cast("const uint8_t*") byte[] data, @Cast("int64_t") long size);

  /** \brief Feed data to the decoder as a Buffer.
   * 
   *  If the decoder can decode one or more messages by the Buffer,
   *  the decoder calls listener->OnMessageDecoded() with a decoded
   *  message multiple times.
   * 
   *  @param buffer [in] a Buffer to be processed.
   *  @return Status */
  
  ///
  ///
  ///
  ///
  ///
  ///
  ///
  ///
  ///
  ///
  ///
  public native @ByVal Status Consume(@SharedPtr ArrowBuffer buffer);

  /** \brief Return the number of bytes needed to advance the state of
   *  the decoder.
   * 
   *  This method is provided for users who want to optimize performance.
   *  Normal users don't need to use this method.
   * 
   *  Here is an example usage for normal users:
   * 
   *  ~~~{.cpp}
   *  decoder.Consume(buffer1);
   *  decoder.Consume(buffer2);
   *  decoder.Consume(buffer3);
   *  ~~~
   * 
   *  Decoder has internal buffer. If consumed data isn't enough to
   *  advance the state of the decoder, consumed data is buffered to
   *  the internal buffer. It causes performance overhead.
   * 
   *  If you pass next_required_size() size data to each Consume()
   *  call, the decoder doesn't use its internal buffer. It improves
   *  performance.
   * 
   *  Here is an example usage to avoid using internal buffer:
   * 
   *  ~~~{.cpp}
   *  buffer1 = get_data(decoder.next_required_size());
   *  decoder.Consume(buffer1);
   *  buffer2 = get_data(decoder.next_required_size());
   *  decoder.Consume(buffer2);
   *  ~~~
   * 
   *  Users can use this method to avoid creating small
   *  chunks. Message body must be contiguous data. If users pass
   *  small chunks to the decoder, the decoder needs concatenate small
   *  chunks internally. It causes performance overhead.
   * 
   *  Here is an example usage to reduce small chunks:
   * 
   *  ~~~{.cpp}
   *  buffer = AllocateResizableBuffer();
   *  while ((small_chunk = get_data(&small_chunk_size))) {
   *    auto current_buffer_size = buffer->size();
   *    buffer->Resize(current_buffer_size + small_chunk_size);
   *    memcpy(buffer->mutable_data() + current_buffer_size,
   *           small_chunk,
   *           small_chunk_size);
   *    if (buffer->size() < decoder.next_required_size()) {
   *      continue;
   *    }
   *    std::shared_ptr<arrow::Buffer> chunk(buffer.release());
   *    decoder.Consume(chunk);
   *    buffer = AllocateResizableBuffer();
   *  }
   *  if (buffer->size() > 0) {
   *    std::shared_ptr<arrow::Buffer> chunk(buffer.release());
   *    decoder.Consume(chunk);
   *  }
   *  ~~~
   * 
   *  @return the number of bytes needed to advance the state of the
   *  decoder */
  
  ///
  ///
  ///
  ///
  public native @Cast("int64_t") long next_required_size();

  /** \brief Return the current state of the decoder.
   * 
   *  This method is provided for users who want to optimize performance.
   *  Normal users don't need to use this method.
   * 
   *  Decoder doesn't need Buffer to process data on the
   *  MessageDecoder::State::INITIAL state and the
   *  MessageDecoder::State::METADATA_LENGTH. Creating Buffer has
   *  performance overhead. Advanced users can avoid creating Buffer
   *  by checking the current state of the decoder:
   * 
   *  ~~~{.cpp}
   *  switch (decoder.state()) {
   *    MessageDecoder::State::INITIAL:
   *    MessageDecoder::State::METADATA_LENGTH:
   *      {
   *        uint8_t data[sizeof(int32_t)];
   *        auto data_size = input->Read(decoder.next_required_size(), data);
   *        decoder.Consume(data, data_size);
   *      }
   *      break;
   *    default:
   *      {
   *        auto buffer = input->Read(decoder.next_required_size());
   *        decoder.Consume(buffer);
   *      }
   *      break;
   *  }
   *  ~~~
   * 
   *  @return the current state */
  public native State state();
}
