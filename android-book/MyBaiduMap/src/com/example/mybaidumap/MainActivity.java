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
		
		//��ʹ�� SDK �����֮ǰ��ʼ�� context ��Ϣ������ ApplicationContext
		//ע��÷���Ҫ�� setContentView ����֮ǰʵ��
		SDKInitializer.initialize(getApplicationContext());
		
		//setContentView(R.layout.activity_main);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.activity_main);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title);
		
		//��ȡ��ͼ�ؼ�����
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
	//�� activity ִ�� onDestroy ʱִ�� mMapView.onDestroy()��ʵ�ֵ�ͼ�������ڹ���
	mMapView.onDestroy();
	}
	@Override
	protected void onResume() {
	super.onResume();
	//�� activity ִ�� onResume ʱִ�� mMapView. onResume ()��ʵ�ֵ�ͼ�������ڹ���
	mMapView.onResume();
	}
	@Override
	protected void onPause() {
	super.onPause();
	//�� activity ִ�� onPause ʱִ�� mMapView. onPause ()��ʵ�ֵ�ͼ�������ڹ���
	mMapView.onPause();
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
