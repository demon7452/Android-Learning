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
		
		//�Ӳ����ļ�װ�ز���������textView����
		TextView textView1 = (TextView)findViewById(R.id.tvLink1);
		TextView textView2 = (TextView)findViewById(R.id.tvLink2);
		
		//���õ�һ��textView��ʾ���ı�
		String html = "<font color='red'>I love Android </font><br> ";
		html += "<font color='#0000FF'><big><i>I love Android.</i></big></font><p>";
		html += "<font color='@" + android.R.color.white + "'><tt><b><big><u>I love Android</u></big></b></tt></font><p>";
		html += "<big><a herf='http://www.baidu.com'>�ٶ�һ�£����֪��</a></big>";
		
		//����Ԥ�����ǩ���ַ���ת����CharSequence����
		CharSequence charSequence = Html.fromHtml(html);
		textView1.setText(charSequence);
		
		//û�и���䣬�޷��������ӵ����������ʾ��ҳ
		textView1.setMovementMethod(LinkMovementMethod.getInstance());
		
		//���õڶ���TextView�ؼ�Ҫ��ʾ���ı�
		String text = "�ҵ�URL:http://www.baidu.com\n";
		text += "�ҵ�Email:1003871302@qq.com";
		text += "�ҵĵ绰��13655510714";
		textView2.setText(text);
		
		//û�и���䣬�޷��������ӵ����������ʾ��ҳ
		textView2.setMovementMethod(LinkMovementMethod.getInstance());
		
		
	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
