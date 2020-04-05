package com.uhf.api.cls;

public class TAGINFO implements Cloneable {
    public byte AntennaID;
    public byte[] CRC = new byte[2];
    public byte[] EmbededData = new byte[128];
    public short EmbededDatalen;
    public byte[] EpcId = new byte[62];
    public short Epclen;
    public int Frequency;
    public byte[] PC = new byte[2];
    public int Phase;
    public int RSSI;
    public int ReadCnt;
    public byte[] Res = new byte[2];
    public int TimeStamp;
    public Reader.SL_TagProtocol protocol;

    public TAGINFO() {
    }

    public Object clone() {
        try {
            return (TAGINFO) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
