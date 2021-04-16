// Targeted by JavaCPP version 1.5.6-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.cpython;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.cpython.global.python.*;



/* --- PyPreConfig ----------------------------------------------- */

@Properties(inherit = org.bytedeco.cpython.presets.python.class)
public class PyPreConfig extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public PyPreConfig() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public PyPreConfig(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public PyPreConfig(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public PyPreConfig position(long position) {
        return (PyPreConfig)super.position(position);
    }
    @Override public PyPreConfig getPointer(long i) {
        return new PyPreConfig((Pointer)this).position(position + i);
    }

    public native int _config_init(); public native PyPreConfig _config_init(int setter);     /* _PyConfigInitEnum value */

    /* Parse Py_PreInitializeFromBytesArgs() arguments?
       See PyConfig.parse_argv */
    public native int parse_argv(); public native PyPreConfig parse_argv(int setter);

    /* If greater than 0, enable isolated mode: sys.path contains
       neither the script's directory nor the user's site-packages directory.

       Set to 1 by the -I command line option. If set to -1 (default), inherit
       Py_IsolatedFlag value. */
    public native int isolated(); public native PyPreConfig isolated(int setter);

    /* If greater than 0: use environment variables.
       Set to 0 by -E command line option. If set to -1 (default), it is
       set to !Py_IgnoreEnvironmentFlag. */
    public native int use_environment(); public native PyPreConfig use_environment(int setter);

    /* Set the LC_CTYPE locale to the user preferred locale? If equals to 0,
       set coerce_c_locale and coerce_c_locale_warn to 0. */
    public native int configure_locale(); public native PyPreConfig configure_locale(int setter);

    /* Coerce the LC_CTYPE locale if it's equal to "C"? (PEP 538)

       Set to 0 by PYTHONCOERCECLOCALE=0. Set to 1 by PYTHONCOERCECLOCALE=1.
       Set to 2 if the user preferred LC_CTYPE locale is "C".

       If it is equal to 1, LC_CTYPE locale is read to decide if it should be
       coerced or not (ex: PYTHONCOERCECLOCALE=1). Internally, it is set to 2
       if the LC_CTYPE locale must be coerced.

       Disable by default (set to 0). Set it to -1 to let Python decide if it
       should be enabled or not. */
    public native int coerce_c_locale(); public native PyPreConfig coerce_c_locale(int setter);

    /* Emit a warning if the LC_CTYPE locale is coerced?

       Set to 1 by PYTHONCOERCECLOCALE=warn.

       Disable by default (set to 0). Set it to -1 to let Python decide if it
       should be enabled or not. */
    public native int coerce_c_locale_warn(); public native PyPreConfig coerce_c_locale_warn(int setter);

// #ifdef MS_WINDOWS
// #endif

    /* Enable UTF-8 mode? (PEP 540)

       Disabled by default (equals to 0).

       Set to 1 by "-X utf8" and "-X utf8=1" command line options.
       Set to 1 by PYTHONUTF8=1 environment variable.

       Set to 0 by "-X utf8=0" and PYTHONUTF8=0.

       If equals to -1, it is set to 1 if the LC_CTYPE locale is "C" or
       "POSIX", otherwise it is set to 0. Inherit Py_UTF8Mode value value. */
    public native int utf8_mode(); public native PyPreConfig utf8_mode(int setter);

    /* If non-zero, enable the Python Development Mode.

       Set to 1 by the -X dev command line option. Set by the PYTHONDEVMODE
       environment variable. */
    public native int dev_mode(); public native PyPreConfig dev_mode(int setter);

    /* Memory allocator: PYTHONMALLOC env var.
       See PyMemAllocatorName for valid values. */
    public native int allocator(); public native PyPreConfig allocator(int setter);
}
