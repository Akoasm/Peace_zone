package com.example.admin.peacezone.activity;



import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.peacezone.base.BaseActivity;
import com.example.admin.peacezone.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by admin on 2016/9/8.
 */
public class LoginActivity extends BaseActivity {

    Button loginBtn;

    @Bind(R.id.logintitle)
    TextView logintitle;
    @Bind(R.id.login_user_img)
    ImageView loginUserImg;
    @Bind(R.id.login_user_ip)
    EditText loginUserIp;
    @Bind(R.id.login_port_img)
    ImageView loginPortImg;
    @Bind(R.id.login_user_port)
    EditText loginUserPort;



    @Override
    public void setLayout() {
        setContentView(R.layout.login);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public void setView() {
        loginBtn = (Button) findViewById(R.id.login_btn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(HomeActivity.class,R.anim.alpha_in,R.anim.alpha_out);
            finish();
        }
    });

    }

    @Override
    public void getdata() {

    }



}
