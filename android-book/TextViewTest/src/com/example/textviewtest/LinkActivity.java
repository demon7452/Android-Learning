package com.example.textviewtest;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LinkActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_link);
		
		TextView tvLink1 = (TextView)findViewById(R.id.tvLink1);
		TextView tvLink2 = (TextView)findViewById(R.id.tvLink2);
		EditText eText = (EditText)findViewById(R.id.etLink);
		
		String text1 = "显示Show_richText";
		String text2 = "显示Text_image";
		String text3 = "editText link";
		//将文本转换成SpannableString对象
		SpannableString spannableString1 = new SpannableString(text1);
		SpannableString spannableString2 = new SpannableString(text2);
		SpannableString spannableString3 = new SpannableString(text3);
		
		//将text1中的所有文本设置成ClickableSapn对象，并实现了onClick方法
		spannableString1.setSpan(new ClickableSpan()
		{
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(LinkActivity.this,Show_richText.class);
				//显示show_rich_text
				startActivity(intent);
			}
		}, 0, text1.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		
		//将text2中的所有文本设置成ClickableSapn对象，并实现了onClick方法
		spannableString2.setSpan(new ClickableSpan()
		{
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(LinkActivity.this,Text_image.class);
				//显示show_rich_text
				startActivity(intent);
			}
		}, 0, text2.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		
		//将text3中的所有文本设置成ClickableSapn对象，并实现了onClick方法
		spannableString3.setSpan(new ClickableSpan()
		{
					
			@Override
			public void onClick(View arg0) 
			{
				// TODO Auto-generated method stub
				Intent intent = new Intent(LinkActivity.this,MainTest.class);
				//显示show_rich_text
				startActivity(intent);
			}
		}, 0, text3.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
		
		//使用spannableString对象设置TextView和EditText控件的内容
		tvLink1.setText(spannableString1);
		tvLink2.setText(spannableString2);
		eText.setText(spannableString3);
		
		//在单击链接时有要执行的动作，都必须设置MovementMethod对象
		tvLink1.setMovementMethod(LinkMovementMethod.getInstance());
		tvLink2.setMovementMethod(LinkMovementMethod.getInstance());
		eText.setMovementMethod(LinkMovementMethod.getInstance());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.link, menu);
		return true;
	}

}
