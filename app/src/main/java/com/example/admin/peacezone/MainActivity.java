//package com.example.admin.peacezone;
//
//
//
//import android.graphics.Color;
//import android.support.v4.app.FragmentManager;
//import android.support.v4.app.FragmentTransaction;
//import android.support.v7.widget.Toolbar;
//import android.view.View;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//
//import com.example.admin.peacezone.addressbook.AddressBookFragment;
//import com.example.admin.peacezone.monitoring.MonitoringFragment;
//import com.example.admin.peacezone.setting.SettingFragment;
//import com.example.admin.peacezone.warning.WarningFragment;
//
//
//
//public class MainActivity extends BaseActivity implements View.OnClickListener {
//
//
//    FragmentManager fm;
//    FragmentTransaction ft;
//    ImageView homeWarningImg,homeAddressImg,homeMonitoringImg,homeSettingImg;
//    Toolbar toolbar;
//    AddressBookFragment addressBookFragment;
//    WarningFragment warningFragment;
//    SettingFragment settingFragment;
//    MonitoringFragment monitoringFragment;
//
//    int[]select_img = {R.mipmap.warning_select,R.mipmap.address_select,R.mipmap.monitoring_select,R.mipmap.setting_select};
//    int[]default_img = {R.mipmap.warning_default,R.mipmap.address_default,R.mipmap.monitoring_default,R.mipmap.setting_default};
//    int position;
//    ImageView[] home_img = new ImageView[4];
//    @Override
//    public void setLayout() {
//        setContentView(R.layout.main);
//
//
//    }
//
//    @Override
//    public void setView() {
//
//        position = 0;
//        fm = getSupportFragmentManager();
//        ft = fm.beginTransaction();
//        addressBookFragment  = new AddressBookFragment();
//        warningFragment = new WarningFragment();
//        settingFragment = new SettingFragment();
//        monitoringFragment = new MonitoringFragment();
//        ft.add(R.id.viewPager,warningFragment).add(R.id.viewPager,addressBookFragment).add(R.id.viewPager,monitoringFragment).add(R.id.viewPager,settingFragment);
//        ft.hide(warningFragment).hide(addressBookFragment).hide(settingFragment).show(monitoringFragment);
//        ft.commit();
//
//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        toolbar.setTitle("平安联防");
//        toolbar.setTitleTextColor(Color.WHITE);
//
//        homeWarningImg = (ImageView) findViewById(R.id.home_warning_img);
//        homeAddressImg = (ImageView) findViewById(R.id.home_address_img);
//        homeMonitoringImg = (ImageView) findViewById(R.id.home_monitoring_img);
//        homeSettingImg = (ImageView) findViewById(R.id.home_setting_img);
//
//        fm = getSupportFragmentManager();
//        home_img[0] = homeWarningImg;
//        home_img[1] = homeAddressImg;
//        home_img[2] = homeMonitoringImg;
//        home_img[3] = homeSettingImg;
//
//        homeWarningImg.setOnClickListener(this);
//        homeAddressImg.setOnClickListener(this);
//        homeMonitoringImg.setOnClickListener(this);
//        homeSettingImg.setOnClickListener(this);
//
//
//
//    }
//
//    @Override
//    public void getdata() {
//
//    }
//
//
//    @Override
//    public void onClick(View view) {
//        ft = fm.beginTransaction();
//        switch (view.getId()) {
//            case R.id.home_warning_img:
//                position=0;
//                setColor(position);
//                ft.hide(new AddressBookFragment()).hide(new MonitoringFragment()).hide(new SettingFragment()).show(new WarningFragment());
//                break;
//            case R.id.home_address_img:
//                position = 1;
//                setColor(position);
//                ft.hide(new WarningFragment()).hide(new MonitoringFragment()).hide(new SettingFragment()).show(new AddressBookFragment());
//                break;
//            case R.id.home_monitoring_img:
//                position = 2;
//                setColor(position);
//                ft.hide(new AddressBookFragment()).hide(new WarningFragment()).hide(new SettingFragment()).show(new MonitoringFragment());
//                break;
//            case R.id.home_setting_img:
//                position = 3;
//                setColor(position);
//                ft.hide(new WarningFragment()).hide(new AddressBookFragment()).hide(new MonitoringFragment()).show(new SettingFragment());
//                break;
//        }
//        ft.commit();
//    }
//
//    public void setColor(int position){
//        for (int i =0;i<4;i++){
//            if(position == i){
//                home_img[i].setImageResource(select_img[i]);
//            }else{
//                home_img[i].setImageResource(default_img[i]);
//            }
//        }
//    }
//
//}
