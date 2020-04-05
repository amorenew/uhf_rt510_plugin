package com.uhf.api.cls;

import androidx.core.view.MotionEventCompat;

public class TagFilter_ST {
    public int bank;
    public byte[] fdata = new byte[MotionEventCompat.ACTION_MASK];
    public int flen;
    public int isInvert;
    public int startaddr;

    public TagFilter_ST() {
    }
}
