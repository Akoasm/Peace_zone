package com.example.admin.peacezone.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.admin.peacezone.R;
import com.example.admin.peacezone.entity.MonitoringEntity;

import java.util.List;

/**
 * Created by admin on 2016/8/25.
 */
public class MonitoringAdapter extends BaseAdapter {
    private List<MonitoringEntity> list;
    private Context mC;

    public MonitoringAdapter(List<MonitoringEntity> list, Context mC) {
        this.list = list;
        this.mC = mC;
    }

    public List<MonitoringEntity> getList() {
        return list;
    }

    public void setList(List<MonitoringEntity> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if(view == null){
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(mC).inflate(R.layout.homebutton_item,null);
            viewHolder.location = (TextView) view.findViewById(R.id.monitoring_item_name);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.location.setText(list.get(i).getLocation());
        return view;
    }
    class ViewHolder{
        TextView location;
    }
}
