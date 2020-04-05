package com.handheld;

import java.util.ArrayList;
import java.util.Map;

public interface  UHFListener {
    void onRead(ArrayList<Map<String, Object>> tagsList);
    void onConnect(boolean isConnected,int powerLevel);

}
