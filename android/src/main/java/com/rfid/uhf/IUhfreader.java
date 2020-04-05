package com.rfid.uhf;

import java.util.List;

public interface IUhfreader {
    boolean clearSelect();

    void close();

    List<String> inventoryRealTime();

    boolean lockTag(int i, int i2, byte[] bArr);

    void open(String str, int i);

    byte[] readData(int i, int i2, int i3, byte[] bArr);

    boolean selectEPC(byte[] bArr);

    boolean setOutPower(short s);

    boolean writeAccess(byte[] bArr, byte[] bArr2);

    boolean writeData(int i, int i2, byte[] bArr, byte[] bArr2);

    boolean writeEPC(byte[] bArr, byte[] bArr2);

    boolean writeKillPsd(byte[] bArr, byte[] bArr2);
}
