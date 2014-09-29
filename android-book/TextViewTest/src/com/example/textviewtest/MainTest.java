package com.example.textviewtest;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainTest extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_test);
	}
	
	public void click_show_richText(View view)
	{
		Intent intent = new Intent(this,Show_richText.class);
		startActivity(intent);
		
	}
	
	public void click_text_image(View view)
	{
		Intent intent = new Intent(this,Text_image.class);
		startActivity(intent);
	}
	
	public void click_link_activity(View view)
	{
		Intent intent = new Intent(this,LinkActivity.class);
		startActivity(intent);
	}
	
	public void click_text_background(View view)
	{
		Intent intent = new Intent(this,Text_background.class);
		startActivity(intent);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_test, menu);
		return true;
	}

}
