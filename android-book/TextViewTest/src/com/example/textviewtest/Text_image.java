package com.example.textviewtest;

import java.lang.reflect.Field;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;
import android.graphics.Color;

public class Text_image extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_text_image);
		
		TextView textView = (TextView)findViewById(R.id.text_image);
		String imageString = "icon1:<img src=icon1/>2:<img src=icon2/>3:<img src=icon3/>";
		//����������ɫ
		textView.setTextColor(Color.BLACK);
		//���ñ���ɫ
		textView.setBackgroundColor(Color.WHITE);
		//���������С
		textView.setTextSize(20);
		//ʹ��Html.fromHtml����ת������Html��ǩ���ı�����Ҫָ��fromHtml�����ĵڶ�������
		
		/**
		CharSequence charSequence = Html.fromHtml(imageString,new ImageGetter() 
		{
			@Override
			public Drawable getDrawable(String source) 
			{
				// TODO Auto-generated method stub
				//װ��ͼ����Դ
				
				Drawable drawable = getResources().getDrawable(getResourceId(source));
				/**
				//������ͼ���ļ���50%�ȱ�ѹ����ʾ��24��24��
				if(source.equals("icon3"))
					drawable.setBounds(0,0,drawable.getIntrinsicWidth()/2,drawable.getIntrinsicHeight()/2);
				else 
					drawable.setBounds(0,0,drawable.getIntrinsicHeight()/2,drawable.getIntrinsicHeight());
				
				return drawable;
			}
		},null);
		*/
		textView.setText(imageString);
		//textView.setText(charSequence);
		//textView.setMovementMethod(LinkMovementMethod.getInstance());
		
	}

	public int getResourceId(String name)
	{
		try 
		{
			//������ԴId�ı��������Field����
			Field field = R.drawable.class.getField(name);
			//ȡ�ò�������ԴId�ֶε�ֵ
			return Integer.parseInt(field.get(null).toString());
		} catch (Exception e) 
		{
			// TODO: handle exception
		}
		return 0;
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.text_image, menu);
		return true;
	}

}
