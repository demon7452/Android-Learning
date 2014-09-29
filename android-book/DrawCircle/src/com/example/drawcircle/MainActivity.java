package com.example.drawcircle;



import java.util.Random;
import com.example.drawcircle.CircleCanvas.CircleInfo;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;


public class MainActivity extends Activity
{
	private CircleCanvas mCircleCanvas;
	
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		ViewGroup viewGroup = (ViewGroup)getLayoutInflater().inflate(R.layout.activity_main, null);
		mCircleCanvas = new CircleCanvas(this);
		viewGroup.addView(mCircleCanvas,new LayoutParams(LayoutParams.FILL_PARENT,700));
		setContentView(viewGroup);
	}
	public void onClick_DrawRandomCircle(View view)
	{
		Random random = new Random();
		float randomX = (float)(100 + random.nextInt(200));
		float randomY = (float)(100 + random.nextInt(500));
		float randomRadius = (float)(20 + random.nextInt(40));
		int randomColor = 0;
		if(random.nextInt(100)>50)
		{
			randomColor = Color.BLUE;
		}
		else
		{
			if(random.nextInt(100)>50)
				randomColor = Color.RED;
			else
				randomColor = Color.GREEN;
		}
		CircleInfo circleInfo = new CircleInfo();
		circleInfo.setX(randomX);
		circleInfo.setY(randomY);
		circleInfo.setRadius(randomRadius);
		circleInfo.setColor(randomColor);
		mCircleCanvas.mCircleInfos.add(circleInfo);
		mCircleCanvas.invalidate();
		Log.v("v",String.valueOf(randomX));
		Log.d("d",String.valueOf(randomX));
		Log.i("i",String.valueOf(randomX));
		Log.w("w",String.valueOf(randomX));
	}
    
	public void onClick_Clear(View view)
	{
		mCircleCanvas.mCircleInfos.clear();
		mCircleCanvas.invalidate();	
	}
    
}

