package ch3.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity01 extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		/* 设置显示activity_activity01.xml布局*/
		setContentView(R.layout.activity_activity01);
		/*  findViewById(R.id.button1) 取得布局xml中的button1*/
		Button button = (Button) findViewById(R.id.button1);
		/* 监听button的事件信息*/
		button.setOnClickListener(new Button.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				// TODO Auto-generated method stub
				/* 新建一个Intent对象*/
				Intent intent = new Intent();
				/* 指定intent要启动的类,this表示当前的activity，class表示要启动的activity*/
				intent.setClass(Activity01.this, Activity02.class);
				/* 启动一个新的Activity*/
				startActivity(intent);
				/* 关闭当前的Activity*/
				Activity01.this.finish();
			}
		});
	}
}
