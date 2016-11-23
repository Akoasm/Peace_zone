package com.example.admin.peacezone.setting;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.peacezone.BaseActivity;
import com.example.admin.peacezone.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by admin on 2016/8/26.
 */
public class SettingDetailsActivity extends BaseActivity {


    @Bind(R.id.setting_details_return)
    ImageView settingDetailsReturn;
    @Bind(R.id.setting_details_title)
    TextView settingDetailsTitle;
    @Bind(R.id.setting_details_toolbar)
    Toolbar settingDetailsToolbar;
    @Bind(R.id.setting_details_submit)
    ImageView settingDetailsSubmit;
    @Bind(R.id.setting_details_currentPhone)
    TextView settingDetailsCurrentPhone;
    @Bind(R.id.setting_details_currentNumber)
    TextView settingDetailsCurrentNumber;
    @Bind(R.id.setting_details_newPhone)
    EditText settingDetailsNewPhone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }


    @Override
    public void setLayout() {
        setContentView(R.layout.setting_details);

    }

    @Override
    public void setView() {
        
    }

    @Override
    public void getdata() {

    }


}
