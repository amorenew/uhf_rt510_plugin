package com.uhf.api.cls;

import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;

import com.BRMicro.SerialPort;

public class Reader {
    private static /* synthetic */ int[] $SWITCH_TABLE$com$uhf$api$cls$Reader$CustomCmdType = null;
    private static /* synthetic */ int[] $SWITCH_TABLE$com$uhf$api$cls$Reader$Mtr_Param = null;
    public static final int HOPTABLECNT = 100;
    public static final int MAXANTCNT = 16;
    public static final int MAXEMBDATALEN = 128;
    public static final int MAXEPCBYTESCNT = 62;
    public static final int MAXINVPOTLSCNT = 6;
    public static final int MAXIPSTRLEN = 50;
    int[] hReader = new int[1];
    JniModuleAPI japi = new JniModuleAPI();

    public enum MaindBoard_Type {
        MAINBOARD_NONE,
        MAINBOARD_ARM7,
        MAINBOARD_SERIAL,
        MAINBOARD_WIFI,
        MAINBOARD_ARM9,
        MAINBOARD_ARM9_WIFI
    }

    static /* synthetic */ int[] $SWITCH_TABLE$com$uhf$api$cls$Reader$CustomCmdType() {
        int[] iArr = $SWITCH_TABLE$com$uhf$api$cls$Reader$CustomCmdType;
        if (iArr == null) {
            iArr = new int[CustomCmdType.values().length];
            try {
                iArr[CustomCmdType.ALIEN_Higgs2_FullLoadImage.ordinal()] = 7;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[CustomCmdType.ALIEN_Higgs2_PartialLoadImage.ordinal()] = 6;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[CustomCmdType.ALIEN_Higgs3_BlockPermaLock.ordinal()] = 11;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[CustomCmdType.ALIEN_Higgs3_BlockReadLock.ordinal()] = 10;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[CustomCmdType.ALIEN_Higgs3_FastLoadImage.ordinal()] = 8;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[CustomCmdType.ALIEN_Higgs3_LoadImage.ordinal()] = 9;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[CustomCmdType.IMPINJ_M4_Qt.ordinal()] = 12;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[CustomCmdType.NXP_Calibrate.ordinal()] = 5;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[CustomCmdType.NXP_ChangeEAS.ordinal()] = 3;
            } catch (NoSuchFieldError e9) {
            }
            try {
                iArr[CustomCmdType.NXP_EASAlarm.ordinal()] = 4;
            } catch (NoSuchFieldError e10) {
            }
            try {
                iArr[CustomCmdType.NXP_ResetReadProtect.ordinal()] = 2;
            } catch (NoSuchFieldError e11) {
            }
            try {
                iArr[CustomCmdType.NXP_SetReadProtect.ordinal()] = 1;
            } catch (NoSuchFieldError e12) {
            }
            $SWITCH_TABLE$com$uhf$api$cls$Reader$CustomCmdType = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] $SWITCH_TABLE$com$uhf$api$cls$Reader$Mtr_Param() {
        int[] iArr = $SWITCH_TABLE$com$uhf$api$cls$Reader$Mtr_Param;
        if (iArr == null) {
            iArr = new int[Mtr_Param.values().length];
            try {
                iArr[Mtr_Param.MTR_PARAM_FREQUENCY_HOPTABLE.ordinal()] = 17;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Mtr_Param.MTR_PARAM_FREQUENCY_REGION.ordinal()] = 16;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[Mtr_Param.MTR_PARAM_MAXINDEX.ordinal()] = 38;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[Mtr_Param.MTR_PARAM_POTL_GEN2_BLF.ordinal()] = 18;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[Mtr_Param.MTR_PARAM_POTL_GEN2_MAXEPCLEN.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[Mtr_Param.MTR_PARAM_POTL_GEN2_Q.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[Mtr_Param.MTR_PARAM_POTL_GEN2_SESSION.ordinal()] = 1;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[Mtr_Param.MTR_PARAM_POTL_GEN2_TAGENCODING.ordinal()] = 3;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[Mtr_Param.MTR_PARAM_POTL_GEN2_TARGET.ordinal()] = 20;
            } catch (NoSuchFieldError e9) {
            }
            try {
                iArr[Mtr_Param.MTR_PARAM_POTL_GEN2_TARI.ordinal()] = 30;
            } catch (NoSuchFieldError e10) {
            }
            try {
                iArr[Mtr_Param.MTR_PARAM_POTL_GEN2_WRITEMODE.ordinal()] = 19;
            } catch (NoSuchFieldError e11) {
            }
            try {
                iArr[Mtr_Param.MTR_PARAM_POTL_ISO180006B_BLF.ordinal()] = 29;
            } catch (NoSuchFieldError e12) {
            }
            try {
                iArr[Mtr_Param.MTR_PARAM_POTL_ISO180006B_DELIMITER.ordinal()] = 37;
            } catch (NoSuchFieldError e13) {
            }
            try {
                iArr[Mtr_Param.MTR_PARAM_POTL_ISO180006B_MODULATION_DEPTH.ordinal()] = 36;
            } catch (NoSuchFieldError e14) {
            }
            try {
                iArr[Mtr_Param.MTR_PARAM_POTL_SUPPORTEDPROTOCOLS.ordinal()] = 28;
            } catch (NoSuchFieldError e15) {
            }
            try {
                iArr[Mtr_Param.MTR_PARAM_POWERSAVE_MODE.ordinal()] = 34;
            } catch (NoSuchFieldError e16) {
            }
            try {
                iArr[Mtr_Param.MTR_PARAM_READER_AVAILABLE_ANTPORTS.ordinal()] = 12;
            } catch (NoSuchFieldError e17) {
            }
            try {
                iArr[Mtr_Param.MTR_PARAM_READER_CONN_ANTS.ordinal()] = 11;
            } catch (NoSuchFieldError e18) {
            }
            try {
                iArr[Mtr_Param.MTR_PARAM_READER_IP.ordinal()] = 15;
            } catch (NoSuchFieldError e19) {
            }
            try {
                iArr[Mtr_Param.MTR_PARAM_READER_IS_CHK_ANT.ordinal()] = 13;
            } catch (NoSuchFieldError e20) {
            }
            try {
                iArr[Mtr_Param.MTR_PARAM_READER_VERSION.ordinal()] = 14;
            } catch (NoSuchFieldError e21) {
            }
            try {
                iArr[Mtr_Param.MTR_PARAM_RF_ANTPOWER.ordinal()] = 5;
            } catch (NoSuchFieldError e22) {
            }
            try {
                iArr[Mtr_Param.MTR_PARAM_RF_HOPTIME.ordinal()] = 25;
            } catch (NoSuchFieldError e23) {
            }
            try {
                iArr[Mtr_Param.MTR_PARAM_RF_LBT_ENABLE.ordinal()] = 26;
            } catch (NoSuchFieldError e24) {
            }
            try {
                iArr[Mtr_Param.MTR_PARAM_RF_MAXPOWER.ordinal()] = 6;
            } catch (NoSuchFieldError e25) {
            }
            try {
                iArr[Mtr_Param.MTR_PARAM_RF_MINPOWER.ordinal()] = 7;
            } catch (NoSuchFieldError e26) {
            }
            try {
                iArr[Mtr_Param.MTR_PARAM_RF_SUPPORTEDREGIONS.ordinal()] = 27;
            } catch (NoSuchFieldError e27) {
            }
            try {
                iArr[Mtr_Param.MTR_PARAM_RF_TEMPERATURE.ordinal()] = 24;
            } catch (NoSuchFieldError e28) {
            }
            try {
                iArr[Mtr_Param.MTR_PARAM_TAGDATA_RECORDHIGHESTRSSI.ordinal()] = 23;
            } catch (NoSuchFieldError e29) {
            }
            try {
                iArr[Mtr_Param.MTR_PARAM_TAGDATA_UNIQUEBYANT.ordinal()] = 21;
            } catch (NoSuchFieldError e30) {
            }
            try {
                iArr[Mtr_Param.MTR_PARAM_TAGDATA_UNIQUEBYEMDDATA.ordinal()] = 22;
            } catch (NoSuchFieldError e31) {
            }
            try {
                iArr[Mtr_Param.MTR_PARAM_TAG_EMBEDEDDATA.ordinal()] = 9;
            } catch (NoSuchFieldError e32) {
            }
            try {
                iArr[Mtr_Param.MTR_PARAM_TAG_EMDSECUREREAD.ordinal()] = 32;
            } catch (NoSuchFieldError e33) {
            }
            try {
                iArr[Mtr_Param.MTR_PARAM_TAG_FILTER.ordinal()] = 8;
            } catch (NoSuchFieldError e34) {
            }
            try {
                iArr[Mtr_Param.MTR_PARAM_TAG_INVPOTL.ordinal()] = 10;
            } catch (NoSuchFieldError e35) {
            }
            try {
                iArr[Mtr_Param.MTR_PARAM_TAG_SEARCH_MODE.ordinal()] = 35;
            } catch (NoSuchFieldError e36) {
            }
            try {
                iArr[Mtr_Param.MTR_PARAM_TRANSMIT_MODE.ordinal()] = 33;
            } catch (NoSuchFieldError e37) {
            }
            try {
                iArr[Mtr_Param.MTR_PARAM_TRANS_TIMEOUT.ordinal()] = 31;
            } catch (NoSuchFieldError e38) {
            }
            $SWITCH_TABLE$com$uhf$api$cls$Reader$Mtr_Param = iArr;
        }
        return iArr;
    }

    public enum Module_Type {
        MODOULE_NONE(0),
        MODOULE_R902_M1S(1),
        MODOULE_R902_M2S(2),
        MODOULE_M5E(3),
        MODOULE_M5E_C(4),
        MODOULE_M6E(5),
        MODOULE_PR9000(6),
        MODOULE_M5E_PRC(7),
        MODOULE_M6E_PRC(8),
        MODOULE_M6E_MICRO(9),
        MODOULE_SLR1100(10),
        MODOULE_SLR1200(11),
        MODOULE_SLR1300(12),
        MODOULE_SLR3000(13),
        MODOULE_SLR5100(14),
        MODOULE_SLR5200(15),
        MODOULE_SLR3100(16),
        MODOULE_SLR3200(17),
        MODOULE_SLR5300(18);
        
        private int value;

        private Module_Type(int value2) {
            this.value = 0;
            this.value = value2;
        }

        public static Module_Type valueOf(int value2) {
            switch (value2) {
                case 0:
                    return MODOULE_NONE;
                case 1:
                    return MODOULE_R902_M1S;
                case 2:
                    return MODOULE_R902_M2S;
                case 3:
                    return MODOULE_M5E;
                case 4:
                    return MODOULE_M5E_C;
                case 5:
                    return MODOULE_M6E;
                case 6:
                    return MODOULE_PR9000;
                case 7:
                    return MODOULE_M5E_PRC;
                case 8:
                    return MODOULE_M6E_PRC;
                case 9:
                    return MODOULE_M6E_MICRO;
                case 10:
                    return MODOULE_SLR1100;
                case SerialPort.com11:
                    return MODOULE_SLR1200;
                case SerialPort.com12:
                    return MODOULE_SLR1300;
                case SerialPort.com13:
                    return MODOULE_SLR3000;
                case SerialPort.com14:
                    return MODOULE_SLR5100;
                case 15:
                    return MODOULE_SLR5200;
                case 16:
                    return MODOULE_SLR3100;
                case SerialPort.com17:
                    return MODOULE_SLR3200;
                case SerialPort.com18:
                    return MODOULE_SLR5300;
                default:
                    return null;
            }
        }

        public int value() {
            return this.value;
        }
    }

    public enum Region_Conf {
        RG_NONE(0),
        RG_NA(1),
        RG_EU(2),
        RG_EU2(7),
        RG_EU3(8),
        RG_KR(3),
        RG_PRC(6),
        RG_PRC2(10),
        RG_OPEN(MotionEventCompat.ACTION_MASK);
        
        int p_v;

        private Region_Conf(int v) {
            this.p_v = v;
        }

        public int value() {
            return this.p_v;
        }

        public static Region_Conf valueOf(int value) {
            switch (value) {
                case 0:
                    return RG_NONE;
                case 1:
                    return RG_NA;
                case 2:
                    return RG_EU;
                case 3:
                    return RG_KR;
                case 6:
                    return RG_PRC;
                case 7:
                    return RG_EU2;
                case 8:
                    return RG_EU3;
                case 10:
                    return RG_PRC2;
                case MotionEventCompat.ACTION_MASK:
                    return RG_OPEN;
                default:
                    return null;
            }
        }
    }

    public enum SL_TagProtocol {
        SL_TAG_PROTOCOL_NONE(0),
        SL_TAG_PROTOCOL_ISO180006B(3),
        SL_TAG_PROTOCOL_GEN2(5),
        SL_TAG_PROTOCOL_ISO180006B_UCODE(6),
        SL_TAG_PROTOCOL_IPX64(7),
        SL_TAG_PROTOCOL_IPX256(8);
        
        int p_v;

        private SL_TagProtocol(int v) {
            this.p_v = v;
        }

        public int value() {
            return this.p_v;
        }

        public static SL_TagProtocol valueOf(int value) {
            switch (value) {
                case 0:
                    return SL_TAG_PROTOCOL_NONE;
                case 3:
                    return SL_TAG_PROTOCOL_ISO180006B;
                case 5:
                    return SL_TAG_PROTOCOL_GEN2;
                case 6:
                    return SL_TAG_PROTOCOL_ISO180006B_UCODE;
                case 7:
                    return SL_TAG_PROTOCOL_IPX64;
                case 8:
                    return SL_TAG_PROTOCOL_IPX256;
                default:
                    return null;
            }
        }
    }

    public enum Lock_Obj {
        LOCK_OBJECT_KILL_PASSWORD(1),
        LOCK_OBJECT_ACCESS_PASSWD(2),
        LOCK_OBJECT_BANK1(4),
        LOCK_OBJECT_BANK2(8),
        LOCK_OBJECT_BANK3(16);
        
        int p_v;

        private Lock_Obj(int v) {
            this.p_v = v;
        }

        public int value() {
            return this.p_v;
        }
    }

    public enum Lock_Type {
        KILL_PASSWORD_UNLOCK(0),
        KILL_PASSWORD_LOCK(512),
        KILL_PASSWORD_PERM_LOCK(768),
        ACCESS_PASSWD_UNLOCK(0),
        ACCESS_PASSWD_LOCK(128),
        ACCESS_PASSWD_PERM_LOCK(192),
        BANK1_UNLOCK(0),
        BANK1_LOCK(32),
        BANK1_PERM_LOCK(48),
        BANK2_UNLOCK(0),
        BANK2_LOCK(8),
        BANK2_PERM_LOCK(12),
        BANK3_UNLOCK(0),
        BANK3_LOCK(2),
        BANK3_PERM_LOCK(3);
        
        int p_v;

        private Lock_Type(int v) {
            this.p_v = v;
        }

        public int value() {
            return this.p_v;
        }
    }

    public enum Reader_Type {
        MODULE_TWO_ANTS(0),
        MODULE_FOUR_ANTS(1),
        MODULE_THREE_ANTS(3),
        MODULE_ONE_ANT(4),
        PR9000(5),
        MODULE_ARM7_TWO_ANTS(6),
        MODULE_ARM7_FOUR_ANTS(7),
        M6E_ARM7_FOUR_ANTS(8),
        M56_ARM7_FOUR_ANTS(9),
        R902_M1S(10),
        R902_M2S(11),
        ARM7_16ANTS(12),
        SL_COMMN_READER(13);
        
        private int value;

        private Reader_Type(int value2) {
            this.value = 0;
            this.value = value2;
        }

        public static Reader_Type valueOf(int value2) {
            switch (value2) {
                case 0:
                    return MODULE_TWO_ANTS;
                case 1:
                    return MODULE_FOUR_ANTS;
                case 2:
                    return MODULE_THREE_ANTS;
                case 3:
                    return MODULE_ONE_ANT;
                case 4:
                    return PR9000;
                case 5:
                    return MODULE_ARM7_TWO_ANTS;
                case 6:
                    return MODULE_ARM7_FOUR_ANTS;
                case 7:
                    return M6E_ARM7_FOUR_ANTS;
                case 8:
                    return M56_ARM7_FOUR_ANTS;
                case 9:
                    return R902_M1S;
                case 10:
                    return R902_M2S;
                case SerialPort.com11:
                    return ARM7_16ANTS;
                case SerialPort.com12:
                    return SL_COMMN_READER;
                default:
                    return null;
            }
        }

        public int value() {
            return this.value;
        }
    }

    public enum READER_ERR {
        MT_OK_ERR(0),
        MT_IO_ERR(1),
        MT_INTERNAL_DEV_ERR(2),
        MT_CMD_FAILED_ERR(3),
        MT_CMD_NO_TAG_ERR(4),
        MT_M5E_FATAL_ERR(5),
        MT_OP_NOT_SUPPORTED(6),
        MT_INVALID_PARA(7),
        MT_INVALID_READER_HANDLE(8),
        MT_HARDWARE_ALERT_ERR_BY_HIGN_RETURN_LOSS(9),
        MT_HARDWARE_ALERT_ERR_BY_TOO_MANY_RESET(10),
        MT_HARDWARE_ALERT_ERR_BY_NO_ANTENNAS(11),
        MT_HARDWARE_ALERT_ERR_BY_HIGH_TEMPERATURE(12),
        MT_HARDWARE_ALERT_ERR_BY_READER_DOWN(13),
        MT_HARDWARE_ALERT_ERR_BY_UNKNOWN_ERR(14),
        M6E_INIT_FAILED(15),
        MT_OP_EXECING(16),
        MT_UNKNOWN_READER_TYPE(17),
        MT_OP_INVALID(18),
        MT_HARDWARE_ALERT_BY_FAILED_RESET_MODLUE(19),
        MT_MAX_ERR_NUM(20),
        MT_MAX_INT_NUM(21);
        
        private int value;

        private READER_ERR(int value2) {
            this.value = 0;
            this.value = value2;
        }

        public static READER_ERR valueOf(int value2) {
            switch (value2) {
                case 0:
                    return MT_OK_ERR;
                case 1:
                    return MT_IO_ERR;
                case 2:
                    return MT_INTERNAL_DEV_ERR;
                case 3:
                    return MT_CMD_FAILED_ERR;
                case 4:
                    return MT_CMD_NO_TAG_ERR;
                case 5:
                    return MT_M5E_FATAL_ERR;
                case 6:
                    return MT_OP_NOT_SUPPORTED;
                case 7:
                    return MT_INVALID_PARA;
                case 8:
                    return MT_INVALID_READER_HANDLE;
                case 9:
                    return MT_HARDWARE_ALERT_ERR_BY_HIGN_RETURN_LOSS;
                case 10:
                    return MT_HARDWARE_ALERT_ERR_BY_TOO_MANY_RESET;
                case SerialPort.com11:
                    return MT_HARDWARE_ALERT_ERR_BY_NO_ANTENNAS;
                case SerialPort.com12:
                    return MT_HARDWARE_ALERT_ERR_BY_HIGH_TEMPERATURE;
                case SerialPort.com13:
                    return MT_HARDWARE_ALERT_ERR_BY_READER_DOWN;
                case SerialPort.com14:
                    return MT_HARDWARE_ALERT_ERR_BY_UNKNOWN_ERR;
                case 15:
                    return M6E_INIT_FAILED;
                case 16:
                    return MT_OP_EXECING;
                case SerialPort.com17:
                    return MT_UNKNOWN_READER_TYPE;
                case SerialPort.com18:
                    return MT_OP_INVALID;
                case 19:
                    return MT_HARDWARE_ALERT_BY_FAILED_RESET_MODLUE;
                case SerialPort.com20:
                    return MT_MAX_ERR_NUM;
                case SerialPort.com21:
                    return MT_MAX_INT_NUM;
                default:
                    return MT_MAX_ERR_NUM;
            }
        }

        public int value() {
            return this.value;
        }
    }

    public enum CustomCmdType {
        NXP_SetReadProtect(0),
        NXP_ResetReadProtect(1),
        NXP_ChangeEAS(2),
        NXP_EASAlarm(3),
        NXP_Calibrate(4),
        ALIEN_Higgs2_PartialLoadImage(5),
        ALIEN_Higgs2_FullLoadImage(6),
        ALIEN_Higgs3_FastLoadImage(7),
        ALIEN_Higgs3_LoadImage(8),
        ALIEN_Higgs3_BlockReadLock(9),
        ALIEN_Higgs3_BlockPermaLock(10),
        IMPINJ_M4_Qt(11);
        
        private int value;

        private CustomCmdType(int value2) {
            this.value = 0;
            this.value = value2;
        }

        public static CustomCmdType valueOf(int value2) {
            switch (value2) {
                case 0:
                    return NXP_SetReadProtect;
                case 1:
                    return NXP_ResetReadProtect;
                case 2:
                    return NXP_ChangeEAS;
                case 3:
                    return NXP_EASAlarm;
                case 4:
                    return NXP_Calibrate;
                case 5:
                    return ALIEN_Higgs2_PartialLoadImage;
                case 6:
                    return ALIEN_Higgs2_FullLoadImage;
                case 7:
                    return ALIEN_Higgs3_FastLoadImage;
                case 8:
                    return ALIEN_Higgs3_LoadImage;
                case 9:
                    return ALIEN_Higgs3_BlockReadLock;
                case 10:
                    return ALIEN_Higgs3_BlockPermaLock;
                case SerialPort.com11:
                    return IMPINJ_M4_Qt;
                default:
                    return null;
            }
        }

        public int value() {
            return this.value;
        }
    }

    public enum Mtr_Param {
        MTR_PARAM_POTL_GEN2_SESSION(0),
        MTR_PARAM_POTL_GEN2_Q(1),
        MTR_PARAM_POTL_GEN2_TAGENCODING(2),
        MTR_PARAM_POTL_GEN2_MAXEPCLEN(3),
        MTR_PARAM_RF_ANTPOWER(4),
        MTR_PARAM_RF_MAXPOWER(5),
        MTR_PARAM_RF_MINPOWER(6),
        MTR_PARAM_TAG_FILTER(7),
        MTR_PARAM_TAG_EMBEDEDDATA(8),
        MTR_PARAM_TAG_INVPOTL(9),
        MTR_PARAM_READER_CONN_ANTS(10),
        MTR_PARAM_READER_AVAILABLE_ANTPORTS(11),
        MTR_PARAM_READER_IS_CHK_ANT(12),
        MTR_PARAM_READER_VERSION(13),
        MTR_PARAM_READER_IP(14),
        MTR_PARAM_FREQUENCY_REGION(15),
        MTR_PARAM_FREQUENCY_HOPTABLE(16),
        MTR_PARAM_POTL_GEN2_BLF(17),
        MTR_PARAM_POTL_GEN2_WRITEMODE(18),
        MTR_PARAM_POTL_GEN2_TARGET(19),
        MTR_PARAM_TAGDATA_UNIQUEBYANT(20),
        MTR_PARAM_TAGDATA_UNIQUEBYEMDDATA(21),
        MTR_PARAM_TAGDATA_RECORDHIGHESTRSSI(22),
        MTR_PARAM_RF_TEMPERATURE(23),
        MTR_PARAM_RF_HOPTIME(24),
        MTR_PARAM_RF_LBT_ENABLE(25),
        MTR_PARAM_RF_SUPPORTEDREGIONS(26),
        MTR_PARAM_POTL_SUPPORTEDPROTOCOLS(27),
        MTR_PARAM_POTL_ISO180006B_BLF(28),
        MTR_PARAM_POTL_GEN2_TARI(29),
        MTR_PARAM_TRANS_TIMEOUT(30),
        MTR_PARAM_TAG_EMDSECUREREAD(31),
        MTR_PARAM_TRANSMIT_MODE(32),
        MTR_PARAM_POWERSAVE_MODE(33),
        MTR_PARAM_TAG_SEARCH_MODE(34),
        MTR_PARAM_POTL_ISO180006B_MODULATION_DEPTH(35),
        MTR_PARAM_POTL_ISO180006B_DELIMITER(36),
        MTR_PARAM_MAXINDEX(37);
        
        private int value;

        private Mtr_Param(int value2) {
            this.value = 0;
            this.value = value2;
        }

        public static Mtr_Param valueOf(int value2) {
            switch (value2) {
                case 0:
                    return MTR_PARAM_POTL_GEN2_SESSION;
                case 1:
                    return MTR_PARAM_POTL_GEN2_Q;
                case 2:
                    return MTR_PARAM_POTL_GEN2_TAGENCODING;
                case 3:
                    return MTR_PARAM_POTL_GEN2_MAXEPCLEN;
                case 4:
                    return MTR_PARAM_RF_ANTPOWER;
                case 5:
                    return MTR_PARAM_RF_MAXPOWER;
                case 6:
                    return MTR_PARAM_RF_MINPOWER;
                case 7:
                    return MTR_PARAM_TAG_FILTER;
                case 8:
                    return MTR_PARAM_TAG_EMBEDEDDATA;
                case 9:
                    return MTR_PARAM_TAG_INVPOTL;
                case 10:
                    return MTR_PARAM_READER_CONN_ANTS;
                case SerialPort.com11:
                    return MTR_PARAM_READER_AVAILABLE_ANTPORTS;
                case SerialPort.com12:
                    return MTR_PARAM_POTL_GEN2_TAGENCODING;
                case SerialPort.com13:
                    return MTR_PARAM_POTL_GEN2_MAXEPCLEN;
                case SerialPort.com14:
                    return MTR_PARAM_RF_ANTPOWER;
                case 15:
                    return MTR_PARAM_RF_MAXPOWER;
                case 16:
                    return MTR_PARAM_RF_MINPOWER;
                case SerialPort.com17:
                    return MTR_PARAM_TAG_FILTER;
                case SerialPort.com18:
                    return MTR_PARAM_TAG_EMBEDEDDATA;
                case 19:
                    return MTR_PARAM_TAG_INVPOTL;
                case SerialPort.com20:
                    return MTR_PARAM_READER_CONN_ANTS;
                case SerialPort.com21:
                    return MTR_PARAM_READER_AVAILABLE_ANTPORTS;
                case SerialPort.com22:
                    return MTR_PARAM_TAGDATA_RECORDHIGHESTRSSI;
                case SerialPort.com23:
                    return MTR_PARAM_POTL_GEN2_MAXEPCLEN;
                case SerialPort.com24:
                    return MTR_PARAM_RF_ANTPOWER;
                case SerialPort.com25:
                    return MTR_PARAM_RF_MAXPOWER;
                case SerialPort.com26:
                    return MTR_PARAM_RF_MINPOWER;
                case SerialPort.com27:
                    return MTR_PARAM_TAG_FILTER;
                case SerialPort.com28:
                    return MTR_PARAM_TAG_EMBEDEDDATA;
                case SerialPort.com29:
                    return MTR_PARAM_TAG_INVPOTL;
                case 30:
                    return MTR_PARAM_READER_CONN_ANTS;
                case 31:
                    return MTR_PARAM_POTL_GEN2_Q;
                case 32:
                    return MTR_PARAM_POTL_GEN2_TAGENCODING;
                case 33:
                    return MTR_PARAM_POTL_GEN2_MAXEPCLEN;
                case 34:
                    return MTR_PARAM_TAG_SEARCH_MODE;
                case 35:
                    return MTR_PARAM_POTL_ISO180006B_MODULATION_DEPTH;
                case 36:
                    return MTR_PARAM_POTL_ISO180006B_DELIMITER;
                default:
                    return null;
            }
        }

        public int value() {
            return this.value;
        }
    }


    public class IMPINJM4QtPara {
        public byte[] AccessPwd = new byte[4];
        public int CmdType;
        public int MemType;
        public int PersistType;
        public int RangeType;
        public short TimeOut;

        public IMPINJM4QtPara() {
        }
    }

    public class IMPINJM4QtResult {
        public int MemType;
        public int RangeType;

        public IMPINJM4QtResult() {
        }
    }

    public class NXPChangeEASPara {
        public byte[] AccessPwd = new byte[4];
        public short TimeOut;
        public int isSet;

        public NXPChangeEASPara() {
        }
    }

    public class NXPEASAlarmPara {
        public byte DR;
        public byte MC;
        public short TimeOut;
        public byte TrExt;

        public NXPEASAlarmPara() {
        }
    }

    public class NXPEASAlarmResult {
        public byte[] EASdata = new byte[8];

        public NXPEASAlarmResult() {
        }
    }

    public class ALIENHiggs3BlockReadLockPara {
        public byte[] AccessPwd = new byte[4];
        public byte BlkBits;
        public short TimeOut;

        public ALIENHiggs3BlockReadLockPara() {
        }
    }



    public class HardwareDetails {
        public MaindBoard_Type board;
        public Reader_Type logictype;
        public Module_Type module;

        public HardwareDetails() {
        }
    }

    public class EmbededSecureRead_ST {
        public int ApIndexBitsNumInEpc;
        public int ApIndexStartBitsInEpc;
        public int accesspwd;
        public int address;
        public int bank;
        public int blkcnt;
        public int pwdtype;
        public int tagtype;

        public EmbededSecureRead_ST() {
        }
    }

    public class Reader_Ip {
        public byte[] gateway;
        public byte[] ip;
        public byte[] mask;

        public Reader_Ip() {
        }
    }

    public class Reader_Ver {
        public char[] ver = new char[50];

        public Reader_Ver() {
        }
    }


    public class EmbededData_ST {
        public byte[] accesspwd;
        public int bank;
        public int bytecnt;
        public int startaddr;

        public EmbededData_ST() {
        }
    }

    public class AntLinkVSWR {
        public int andid;
        public float vswr;

        public AntLinkVSWR() {
        }
    }

    public class AntPortsVSWR {
        public AntLinkVSWR[] AntVSWRS = new AntLinkVSWR[16];
        public int antcnt;

        public AntPortsVSWR() {
        }
    }

    public class ConnAnts_ST {
        public int antcnt;
        public int[] connectedants = new int[16];

        public ConnAnts_ST() {
        }
    }

    public class HoptableData_ST {
        public int[] htb = new int[100];
        public int lenhtb;

        public HoptableData_ST() {
        }
    }

    public class Inv_Potl {
        public SL_TagProtocol potl;
        public int weight;

        public Inv_Potl() {
        }
    }

    public class Inv_Potls_ST {
        public int potlcnt;
        public Inv_Potl[] potls = new Inv_Potl[6];

        public Inv_Potls_ST() {
        }
    }

    public void Hex2Str(byte[] buf, int len, char[] out) {
        char[] hexc = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        for (int i = 0; i < len; i++) {
            out[i * 2] = hexc[(buf[i] & 255) / 16];
            out[(i * 2) + 1] = hexc[(buf[i] & 255) % 16];
        }
    }

    private char[] bytestochars(byte[] bdata) {
        char[] cdata = new char[bdata.length];
        for (int i = 0; i < bdata.length; i++) {
            cdata[i] = (char) bdata[i];
        }
        return cdata;
    }

    private byte[] charstobytes(char[] cdata) {
        if (cdata == null) {
            return null;
        }
        int len = 0;
        int i = 0;
        while (i < cdata.length && cdata[i] != 0) {
            len++;
            i++;
        }
        byte[] bdata = new byte[len];
        for (int i2 = 0; i2 < len; i2++) {
            bdata[i2] = (byte) cdata[i2];
        }
        return bdata;
    }

    public READER_ERR InitReader(String src, Reader_Type rtype) {
        return READER_ERR.valueOf(this.japi.InitReader(this.hReader, src, rtype.value()));
    }

    public READER_ERR InitReader_Notype(String src, int rtype) {
        return READER_ERR.valueOf(this.japi.InitReader_Notype(this.hReader, src, rtype));
    }

    public READER_ERR GetHardwareDetails(HardwareDetails val) {
        byte[] data = new byte[3];
        READER_ERR ERR = READER_ERR.valueOf(this.japi.GetHardwareDetails(this.hReader[0], data));
        if (ERR == READER_ERR.MT_OK_ERR) {
            val.module = Module_Type.valueOf((int) data[0]);
            switch (data[1]) {
                case 0:
                    val.board = MaindBoard_Type.MAINBOARD_NONE;
                    break;
                case 1:
                    val.board = MaindBoard_Type.MAINBOARD_ARM7;
                    break;
                case 2:
                    val.board = MaindBoard_Type.MAINBOARD_SERIAL;
                    break;
                case 3:
                    val.board = MaindBoard_Type.MAINBOARD_WIFI;
                    break;
                case 4:
                    val.board = MaindBoard_Type.MAINBOARD_ARM9;
                    break;
                case 5:
                    val.board = MaindBoard_Type.MAINBOARD_ARM9_WIFI;
                    break;
            }
            val.logictype = Reader_Type.valueOf((int) data[2]);
        }
        return ERR;
    }

    public void CloseReader() {
        this.japi.CloseReader(this.hReader[0]);
        this.hReader[0] = 0;
    }

    public READER_ERR GetTagData(int ant, char bank, int address, int blkcnt, byte[] data, byte[] accesspasswd, short timeout) {
        return READER_ERR.valueOf(this.japi.GetTagData(this.hReader[0], ant, bank, address, blkcnt, data, accesspasswd, timeout));
    }

    public READER_ERR WriteTagData(int ant, char bank, int address, byte[] data, int datalen, byte[] accesspasswd, short timeout) {
        return READER_ERR.valueOf(this.japi.WriteTagData(this.hReader[0], ant, bank, address, data, datalen, accesspasswd, timeout));
    }

    public READER_ERR WriteTagEpcEx(int ant, byte[] Epc, int epclen, byte[] accesspwd, short timeout) {
        return READER_ERR.valueOf(this.japi.WriteTagEpcEx(this.hReader[0], ant, Epc, epclen, accesspwd, timeout));
    }

    public READER_ERR TagInventory(int[] ants, int antcnt, short timeout, TAGINFO[] pTInfo, int[] tagcnt) {
        READER_ERR ERR = READER_ERR.valueOf(this.japi.TagInventory_Raw(this.hReader[0], ants, antcnt, timeout, tagcnt));
        if (ERR == READER_ERR.MT_OK_ERR) {
            for (int i = 0; i < tagcnt[0]; i++) {
                TAGINFO pTInfoa = new TAGINFO();
                if (GetNextTag(pTInfoa) == READER_ERR.MT_OK_ERR) {
                    pTInfo[i] = pTInfoa;
                }
            }
        }
        return ERR;
    }

    public READER_ERR TagInventory_Raw(int[] ants, int antcnt, short timeout, int[] tagcnt) {
        return READER_ERR.valueOf(this.japi.TagInventory_Raw(this.hReader[0], ants, antcnt, timeout, tagcnt));
    }

    public READER_ERR TagInventory_BaseType(int[] ants, int antcnt, short timeout, char[] outbuf, int[] tagcnt) {
        return READER_ERR.valueOf(this.japi.TagInventory_BaseType(this.hReader[0], ants, antcnt, timeout, outbuf, tagcnt));
    }

    public READER_ERR GetNextTag(TAGINFO TI) {
        byte[] tagbuf = new byte[230];
        READER_ERR ERR = READER_ERR.valueOf(this.japi.GetNextTag_BaseType(this.hReader[0], tagbuf));
        if (ERR == READER_ERR.MT_OK_ERR) {
            int pos = 0 + 1;
            TI.ReadCnt = tagbuf[0];
            int pos2 = pos + 1;
            TI.RSSI = tagbuf[pos];
            int pos3 = pos2 + 1;
            TI.AntennaID = tagbuf[pos2];
            TI.Frequency = ((tagbuf[pos3] & 255) << 24) | ((tagbuf[4] & 255) << 16) | ((tagbuf[5] & 255) << 8) | (tagbuf[6] & 255);
            int pos4 = pos3 + 4;
            TI.TimeStamp = (tagbuf[pos4] << 24) | (tagbuf[8] << 16) | (tagbuf[9] << 8) | tagbuf[10];
            int pos5 = pos4 + 4;
            int pos6 = pos5 + 1;
            TI.Res[0] = tagbuf[pos5];
            int pos7 = pos6 + 1;
            TI.Res[1] = tagbuf[pos6];
            int epclen = (tagbuf[pos7] << 8) | tagbuf[14];
            int pos8 = pos7 + 2;
            int pos9 = pos8 + 1;
            TI.PC[0] = tagbuf[pos8];
            TI.PC[1] = tagbuf[pos9];
            TI.EpcId = new byte[epclen];
            TI.Epclen = (short) epclen;
            System.arraycopy(tagbuf, pos9 + 1, TI.EpcId, 0, epclen);
            int pos10 = epclen + 17;
            int pos11 = pos10 + 1;
            TI.CRC[0] = tagbuf[pos10];
            int pos12 = pos11 + 1;
            TI.CRC[1] = tagbuf[pos11];
            int emddatalen = (tagbuf[pos12] << 8) | tagbuf[pos12 + 1];
            int pos13 = pos12 + 2;
            TI.EmbededData = new byte[emddatalen];
            TI.EmbededDatalen = (short) emddatalen;
            if (emddatalen > 0) {
                System.arraycopy(tagbuf, pos13, TI.EmbededData, 0, emddatalen);
            }
        }
        return ERR;
    }

    public READER_ERR GetNextTag_BaseType(byte[] outbuf) {
        return READER_ERR.valueOf(this.japi.GetNextTag_BaseType(this.hReader[0], outbuf));
    }

    public READER_ERR LockTag(int ant, byte lockobjects, short locktypes, byte[] accesspasswd, short timeout) {
        return READER_ERR.valueOf(this.japi.LockTag(this.hReader[0], ant, lockobjects, locktypes, accesspasswd, timeout));
    }

    public READER_ERR KillTag(int ant, byte[] killpasswd, short timeout) {
        return READER_ERR.valueOf(this.japi.KillTag(this.hReader[0], ant, killpasswd, timeout));
    }

    public READER_ERR Lock180006BTag(int ant, int startblk, int blkcnt, short timeout) {
        return READER_ERR.valueOf(this.japi.Lock180006BTag(this.hReader[0], ant, startblk, blkcnt, timeout));
    }

    public READER_ERR BlockPermaLock(int ant, int readlock, int startblk, int blkrange, byte[] mask, byte[] pwd, short timeout) {
        return READER_ERR.valueOf(this.japi.BlockPermaLock(this.hReader[0], ant, readlock, startblk, blkrange, mask, pwd, timeout));
    }

    public READER_ERR BlockErase(int ant, int bank, int wordaddr, int wordcnt, byte[] pwd, short timeout) {
        return READER_ERR.valueOf(this.japi.BlockErase(this.hReader[0], ant, bank, wordaddr, wordcnt, pwd, timeout));
    }

    public READER_ERR EraseDataOnReader() {
        return READER_ERR.valueOf(this.japi.EraseDataOnReader(this.hReader[0]));
    }

    public READER_ERR SaveDataOnReader(int address, byte[] data, int datalen) {
        return READER_ERR.valueOf(this.japi.SaveDataOnReader(this.hReader[0], address, data, datalen));
    }

    public READER_ERR ReadDataOnReader(int address, byte[] data, int datalen) {
        return READER_ERR.valueOf(this.japi.ReadDataOnReader(this.hReader[0], address, data, datalen));
    }

    public READER_ERR CustomCmd(int ant, CustomCmdType cmdtype, Object CustomPara, Object CustomRet) {
        byte[] para = null;
        byte[] ret = null;
        switch ($SWITCH_TABLE$com$uhf$api$cls$Reader$CustomCmdType()[cmdtype.ordinal()]) {
            case 3:
                para = new byte[7];
                ret = new byte[7];
                NXPChangeEASPara CustomPara2 = (NXPChangeEASPara) CustomPara;
                System.arraycopy(CustomPara2.AccessPwd, 0, para, 0, 4);
                para[4] = (byte) CustomPara2.isSet;
                para[5] = (byte) ((CustomPara2.TimeOut & 65280) >> 8);
                para[6] = (byte) (CustomPara2.TimeOut & 255);
                break;
            case 4:
                ret = new byte[5];
                NXPEASAlarmPara CustomPara22 = (NXPEASAlarmPara) CustomPara;
                CustomPara22.MC = 11;
                para = new byte[]{CustomPara22.DR, 11, CustomPara22.TrExt, (byte) ((CustomPara22.TimeOut & 65280) >> 8), (byte) (CustomPara22.TimeOut & 255)};
                break;
            case 10:
                para = new byte[7];
                ret = new byte[7];
                ALIENHiggs3BlockReadLockPara CustomPara23 = (ALIENHiggs3BlockReadLockPara) CustomPara;
                System.arraycopy(CustomPara23.AccessPwd, 0, para, 0, 4);
                para[4] = CustomPara23.BlkBits;
                para[5] = (byte) ((CustomPara23.TimeOut & 65280) >> 8);
                para[6] = (byte) (CustomPara23.TimeOut & 255);
                break;
            case SerialPort.com12:
                IMPINJM4QtPara CustomPara24 = (IMPINJM4QtPara) CustomPara;
                para = new byte[10];
                ret = new byte[10];
                System.arraycopy(CustomPara24.AccessPwd, 0, para, 0, 4);
                para[4] = (byte) CustomPara24.CmdType;
                para[5] = (byte) CustomPara24.MemType;
                para[6] = (byte) CustomPara24.PersistType;
                para[7] = (byte) CustomPara24.RangeType;
                para[8] = (byte) ((CustomPara24.TimeOut & 65280) >> 8);
                para[9] = (byte) (CustomPara24.TimeOut & 255);
                break;
        }
        return READER_ERR.valueOf(this.japi.CustomCmd_BaseType(this.hReader[0], ant, cmdtype.value(), para, ret));
    }

    public READER_ERR CustomCmd_BaseType(int ant, int cmdtype, byte[] CustomPara, byte[] CustomRet) {
        return READER_ERR.valueOf(this.japi.CustomCmd_BaseType(this.hReader[0], ant, cmdtype, CustomPara, CustomRet));
    }

    public READER_ERR SetGPO(int gpoid, int val) {
        return READER_ERR.valueOf(this.japi.SetGPO(this.hReader[0], gpoid, val));
    }

    public READER_ERR GetGPI(int gpoid, int[] val) {
        return READER_ERR.valueOf(this.japi.GetGPI(this.hReader[0], gpoid, val));
    }

    public READER_ERR PsamTransceiver(int soltid, int coslen, byte[] cos, int[] cosresplen, byte[] cosresp, byte[] errcode, short timeout) {
        return READER_ERR.valueOf(this.japi.PsamTransceiver(this.hReader[0], soltid, coslen, cos, cosresplen, cosresp, errcode, timeout));
    }

    public READER_ERR ParamGet(Mtr_Param key, Object val) {
        int re;
        switch ($SWITCH_TABLE$com$uhf$api$cls$Reader$Mtr_Param()[key.ordinal()]) {
            case 5:
                byte[] data = new byte[81];
                re = this.japi.ParamGet(this.hReader[0], key.value(), data);
                if (re == 0) {
                    ((AntPowerConf) val).antcnt = data[0];
                    for (int i = 0; i < data[0]; i++) {
                        AntPower apcf = new AntPower();
                        apcf.antid = data[(i * 5) + 1];
                        apcf.readPower = (short) ((data[(i * 5) + 2] << 8) | (data[(i * 5) + 3] & 255));
                        apcf.writePower = (short) ((data[(i * 5) + 4] << 8) | (data[(i * 5) + 5] & 255));
                        ((AntPowerConf) val).Powers[i] = apcf;
                    }
                    break;
                }
                break;
            case 8:
                byte[] data2 = new byte[266];
                re = this.japi.ParamGet(this.hReader[0], key.value(), data2);
                if (re == 0) {
                    ((TagFilter_ST) val).bank = data2[0];
                    ((TagFilter_ST) val).startaddr = ((data2[1] & MotionEventCompat.ACTION_MASK) << 24) | (data2[2] << 16) | (data2[3] << 8) | (data2[4] & 255);
                    ((TagFilter_ST) val).flen = (data2[5] << 24) | (data2[6] << 16) | (data2[7] << 8) | (data2[8] & 255);
                    int ilen = ((TagFilter_ST) val).flen / 8;
                    if (((TagFilter_ST) val).flen % 8 != 0) {
                        ilen++;
                    }
                    System.arraycopy(data2, 9, ((TagFilter_ST) val).fdata, 0, ilen);
                    ((TagFilter_ST) val).isInvert = data2[ilen + 9];
                    break;
                }
                break;
            case 9:
                byte[] data3 = new byte[14];
                re = this.japi.ParamGet(this.hReader[0], key.value(), data3);
                if (re == 0) {
                    ((EmbededData_ST) val).bank = data3[1];
                    ((EmbededData_ST) val).startaddr = (data3[2] << 24) | (data3[3] << 16) | (data3[4] << 8) | (data3[5] & 255);
                    ((EmbededData_ST) val).bytecnt = (data3[6] << 24) | (data3[7] << 16) | (data3[8] << 8) | (data3[9] & 255);
                    if (data3[0] == 14) {
                        System.arraycopy(data3, 10, ((EmbededData_ST) val).accesspwd, 0, 4);
                        break;
                    }
                }
                break;
            case 10:
                byte[] data4 = new byte[31];
                re = this.japi.ParamGet(this.hReader[0], key.value(), data4);
                if (re == 0) {
                    ((Inv_Potls_ST) val).potlcnt = data4[0];
                    ((Inv_Potls_ST) val).potls = new Inv_Potl[data4[0]];
                    for (int i2 = 0; i2 < data4[0]; i2++) {
                        ((Inv_Potls_ST) val).potls[i2] = new Inv_Potl();
                        ((Inv_Potls_ST) val).potls[i2].potl = SL_TagProtocol.valueOf((int) data4[(i2 * 5) + 1]);
                        ((Inv_Potls_ST) val).potls[i2].weight = (data4[(i2 * 5) + 1] << 24) | (data4[(i2 * 5) + 2] << 16) | (data4[(i2 * 5) + 3] << 8) | (data4[(i2 * 5) + 4] & 255);
                    }
                    break;
                }
                break;
            case SerialPort.com11:
                byte[] data5 = new byte[17];
                re = this.japi.ParamGet(this.hReader[0], key.value(), data5);
                if (re == 0) {
                    ((ConnAnts_ST) val).antcnt = data5[0];
                    for (int i3 = 0; i3 < data5[0]; i3++) {
                        ((ConnAnts_ST) val).connectedants[i3] = data5[i3 + 1];
                    }
                    break;
                }
                break;
            case 15:
                byte[] data6 = new byte[48];
                re = this.japi.ParamGet(this.hReader[0], key.value(), data6);
                if (re == 0) {
                    ((Reader_Ip) val).ip = new byte[data6[0]];
                    ((Reader_Ip) val).mask = new byte[data6[1]];
                    ((Reader_Ip) val).gateway = new byte[data6[2]];
                    System.arraycopy(data6, 3, ((Reader_Ip) val).ip, 0, data6[0]);
                    System.arraycopy(data6, data6[0] + 3, ((Reader_Ip) val).mask, 0, data6[1]);
                    System.arraycopy(data6, data6[0] + 3 + data6[1], ((Reader_Ip) val).gateway, 0, data6[2]);
                    break;
                }
                break;
            case 16:
                int[] data7 = new int[1];
                re = this.japi.ParamGet(this.hReader[0], key.value(), data7);
                if (re == 0) {
                    ((Region_Conf[]) val)[0] = Region_Conf.valueOf(data7[0]);
                    break;
                }
                break;
            case SerialPort.com17:
                byte[] data8 = new byte[401];
                re = this.japi.ParamGet(this.hReader[0], key.value(), data8);
                if (re == 0) {
                    ((HoptableData_ST) val).lenhtb = data8[0];
                    for (int i4 = 0; i4 < data8[0]; i4++) {
                        ((HoptableData_ST) val).htb[i4] = ((data8[(i4 * 4) + 1] & MotionEventCompat.ACTION_MASK) << 24) | ((data8[(i4 * 4) + 2] & MotionEventCompat.ACTION_MASK) << 16) | ((data8[(i4 * 4) + 3] & MotionEventCompat.ACTION_MASK) << 8) | (data8[(i4 * 4) + 4] & MotionEventCompat.ACTION_MASK);
                    }
                    break;
                }
                break;
            case 32:
                int[] data9 = new int[8];
                re = this.japi.ParamGet(this.hReader[0], key.value(), data9);
                if (re == 0) {
                    ((EmbededSecureRead_ST) val).tagtype = data9[0];
                    ((EmbededSecureRead_ST) val).pwdtype = data9[1];
                    ((EmbededSecureRead_ST) val).ApIndexStartBitsInEpc = data9[2];
                    ((EmbededSecureRead_ST) val).ApIndexBitsNumInEpc = data9[3];
                    ((EmbededSecureRead_ST) val).bank = data9[4];
                    ((EmbededSecureRead_ST) val).address = data9[5];
                    ((EmbededSecureRead_ST) val).blkcnt = data9[6];
                    ((EmbededSecureRead_ST) val).accesspwd = data9[7];
                    break;
                }
                break;
            default:
                re = this.japi.ParamGet(this.hReader[0], key.value(), val);
                break;
        }
        return READER_ERR.valueOf(re);
    }

    public READER_ERR ParamSet(Mtr_Param key, Object val) {
        int re;
        switch ($SWITCH_TABLE$com$uhf$api$cls$Reader$Mtr_Param()[key.ordinal()]) {
            case 5:
                byte[] data = new byte[81];
                data[0] = (byte) ((AntPowerConf) val).antcnt;
                for (int i = 0; i < data[0]; i++) {
                    data[(i * 5) + 1] = (byte) ((AntPowerConf) val).Powers[i].antid;
                    data[(i * 5) + 2] = (byte) ((((AntPowerConf) val).Powers[i].readPower & 65280) >> 8);
                    data[(i * 5) + 3] = (byte) (((AntPowerConf) val).Powers[i].readPower & 255);
                    data[(i * 5) + 4] = (byte) ((((AntPowerConf) val).Powers[i].writePower & 65280) >> 8);
                    data[(i * 5) + 5] = (byte) (((AntPowerConf) val).Powers[i].writePower & 255);
                }
                re = this.japi.ParamSet(this.hReader[0], key.value(), data);
                break;
            case 8:
                if (((TagFilter_ST) val) == null) {
                    re = this.japi.ParamSet(this.hReader[0], key.value(), (Object) null);
                    break;
                } else {
                    byte[] data2 = new byte[266];
                    data2[0] = (byte) ((TagFilter_ST) val).bank;
                    data2[1] = (byte) ((((TagFilter_ST) val).startaddr & ViewCompat.MEASURED_STATE_MASK) >> 24);
                    data2[2] = (byte) ((((TagFilter_ST) val).startaddr & 16711680) >> 16);
                    data2[3] = (byte) ((((TagFilter_ST) val).startaddr & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8);
                    data2[4] = (byte) (((TagFilter_ST) val).startaddr & MotionEventCompat.ACTION_MASK);
                    data2[5] = (byte) ((((TagFilter_ST) val).flen & ViewCompat.MEASURED_STATE_MASK) >> 24);
                    data2[6] = (byte) ((((TagFilter_ST) val).flen & 16711680) >> 16);
                    data2[7] = (byte) ((((TagFilter_ST) val).flen & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8);
                    data2[8] = (byte) (((TagFilter_ST) val).flen & MotionEventCompat.ACTION_MASK);
                    int ilen = ((TagFilter_ST) val).flen / 8;
                    if (((TagFilter_ST) val).flen % 8 != 0) {
                        ilen++;
                    }
                    System.arraycopy(((TagFilter_ST) val).fdata, 0, data2, 9, ilen);
                    data2[ilen + 9] = (byte) ((TagFilter_ST) val).isInvert;
                    re = this.japi.ParamSet(this.hReader[0], key.value(), data2);
                    break;
                }
            case 9:
                if (((EmbededData_ST) val) == null) {
                    re = this.japi.ParamSet(this.hReader[0], key.value(), (Object) null);
                    break;
                } else {
                    byte[] data3 = new byte[14];
                    if (((EmbededData_ST) val).accesspwd == null) {
                        data3[0] = 10;
                    } else {
                        data3[0] = 14;
                    }
                    data3[1] = (byte) ((EmbededData_ST) val).bank;
                    data3[2] = (byte) ((((EmbededData_ST) val).startaddr & ViewCompat.MEASURED_STATE_MASK) >> 24);
                    data3[3] = (byte) ((((EmbededData_ST) val).startaddr & 16711680) >> 16);
                    data3[4] = (byte) ((((EmbededData_ST) val).startaddr & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8);
                    data3[5] = (byte) (((EmbededData_ST) val).startaddr & MotionEventCompat.ACTION_MASK);
                    data3[6] = (byte) ((((EmbededData_ST) val).bytecnt & ViewCompat.MEASURED_STATE_MASK) >> 24);
                    data3[7] = (byte) ((((EmbededData_ST) val).bytecnt & 16711680) >> 16);
                    data3[8] = (byte) ((((EmbededData_ST) val).bytecnt & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8);
                    data3[9] = (byte) (((EmbededData_ST) val).bytecnt & MotionEventCompat.ACTION_MASK);
                    if (((EmbededData_ST) val).accesspwd != null) {
                        System.arraycopy(((EmbededData_ST) val).accesspwd, 0, data3, 10, 4);
                    }
                    re = this.japi.ParamSet(this.hReader[0], key.value(), data3);
                    break;
                }
            case 10:
                byte[] data4 = new byte[31];
                data4[0] = (byte) ((Inv_Potls_ST) val).potlcnt;
                for (int i2 = 0; i2 < data4[0]; i2++) {
                    data4[(i2 * 5) + 1] = (byte) ((Inv_Potls_ST) val).potls[i2].potl.value();
                    data4[(i2 * 5) + 2] = (byte) ((((Inv_Potls_ST) val).potls[i2].weight & ViewCompat.MEASURED_STATE_MASK) >> 24);
                    data4[(i2 * 5) + 3] = (byte) ((((Inv_Potls_ST) val).potls[i2].weight & 16711680) >> 16);
                    data4[(i2 * 5) + 4] = (byte) ((((Inv_Potls_ST) val).potls[i2].weight & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8);
                    data4[(i2 * 5) + 5] = (byte) (((Inv_Potls_ST) val).potls[i2].weight & MotionEventCompat.ACTION_MASK);
                }
                re = this.japi.ParamSet(this.hReader[0], key.value(), data4);
                break;
            case 15:
                int ipl = ((Reader_Ip) val).ip.length;
                int ml = ((Reader_Ip) val).mask.length;
                int gl = ((Reader_Ip) val).gateway.length;
                byte[] data5 = new byte[(ipl + 3 + ml + gl)];
                data5[0] = (byte) ipl;
                data5[1] = (byte) ml;
                data5[2] = (byte) gl;
                System.arraycopy(((Reader_Ip) val).ip, 0, data5, 3, ipl);
                System.arraycopy(((Reader_Ip) val).mask, 0, data5, ipl + 3, ml);
                System.arraycopy(((Reader_Ip) val).ip, 0, data5, ipl + 3 + ml, gl);
                re = this.japi.ParamSet(this.hReader[0], key.value(), data5);
                break;
            case 16:
                re = this.japi.ParamSet(this.hReader[0], key.value(), new byte[]{(byte) ((Region_Conf) val).value()});
                break;
            case SerialPort.com17:
                byte[] data6 = new byte[((((HoptableData_ST) val).lenhtb * 4) + 1)];
                data6[0] = (byte) ((HoptableData_ST) val).lenhtb;
                for (int i3 = 0; i3 < data6[0]; i3++) {
                    data6[(i3 * 4) + 1] = (byte) ((((HoptableData_ST) val).htb[i3] & ViewCompat.MEASURED_STATE_MASK) >> 24);
                    data6[(i3 * 4) + 2] = (byte) ((((HoptableData_ST) val).htb[i3] & 16711680) >> 16);
                    data6[(i3 * 4) + 3] = (byte) ((((HoptableData_ST) val).htb[i3] & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8);
                    data6[(i3 * 4) + 4] = (byte) (((HoptableData_ST) val).htb[i3] & MotionEventCompat.ACTION_MASK);
                }
                re = this.japi.ParamSet(this.hReader[0], key.value(), data6);
                break;
            case 32:
                if (((EmbededSecureRead_ST) val) != null) {
                    re = this.japi.ParamSet(this.hReader[0], key.value(), new int[]{((EmbededSecureRead_ST) val).tagtype, ((EmbededSecureRead_ST) val).pwdtype, ((EmbededSecureRead_ST) val).ApIndexStartBitsInEpc, ((EmbededSecureRead_ST) val).ApIndexBitsNumInEpc, ((EmbededSecureRead_ST) val).bank, ((EmbededSecureRead_ST) val).address, ((EmbededSecureRead_ST) val).blkcnt, ((EmbededSecureRead_ST) val).accesspwd});
                    break;
                } else {
                    re = this.japi.ParamSet(this.hReader[0], key.value(), (Object) null);
                    break;
                }
            default:
                re = this.japi.ParamSet(this.hReader[0], key.value(), val);
                break;
        }
        return READER_ERR.valueOf(re);
    }

    public static String bytes_Hexstr(byte[] bArray) {
        StringBuffer sb = new StringBuffer(bArray.length);
        for (byte b : bArray) {
            String sTemp = Integer.toHexString(b & 255);
            if (sTemp.length() < 2) {
                sb.append(0);
            }
            sb.append(sTemp.toUpperCase());
        }
        return sb.toString();
    }

    public void Str2Hex(String buf, int len, byte[] hexbuf) {
        if (len % 2 == 0) {
            for (int i = 0; i < len; i += 2) {
                hexbuf[i / 2] = (byte) (((((byte) "0123456789ABCDEF".indexOf(buf.toUpperCase().substring(i, i + 1))) << 4) & 255) | (((byte) "0123456789ABCDEF".indexOf(buf.toUpperCase().substring(i + 1, i + 2))) & 255));
            }
        }
    }

    public void Str2Binary(String buf, int len, byte[] binarybuf) {
        if (len % 8 == 0) {
            for (int i = 0; i < len; i += 8) {
                byte temp = 0;
                for (int j = 0; j < 8; j++) {
                    temp = (byte) (((byte) (Byte.parseByte(buf.substring(i + j, (i + j) + 1)) << (7 - j))) | temp);
                }
                int i2 = i / 8;
                binarybuf[i2] = (byte) (binarybuf[i2] | temp);
            }
        }
    }

    public READER_ERR AsyncStartReading(int[] ants, int antcnt, int option) {
        return READER_ERR.valueOf(this.japi.AsyncStartReading(this.hReader[0], ants, antcnt, option));
    }

    public READER_ERR AsyncStopReading() {
        return READER_ERR.valueOf(this.japi.AsyncStopReading(this.hReader[0]));
    }

    public READER_ERR AsyncGetTagCount(int[] tagcnt) {
        return READER_ERR.valueOf(this.japi.AsyncGetTagCount(this.hReader[0], tagcnt));
    }

    public READER_ERR AsyncGetNextTag(TAGINFO pTInfo) {
        TAGINFO[] temp = new TAGINFO[1];
        int re = this.japi.AsyncGetNextTag(this.hReader[0], temp);
        if (re == 0) {
            pTInfo.AntennaID = temp[0].AntennaID;
            pTInfo.CRC = temp[0].CRC;
            pTInfo.EmbededData = temp[0].EmbededData;
            pTInfo.EmbededDatalen = temp[0].EmbededDatalen;
            pTInfo.EpcId = temp[0].EpcId;
            pTInfo.Epclen = temp[0].Epclen;
            pTInfo.Frequency = temp[0].Frequency;
            pTInfo.PC = temp[0].PC;
            pTInfo.Phase = temp[0].Phase;
            pTInfo.protocol = temp[0].protocol;
            pTInfo.ReadCnt = temp[0].ReadCnt;
            pTInfo.Res = temp[0].Res;
            pTInfo.RSSI = (byte) temp[0].RSSI;
            pTInfo.TimeStamp = temp[0].TimeStamp;
        }
        return READER_ERR.valueOf(re);
    }
}
