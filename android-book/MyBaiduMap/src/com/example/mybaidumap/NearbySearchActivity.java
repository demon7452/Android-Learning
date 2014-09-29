package com.example.mybaidumap;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.Window;

public class NearbySearchActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.activity_nearby_search);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.nearby_search_title);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.nearby_search, menu);
		return true;
	}

}
