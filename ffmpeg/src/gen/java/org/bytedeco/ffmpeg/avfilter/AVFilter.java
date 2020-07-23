// Targeted by JavaCPP version 1.5.4-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.ffmpeg.avfilter;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.ffmpeg.avutil.*;
import static org.bytedeco.ffmpeg.global.avutil.*;
import org.bytedeco.ffmpeg.swresample.*;
import static org.bytedeco.ffmpeg.global.swresample.*;
import org.bytedeco.ffmpeg.avcodec.*;
import static org.bytedeco.ffmpeg.global.avcodec.*;
import org.bytedeco.ffmpeg.avformat.*;
import static org.bytedeco.ffmpeg.global.avformat.*;
import org.bytedeco.ffmpeg.postproc.*;
import static org.bytedeco.ffmpeg.global.postproc.*;
import org.bytedeco.ffmpeg.swscale.*;
import static org.bytedeco.ffmpeg.global.swscale.*;

import static org.bytedeco.ffmpeg.global.avfilter.*;


/**
 * Filter definition. This defines the pads a filter contains, and all the
 * callback functions used to interact with the filter.
 */
@Properties(inherit = org.bytedeco.ffmpeg.presets.avfilter.class)
public class AVFilter extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public AVFilter() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public AVFilter(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public AVFilter(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public AVFilter position(long position) {
        return (AVFilter)super.position(position);
    }

    /**
     * Filter name. Must be non-NULL and unique among filters.
     */
    public native @Cast("const char*") BytePointer name(); public native AVFilter name(BytePointer setter);

    /**
     * A description of the filter. May be NULL.
     *
     * You should use the NULL_IF_CONFIG_SMALL() macro to define it.
     */
    public native @Cast("const char*") BytePointer description(); public native AVFilter description(BytePointer setter);

    /**
     * List of inputs, terminated by a zeroed element.
     *
     * NULL if there are no (static) inputs. Instances of filters with
     * AVFILTER_FLAG_DYNAMIC_INPUTS set may have more inputs than present in
     * this list.
     */
    public native @Const AVFilterPad inputs(); public native AVFilter inputs(AVFilterPad setter);
    /**
     * List of outputs, terminated by a zeroed element.
     *
     * NULL if there are no (static) outputs. Instances of filters with
     * AVFILTER_FLAG_DYNAMIC_OUTPUTS set may have more outputs than present in
     * this list.
     */
    public native @Const AVFilterPad outputs(); public native AVFilter outputs(AVFilterPad setter);

    /**
     * A class for the private data, used to declare filter private AVOptions.
     * This field is NULL for filters that do not declare any options.
     *
     * If this field is non-NULL, the first member of the filter private data
     * must be a pointer to AVClass, which will be set by libavfilter generic
     * code to this class.
     */
    public native @Const AVClass priv_class(); public native AVFilter priv_class(AVClass setter);

    /**
     * A combination of AVFILTER_FLAG_*
     */
    public native int flags(); public native AVFilter flags(int setter);

    /*****************************************************************
     * All fields below this line are not part of the public API. They
     * may not be used outside of libavfilter and can be changed and
     * removed at will.
     * New public fields should be added right above.
     *****************************************************************
     */

    /**
     * Filter pre-initialization function
     *
     * This callback will be called immediately after the filter context is
     * allocated, to allow allocating and initing sub-objects.
     *
     * If this callback is not NULL, the uninit callback will be called on
     * allocation failure.
     *
     * @return 0 on success,
     *         AVERROR code on failure (but the code will be
     *           dropped and treated as ENOMEM by the calling code)
     */
    public static class Preinit_AVFilterContext extends FunctionPointer {
        static { Loader.load(); }
        /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
        public    Preinit_AVFilterContext(Pointer p) { super(p); }
        protected Preinit_AVFilterContext() { allocate(); }
        private native void allocate();
        public native int call(AVFilterContext ctx);
    }
    public native Preinit_AVFilterContext preinit(); public native AVFilter preinit(Preinit_AVFilterContext setter);

    /**
     * Filter initialization function.
     *
     * This callback will be called only once during the filter lifetime, after
     * all the options have been set, but before links between filters are
     * established and format negotiation is done.
     *
     * Basic filter initialization should be done here. Filters with dynamic
     * inputs and/or outputs should create those inputs/outputs here based on
     * provided options. No more changes to this filter's inputs/outputs can be
     * done after this callback.
     *
     * This callback must not assume that the filter links exist or frame
     * parameters are known.
     *
     * \ref AVFilter.uninit "uninit" is guaranteed to be called even if
     * initialization fails, so this callback does not have to clean up on
     * failure.
     *
     * @return 0 on success, a negative AVERROR on failure
     */
    public static class Init_AVFilterContext extends FunctionPointer {
        static { Loader.load(); }
        /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
        public    Init_AVFilterContext(Pointer p) { super(p); }
        protected Init_AVFilterContext() { allocate(); }
        private native void allocate();
        public native int call(AVFilterContext ctx);
    }
    public native Init_AVFilterContext init(); public native AVFilter init(Init_AVFilterContext setter);

    /**
     * Should be set instead of \ref AVFilter.init "init" by the filters that
     * want to pass a dictionary of AVOptions to nested contexts that are
     * allocated during init.
     *
     * On return, the options dict should be freed and replaced with one that
     * contains all the options which could not be processed by this filter (or
     * with NULL if all the options were processed).
     *
     * Otherwise the semantics is the same as for \ref AVFilter.init "init".
     */
    public static class Init_dict_AVFilterContext_PointerPointer extends FunctionPointer {
        static { Loader.load(); }
        /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
        public    Init_dict_AVFilterContext_PointerPointer(Pointer p) { super(p); }
        protected Init_dict_AVFilterContext_PointerPointer() { allocate(); }
        private native void allocate();
        public native int call(AVFilterContext ctx, @Cast("AVDictionary**") PointerPointer options);
    }
    public native Init_dict_AVFilterContext_PointerPointer init_dict(); public native AVFilter init_dict(Init_dict_AVFilterContext_PointerPointer setter);

    /**
     * Filter uninitialization function.
     *
     * Called only once right before the filter is freed. Should deallocate any
     * memory held by the filter, release any buffer references, etc. It does
     * not need to deallocate the AVFilterContext.priv memory itself.
     *
     * This callback may be called even if \ref AVFilter.init "init" was not
     * called or failed, so it must be prepared to handle such a situation.
     */
    public static class Uninit_AVFilterContext extends FunctionPointer {
        static { Loader.load(); }
        /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
        public    Uninit_AVFilterContext(Pointer p) { super(p); }
        protected Uninit_AVFilterContext() { allocate(); }
        private native void allocate();
        public native void call(AVFilterContext ctx);
    }
    public native Uninit_AVFilterContext uninit(); public native AVFilter uninit(Uninit_AVFilterContext setter);

    /**
     * Query formats supported by the filter on its inputs and outputs.
     *
     * This callback is called after the filter is initialized (so the inputs
     * and outputs are fixed), shortly before the format negotiation. This
     * callback may be called more than once.
     *
     * This callback must set AVFilterLink.out_formats on every input link and
     * AVFilterLink.in_formats on every output link to a list of pixel/sample
     * formats that the filter supports on that link. For audio links, this
     * filter must also set \ref AVFilterLink.in_samplerates "in_samplerates" /
     * \ref AVFilterLink.out_samplerates "out_samplerates" and
     * \ref AVFilterLink.in_channel_layouts "in_channel_layouts" /
     * \ref AVFilterLink.out_channel_layouts "out_channel_layouts" analogously.
     *
     * This callback may be NULL for filters with one input, in which case
     * libavfilter assumes that it supports all input formats and preserves
     * them on output.
     *
     * @return zero on success, a negative value corresponding to an
     * AVERROR code otherwise
     */
    public static class Query_formats_AVFilterContext extends FunctionPointer {
        static { Loader.load(); }
        /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
        public    Query_formats_AVFilterContext(Pointer p) { super(p); }
        protected Query_formats_AVFilterContext() { allocate(); }
        private native void allocate();
        public native int call(AVFilterContext arg0);
    }
    public native Query_formats_AVFilterContext query_formats(); public native AVFilter query_formats(Query_formats_AVFilterContext setter);

    /** size of private data to allocate for the filter */
    public native int priv_size(); public native AVFilter priv_size(int setter);

    /** Additional flags for avfilter internal use only. */
    public native int flags_internal(); public native AVFilter flags_internal(int setter);

    /**
     * Used by the filter registration system. Must not be touched by any other
     * code.
     */
    public native AVFilter next(); public native AVFilter next(AVFilter setter);

    /**
     * Make the filter instance process a command.
     *
     * @param cmd    the command to process, for handling simplicity all commands must be alphanumeric only
     * @param arg    the argument for the command
     * @param res    a buffer with size res_size where the filter(s) can return a response. This must not change when the command is not supported.
     * @param flags  if AVFILTER_CMD_FLAG_FAST is set and the command would be
     *               time consuming then a filter should treat it like an unsupported command
     *
     * @return >=0 on success otherwise an error code.
     *          AVERROR(ENOSYS) on unsupported commands
     */
    public static class Process_command_AVFilterContext_BytePointer_BytePointer_BytePointer_int_int extends FunctionPointer {
        static { Loader.load(); }
        /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
        public    Process_command_AVFilterContext_BytePointer_BytePointer_BytePointer_int_int(Pointer p) { super(p); }
        protected Process_command_AVFilterContext_BytePointer_BytePointer_BytePointer_int_int() { allocate(); }
        private native void allocate();
        public native int call(AVFilterContext arg0, @Cast("const char*") BytePointer cmd, @Cast("const char*") BytePointer arg, @Cast("char*") BytePointer res, int res_len, int flags);
    }
    public native Process_command_AVFilterContext_BytePointer_BytePointer_BytePointer_int_int process_command(); public native AVFilter process_command(Process_command_AVFilterContext_BytePointer_BytePointer_BytePointer_int_int setter);

    /**
     * Filter initialization function, alternative to the init()
     * callback. Args contains the user-supplied parameters, opaque is
     * used for providing binary data.
     */
    public static class Init_opaque_AVFilterContext_Pointer extends FunctionPointer {
        static { Loader.load(); }
        /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
        public    Init_opaque_AVFilterContext_Pointer(Pointer p) { super(p); }
        protected Init_opaque_AVFilterContext_Pointer() { allocate(); }
        private native void allocate();
        public native int call(AVFilterContext ctx, Pointer opaque);
    }
    public native Init_opaque_AVFilterContext_Pointer init_opaque(); public native AVFilter init_opaque(Init_opaque_AVFilterContext_Pointer setter);

    /**
     * Filter activation function.
     *
     * Called when any processing is needed from the filter, instead of any
     * filter_frame and request_frame on pads.
     *
     * The function must examine inlinks and outlinks and perform a single
     * step of processing. If there is nothing to do, the function must do
     * nothing and not return an error. If more steps are or may be
     * possible, it must use ff_filter_set_ready() to schedule another
     * activation.
     */
    public static class Activate_AVFilterContext extends FunctionPointer {
        static { Loader.load(); }
        /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
        public    Activate_AVFilterContext(Pointer p) { super(p); }
        protected Activate_AVFilterContext() { allocate(); }
        private native void allocate();
        public native int call(AVFilterContext ctx);
    }
    public native Activate_AVFilterContext activate(); public native AVFilter activate(Activate_AVFilterContext setter);
}
