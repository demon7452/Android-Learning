package com.example.mybaidumap;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.MapView;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;

public class MainActivity extends Activity {

	MapView mMapView = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//在使用 SDK 各组件之前初始化 context 信息，传入 ApplicationContext
		//注意该方法要再 setContentView 方法之前实现
		SDKInitializer.initialize(getApplicationContext());
		
		//setContentView(R.layout.activity_main);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.activity_main);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title);
		
		//获取地图控件引用
		mMapView = (MapView)findViewById(R.id.bmapView);
	}
	
	public void onClick_btTitle(View view)
	{
		Intent intent = new Intent(this,NearbySearchActivity.class);
		startActivity(intent);
	}
	@Override
	protected void onDestroy() 
	{
	super.onDestroy();
	//在 activity 执行 onDestroy 时执行 mMapView.onDestroy()，实现地图生命周期管理
	mMapView.onDestroy();
	}
	@Override
	protected void onResume() {
	super.onResume();
	//在 activity 执行 onResume 时执行 mMapView. onResume ()，实现地图生命周期管理
	mMapView.onResume();
	}
	@Override
	protected void onPause() {
	super.onPause();
	//在 activity 执行 onPause 时执行 mMapView. onPause ()，实现地图生命周期管理
	mMapView.onPause();
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
