package com.example.testjia;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity 
{
	private Button login;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		initViewListener();
		
		
	}


	
	
	private void initView() {
		
		login = (Button)findViewById(R.id.login);
	}
	private void next() 
	{
		Intent intent = new Intent(this,FirstMainActivity.class);
		startActivity(intent);
	}
	private void initViewListener() {
		
		login.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0)
			{
				next();
			}
		});

	}

	
	
}
