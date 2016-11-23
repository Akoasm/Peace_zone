package com.example.admin.peacezone.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by admin on 2016/9/18.
 */
public class SpfManager {
    Context mC;
    public static SpfManager spfManager;

    private SpfManager(Context mC) {
        this.mC = mC;
    }

    public void LoginIsfirst(){
        SharedPreferences sharedPreferences = mC.getSharedPreferences("first",Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = sharedPreferences.edit();
        ed.putString("isFirst","yes");
        ed.commit();
    }
    public String getIsFirst(){
        SharedPreferences sharedPreferences = mC.getSharedPreferences("first",Context.MODE_PRIVATE);
        return sharedPreferences.getString("isFirst","no");
    }


}
