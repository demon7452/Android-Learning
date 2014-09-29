package com.example.mybaidumap;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.Window;
import android.widget.ImageView;

public class LogoActivity extends Activity {

	private ImageView imageView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// delete title
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		setContentView(R.layout.activity_logo);
		imageView = (ImageView)findViewById(R.id.ivLogo);
        //		结束logo界面跳转到百度地图主界面
		new Handler().postDelayed(new Runnable()
		{
			
			@Override
			public void run() 
			{
				// TODO Auto-generated method stub
				Intent intent = new Intent(LogoActivity.this,MainActivity.class);
				startActivity(intent);
				overridePendingTransition(R.anim.in, R.anim.out);
				LogoActivity.this.finish();
			}
		}, 700);
		 
	        
	        
	}

	

}
