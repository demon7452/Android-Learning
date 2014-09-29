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
		//设置文字颜色
		textView.setTextColor(Color.BLACK);
		//设置背景色
		textView.setBackgroundColor(Color.WHITE);
		//设置字体大小
		textView.setTextSize(20);
		//使用Html.fromHtml方法转换包含Html标签的文本，需要指定fromHtml方法的第二个参数
		
		/**
		CharSequence charSequence = Html.fromHtml(imageString,new ImageGetter() 
		{
			@Override
			public Drawable getDrawable(String source) 
			{
				// TODO Auto-generated method stub
				//装载图像资源
				
				Drawable drawable = getResources().getDrawable(getResourceId(source));
				/**
				//第三个图像文件按50%等比压缩显示（24×24）
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
			//根据资源Id的变量名获得Field对象
			Field field = R.drawable.class.getField(name);
			//取得并返回资源Id字段的值
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
