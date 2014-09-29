package com.example.animationtest;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		
		//Intent intent = new Intent(this,JumpActivity.class);
		//startActivity(intent);
		
		//overridePendingTransition(R.anim.small, R.anim.small);
		new Handler().postDelayed(new Runnable() 
		{

			@Override
			public void run()
			{
				Intent intent = new Intent(MainActivity.this,JumpActivity.class);
				startActivity(intent);
				//overridePendingTransition(R.anim.small, R.anim.small);
				overridePendingTransition(R.anim.full, R.anim.full);
				MainActivity.this.finish();
			}

		}, 700);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
