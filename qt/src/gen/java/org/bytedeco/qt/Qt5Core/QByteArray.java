// Targeted by JavaCPP version 1.5.4-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.qt.Qt5Core;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.qt.global.Qt5Core.*;

// Parsed from QtCore/qbytearray.h

@NoOffset @Properties(inherit = org.bytedeco.qt.presets.Qt5Core.class)
public class QByteArray extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public QByteArray(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public QByteArray(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public QByteArray position(long position) {
        return (QByteArray)super.position(position);
    }

    public enum Base64Option {
        Base64Encoding(0),
        Base64UrlEncoding(1),

        KeepTrailingEquals(0),
        OmitTrailingEquals(2),

        IgnoreBase64DecodingErrors(0),
        AbortOnBase64DecodingErrors(4);

        public final int value;
        private Base64Option(int v) { this.value = v; }
        private Base64Option(Base64Option e) { this.value = e.value; }
        public Base64Option intern() { for (Base64Option e : values()) if (e.value == value) return e; return this; }
        @Override public String toString() { return intern().name(); }
    }
//     #define Q_DECLARE_FLAGS(arg0, arg1)(Base64Options, Base64Option)

    /** enum class QByteArray::Base64DecodingStatus */
    public static final int
        Ok = 0,
        IllegalInputLength = 1,
        IllegalCharacter = 2,
        IllegalPadding = 3;

    public QByteArray() { super((Pointer)null); allocate(); }
    @NoException private native void allocate();
    public QByteArray(@Cast("const char*") BytePointer arg0, int size/*=-1*/) { super((Pointer)null); allocate(arg0, size); }
    private native void allocate(@Cast("const char*") BytePointer arg0, int size/*=-1*/);
    public QByteArray(@Cast("const char*") BytePointer arg0) { super((Pointer)null); allocate(arg0); }
    private native void allocate(@Cast("const char*") BytePointer arg0);
    public QByteArray(String arg0, int size/*=-1*/) { super((Pointer)null); allocate(arg0, size); }
    private native void allocate(String arg0, int size/*=-1*/);
    public QByteArray(String arg0) { super((Pointer)null); allocate(arg0); }
    private native void allocate(String arg0);
    public QByteArray(int size, @Cast("char") byte c) { super((Pointer)null); allocate(size, c); }
    private native void allocate(int size, @Cast("char") byte c);
    public QByteArray(int size, @Cast("Qt::Initialization") int arg1) { super((Pointer)null); allocate(size, arg1); }
    private native void allocate(int size, @Cast("Qt::Initialization") int arg1);
    public QByteArray(@Const @ByRef QByteArray arg0) { super((Pointer)null); allocate(arg0); }
    @NoException private native void allocate(@Const @ByRef QByteArray arg0);

    public native @ByRef @Name("operator =") @NoException QByteArray put(@Const @ByRef QByteArray arg0);
    public native @ByRef @Name("operator =") QByteArray put(@Cast("const char*") BytePointer str);
    public native @ByRef @Name("operator =") QByteArray put(String str);

    public native @NoException void swap(@ByRef QByteArray other);

    public native int size();
    public native @Cast("bool") boolean isEmpty();
    public native void resize(int size);

    public native @ByRef @Name("fill") QByteArray _fill(@Cast("char") byte c, int size/*=-1*/);
    public native @ByRef @Name("fill") QByteArray _fill(@Cast("char") byte c);

    public native @Name("capacity") int _capacity();
    public native void reserve(int size);
    public native void squeeze();

// #ifndef QT_NO_CAST_FROM_BYTEARRAY
    public native @Const @Name("operator const char*") @Cast("const char*") BytePointer asBytePointer();
    public native @Const @Name("operator const void*") Pointer asPointer();
// #endif
    public native @Cast("char*") BytePointer data();
    public native @Cast("const char*") BytePointer constData();
    public native void detach();
    public native @Cast("bool") boolean isDetached();
    public native @Cast("bool") boolean isSharedWith(@Const @ByRef QByteArray other);
    public native void clear();

    public native @Cast("char") byte at(int i);
    public native @Cast("char") @Name("operator []") byte get(int i);
    
    
     public native @Cast("char") byte front();
    
     public native @Cast("char") byte back();
    

    public native int indexOf(@Cast("char") byte c, int from/*=0*/);
    public native int indexOf(@Cast("char") byte c);
    public native int indexOf(@Cast("const char*") BytePointer c, int from/*=0*/);
    public native int indexOf(@Cast("const char*") BytePointer c);
    public native int indexOf(String c, int from/*=0*/);
    public native int indexOf(String c);
    public native int indexOf(@Const @ByRef QByteArray a, int from/*=0*/);
    public native int indexOf(@Const @ByRef QByteArray a);
    public native int lastIndexOf(@Cast("char") byte c, int from/*=-1*/);
    public native int lastIndexOf(@Cast("char") byte c);
    public native int lastIndexOf(@Cast("const char*") BytePointer c, int from/*=-1*/);
    public native int lastIndexOf(@Cast("const char*") BytePointer c);
    public native int lastIndexOf(String c, int from/*=-1*/);
    public native int lastIndexOf(String c);
    public native int lastIndexOf(@Const @ByRef QByteArray a, int from/*=-1*/);
    public native int lastIndexOf(@Const @ByRef QByteArray a);

    public native @Cast("bool") boolean contains(@Cast("char") byte c);
    public native @Cast("bool") boolean contains(@Cast("const char*") BytePointer a);
    public native @Cast("bool") boolean contains(String a);
    public native @Cast("bool") boolean contains(@Const @ByRef QByteArray a);
    public native int count(@Cast("char") byte c);
    public native int count(@Cast("const char*") BytePointer a);
    public native int count(String a);
    public native int count(@Const @ByRef QByteArray a);

    public native @NoException int compare(@Cast("const char*") BytePointer c, CaseSensitivity cs/*=Qt::CaseSensitive*/);
    public native @NoException int compare(@Cast("const char*") BytePointer c);
    public native @NoException int compare(String c, CaseSensitivity cs/*=Qt::CaseSensitive*/);
    public native @NoException int compare(String c);
    public native @NoException int compare(@Const @ByRef QByteArray a, CaseSensitivity cs/*=Qt::CaseSensitive*/);
    public native @NoException int compare(@Const @ByRef QByteArray a);

     public native @ByVal QByteArray left(int len);
     public native @ByVal QByteArray right(int len);
     public native @ByVal QByteArray mid(int index, int len/*=-1*/);
public native @ByVal QByteArray mid(int index);
     public native @ByVal QByteArray chopped(int len);

    public native @Cast("bool") boolean startsWith(@Const @ByRef QByteArray a);
    public native @Cast("bool") boolean startsWith(@Cast("char") byte c);
    public native @Cast("bool") boolean startsWith(@Cast("const char*") BytePointer c);
    public native @Cast("bool") boolean startsWith(String c);

    public native @Cast("bool") boolean endsWith(@Const @ByRef QByteArray a);
    public native @Cast("bool") boolean endsWith(@Cast("char") byte c);
    public native @Cast("bool") boolean endsWith(@Cast("const char*") BytePointer c);
    public native @Cast("bool") boolean endsWith(String c);

    public native @Cast("bool") boolean isUpper();
    public native @Cast("bool") boolean isLower();

    public native void truncate(int pos);
    public native void chop(int n);

// #if defined(Q_COMPILER_REF_QUALIFIERS) && !defined(QT_COMPILING_QSTRING_COMPAT_CPP) && !defined(Q_CLANG_QDOC)
// #else
     public native @ByVal QByteArray toLower();
     public native @ByVal QByteArray toUpper();
     public native @ByVal QByteArray trimmed();
     public native @ByVal QByteArray simplified();
// #endif

     public native @ByVal QByteArray leftJustified(int width, @Cast("char") byte _fill/*=' '*/, @Cast("bool") boolean truncate/*=false*/);
public native @ByVal QByteArray leftJustified(int width);
     public native @ByVal QByteArray rightJustified(int width, @Cast("char") byte _fill/*=' '*/, @Cast("bool") boolean truncate/*=false*/);
public native @ByVal QByteArray rightJustified(int width);

    public native @ByRef QByteArray prepend(@Cast("char") byte c);
    public native @ByRef QByteArray prepend(int count, @Cast("char") byte c);
    public native @ByRef QByteArray prepend(@Cast("const char*") BytePointer s);
    public native @ByRef QByteArray prepend(String s);
    public native @ByRef QByteArray prepend(@Cast("const char*") BytePointer s, int len);
    public native @ByRef QByteArray prepend(String s, int len);
    public native @ByRef QByteArray prepend(@Const @ByRef QByteArray a);
    public native @ByRef QByteArray append(@Cast("char") byte c);
    public native @ByRef QByteArray append(int count, @Cast("char") byte c);
    public native @ByRef QByteArray append(@Cast("const char*") BytePointer s);
    public native @ByRef QByteArray append(String s);
    public native @ByRef QByteArray append(@Cast("const char*") BytePointer s, int len);
    public native @ByRef QByteArray append(String s, int len);
    public native @ByRef QByteArray append(@Const @ByRef QByteArray a);
    public native @ByRef QByteArray insert(int i, @Cast("char") byte c);
    public native @ByRef QByteArray insert(int i, int count, @Cast("char") byte c);
    public native @ByRef QByteArray insert(int i, @Cast("const char*") BytePointer s);
    public native @ByRef QByteArray insert(int i, String s);
    public native @ByRef QByteArray insert(int i, @Cast("const char*") BytePointer s, int len);
    public native @ByRef QByteArray insert(int i, String s, int len);
    public native @ByRef QByteArray insert(int i, @Const @ByRef QByteArray a);
    public native @ByRef QByteArray remove(int index, int len);
    public native @ByRef QByteArray replace(int index, int len, @Cast("const char*") BytePointer s);
    public native @ByRef QByteArray replace(int index, int len, String s);
    public native @ByRef QByteArray replace(int index, int len, @Cast("const char*") BytePointer s, int alen);
    public native @ByRef QByteArray replace(int index, int len, String s, int alen);
    public native @ByRef QByteArray replace(int index, int len, @Const @ByRef QByteArray s);
    public native @ByRef QByteArray replace(@Cast("char") byte before, @Cast("const char*") BytePointer after);
    public native @ByRef QByteArray replace(@Cast("char") byte before, String after);
    public native @ByRef QByteArray replace(@Cast("char") byte before, @Const @ByRef QByteArray after);
    public native @ByRef QByteArray replace(@Cast("const char*") BytePointer before, @Cast("const char*") BytePointer after);
    public native @ByRef QByteArray replace(String before, String after);
    public native @ByRef QByteArray replace(@Cast("const char*") BytePointer before, int bsize, @Cast("const char*") BytePointer after, int asize);
    public native @ByRef QByteArray replace(String before, int bsize, String after, int asize);
    public native @ByRef QByteArray replace(@Const @ByRef QByteArray before, @Const @ByRef QByteArray after);
    public native @ByRef QByteArray replace(@Const @ByRef QByteArray before, @Cast("const char*") BytePointer after);
    public native @ByRef QByteArray replace(@Const @ByRef QByteArray before, String after);
    public native @ByRef QByteArray replace(@Cast("const char*") BytePointer before, @Const @ByRef QByteArray after);
    public native @ByRef QByteArray replace(String before, @Const @ByRef QByteArray after);
    public native @ByRef QByteArray replace(@Cast("char") byte before, @Cast("char") byte after);
    public native @ByRef @Name("operator +=") QByteArray addPut(@Cast("char") byte c);
    public native @ByRef @Name("operator +=") QByteArray addPut(@Cast("const char*") BytePointer s);
    public native @ByRef @Name("operator +=") QByteArray addPut(String s);
    public native @ByRef @Name("operator +=") QByteArray addPut(@Const @ByRef QByteArray a);

     public native @ByVal QByteArray repeated(int times);

// #ifndef QT_NO_CAST_TO_ASCII
    public native @Deprecated @ByRef QByteArray append(@Const @ByRef QString s);
    public native @Deprecated @ByRef QByteArray insert(int i, @Const @ByRef QString s);
    public native @Deprecated @ByRef QByteArray replace(@Const @ByRef QString before, @Cast("const char*") BytePointer after);
    public native @Deprecated @ByRef QByteArray replace(@Const @ByRef QString before, String after);
    public native @Deprecated @ByRef QByteArray replace(@Cast("char") byte c, @Const @ByRef QString after);
    public native @Deprecated @ByRef QByteArray replace(@Const @ByRef QString before, @Const @ByRef QByteArray after);

    public native @Deprecated @ByRef @Name("operator +=") QByteArray addPut(@Const @ByRef QString s);
    public native @Deprecated int indexOf(@Const @ByRef QString s, int from/*=0*/);
    public native @Deprecated int indexOf(@Const @ByRef QString s);
    public native @Deprecated int lastIndexOf(@Const @ByRef QString s, int from/*=-1*/);
    public native @Deprecated int lastIndexOf(@Const @ByRef QString s);
// #endif
// #if !defined(QT_NO_CAST_FROM_ASCII) && !defined(QT_RESTRICTED_CAST_FROM_ASCII)
// #endif

    public native short toShort(@Cast("bool*") BoolPointer ok/*=nullptr*/, int base/*=10*/);
    public native short toShort();
    public native short toShort(@Cast("bool*") boolean[] ok/*=nullptr*/, int base/*=10*/);
    public native @Cast("unsigned short") short toUShort(@Cast("bool*") BoolPointer ok/*=nullptr*/, int base/*=10*/);
    public native @Cast("unsigned short") short toUShort();
    public native @Cast("unsigned short") short toUShort(@Cast("bool*") boolean[] ok/*=nullptr*/, int base/*=10*/);
    public native int toInt(@Cast("bool*") BoolPointer ok/*=nullptr*/, int base/*=10*/);
    public native int toInt();
    public native int toInt(@Cast("bool*") boolean[] ok/*=nullptr*/, int base/*=10*/);
    public native @Cast("unsigned int") int toUInt(@Cast("bool*") BoolPointer ok/*=nullptr*/, int base/*=10*/);
    public native @Cast("unsigned int") int toUInt();
    public native @Cast("unsigned int") int toUInt(@Cast("bool*") boolean[] ok/*=nullptr*/, int base/*=10*/);
    public native long toLong(@Cast("bool*") BoolPointer ok/*=nullptr*/, int base/*=10*/);
    public native long toLong();
    public native long toLong(@Cast("bool*") boolean[] ok/*=nullptr*/, int base/*=10*/);
    public native @Cast("unsigned long") long toULong(@Cast("bool*") BoolPointer ok/*=nullptr*/, int base/*=10*/);
    public native @Cast("unsigned long") long toULong();
    public native @Cast("unsigned long") long toULong(@Cast("bool*") boolean[] ok/*=nullptr*/, int base/*=10*/);
    public native long toLongLong(@Cast("bool*") BoolPointer ok/*=nullptr*/, int base/*=10*/);
    public native long toLongLong();
    public native long toLongLong(@Cast("bool*") boolean[] ok/*=nullptr*/, int base/*=10*/);
    public native @Cast("unsigned long long") long toULongLong(@Cast("bool*") BoolPointer ok/*=nullptr*/, int base/*=10*/);
    public native @Cast("unsigned long long") long toULongLong();
    public native @Cast("unsigned long long") long toULongLong(@Cast("bool*") boolean[] ok/*=nullptr*/, int base/*=10*/);
    public native float toFloat(@Cast("bool*") BoolPointer ok/*=nullptr*/);
    public native float toFloat();
    public native float toFloat(@Cast("bool*") boolean[] ok/*=nullptr*/);
    public native double toDouble(@Cast("bool*") BoolPointer ok/*=nullptr*/);
    public native double toDouble();
    public native double toDouble(@Cast("bool*") boolean[] ok/*=nullptr*/);
    public native @ByVal QByteArray toBase64(); // ### Qt6 merge with previous
    public native @ByVal QByteArray toHex();
    public native @ByVal QByteArray toHex(@Cast("char") byte separator); // ### Qt6 merge with previous
    public native @ByVal QByteArray toPercentEncoding(@Const @ByRef(nullValue = "QByteArray()") QByteArray exclude,
                                     @Const @ByRef(nullValue = "QByteArray()") QByteArray include,
                                     @Cast("char") byte percent/*='%'*/);
    public native @ByVal QByteArray toPercentEncoding();

    public native @ByRef QByteArray setNum(short arg0, int base/*=10*/);
    public native @ByRef QByteArray setNum(short arg0);
    public native @ByRef QByteArray setNum(int arg0, int base/*=10*/);
    public native @ByRef QByteArray setNum(int arg0);
    public native @ByRef QByteArray setNum(long arg0, int base/*=10*/);
    public native @ByRef QByteArray setNum(long arg0);
    public native @ByRef QByteArray setNum(float arg0, @Cast("char") byte f/*='g'*/, int prec/*=6*/);
    public native @ByRef QByteArray setNum(float arg0);
    public native @ByRef QByteArray setNum(double arg0, @Cast("char") byte f/*='g'*/, int prec/*=6*/);
    public native @ByRef QByteArray setNum(double arg0);
    public native @ByRef QByteArray setRawData(@Cast("const char*") BytePointer a, @Cast("unsigned int") int n);
    public native @ByRef QByteArray setRawData(String a, @Cast("unsigned int") int n); // ### Qt 6: use an int

     public static native @ByVal QByteArray number(int arg0, int base/*=10*/);
public static native @ByVal QByteArray number(int arg0);
    
     public static native @ByVal QByteArray number(long arg0, int base/*=10*/);
public static native @ByVal QByteArray number(long arg0);
    
     public static native @ByVal QByteArray number(double arg0, @Cast("char") byte f/*='g'*/, int prec/*=6*/);
public static native @ByVal QByteArray number(double arg0);
     public static native @ByVal QByteArray fromRawData(@Cast("const char*") BytePointer arg0, int size);
public static native @ByVal QByteArray fromRawData(String arg0, int size);

    @Opaque public static class FromBase64Result extends Pointer {
        /** Empty constructor. Calls {@code super((Pointer)null)}. */
        public FromBase64Result() { super((Pointer)null); }
        /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
        public FromBase64Result(Pointer p) { super(p); }
    }
     public static native @ByVal FromBase64Result fromBase64Encoding(@ByVal QByteArray base64);
    
    
     public static native @ByVal QByteArray fromBase64(@Const @ByRef QByteArray base64); // ### Qt6 merge with previous
     public static native @ByVal QByteArray fromHex(@Const @ByRef QByteArray hexEncoded);
     public static native @ByVal QByteArray fromPercentEncoding(@Const @ByRef QByteArray pctEncoded, @Cast("char") byte percent/*='%'*/);
public static native @ByVal QByteArray fromPercentEncoding(@Const @ByRef QByteArray pctEncoded);

// #if defined(Q_OS_DARWIN) || defined(Q_QDOC)
// #endif

    // stl compatibility
    public native void push_back(@Cast("char") byte c);
    public native void push_back(@Cast("const char*") BytePointer c);
    public native void push_back(String c);
    public native void push_back(@Const @ByRef QByteArray a);
    public native void push_front(@Cast("char") byte c);
    public native void push_front(@Cast("const char*") BytePointer c);
    public native void push_front(String c);
    public native void push_front(@Const @ByRef QByteArray a);
    public native void shrink_to_fit();

    public static native @ByVal QByteArray fromStdString(@StdString BytePointer s);
    public static native @ByVal QByteArray fromStdString(@StdString String s);
    public native @StdString BytePointer toStdString();

    public native int count();
    public native int length();
    public native @Cast("bool") boolean isNull();
    public native @Cast("QByteArray::DataPtr*") @ByRef PointerPointer data_ptr();
}
