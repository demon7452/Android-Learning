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
		
		String text1 = "��ʾShow_richText";
		String text2 = "��ʾText_image";
		String text3 = "editText link";
		//���ı�ת����SpannableString����
		SpannableString spannableString1 = new SpannableString(text1);
		SpannableString spannableString2 = new SpannableString(text2);
		SpannableString spannableString3 = new SpannableString(text3);
		
		//��text1�е������ı����ó�ClickableSapn���󣬲�ʵ����onClick����
		spannableString1.setSpan(new ClickableSpan()
		{
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(LinkActivity.this,Show_richText.class);
				//��ʾshow_rich_text
				startActivity(intent);
			}
		}, 0, text1.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		
		//��text2�е������ı����ó�ClickableSapn���󣬲�ʵ����onClick����
		spannableString2.setSpan(new ClickableSpan()
		{
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(LinkActivity.this,Text_image.class);
				//��ʾshow_rich_text
				startActivity(intent);
			}
		}, 0, text2.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		
		//��text3�е������ı����ó�ClickableSapn���󣬲�ʵ����onClick����
		spannableString3.setSpan(new ClickableSpan()
		{
					
			@Override
			public void onClick(View arg0) 
			{
				// TODO Auto-generated method stub
				Intent intent = new Intent(LinkActivity.this,MainTest.class);
				//��ʾshow_rich_text
				startActivity(intent);
			}
		}, 0, text3.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
		
		//ʹ��spannableString��������TextView��EditText�ؼ�������
		tvLink1.setText(spannableString1);
		tvLink2.setText(spannableString2);
		eText.setText(spannableString3);
		
		//�ڵ�������ʱ��Ҫִ�еĶ���������������MovementMethod����
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
