package com.example.admin.peacezone.addressbook;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.example.admin.peacezone.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2016/8/30.
 */
public class AddressAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{


    public static final int FIRST_STICKY_VIEW = 1;
    public static final int HAS_STICKY_VIEW = 2;
    public static final int NONE_STICKY_VIEW = 3;

    private Context context;
    private List<AddressInfo> list = new ArrayList<AddressInfo>();
    private onItemClickListener listener;
    public AddressAdapter(Context context, List<AddressInfo> list) {
        this.context = context;
        this.list = list;
    }


    public interface  onItemClickListener{
        void itemClick(int position);
    }

    public void setListener(onItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_list_item,parent,false);
        return new LinkManViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {


        if(holder instanceof LinkManViewHolder){
            LinkManViewHolder viewHolder = (LinkManViewHolder) holder;
            AddressInfo addressInfo = list.get(position);
            viewHolder.tvName.setText(addressInfo.getName());

            viewHolder.rlContentWrapper.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.itemClick(position);
                }
            });

            if(position == 0){
                viewHolder.tvStickyHeader.setVisibility(View.VISIBLE);
                viewHolder.tvStickyHeader.setText(addressInfo.getFirstPinyin());
                viewHolder.itemView.setTag(FIRST_STICKY_VIEW);
            }else{
                if(!TextUtils.equals(addressInfo.getFirstPinyin(),list.get(position - 1).getFirstPinyin())){
                    viewHolder.tvStickyHeader.setVisibility(View.VISIBLE);
                    viewHolder.tvStickyHeader.setText(addressInfo.getFirstPinyin());
                    viewHolder.itemView.setTag(HAS_STICKY_VIEW);
                }else{
                    viewHolder.tvStickyHeader.setVisibility(View.GONE);
                    viewHolder.itemView.setTag(NONE_STICKY_VIEW);
                }
            }
            viewHolder.itemView.setContentDescription(addressInfo.getFirstPinyin());
        }
    }

    @Override
    public int getItemCount() {
        return list.size() == 0 ? 0 :list.size();
    }

    public class LinkManViewHolder extends  RecyclerView.ViewHolder {

        TextView tvStickyHeader,tvName;
        RelativeLayout rlContentWrapper;


        public LinkManViewHolder(View itemView) {
            super(itemView);
            tvStickyHeader = (TextView) itemView.findViewById(R.id.tv_sticky_header_view);
            rlContentWrapper = (RelativeLayout) itemView.findViewById(R.id.rl_content_wrapper);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
        }
    }
}
