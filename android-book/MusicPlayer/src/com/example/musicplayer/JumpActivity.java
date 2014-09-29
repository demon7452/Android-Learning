package com.example.musicplayer;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class JumpActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jump);
		TextView textView1 = (TextView)findViewById(R.id.textView1);
		TextView textView2 = (TextView)findViewById(R.id.textView2);
		
		String text1 = "显示Activity1";
		String text2 = "显示Activity2";
		//将文本转换成SpannableString对象
		SpannableString spannableString1 = new SpannableString(text1);
		SpannableString spannableString2 = new SpannableString(text2);
		//将Text1中的所有文本设置成ClickableSpan对象，并实现了onClick方法
		spannableString1.setSpan(new ClickableSpan()
		{
			//在onClick方法中可以编写单击链接时要执行的动作
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(JumpActivity.this,MainActivity.class);
				startActivity(intent);
			}
		}, 0, text1.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		//使用spannableString 对象设置两个textView控件的内容
		textView1.setText(spannableString1);
		//在单击链接时凡是有要执行的动作，都必须设置MovementMethod对象
		textView1.setMovementMethod(LinkMovementMethod.getInstance());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.jump, menu);
		return true;
	}

}
