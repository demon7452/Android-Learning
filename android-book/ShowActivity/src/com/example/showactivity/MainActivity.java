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
        //从xml布局文件中创建三个按钮对象
         button1 = (Button)findViewById(R.id.activity1);
         button2 = (Button)findViewById(R.id.activity2);
         button3 = (Button)findViewById(R.id.activity3);
        
        //设置三个按钮的单击事件
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
		case R.id.activity1:   //显示调用Activity1
			intent = new Intent(this,MyActivity1.class);
			startActivity(intent);
			break;
		case R.id.activity2:   //隐式调用Activity2
			intent = new Intent("myAction1");
			startActivity(intent);
			break;
		case R.id.activity3:   //隐式调用Activity2和3
			intent = new Intent("myAction2");
			//并不需要显示调用android.intent.category.DEFAULT
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
