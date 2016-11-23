package com.example.admin.peacezone.login;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;


import com.example.admin.peacezone.JniTest;
import com.example.admin.peacezone.R;

/**
 * Created by admin on 2016/9/8.
 */
public class LoginActivity extends Activity {


    String ip = "10.89.12.161";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        JniTest jniTest = new JniTest();
        jniTest.CreateClient(ip, 10000);
//        jniTest.OnDataRecvCallFunc();
//        jniTest.SendData();
//        jniTest.FreeNet();
    }
    private onRecvCall recvCall;

    private interface  onRecvCall{
        void OnDataRecvCallFunc(char  dataBuf,  int dataSize, long srcIP, int srcPort, char dataType, String sender, String handle);
    }

    public LoginActivity(onRecvCall recvCall) {
        this.recvCall = recvCall;
    }
}
