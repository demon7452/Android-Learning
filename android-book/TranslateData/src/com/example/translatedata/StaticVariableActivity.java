package com.example.translatedata;

import java.util.Date;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class StaticVariableActivity extends Activity {

	public static String name;
	public static int id;
	public static Date date;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_static_variable);
		TextView staticTextView = (TextView)findViewById(R.id.staticTextView);
		
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("name:");
		stringBuffer.append(name);
		stringBuffer.append("\n");
		stringBuffer.append("id:");
		stringBuffer.append(id);
		stringBuffer.append("\n");
		stringBuffer.append("date:");
		
		stringBuffer.append("\n");
		
		//输出静态变量的值
		staticTextView.setText(stringBuffer);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.static_variable, menu);
		return true;
	}

}
