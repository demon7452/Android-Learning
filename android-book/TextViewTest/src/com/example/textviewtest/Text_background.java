package com.example.textviewtest;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.view.Menu;
import android.widget.TextView;

public class Text_background extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_text_background);
		setText();
		
		TextView textView2 = (TextView)findViewById(R.id.tvLinkText);
		String text ="王涛：18601579829";
		textView2.setText(text);
		textView2.setMovementMethod(LinkMovementMethod.getInstance());
	}
	
	private void setText()
	{
		TextView textView = (TextView)findViewById(R.id.tvBackground);
		
		//设置要显示的字符串
		String text = "<没有背景><黄色背景>\n\n<蓝色背景，红色文字>";
		SpannableString spannableString = new SpannableString(text);
		//设置黄色背景
		BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(Color.YELLOW);
		spannableString.setSpan(backgroundColorSpan, 6, 12, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		//设置蓝色背景和红色文字
		ColorSpan colorSpan = new ColorSpan(Color.RED, Color.BLUE);
		spannableString.setSpan(colorSpan, 14, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		
		textView.setText(spannableString);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.text_background, menu);
		return true;
	}

}
