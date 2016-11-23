package com.example.admin.peacezone.fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.admin.peacezone.R;
import com.example.admin.peacezone.adapter.SettingAdapter;
import com.example.admin.peacezone.base.myFragment;
import com.example.admin.peacezone.entity.SettingEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2016/8/24.
 */
public class SettingFragment extends myFragment {

    ImageView settingProtrait;
    TextView settingName,settingPhone;
    ListView listView;
    SettingAdapter adapter;
    List<SettingEntity> list;
    @Override
    public int setLayout() {
        return R.layout.setting;
    }

    @Override
    public void getview() {
        settingProtrait = (ImageView) view.findViewById(R.id.setting_portrait);
        settingName = (TextView) view.findViewById(R.id.setting_name);
        settingPhone = (TextView) view.findViewById(R.id.setting_phone);
        listView = (ListView) view.findViewById(R.id.setting_updatePhone);
    }

    @Override
    public void setListener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }

    @Override
    public void setView() {
        list = new ArrayList<>();
        adapter = new SettingAdapter(list,getActivity());
        listView.setAdapter(adapter);
    }
}
