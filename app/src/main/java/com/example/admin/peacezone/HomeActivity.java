package com.example.admin.peacezone;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.admin.peacezone.addressbook.AddressBookFragment;
import com.example.admin.peacezone.monitoring.MonitoringFragment;
import com.example.admin.peacezone.setting.SettingFragment;
import com.example.admin.peacezone.warning.WarningFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by admin on 2016/9/5.
 */
public class HomeActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {


    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.home_monitoring_img)
    ImageView homeMonitoringImg;
    @Bind(R.id.home_warning_img)
    ImageView homeWarningImg;
    @Bind(R.id.home_address_img)
    ImageView homeAddressImg;
    @Bind(R.id.home_setting_img)
    ImageView homeSettingImg;

    int[]select_img = {R.mipmap.monitoring_select,R.mipmap.warning_select,R.mipmap.address_select,R.mipmap.setting_select};
    int[]default_img = {R.mipmap.monitoring_default,R.mipmap.warning_default,R.mipmap.address_default,R.mipmap.setting_default};

    ImageView[] home_img = new ImageView[4];
    private final FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new MonitoringFragment();
                case 1:
                    return new WarningFragment();
                case 2:
                    return new AddressBookFragment();
                case 3:
                    return new SettingFragment();
                default:
                    throw new RuntimeException("不存在的数据");
            }
        }

        @Override
        public int getCount() {
            return 4;
        }
    };
    @Bind(R.id.viewPager)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ButterKnife.bind(this);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(this);
        homeMonitoringImg.setSelected(true);
        chooseFragment(viewPager);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("平安联防");
        toolbar.setTitleTextColor(Color.WHITE);
        home_img[0] = homeMonitoringImg;
        home_img[1] = homeWarningImg;
        home_img[2] = homeAddressImg;
        home_img[3] = homeSettingImg;
        viewPager.setOffscreenPageLimit(2);

    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        ButterKnife.bind(this);
    }

    @OnClick({R.id.home_monitoring_img, R.id.home_warning_img, R.id.home_address_img, R.id.home_setting_img})
    public void chooseFragment(View view) {
        switch (view.getId()) {
            case R.id.home_monitoring_img:
                viewPager.setCurrentItem(0, false);
                setColor(0);
                break;
            case R.id.home_warning_img:
                viewPager.setCurrentItem(1, false);
                setColor(1);
                break;
            case R.id.home_address_img:
                viewPager.setCurrentItem(2, false);
                setColor(2);
                break;
            case R.id.home_setting_img:
                viewPager.setCurrentItem(3, false);
                setColor(3);
                break;
        }
    }
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        homeMonitoringImg.setSelected(position == 0);
        homeWarningImg.setSelected(position == 1);
        homeAddressImg.setSelected(position == 2);
        homeSettingImg.setSelected(position == 3);

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
    public void setColor(int position){
        for (int i =0;i<4;i++){
            if(position == i){
                home_img[i].setImageResource(select_img[i]);
            }else{
                home_img[i].setImageResource(default_img[i]);
            }
        }
    }


}
