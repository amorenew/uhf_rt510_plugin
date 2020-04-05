package com.handheld.UHFLonger;

import android.util.Log;
import com.BRMicro.SerialPort;
import com.rfid.uhf.IUhfreader;
import com.uhf.api.cls.AntPower;
import com.uhf.api.cls.AntPowerConf;
import com.uhf.api.cls.Reader;
import com.uhf.api.cls.TAGINFO;
import com.uhf.api.cls.TagFilter_ST;

import java.util.ArrayList;
import java.util.List;

public class UHFLongerManager implements IUhfreader {
    public static final int LOCK_MEM_ACCESS = 1;
    public static final int LOCK_MEM_EPC = 2;
    public static final int LOCK_MEM_KILL = 0;
    public static final int LOCK_MEM_TID = 3;
    public static final int LOCK_MEM_USER = 4;
    public static final int LOCK_PERM = 4;
    public static final int LOCK_PSD = 2;
    public static final int MEMBANK_EPC = 1;
    public static final int MEMBANK_RESEVER = 0;
    public static final int MEMBANK_TID = 2;
    public static final int MEMBANK_USER = 3;
    public static final int UNLOCK = 0;
    private static UHFLongerManager manager;
    public static int port = 12;
    private static String serialportPath = "/dev/ttyMT1";
    private short WRtimeout = 1000;
    private int ant = 1;
    private int[] ants = {1};
    private SerialPort mSerialport = new SerialPort();
    private Reader reader = new Reader();
    private int[] tagcnt = new int[1];
    private short timeout = 50;

    public UHFLongerManager(String serialPath, int port2) throws Exception {
        this.mSerialport.zigbeepoweron();
        this.mSerialport.rfidPoweron();
        this.mSerialport.switch2Channel(port2);
        if (this.reader.InitReader_Notype(serialPath, 1) != Reader.READER_ERR.MT_OK_ERR) {
            throw new Exception("init device fail");
        }
    }

    public static UHFLongerManager getInstance() throws Exception {
        if (manager == null) {
            manager = new UHFLongerManager(serialportPath, port);
        }
        return manager;
    }

    public void close() {
        debugLog("close()");
        if (manager != null) {
            manager = null;
            this.reader.CloseReader();
            this.mSerialport.zigbeepoweroff();
            this.mSerialport.rfidPoweroff();
        }
    }

    public List<String> inventoryRealTime() {
        List<String> list = null;
        if (this.reader.TagInventory_Raw(this.ants, this.ants.length, this.timeout, this.tagcnt) == Reader.READER_ERR.MT_OK_ERR && this.tagcnt[0] > 0) {
            list = new ArrayList<>();
            for (int i = 0; i < this.tagcnt[0]; i++) {
                Reader reader2 = this.reader;
                reader2.getClass();
                TAGINFO info = new TAGINFO();
                if (this.reader.GetNextTag(info) == Reader.READER_ERR.MT_OK_ERR) {
                    list.add(Reader.bytes_Hexstr(info.EpcId));
                }
            }
        }
        return list;
    }

    public void open(String serial, int port2) {
    }

    public boolean selectEPC(byte[] epc) {
        Reader reader2 = this.reader;
        reader2.getClass();
        TagFilter_ST tfst = new TagFilter_ST();
        tfst.bank = 1;
        tfst.fdata = epc;
        tfst.flen = epc.length;
        tfst.isInvert = 0;
        tfst.startaddr = 32;
        if (this.reader.ParamSet(Reader.Mtr_Param.MTR_PARAM_TAG_FILTER, tfst) == Reader.READER_ERR.MT_OK_ERR) {
            return true;
        }
        return false;
    }

    public boolean clearSelect() {
        Reader.READER_ERR ParamSet = this.reader.ParamSet(Reader.Mtr_Param.MTR_PARAM_TAG_FILTER, (Object) null);
        return false;
    }

    public byte[] readData(int memBank, int start, int length, byte[] password) {
        byte[] data = new byte[(length * 2)];
        if (this.reader.GetTagData(this.ant, (char) memBank, start, length, data, password, this.WRtimeout) == Reader.READER_ERR.MT_OK_ERR) {
            return data;
        }
        return null;
    }

    private void debugLog(String msg) {
        Log.e("UHF READER", msg);
    }

    public boolean writeData(int memBank, int start, byte[] password, byte[] wData) {
        if (this.reader.WriteTagData(this.ant, (char) memBank, start, wData, wData.length, password, this.WRtimeout) == Reader.READER_ERR.MT_OK_ERR) {
            return true;
        }
        return false;
    }

