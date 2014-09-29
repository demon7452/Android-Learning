package com.example.translatedata;

import android.os.Bundle;
import android.provider.ContactsContract.Contacts.Data;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;



public class MainActivity extends Activity 
{
	private Button btIntentButton;
	private Button btStaticButton;
	private Button btClipboard;
	private Button btAllData;
	private Button btRetrunData;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		buttonSet();
		buttonListener();
	}
	
	private void buttonSet()
	{
		btIntentButton = (Button)findViewById(R.id.btIntent);
		btStaticButton = (Button)findViewById(R.id.btStatic);
		btClipboard = (Button)findViewById(R.id.btClipboard);
		btAllData = (Button)findViewById(R.id.btAllData);
		btRetrunData = (Button)findViewById(R.id.btRetrunData);
	}
	
	private void buttonListener()
	{
		btIntentButton.setOnClickListener(new OnClickListener() 
		{	
			public void onClick(View arg0) 
			{
				translateByIntent();
			}
		});
		btStaticButton.setOnClickListener(new OnClickListener()
		{	
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				translateByStatic();			
			}
		});
		
		btClipboard.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View arg0) 
			{
				// TODO Auto-generated method stub
				translateByClipboard();
			}
		});
		
		btAllData.setOnClickListener(new OnClickListener()
		{	
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				translateByAllData();
			}
		});
		
		btRetrunData.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				retrunData();
			}
		});
	}
	public void translateByIntent()
	{
		Intent intent = new Intent(this,IntentActivity.class);
		intent.putExtra("intent_string", "通过Intent传递的字符串");
		intent.putExtra("intent_integer", 300);
		startActivity(intent);	
	}
	
	public void translateByStatic()
	{
		Intent intent = new Intent(this,StaticVariableActivity.class);
		StaticVariableActivity.id = 2011686;
		StaticVariableActivity.name = "李雄";
	
		startActivity(intent);
	}
	
	@SuppressLint("NewApi")
	public void translateByClipboard()
	{
		Intent intent = new Intent(this,ClipboardActivity.class);
		//通过getSystemService获得管理对象
		ClipboardManager clipboardManager = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
		//向剪切板传递数据
		clipboardManager.setText("通过剪切板Clipboard传递数据");
		startActivity(intent);
	}
	
	private void translateByAllData()
	{
		Intent intent = new Intent(this,AllDataActivity.class);
		AllData allData = (AllData)getApplicationContext();
		allData.countryString = "China";
		allData.number = 2014;
		startActivity(intent);
	}
	private void retrunData()
	{
		Intent intent = new Intent(this,ReturnDataActivity.class);
		startActivityForResult(intent, 1);
	}
	/**@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}*/

}
