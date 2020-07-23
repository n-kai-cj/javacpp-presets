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

// Parsed from QtWidgets/qframe.h

@Properties(inherit = org.bytedeco.qt.presets.Qt5Widgets.class)
public class QFrame extends QWidget {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public QFrame(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public QFrame(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public QFrame position(long position) {
        return (QFrame)super.position(position);
    }

    public QFrame(QWidget parent/*=nullptr*/, @ByVal(nullValue = "Qt::WindowFlags()") @Cast("Qt::WindowFlags") int f) { super((Pointer)null); allocate(parent, f); }
    private native void allocate(QWidget parent/*=nullptr*/, @ByVal(nullValue = "Qt::WindowFlags()") @Cast("Qt::WindowFlags") int f);
    public QFrame() { super((Pointer)null); allocate(); }
    private native void allocate();

    public native int frameStyle();
    public native void setFrameStyle(int arg0);

    public native int frameWidth();

    public native @ByVal QSize sizeHint();

    /** enum QFrame::Shape */
    public static final int
        NoFrame  = 0, // no frame
        Box = 0x0001, // rectangular box
        Panel = 0x0002, // rectangular panel
        WinPanel = 0x0003, // rectangular panel (Windows)
        HLine = 0x0004, // horizontal line
        VLine = 0x0005, // vertical line
        StyledPanel = 0x0006; // rectangular panel depending on the GUI style
    
    /** enum QFrame::Shadow */
    public static final int
        Plain = 0x0010, // plain line
        Raised = 0x0020, // raised shadow effect
        Sunken = 0x0030; // sunken shadow effect
    

    /** enum QFrame::StyleMask */
    public static final int
        Shadow_Mask = 0x00f0, // mask for the shadow
        Shape_Mask = 0x000f; // mask for the shape

    public native @Cast("QFrame::Shape") int frameShape();
    public native void setFrameShape(@Cast("QFrame::Shape") int arg0);
    public native @Cast("QFrame::Shadow") int frameShadow();
    public native void setFrameShadow(@Cast("QFrame::Shadow") int arg0);

    public native int lineWidth();
    public native void setLineWidth(int arg0);

    public native int midLineWidth();
    public native void setMidLineWidth(int arg0);
}
