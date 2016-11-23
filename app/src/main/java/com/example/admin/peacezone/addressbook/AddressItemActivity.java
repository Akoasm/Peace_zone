package com.example.admin.peacezone.addressbook;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.peacezone.BaseActivity;
import com.example.admin.peacezone.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by admin on 2016/9/1.
 */
public class AddressItemActivity extends BaseActivity implements View.OnClickListener{

    Button callphone,sendmessage,savetolocal;
    ImageView toolbarReturn;
    TextView toolbarTitle,addressDetailName,addressDetailPhone,addressDetailPhonenumber,addressDetailGroup,addressDetailAddress;
    List<AddressItemEntity> list;


    @Override
    public void setLayout() {
        setContentView(R.layout.addressbook_detail);
    }


    @Override
    public void setView() {
        callphone = (Button) findViewById(R.id.callphone);
        sendmessage = (Button) findViewById(R.id.sendmessage);
        savetolocal = (Button) findViewById(R.id.savetolocal);
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
            case R.id.sendmessage:
                Intent i = new Intent();
                break;
            case R.id.callphone:
                Intent intent = new Intent();
                intent.setAction(intent.ACTION_CALL);
                intent.setData(Uri.parse(""));
                startActivity(intent);
                break;
            case R.id.savetolocal:

                break;

        }
    }
}
