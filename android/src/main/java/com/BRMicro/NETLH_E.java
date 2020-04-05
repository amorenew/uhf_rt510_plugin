package com.BRMicro;

import android.util.Log;
import java.io.DataOutputStream;

public class NETLH_E {
    private final String TAG = "=NETLH_E=";

    public native int AsciiToHex(char[] cArr, int i, char[] cArr2, int[] iArr);

    public native int CmdDelChar(int i, int[] iArr);

    public native int CmdDetectFinger(int[] iArr);

    public native int CmdDeviceInitGetPath(byte[] bArr);

    public native int CmdDeviceReset(int[] iArr);

    public native int CmdDownLoadImage(byte[] bArr);

    public native int CmdEmptyChar(int[] iArr);

    public native int CmdEraseProgram(int[] iArr);

    public native int CmdGenChar(int i, int[] iArr);

    public native int CmdGetChar_eAlg(int i, byte[] bArr, int[] iArr);

    public native int CmdGetChar_xAlg(int i, byte[] bArr, int[] iArr);

    public native int CmdGetMBIndex(byte[] bArr, int i, int i2, int[] iArr);

    public native int CmdGetRandom(int[] iArr, int[] iArr2);

    public native int CmdGetRawImage(int[] iArr);

    public native int CmdGetRawImageBuf(byte[] bArr);

    public native int CmdGetRedressImage(int i, int[] iArr);

    public native int CmdMatchChar(int[] iArr, int[] iArr2);

    public native int CmdMergeChar(int[] iArr, int[] iArr2);

    public native int CmdPutChar_eAlg(int i, byte[] bArr, int[] iArr);

    public native int CmdPutChar_xAlg(int i, byte[] bArr, int[] iArr);

    public native int CmdReadCharDirect_eAlg(int i, byte[] bArr, int[] iArr);

    public native int CmdReadCharDirect_xAlg(int i, byte[] bArr, int[] iArr);

    public native int CmdReadNoteBook(int i, byte[] bArr, int[] iArr);

    public native int CmdReadParaTable(PARA_TABLE para_table, int[] iArr);

    public native int CmdResumeFactory(int[] iArr);

    public native int CmdSearchChar(int i, int[] iArr, int[] iArr2, int[] iArr3);

    public native int CmdSendDemon(byte[] bArr, int[] iArr);

    public native int CmdSetBaudRate(int i, int[] iArr);

    public native int CmdSetCmosPara(int i, int i2, int[] iArr);

    public native int CmdSetDeviceAddress(int i, int[] iArr);

    public native int CmdSetPsw(int i, int[] iArr);

    public native int CmdSetSecurLevel(int i, int[] iArr);

    public native int CmdStoreChar(int i, int[] iArr, int[] iArr2, int[] iArr3);

    public native int CmdStoreCharDirect_eAlg(int i, byte[] bArr, int[] iArr);

    public native int CmdStoreCharDirect_xAlg(int i, byte[] bArr, int[] iArr);

    public native int CmdUpLoadRawImage(byte[] bArr);

    public native int CmdUpLoadRedressImage(byte[] bArr);

    public native int CmdUpLoadRedressImage256x360(byte[] bArr);

    public native int CmdVerifyChar(int i, int i2, int[] iArr, int[] iArr2);

    public native int CmdWriteNoteBook(int i, byte[] bArr, int[] iArr);

    public native void CommClose();

    public native int ConfigCommParameterCom(String str, int i, int i2, int i3, int i4, int i5, int i6);

    public native int ConfigCommParameterUDisk(int i, int i2);

    public native int GetAppDirectoryPath(char[] cArr, int i);

    public native int GetComList(char[] cArr);

    public native int GetCurrentDirectoryPath(char[] cArr, int i);

    public native int GetLastCommErr();

    public native int GetLastCommSystemErr();

    public native int GetTimeOutValue();

    public native int SetAppDirectoryPath(char[] cArr, int i);

    public native void SetTimeOutValue(int i);

    public NETLH_E() {
        char[] charArray = "/mnt/sdcard/".toCharArray();
        char[] ppCurrentPath = new char[1024];
        GetAppDirectoryPath(ppCurrentPath, 1024);
        String obj = ppCurrentPath.toString();
    }

    public int CmdDeviceGetChmod(int ErrCode) {
        byte[] path = new byte[128];
        CmdDeviceInitGetPath(path);
        String spath = new String(path);
        String command = "chmod 777 " + spath.substring(0, spath.indexOf(0));
        Log.d("=NETLH_E=", " exec " + command);
        try {
            Process process = Runtime.getRuntime().exec("su");
            DataOutputStream os = new DataOutputStream(process.getOutputStream());
            try {
                os.writeBytes(String.valueOf(command) + "\n");
                os.writeBytes("exit\n");
                os.flush();
                process.waitFor();
                DataOutputStream dataOutputStream = os;
                return 1;
            } catch (Exception e) {
                DataOutputStream dataOutputStream2 = os;
                return 0;
            }
        } catch (Exception e2) {
            return 0;
        }
    }

    public int CmdDeviceGetChmod(String path) {
        String command = "chmod 777 " + path;
        Log.d("=NETLH_E=", " exec " + command);
        try {
            Process process = Runtime.getRuntime().exec("su");
            DataOutputStream os = new DataOutputStream(process.getOutputStream());
            try {
                os.writeBytes(String.valueOf(command) + "\n");
                os.writeBytes("exit\n");
                os.flush();
                process.waitFor();
                DataOutputStream dataOutputStream = os;
                return 0;
            } catch (Exception e) {
                DataOutputStream dataOutputStream2 = os;
                return 0;
            }
        } catch (Exception e2) {
            return 0;
        }
    }

    static {
        System.loadLibrary("NETLH_E");
    }
}
