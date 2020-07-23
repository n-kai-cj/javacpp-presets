// Targeted by JavaCPP version 1.5.3: DO NOT EDIT THIS FILE

package org.bytedeco.cpu_features;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.cpu_features.global.cpu_features.*;


// See https://en.wikipedia.org/wiki/CPUID for a list of x86 cpu features.
// The field names are based on the short name provided in the wikipedia tables.
@Namespace("cpu_features") @Properties(inherit = org.bytedeco.cpu_features.presets.cpu_features.class)
public class X86Features extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public X86Features() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public X86Features(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public X86Features(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public X86Features position(long position) {
        return (X86Features)super.position(position);
    }

  public native @NoOffset int fpu(); public native X86Features fpu(int setter);
  public native @NoOffset int tsc(); public native X86Features tsc(int setter);
  public native @NoOffset int cx8(); public native X86Features cx8(int setter);
  public native @NoOffset int clfsh(); public native X86Features clfsh(int setter);
  public native @NoOffset int mmx(); public native X86Features mmx(int setter);
  public native @NoOffset int aes(); public native X86Features aes(int setter);
  public native @NoOffset int erms(); public native X86Features erms(int setter);
  public native @NoOffset int f16c(); public native X86Features f16c(int setter);
  public native @NoOffset int fma3(); public native X86Features fma3(int setter);
  public native @NoOffset int vaes(); public native X86Features vaes(int setter);
  public native @NoOffset int vpclmulqdq(); public native X86Features vpclmulqdq(int setter);
  public native @NoOffset int bmi1(); public native X86Features bmi1(int setter);
  public native @NoOffset int hle(); public native X86Features hle(int setter);
  public native @NoOffset int bmi2(); public native X86Features bmi2(int setter);
  public native @NoOffset int rtm(); public native X86Features rtm(int setter);
  public native @NoOffset int rdseed(); public native X86Features rdseed(int setter);
  public native @NoOffset int clflushopt(); public native X86Features clflushopt(int setter);
  public native @NoOffset int clwb(); public native X86Features clwb(int setter);

  public native @NoOffset int sse(); public native X86Features sse(int setter);
  public native @NoOffset int sse2(); public native X86Features sse2(int setter);
  public native @NoOffset int sse3(); public native X86Features sse3(int setter);
  public native @NoOffset int ssse3(); public native X86Features ssse3(int setter);
  public native @NoOffset int sse4_1(); public native X86Features sse4_1(int setter);
  public native @NoOffset int sse4_2(); public native X86Features sse4_2(int setter);

  public native @NoOffset int avx(); public native X86Features avx(int setter);
  public native @NoOffset int avx2(); public native X86Features avx2(int setter);

  public native @NoOffset int avx512f(); public native X86Features avx512f(int setter);
  public native @NoOffset int avx512cd(); public native X86Features avx512cd(int setter);
  public native @NoOffset int avx512er(); public native X86Features avx512er(int setter);
  public native @NoOffset int avx512pf(); public native X86Features avx512pf(int setter);
  public native @NoOffset int avx512bw(); public native X86Features avx512bw(int setter);
  public native @NoOffset int avx512dq(); public native X86Features avx512dq(int setter);
  public native @NoOffset int avx512vl(); public native X86Features avx512vl(int setter);
  public native @NoOffset int avx512ifma(); public native X86Features avx512ifma(int setter);
  public native @NoOffset int avx512vbmi(); public native X86Features avx512vbmi(int setter);
  public native @NoOffset int avx512vbmi2(); public native X86Features avx512vbmi2(int setter);
  public native @NoOffset int avx512vnni(); public native X86Features avx512vnni(int setter);
  public native @NoOffset int avx512bitalg(); public native X86Features avx512bitalg(int setter);
  public native @NoOffset int avx512vpopcntdq(); public native X86Features avx512vpopcntdq(int setter);
  public native @NoOffset int avx512_4vnniw(); public native X86Features avx512_4vnniw(int setter);
  public native @NoOffset int avx512_4vbmi2(); public native X86Features avx512_4vbmi2(int setter);

  public native @NoOffset int pclmulqdq(); public native X86Features pclmulqdq(int setter);
  public native @NoOffset int smx(); public native X86Features smx(int setter);
  public native @NoOffset int sgx(); public native X86Features sgx(int setter);
  public native @NoOffset int cx16(); public native X86Features cx16(int setter);  // aka. CMPXCHG16B
  public native @NoOffset int sha(); public native X86Features sha(int setter);
  public native @NoOffset int popcnt(); public native X86Features popcnt(int setter);
  public native @NoOffset int movbe(); public native X86Features movbe(int setter);
  public native @NoOffset int rdrnd(); public native X86Features rdrnd(int setter);

  public native @NoOffset int dca(); public native X86Features dca(int setter);
  public native @NoOffset int ss(); public native X86Features ss(int setter);
  // Make sure to update X86FeaturesEnum below if you add a field here.
}
