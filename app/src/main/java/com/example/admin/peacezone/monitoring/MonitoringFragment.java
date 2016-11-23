package com.example.admin.peacezone.monitoring;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.admin.peacezone.R;
import com.example.admin.peacezone.myFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by admin on 2016/8/24.
 */
public class MonitoringFragment extends myFragment {


    @Bind(R.id.monitoring_listview)
    ListView monitoringListview;

    @Override
    public int setLayout() {
        return R.layout.monitoring;
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
