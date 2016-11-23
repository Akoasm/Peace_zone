package com.example.admin.peacezone.activity;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.admin.peacezone.entity.AddressItemEntity;
import com.example.admin.peacezone.base.BaseActivity;
import com.example.admin.peacezone.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2016/9/1.
 */
public class AddressDetailsActivity extends BaseActivity implements View.OnClickListener{

    RelativeLayout sendmessage,callphone,savetolocal;
    ImageView toolbarReturn;
    TextView toolbarTitle,addressDetailName,addressDetailPhone,addressDetailPhonenumber,addressDetailGroup,addressDetailAddress;
    List<AddressItemEntity> list;


    @Override
    public void setLayout() {
        setContentView(R.layout.addressbook_detail);
    }


    @Override
    public void setView() {
        sendmessage = (RelativeLayout) findViewById(R.id.sendmessage_relative);
        callphone = (RelativeLayout) findViewById(R.id.callphone_relative);
        savetolocal = (RelativeLayout) findViewById(R.id.save_relative);

        toolbarTitle = (TextView) findViewById(R.id.toolbar_title);
        addressDetailName = (TextView) findViewById(R.id.address_detail_name);
        addressDetailPhone = (TextView) findViewById(R.id.address_detail_phone);
        addressDetailPhonenumber = (TextView) findViewById(R.id.address_detail_phonenumber);
        addressDetailGroup = (TextView) findViewById(R.id.address_detail_group);
        addressDetailAddress = (TextView) findViewById(R.id.address_detail_address );
        toolbarReturn = (ImageView) findViewById(R.id.toolbar_return);

        list = new ArrayList<>();
            toolbarTitle.setText("联系人详情");
            callphone.setOnClickListener(this);
    }

    @Override
    public void getdata() {
        list = new ArrayList<>();


    }



    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.sendmessage_relative:
                Intent i = new Intent();
                break;
            case R.id.callphone_relative:
                Intent intent = new Intent();
                intent.setAction(intent.ACTION_CALL);
                intent.setData(Uri.parse("17760553329"));
                startActivity(intent);
                break;
            case R.id.save_relative:

                break;

        }
    }
}
