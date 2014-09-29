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
		
		String text1 = "��ʾActivity1";
		String text2 = "��ʾActivity2";
		//���ı�ת����SpannableString����
		SpannableString spannableString1 = new SpannableString(text1);
		SpannableString spannableString2 = new SpannableString(text2);
		//��Text1�е������ı����ó�ClickableSpan���󣬲�ʵ����onClick����
		spannableString1.setSpan(new ClickableSpan()
		{
			//��onClick�����п��Ա�д��������ʱҪִ�еĶ���
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(JumpActivity.this,MainActivity.class);
				startActivity(intent);
			}
		}, 0, text1.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		//ʹ��spannableString ������������textView�ؼ�������
		textView1.setText(spannableString1);
		//�ڵ�������ʱ������Ҫִ�еĶ���������������MovementMethod����
		textView1.setMovementMethod(LinkMovementMethod.getInstance());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.jump, menu);
		return true;
	}

}
