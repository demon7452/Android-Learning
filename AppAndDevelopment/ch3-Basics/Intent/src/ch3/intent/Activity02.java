package ch3.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity02 extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		/* 设置显示activity_activity02.xml布局文件*/
		setContentView(R.layout.activity_activity02);
		Button button = (Button) findViewById(R.id.button2);
		button.setOnClickListener(new Button.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(Activity02.this, Activity01.class);
				startActivity(intent);
				Activity02.this.finish();
			}
			
		});
	}
}
