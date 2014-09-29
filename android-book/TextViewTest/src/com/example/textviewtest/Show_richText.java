package com.example.textviewtest;


import android.os.Bundle;
import android.app.Activity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.widget.TextView;

public class Show_richText extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_rich_text);
		
		//从布局文件装载并创建两个textView对象
		TextView textView1 = (TextView)findViewById(R.id.tvLink1);
		TextView textView2 = (TextView)findViewById(R.id.tvLink2);
		
		//设置第一个textView显示的文本
		String html = "<font color='red'>I love Android </font><br> ";
		html += "<font color='#0000FF'><big><i>I love Android.</i></big></font><p>";
		html += "<font color='@" + android.R.color.white + "'><tt><b><big><u>I love Android</u></big></b></tt></font><p>";
		html += "<big><a herf='http://www.baidu.com'>百度一下，你就知道</a></big>";
		
		//将带预定义标签的字符串转换成CharSequence对象
		CharSequence charSequence = Html.fromHtml(html);
		textView1.setText(charSequence);
		
		//没有该语句，无法单击链接调用浏览器显示网页
		textView1.setMovementMethod(LinkMovementMethod.getInstance());
		
		//设置第二个TextView控件要显示的文本
		String text = "我的URL:http://www.baidu.com\n";
		text += "我的Email:1003871302@qq.com";
		text += "我的电话：13655510714";
		textView2.setText(text);
		
		//没有该语句，无法单击链接调用浏览器显示网页
		textView2.setMovementMethod(LinkMovementMethod.getInstance());
		
		
	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
