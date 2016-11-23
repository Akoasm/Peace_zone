package com.example.admin.peacezone.addressbook;


import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.peacezone.R;

import com.example.admin.peacezone.addressbook.view.Address_SlideView;
import com.example.admin.peacezone.addressbook.view.CircleTextView;
import com.example.admin.peacezone.myFragment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import com.github.promeg.pinyinhelper.Pinyin;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by admin on 2016/8/24.
 */
public class AddressBookFragment extends myFragment implements Address_SlideView.onTouchListener, AddressAdapter.onItemClickListener {

        private Address_SlideView mySlideView;
        private RecyclerView rvStickyExample;
        private TextView tvStickyHeaderView;
        private CircleTextView myCircleView;

    private List<AddressInfo> addresslist = new ArrayList<>();
    private Set<String> firstPinYin = new LinkedHashSet<>();
    public static List<String> pinyinList = new ArrayList<>();
    private PinyinComparator pinyinComparator;

    private AddressAdapter adapter;
    private LinearLayoutManager layoutManager;
    @Override
    public int setLayout() {
        return R.layout.address_scoll_view;
    }

    @Override
    public void getview() {
        mySlideView  = (Address_SlideView) view.findViewById(R.id.my_slide_view);
        rvStickyExample = (RecyclerView) view.findViewById(R.id.rv_sticky_example);
        tvStickyHeaderView = (TextView) view.findViewById(R.id.tv_sticky_header_view);
        myCircleView = (CircleTextView) view.findViewById(R.id.my_circle_view);

        addresslist.clear();
        firstPinYin.clear();
        pinyinList.clear();

        pinyinComparator = new PinyinComparator();
        for(int i = 0;i<AddressInfo.linkman.length;i++){
            AddressInfo addressInfo = new AddressInfo();
            addressInfo.setName(AddressInfo.linkman[i]);
            addressInfo.setNamePinyin(transformPinYin(AddressInfo.linkman[i]));
            addresslist.add(addressInfo);
        }
        Collections.sort(addresslist, pinyinComparator);
        for (AddressInfo addressinfo: addresslist) {
            pinyinList.add(addressinfo.getNamePinyin().substring(0,1));
        }
        for (String string:firstPinYin) {
            pinyinList.add(string);
        }
        mySlideView = new Address_SlideView(getActivity());
        mySlideView.setListener(this);
        layoutManager = new LinearLayoutManager(getActivity());
        rvStickyExample.setLayoutManager(layoutManager);
        adapter = new AddressAdapter(getActivity().getApplicationContext(),addresslist);
        adapter.setListener(this);
        rvStickyExample.setAdapter(adapter);
        rvStickyExample.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);


                View stickyInfoView = rvStickyExample.findChildViewUnder(tvStickyHeaderView.getMeasuredWidth() / 2, 5);
                if (stickyInfoView != null && stickyInfoView.getContentDescription() != null) {
                    tvStickyHeaderView.setText(String.valueOf(stickyInfoView.getContentDescription()));

                }

                View tranInfoView = recyclerView.findChildViewUnder(tvStickyHeaderView.getMeasuredWidth() / 2, tvStickyHeaderView.getMeasuredHeight() + 1);
                if (tranInfoView != null && tranInfoView.getTag() != null) {
                    int transViewStatus = (int) tranInfoView.getTag();
                    int dealtY = tranInfoView.getTop() - tvStickyHeaderView.getMeasuredHeight();
                    if (transViewStatus == AddressAdapter.HAS_STICKY_VIEW) {
                        if (tranInfoView.getTop() > 0) {
                            tvStickyHeaderView.setTranslationY(dealtY);
                        } else {
                            tvStickyHeaderView.setTranslationY(0);
                        }
                    } else if (transViewStatus == AddressAdapter.NONE_STICKY_VIEW) {
                        tvStickyHeaderView.setTranslationY(0);
                    }
                }
            }
        });

    }

    @Override
    public void setListener() {

    }

    @Override
    public void setView() {

    }
    @Override
    public void itemClick(int position) {
        Intent intent  = new Intent(getActivity(),AddressItemActivity.class);
        startActivity(intent);
    }
    public String transformPinYin(String character) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < character.length(); i++) {
            buffer.append(Pinyin.toPinyin(character.charAt(i)));
        }
        return buffer.toString();
    }

    @Override
    public void showTextView(String textView, boolean dismiss) {
        if(dismiss){
            myCircleView.setVisibility(View.GONE);
        }else{
            myCircleView.setVisibility(View.VISIBLE);
            myCircleView.setText(textView);
        }
        int selectPosition = 0;
        for (int i = 0 ;i < addresslist.size();i++){
            if(addresslist.get(i).getFirstPinyin().equals(textView)){
                selectPosition = i;
                break;
            }
        }
        rvStickyExample.scrollToPosition(selectPosition);
        scroll2Position(selectPosition);
    }
    public class PinyinComparator implements Comparator<AddressInfo> {

        @Override
        public int compare(AddressInfo addressInfo, AddressInfo t1) {
            return addressInfo.getNamePinyin().compareTo(t1.getNamePinyin());
        }
    }

    private void scroll2Position(int index) {
        int firstPosition = layoutManager.findFirstVisibleItemPosition();
        int lastPosition = layoutManager.findLastVisibleItemPosition();
        if (index <= firstPosition) {
            rvStickyExample.scrollToPosition(index);
        } else if (index <= lastPosition) {
            int top = rvStickyExample.getChildAt(index - firstPosition).getTop();
            rvStickyExample.scrollBy(0, top);
        } else {
            rvStickyExample.scrollToPosition(index);
        }
    }
}
