package com.example.admin.peacezone.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.peacezone.R;
import com.example.admin.peacezone.entity.SettingEntity;

import java.util.List;

/**
 * Created by admin on 2016/8/29.
 */
public class SettingAdapter extends BaseAdapter {
    private List<SettingEntity> list;
    private Context mC;

    public SettingAdapter(List<SettingEntity> list, Context mC) {
        this.list = list;
        this.mC = mC;
    }

    public List<SettingEntity> getList() {
        return list;
    }

    public void setList(List<SettingEntity> list) {
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
            view = LayoutInflater.from(mC).inflate(R.layout.setting_item,null);
            viewHolder.update_tv = (TextView) view.findViewById(R.id.setting_item_name);
            viewHolder.arrow_img = (ImageView) view.findViewById(R.id.setting_item_img);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
            viewHolder.arrow_img.setBackgroundResource(R.mipmap.ic_arrow);
            viewHolder.update_tv.setText(list.get(i).getUpdate());


        return view;
    }
    class ViewHolder{
        TextView update_tv;
        ImageView arrow_img;

    }
}
