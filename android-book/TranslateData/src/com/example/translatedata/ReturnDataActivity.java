package com.example.translatedata;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class ReturnDataActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_return_data);
	}
	public void btSure(View view)
	{
		EditText myEditText = (EditText)findViewById(R.id.editText);
		String valueString = myEditText.getText().toString();
		Intent intent = new Intent();
		intent.putExtra("value", valueString);
		//通过Intent对象返回结果
		setResult(2,intent);
		//关闭当前Activity
		finish();
	}
	
	protected void onActivityResult(int requestCode,int resultCode,Intent data)
	{
		super.onActivityResult(requestCode, resultCode, data);
		switch (requestCode)
		{
		case 1://请求码
			switch (resultCode) 
			{
			case 2://响应码
				setTitle(data.getStringExtra("value"));
				break;

			default:
				break;
			}
			break;

		default:
			break;
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.return_data, menu);
		return true;
	}

}
