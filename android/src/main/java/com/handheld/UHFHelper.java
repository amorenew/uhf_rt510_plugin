package com.handheld;

import android.content.Context;

import com.handheld.UHFLonger.UHFLongerManager;
import com.handheld.UHFLongerDemo.EPC;
import com.handheld.UHFLongerDemo.MyApplication;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class UHFHelper {
    //private Context context;
    private static UHFHelper instance;
    private UHFLongerManager manager;
    private MyApplication myApp;
    private boolean runFlag = true;
    private boolean startFlag = false;
    private ArrayList<EPC> listEPC;
    private UHFListener uhfListener;
    private int signalPowerLevel = 30;//30 to 90
    private boolean connectFlag = false;

    private UHFHelper() {

    }

    public static UHFHelper getInstance() {
        if (instance == null)
            instance = new UHFHelper();
        return instance;
    }

    public void init(Context context, UHFListener uhfListener) {
        // this.context = context;
        this.uhfListener = uhfListener;
        this.myApp = new MyApplication();
        MyApplication.myapp = this.myApp;
        this.listEPC = new ArrayList<>();
        this.myApp.setListEpc(new ArrayList<String>());
        //Util.initSoundPool(context);
        new InventoryThread().start();
    }

    public boolean isStarted() {
        return startFlag;
    }

    public void start() {
        this.startFlag = true;
    }

    public void stop() {
        this.startFlag = false;
    }

    public void clearData() {
        if (manager != null)
            manager.clearSelect();

        this.listEPC.clear();
        this.myApp.getListEpc().clear();

    }

    public boolean isEmptyTags() {
        return this.myApp.getListEpc() == null || this.myApp.getListEpc().isEmpty();
    }

    public void close() {
        stop();
        runFlag = false;
        if (manager != null) {
            manager.close();
            manager = null;
        }
    }

    public void connect() {
        try {
            manager = UHFLongerManager.getInstance();
            new Timer().schedule(new TimerTask() {
                public void run() {
                    if (manager != null && manager.setOutPower((short) signalPowerLevel)) {
                        connectFlag = true;
                        myApp.setmanager(manager);
                        uhfListener.onConnect(true, signalPowerLevel);
                    } else {
                        connectFlag = false;
                        uhfListener.onConnect(false, -1);
                    }
                }
            }, 100);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isConnected() {
        return connectFlag && manager != null;
    }


    class InventoryThread extends Thread {

        InventoryThread() {
        }

        public void run() {
            super.run();
            while (runFlag) {
                if (startFlag) {
                    List<String> epcList = null;
                    if (manager != null)
                        epcList = manager.inventoryRealTime();
                    if (epcList != null && !epcList.isEmpty()) {
                        //Util.play(1, 0);
                        for (String epc : epcList) {
                            addToList(listEPC, epc);
                        }
                    }
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    private void addToList(final List<EPC> list, final String epc) {
        if (!list.isEmpty()) {
            int i = 0;
            while (true) {
                if (i >= list.size()) {
                    break;
                }
                EPC mEPC = (EPC) list.get(i);
                if (epc.equals(mEPC.getEpc())) {
                    mEPC.setCount(mEPC.getCount() + 1);
                    list.set(i, mEPC);
                    break;
                }
                if (i == list.size() - 1) {
                    EPC newEPC = new EPC();
                    newEPC.setEpc(epc);
                    newEPC.setCount(1);
                    list.add(newEPC);
                    myApp.addEPC(epc);
                }
                i++;
            }
        } else {
            EPC epcTag = new EPC();
            epcTag.setEpc(epc);
            epcTag.setCount(1);
            list.add(epcTag);
            myApp.addEPC(epc);
        }
        ArrayList<Map<String, Object>> listMap = new ArrayList<>();
        int idcount = 1;

        final JSONArray jsonArray = new JSONArray();

        for (EPC epcdata : list) {
            Map<String, Object> map = new HashMap<>();
            map.put(TagKey.ID, idcount);
            map.put(TagKey.EPC, epcdata.getEpc());
            map.put(TagKey.COUNT, epcdata.getCount());
            JSONObject json = new JSONObject();
            try {
                json.put(TagKey.ID, idcount);
                json.put(TagKey.EPC, epcdata.getEpc());
                json.put(TagKey.COUNT, epcdata.getCount());
                jsonArray.put(json);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            idcount++;
            listMap.add(map);
        }


        uhfListener.onRead(jsonArray.toString());

    }


}
