package com.example.mybaidumap;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class JumpToLogoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		new Handler().postDelayed(new Runnable() 
		{
			
			@Override
			public void run()
			{
				// TODO Auto-generated method stub
				Intent intent = new Intent(JumpToLogoActivity.this,LogoActivity.class);
				startActivity(intent);
				overridePendingTransition(R.anim.small, R.anim.small);
				JumpToLogoActivity.this.finish();
			}
		}, 700);
	}



}