    public boolean writeEPC(byte[] newEPC, byte[] password) {
        if (this.reader.WriteTagEpcEx(this.ant, newEPC, newEPC.length, password, this.WRtimeout) == Reader.READER_ERR.MT_OK_ERR) {
            return true;
        }
        return false;
    }

    public boolean writeAccess(byte[] newAccess, byte[] oldAccess) {
        if (this.reader.WriteTagData(this.ant, (char)0, 2, newAccess, newAccess.length, oldAccess, this.WRtimeout) == Reader.READER_ERR.MT_OK_ERR) {
            return true;
        }
        return false;
    }

    public boolean writeKillPsd(byte[] newKill, byte[] access) {
        if (this.reader.WriteTagData(this.ant, (char)0, 0, newKill, newKill.length, access, this.WRtimeout) == Reader.READER_ERR.MT_OK_ERR) {
            return true;
        }
        return false;
    }

    public boolean lockTag(int lockType, int lockMem, byte[] access) {
        Reader.Lock_Obj lockobj = Reader.Lock_Obj.LOCK_OBJECT_ACCESS_PASSWD;
        Reader.Lock_Type mlocktype = Reader.Lock_Type.ACCESS_PASSWD_UNLOCK;
        switch (lockMem) {
            case 0:
                lockobj = Reader.Lock_Obj.LOCK_OBJECT_KILL_PASSWORD;
                if (lockType != 4) {
                    if (lockType != 2) {
                        mlocktype = Reader.Lock_Type.KILL_PASSWORD_UNLOCK;
                        break;
                    } else {
                        mlocktype = Reader.Lock_Type.KILL_PASSWORD_LOCK;
                        break;
                    }
                } else {
                    mlocktype = Reader.Lock_Type.KILL_PASSWORD_PERM_LOCK;
                    break;
                }
            case 1:
                lockobj = Reader.Lock_Obj.LOCK_OBJECT_ACCESS_PASSWD;
                if (lockType != 4) {
                    if (lockType != 2) {
                        mlocktype = Reader.Lock_Type.ACCESS_PASSWD_UNLOCK;
                        break;
                    } else {
                        mlocktype = Reader.Lock_Type.ACCESS_PASSWD_LOCK;
                        break;
                    }
                } else {
                    mlocktype = Reader.Lock_Type.ACCESS_PASSWD_PERM_LOCK;
                    break;
                }
            case 2:
                lockobj = Reader.Lock_Obj.LOCK_OBJECT_BANK1;
                if (lockType != 4) {
                    if (lockType != 2) {
                        mlocktype = Reader.Lock_Type.BANK1_UNLOCK;
                        break;
                    } else {
                        mlocktype = Reader.Lock_Type.BANK1_LOCK;
                        break;
                    }
                } else {
                    mlocktype = Reader.Lock_Type.BANK1_PERM_LOCK;
                    break;
                }
            case 3:
                lockobj = Reader.Lock_Obj.LOCK_OBJECT_BANK2;
                if (lockType != 4) {
                    if (lockType != 2) {
                        mlocktype = Reader.Lock_Type.BANK2_UNLOCK;
                        break;
                    } else {
                        mlocktype = Reader.Lock_Type.BANK2_LOCK;
                        break;
                    }
                } else {
                    mlocktype = Reader.Lock_Type.BANK2_PERM_LOCK;
                    break;
                }
            case 4:
                lockobj = Reader.Lock_Obj.LOCK_OBJECT_BANK3;
                if (lockType != 4) {
                    if (lockType != 2) {
                        mlocktype = Reader.Lock_Type.BANK3_UNLOCK;
                        break;
                    } else {
                        mlocktype = Reader.Lock_Type.BANK3_LOCK;
                        break;
                    }
                } else {
                    mlocktype = Reader.Lock_Type.BANK3_PERM_LOCK;
                    break;
                }
        }
        if (this.reader.LockTag(this.ant, (byte) lockobj.value(), (short) mlocktype.value(), access, this.WRtimeout) == Reader.READER_ERR.MT_OK_ERR) {
            return true;
        }
        return false;
    }

    public boolean setOutPower(short value) {
        Reader reader2 = this.reader;
        reader2.getClass();
        AntPowerConf apcf = new AntPowerConf();
        apcf.antcnt = 1;
        Reader reader3 = this.reader;
        reader3.getClass();
        AntPower jaap = new AntPower();
        jaap.antid = 1;
        jaap.readPower = (short) (value * 100);
        jaap.writePower = (short) (value * 100);
        apcf.Powers[0] = jaap;
        if (this.reader.ParamSet(Reader.Mtr_Param.MTR_PARAM_RF_ANTPOWER, apcf) == Reader.READER_ERR.MT_OK_ERR) {
            return true;
        }
        return false;
    }
}
