package com.example.admin.peacezone.utils;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2016/9/19.
 */
public class Manager {
     static Context mC;
    List<String> list;

    public Manager(Context mC) {
        this.mC = mC;
        list = new ArrayList<>();
    }
    private static Manager sn = null;

    public static Manager getSN() {
        if(sn == null){
            sn = new Manager(mC);
        }
        return sn;
    }
    public static void GetMsg(String str){
        if(getdate!=null){
            getdate.getResult(str);
        }
    }

    public static getDate getdate;

    public getDate getGd() {
        return getdate;
    }

    public void setGd(getDate getdate) {
        this.getdate = getdate;
    }

    public  interface getDate{
        void getResult(String str);
    }
}
