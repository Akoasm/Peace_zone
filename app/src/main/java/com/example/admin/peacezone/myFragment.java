package com.example.admin.peacezone;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by adming on 2016/8/29.
 */
public abstract class myFragment extends Fragment{
    public View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(setLayout(),null);
        getview();
        setView();
        setListener();
        return view;
    }
    public abstract int setLayout();
    public abstract void getview();
    public abstract void setListener();
    public abstract void setView();
}
