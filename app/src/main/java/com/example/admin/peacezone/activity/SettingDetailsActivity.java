package com.example.admin.peacezone.activity;

import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.peacezone.base.BaseActivity;
import com.example.admin.peacezone.R;

/**
 * Created by admin on 2016/8/26.
 */
public class SettingDetailsActivity extends BaseActivity {


    ImageView setting_details_return,setting_details_submit;
    TextView setting_details_title,setting_details_currentphone,setting_details_currentNumber;
    EditText setting_details_newphone;
    Toolbar setting_details_toolbar;



    @Override
    public void setLayout() {
        setContentView(R.layout.setting_details);

    }

    @Override
    public void setView() {
       setting_details_return = (ImageView) findViewById(R.id.setting_details_return);
    }

    @Override
    public void getdata() {

    }


}
