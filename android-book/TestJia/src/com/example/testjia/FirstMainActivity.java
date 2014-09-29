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

public class FirstMainActivity extends Activity {
//	private EditText tv;
//	private Button check;
//	private EditText password;
	private Button play;
	private Button stop;
	private ImageView imageView;
	private TextView textView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_framelayout);
		System.out.println("-----onCreate-----");
		
		initView();
		
		initViewListener();
		
		
//		tv = (TextView)findViewById(R.id.tv);
//		tv.setOnClickListener(new OnClickListener(){
//			public void onClick(View arg0){
//				Intent intent = new Intent(FirstMainActivity.this,SecondMainActivity.class);
//				startActivity(intent);
//			}
//		});
		
//		tv = (EditText)findViewById(R.id.tv);
//		password = (EditText)findViewById(R.id.password);
//		check = (Button)findViewById(R.id.check);
//		check.setOnClickListener(new OnClickListener(){
//			public void onClick(View arg0){
//				String str1 = tv.getText().toString();
//				String str2 = password.getText().toString();
//				
//				if((str1.equals("hjq"))&&( str2.equals("123456")))
//				{
//					Intent intent = new Intent(FirstMainActivity.this,SecondMainActivity.class);
//					startActivity(intent);
//				}
//				else{
//					//TextView.setText("密码错误，请重新输入");
//				}
//			}
//		});
	}
	
	private void initView() {
		
		play = (Button)findViewById(R.id.play);
		stop = (Button)findViewById(R.id.stop);
		imageView = (ImageView)findViewById(R.id.imageView);
		textView = (TextView)findViewById(R.id.textView);
		
		
	}

	private void initViewListener() {
		
		play.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0){
				imageView.setVisibility(View.INVISIBLE);
				textView.setText("视频正在播放中...");
			}
		});
		
		stop.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0){
				imageView.setVisibility(View.VISIBLE);
				textView.setText("视频正在暂停中...");
			
			}
		});
		
	}

	@Override
	protected void onStart() {
		System.out.println("-----onStart-----");
		super.onStart();
	}

	@Override
	protected void onResume() {
		System.out.println("-----onResume-----");
		super.onResume();
	}

	@Override
	protected void onPause() {
		System.out.println("-----onPause-----");
		super.onPause();
	}

	@Override
	protected void onStop() {
		System.out.println("-----onStop-----");
		super.onStop();
	}

	@Override
	protected void onDestroy() {
		System.out.println("-----onDestroy-----");
		super.onDestroy();
	}

}
