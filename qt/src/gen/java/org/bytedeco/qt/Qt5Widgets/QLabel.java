// Targeted by JavaCPP version 1.5.4-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.qt.Qt5Widgets;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.qt.Qt5Core.*;
import static org.bytedeco.qt.global.Qt5Core.*;
import org.bytedeco.qt.Qt5Gui.*;
import static org.bytedeco.qt.global.Qt5Gui.*;

import static org.bytedeco.qt.global.Qt5Widgets.*;

// Parsed from QtWidgets/qlabel.h

@Properties(inherit = org.bytedeco.qt.presets.Qt5Widgets.class)
public class QLabel extends QFrame {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public QLabel(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public QLabel(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public QLabel position(long position) {
        return (QLabel)super.position(position);
    }

    public QLabel(QWidget parent/*=nullptr*/, @ByVal(nullValue = "Qt::WindowFlags()") @Cast("Qt::WindowFlags") int f) { super((Pointer)null); allocate(parent, f); }
    private native void allocate(QWidget parent/*=nullptr*/, @ByVal(nullValue = "Qt::WindowFlags()") @Cast("Qt::WindowFlags") int f);
    public QLabel() { super((Pointer)null); allocate(); }
    private native void allocate();
    public QLabel(@Const @ByRef QString text, QWidget parent/*=nullptr*/, @ByVal(nullValue = "Qt::WindowFlags()") @Cast("Qt::WindowFlags") int f) { super((Pointer)null); allocate(text, parent, f); }
    private native void allocate(@Const @ByRef QString text, QWidget parent/*=nullptr*/, @ByVal(nullValue = "Qt::WindowFlags()") @Cast("Qt::WindowFlags") int f);
    public QLabel(@Const @ByRef QString text) { super((Pointer)null); allocate(text); }
    private native void allocate(@Const @ByRef QString text);

    public native @ByVal QString text();

// #if QT_DEPRECATED_SINCE(5,15) // ### Qt 7: Remove function
// #else // ### Qt 7: Remove arg
// #endif // QT_DEPRECATED_SINCE(5,15)

// #ifndef QT_NO_PICTURE
// #  if QT_DEPRECATED_SINCE(5,15) // ### Qt 7: Remove function
// #  else // ### Qt 7: Remove arg
// #  endif // QT_DEPRECATED_SINCE(5,15)
// #endif
// #if QT_CONFIG(movie)
// #endif

    public native @Cast("Qt::TextFormat") int textFormat();
    public native void setTextFormat(@Cast("Qt::TextFormat") int arg0);

    public native @ByVal @Cast("Qt::Alignment") int alignment();
    public native void setAlignment(@ByVal @Cast("Qt::Alignment") int arg0);

    public native void setWordWrap(@Cast("bool") boolean on);
    public native @Cast("bool") boolean wordWrap();

    public native int indent();
    public native void setIndent(int arg0);

    public native int margin();
    public native void setMargin(int arg0);

    public native @Cast("bool") boolean hasScaledContents();
    public native void setScaledContents(@Cast("bool") boolean arg0);
    public native @ByVal QSize sizeHint();
    public native @ByVal QSize minimumSizeHint();
// #ifndef QT_NO_SHORTCUT
    public native void setBuddy(QWidget arg0);
    public native QWidget buddy();
// #endif
    public native int heightForWidth(int arg0);

    public native @Cast("bool") boolean openExternalLinks();
    public native void setOpenExternalLinks(@Cast("bool") boolean open);

    public native void setTextInteractionFlags(@ByVal @Cast("Qt::TextInteractionFlags") int flags);
    public native @ByVal @Cast("Qt::TextInteractionFlags") int textInteractionFlags();

    public native void setSelection(int arg0, int arg1);
    public native @Cast("bool") boolean hasSelectedText();
    public native @ByVal QString selectedText();
    public native int selectionStart();
    public native void setText(@Const @ByRef QString arg0);
// #ifndef QT_NO_PICTURE
// #endif
// #if QT_CONFIG(movie)
// #endif
    public native void setNum(int arg0);
    public native void setNum(double arg0);
    public native void clear();
}
