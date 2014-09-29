package com.example.blacklist;

import java.io.File;

import android.media.MediaRecorder;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

import com.example.services.*;

public class MainActivity extends Activity {

	private Button btRecorder;
	private Button btEnd;
	private File recordAudioFile;
	private MediaRecorder mediaRecorder;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		buttonSet();
		buttonListener();
		mediaRecordSet();
	}
	/**
	 * 启动黑名单的服务
	 * @param v
	 */
	private void buttonSet()
	{
		btRecorder = (Button) findViewById(R.id.btRecorder);
		btEnd = (Button) findViewById(R.id.btEnd);
	}
	private void mediaRecordSet()
	{
		try 
		{
			recordAudioFile =  File.createTempFile("record", ".amr");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error");
		}
		mediaRecorder = new MediaRecorder();
		mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
		mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
		mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);
		mediaRecorder.setOutputFile(recordAudioFile.getAbsolutePath());
	}
	private void buttonListener()
	{
		btRecorder.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View arg0) 
			{
				// TODO Auto-generated method stub
				try 
				{
					mediaRecorder.prepare();
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("error2");
				}
				mediaRecorder.start();
			}
		});
		btEnd.setOnClickListener(new OnClickListener() 
		{
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				mediaRecorder.stop();
			}
		});
	}
	public void start(View v)
	{
		Intent intent = new Intent(this,BlaceListService.class);
		Log.d("star", "start");
		startService(intent);
	}
	public void stop(View v)
	{
		Intent intent = new Intent(this,BlaceListService.class);
		stopService(intent);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
