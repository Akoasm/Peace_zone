package com.example.admin.peacezone.setting;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.admin.peacezone.R;
import com.example.admin.peacezone.myFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by admin on 2016/8/24.
 */
public class SettingFragment extends myFragment {


    @Bind(R.id.setting_portrait)
    ImageView settingPortrait;
    @Bind(R.id.setting_name)
    TextView settingName;
    @Bind(R.id.setting_phone)
    TextView settingPhone;
    @Bind(R.id.setting_updatePhone)
    ListView settingUpdatePhone;

    @Override
    public int setLayout() {
        return R.layout.setting;
    }

    @Override
    public void getview() {

    }

    @Override
    public void setListener() {

    }

    @Override
    public void setView() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
