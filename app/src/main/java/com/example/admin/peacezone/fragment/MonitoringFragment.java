package com.example.admin.peacezone.fragment;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.admin.peacezone.R;
import com.example.admin.peacezone.adapter.MonitoringAdapter;
import com.example.admin.peacezone.base.myFragment;
import com.example.admin.peacezone.entity.MonitoringEntity;
import com.example.admin.peacezone.utils.Manager;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;


/**
 * Created by admin on 2016/8/24.
 */
public class MonitoringFragment extends myFragment {


    ListView monitoringListview;
    private MonitoringAdapter adapter;
    List<MonitoringEntity> list;

    @Override
    public int setLayout() {
        return R.layout.monitoring;
    }

    @Override
    public void getview() {
        monitoringListview = (ListView) view.findViewById(R.id.monitoring_listview);
    }

    @Override
    public void setListener() {

        monitoringListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(getActivity(),"点击",Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public void setView() {

    }


}
