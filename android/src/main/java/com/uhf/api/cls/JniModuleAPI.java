package com.uhf.api.cls;

import com.uhf.api.cls.Reader;

public class JniModuleAPI {
    public native int AsyncGetNextTag(int i, TAGINFO[] taginfoArr);

    public native int AsyncGetTagCount(int i, int[] iArr);

    public native int AsyncStartReading(int i, int[] iArr, int i2, int i3);

    public native int AsyncStopReading(int i);

    public native int BlockErase(int i, int i2, int i3, int i4, int i5, byte[] bArr, short s);

    public native int BlockPermaLock(int i, int i2, int i3, int i4, int i5, byte[] bArr, byte[] bArr2, short s);

    public native void CloseReader(int i);

    public native int CustomCmd_BaseType(int i, int i2, int i3, byte[] bArr, byte[] bArr2);

    public native int EraseDataOnReader(int i);

    public native int GetGPI(int i, int i2, int[] iArr);

    public native int GetHardwareDetails(int i, Object obj);

    public native int GetNextTag_BaseType(int i, byte[] bArr);

    public native int GetTagData(int i, int i2, char c, int i3, int i4, byte[] bArr, byte[] bArr2, short s);

    public native int InitReader(int[] iArr, String str, int i);

    public native int InitReader_Notype(int[] iArr, String str, int i);

    public native int KillTag(int i, int i2, byte[] bArr, short s);

    public native int Lock180006BTag(int i, int i2, int i3, int i4, short s);

    public native int LockTag(int i, int i2, byte b, short s, byte[] bArr, short s2);

    public native int ParamGet(int i, int i2, Object obj);

    public native int ParamSet(int i, int i2, Object obj);

    public native int PsamTransceiver(int i, int i2, int i3, byte[] bArr, int[] iArr, byte[] bArr2, byte[] bArr3, short s);

    public native int ReadDataOnReader(int i, int i2, byte[] bArr, int i3);

    public native int SaveDataOnReader(int i, int i2, byte[] bArr, int i3);

    public native int SetGPO(int i, int i2, int i3);

    public native int TagInventory_BaseType(int i, int[] iArr, int i2, short s, char[] cArr, int[] iArr2);

    public native int TagInventory_Raw(int i, int[] iArr, int i2, short s, int[] iArr2);

    public native int WriteTagData(int i, int i2, char c, int i3, byte[] bArr, int i4, byte[] bArr2, short s);

    public native int WriteTagEpcEx(int i, int i2, byte[] bArr, int i3, byte[] bArr2, short s);

    static {
        System.loadLibrary("ModuleAPI_Android");
    }
}
