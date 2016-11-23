package com.example.admin.peacezone;

/**
 * Created by admin on 2016/9/8.
 */
public class JniTest {
    public native int CreateServer(int bindPort,int MaxConnectCount);
    public native char CreateClient(String svrIp,int svrPort);
    public native void OnDataRecvCallFunc(char dataBuf, int dataSize, long srcIP,  int srcPort, char dataType, String sender, String  handle);
//    public native boolean SetCallFunc(String  netHandle,String userData,OnDataRecvCallFunc callFunc);

    public native boolean SendData(String netHandle,String data, int dataSize);
    public native void FreeNet(String netHandle);


    static {
        System.loadLibrary("JniTest");
    }
}
