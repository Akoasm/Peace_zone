package com.example.admin.peacezone.fragment;


import android.app.AlertDialog;
import android.view.View;
import android.widget.TextView;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.example.admin.peacezone.R;
import com.example.admin.peacezone.base.myFragment;

import butterknife.ButterKnife;


/**
 * Created by admin on 2016/8/24.
 */
public class WarningFragment extends myFragment {

    MapView mMapView = null;
    public LocationClient mLocationClient = null;
    public BDLocationListener myListener = new MyLocationListener();
    private double myLatitude;
    private double myLongitude;
    private BaiduMap mBaidumap;
    boolean isFirstLoc = true;// 是否首次定位
    private View layout;
    private TextView endPoint;
    private AlertDialog dialog;
    private String mMap_WeiZhi;

    @Override
    public int setLayout() {
        return R.layout.warning;
    }

    @Override
    public void getview() {
        //获取地图控件引用
        mMapView = (MapView) view.findViewById(R.id.warning_map);
        mBaidumap =  mMapView.getMap();
        mBaidumap.setMapType(BaiduMap.MAP_TYPE_NORMAL);

        //第一步初始化控件
        mLocationClient = new LocationClient(getActivity());     //声明LocationClient类
        mLocationClient.registerLocationListener(myListener);    //注册监听函数
        //配置
        initLocation();
        //第五步开启定位
        mLocationClient.start();
        //开启导航
//        initView(mMapView,getActivity());

    }

    //配置地图设置
    private void initLocation(){
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy
        );//可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
        option.setCoorType("bd09ll");//可选，默认gcj02，设置返回的定位结果坐标系
        int span=1000;
        option.setScanSpan(span);//可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的
        option.setIsNeedAddress(true);//可选，设置是否需要地址信息，默认不需要
        option.setOpenGps(true);//可选，默认false,设置是否使用gps
        option.setLocationNotify(true);//可选，默认false，设置是否当gps有效时按照1S1次频率输出GPS结果
        option.setIsNeedLocationDescribe(true);//可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”
        option.setIsNeedLocationPoiList(true);//可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到
        option.setIgnoreKillProcess(false);//可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死
        option.SetIgnoreCacheException(false);//可选，默认false，设置是否收集CRASH信息，默认收集
        option.setEnableSimulateGps(false);//可选，默认false，设置是否需要过滤gps仿真结果，默认需要
        mLocationClient.setLocOption(option);
    }

    //设置定位当前位置时间，并且添加当前位置图标
    public class MyLocationListener implements BDLocationListener {

        @Override
        public void onReceiveLocation(BDLocation location) {
            // 取经纬度
            myLatitude = location.getLatitude();
            myLongitude = location.getLongitude();

            // map view 销毁后不在处理新接收的位置
            if (location == null || mMapView == null)
                return;
            MyLocationData locData = new MyLocationData.Builder()
                    .accuracy(location.getRadius())
                    //设置获取到的方向信息，0-360
                    .direction(100).latitude(location.getLatitude())
                    .longitude(location.getLongitude()).build();

            if (locData != null && mBaidumap != null)
                mBaidumap.setMyLocationData(locData);
//            if (isFirstLoc) {/////判断是不是第一次定位
                isFirstLoc = false;
                LatLng ll = new LatLng(location.getLatitude(),
                        location.getLongitude());
                MapStatusUpdate u = MapStatusUpdateFactory.newLatLng(ll);
                mBaidumap.animateMapStatus(u);

            mMap_WeiZhi =location.getAddrStr();
            addMarker(myLatitude,myLongitude);

        }
    }


    /** 添加地图图标方法*/

    public void addMarker(double myLatitude,double myLongitude){

        LatLng point = new LatLng(myLatitude,myLongitude);
        BitmapDescriptor bitmap = BitmapDescriptorFactory.fromResource(R.mipmap.iconfont_dingwei);
        OverlayOptions option = new MarkerOptions().position(point).icon(bitmap);
        mBaidumap.addOverlay(option);
    }


//    /** 地图导航*/
//    public void initView(MapView mMapView, Context context) {
//        // 获得 LayoutInflater 实例
//        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        layout = inflater.inflate(R.layout.warning_item, null);
//        endPoint = (TextView)layout.findViewById(R.id.driver_location_name);
//        // 构造一个更新地图的msu对象，然后设置该对象为缩放等级14.0，最后设置地图状态。
//        MapStatusUpdate msu = MapStatusUpdateFactory.zoomTo(14.0f);
//        mBaidumap.setMapStatus(msu);
//
//        //设置地图点击事件，获取当前点击位置的经纬度，并且添加图标
//        mBaidumap.setOnMapClickListener(new BaiduMap.OnMapClickListener() {
//            @Override
//            public void onMapClick(LatLng latLng) {
//                double lat = latLng.latitude;
//                double lon = latLng.longitude;
////                addMarker(lat,lon);
//                latLng.describeContents();
//                Dingwei_Info.Info info = new Dingwei_Info.Info();
//                info.setLatitude(lat);
//                info.setLongitude(lon);
////                GetOkBack(info);
//            }
//
//            @Override
//            public boolean onMapPoiClick(MapPoi mapPoi) {
//                return false;
//            }
//        });
//    }

//    private void showLocation(final Marker marker){
//        LatLng pt = null;
//        double latitude, longitude;
//        latitude = marker.getPosition().latitude;
//        longitude = marker.getPosition().longitude;
//        pt = new LatLng(latitude+0.0004,longitude+0.0005);
//        endPoint.setText(marker.getTitle());
//
//        InfoWindow.OnInfoWindowClickListener listener = new InfoWindow.OnInfoWindowClickListener() {
//            @Override
//            public void onInfoWindowClick() {
//
//            }
//        };
//    }

    private void mark(double latitude,double longitude,String title){

    }

    @Override
    public void setListener() {

    }

    @Override
    public void setView() {

    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
