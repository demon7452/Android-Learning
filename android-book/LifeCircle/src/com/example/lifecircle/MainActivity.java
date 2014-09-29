package com.example.lifecircle;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d("onCreate", "onCreate method is executed");
	}
	
	
	
	protected void onStart()
	{
		super.onStart();
		Log.d("onStart", "onStart method is executed");
	}

	protected void onResume()
	{
		super.onResume();
		Log.d("onResume", "onResume method is executed");
	}
	
	

	protected void onPause()
	{
		super.onPause();
		Log.d("onPause", "onPause method is executed");
	}
	
	protected void onStop()
	{
		super.onStop();
		Log.d("onStop", "onStop method is executed");
	}
	
	protected void onDestory ()
	{
		super.onDestroy();
		Log.d("onDestory", "onDestory method is executed");
	}
	
	protected void onRestart()
	{
		super.onRestart();
		Log.d("onRestart", "onRestart method is executed");
	}
	
}
