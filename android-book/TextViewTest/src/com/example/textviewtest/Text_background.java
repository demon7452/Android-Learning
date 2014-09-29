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
		String text ="���Σ�18601579829";
		textView2.setText(text);
		textView2.setMovementMethod(LinkMovementMethod.getInstance());
	}
	
	private void setText()
	{
		TextView textView = (TextView)findViewById(R.id.tvBackground);
		
		//����Ҫ��ʾ���ַ���
		String text = "<û�б���><��ɫ����>\n\n<��ɫ��������ɫ����>";
		SpannableString spannableString = new SpannableString(text);
		//���û�ɫ����
		BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(Color.YELLOW);
		spannableString.setSpan(backgroundColorSpan, 6, 12, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		//������ɫ�����ͺ�ɫ����
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
