package com.example.translatedata;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class AllDataActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_all_data);
		
		TextView textView = (TextView)findViewById(R.id.allDataTextView);
		AllData allData = (AllData)getApplicationContext();
		String contextString = allData.countryString + allData.number;
		textView.setText(contextString);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.all_data, menu);
		return true;
	}

}
