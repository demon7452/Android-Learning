package com.example.showactivity;

import android.R.integer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	private Button button1;
	private Button button2;
	private Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //��xml�����ļ��д���������ť����
         button1 = (Button)findViewById(R.id.activity1);
         button2 = (Button)findViewById(R.id.activity2);
         button3 = (Button)findViewById(R.id.activity3);
        
        //����������ť�ĵ����¼�
       initViewListener();
    }
    private void initViewListener()
    {
    	 button1.setOnClickListener(new OnClickListener()
    	 {
			public void onClick(View arg0)
			{
				int id=arg0.getId();
				onClickNew(id);
			}
		 });
    	 button2.setOnClickListener(new OnClickListener()
    	 {
			public void onClick(View arg0)
			{
				int id=arg0.getId();
				onClickNew(id);
			}
		 });
    	 button3.setOnClickListener(new OnClickListener()
    	 {
			public void onClick(View arg0)
			{
				int id=arg0.getId();
				onClickNew(id);
			}
		 });
    }
    public void onClickNew (int id)
    {
    	Intent intent = null;
    	switch (id)
    	{
		case R.id.activity1:   //��ʾ����Activity1
			intent = new Intent(this,MyActivity1.class);
			startActivity(intent);
			break;
		case R.id.activity2:   //��ʽ����Activity2
			intent = new Intent("myAction1");
			startActivity(intent);
			break;
		case R.id.activity3:   //��ʽ����Activity2��3
			intent = new Intent("myAction2");
			//������Ҫ��ʾ����android.intent.category.DEFAULT
			intent.addCategory("myCategory");
			startActivity(intent);
			break;
		default:
			break;
		}
    }


   /** @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }*/
    
}
