package com.example.musicplayer;

import javax.security.auth.PrivateCredentialPermission;

import android.R.integer;
import android.R.string;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {
	
	private Button play;
	private Button pause;
	private Button restart;
	private Button stop;
	private MediaPlayer mediaPlayer;
	private TextView textView;
	private int musicPath = R.raw.test;
	private String pathMString = "./res/raw/test.mp3";
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		buttonSet();
		buttonListenr();
	}

	
	private void buttonSet()
	{
		setMedia(musicPath);
		textView = (TextView)findViewById(R.id.text);
		play = (Button)findViewById(R.id.play);
		pause = (Button)findViewById(R.id.pause);
		restart = (Button)findViewById(R.id.restart);
		stop = (Button)findViewById(R.id.stop);
	}
	private void setMedia(int path)
	{
		mediaPlayer =MediaPlayer.create(this, path);
	}

	private void buttonListenr()
	{
		final Drawable drawable = play.getBackground();
		play.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View arg0) {
				setMedia(musicPath);
				mediaPlayer.start();
				textView.setText(pathMString);
				play.setClickable(false);
				play.setBackgroundColor(TRIM_MEMORY_BACKGROUND);
				restart.setClickable(true);
				pause.setClickable(true);
			}
		});
		stop.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View arg0) {
				mediaPlayer.reset();
				textView.setText(pathMString);
				pause.setText("ÔÝÍ£");
				play.setClickable(true);
				play.setBackgroundDrawable(drawable);
				restart.setClickable(false);
				pause.setClickable(false);
				
			}
		});
		pause.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View arg0) {
				int j = pause.getText().toString().compareTo("ÔÝÍ£");
				if (j == 0) 
				{
					mediaPlayer.pause();
					textView.setText(pathMString);
					pause.setText("Ðø²¥");
					
				}
				else
				{
					mediaPlayer.start();
					pause.setText("ÔÝÍ£");
				}
				
			}
		});
		restart.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View arg0) 
			{
				mediaPlayer.reset();
				setMedia(musicPath);
				mediaPlayer.start();
				textView.setText(pathMString);
				pause.setText("ÔÝÍ£");
			}
		});
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
