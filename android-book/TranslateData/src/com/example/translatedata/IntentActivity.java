package com.example.translatedata;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class IntentActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_intent);
		
		TextView textView =(TextView)findViewById(R.id.intentTextView);
		
		String intentString = getIntent().getStringExtra("intent_string");
		int intentInteger = getIntent().getExtras().getInt("intent_integer");
		
		StringBuffer textStringBuffer = new StringBuffer();
		textStringBuffer.append("intent_string:");
		textStringBuffer.append(intentString);
		textStringBuffer.append("\n");
		textStringBuffer.append("intent_integer:");
		textStringBuffer.append(intentInteger);
		textStringBuffer.append("\n");
		textView.setText(textStringBuffer.toString());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{	
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.intent, menu);
		return true;
	}

}
