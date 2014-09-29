package com.example.services;

import java.util.IllegalFormatCodePointException;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.style.SuperscriptSpan;
import android.util.Log;
import android.widget.Toast;

public class BlaceListService extends Service {

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	public void onCreate()
	{
		//找到电话服务
		TelephonyManager tManager = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
		
		//实现电话状态的监听
		tManager.listen(new MyCallStatListener (), PhoneStateListener.LISTEN_CALL_STATE);
	
		System.out.println("qidong");
		super.onCreate();
	}
	
	private class MyCallStatListener extends PhoneStateListener {
		
		public void onCallStateChanged(int state, String incomingNumber) 
		{
			Log.d("callnumber",incomingNumber);
			switch (state) {
			case TelephonyManager.CALL_STATE_IDLE:
				System.out.println("IDLE");
				
				break;
			case TelephonyManager.CALL_STATE_OFFHOOK:
				System.out.println("OFFHOOK");
				break;
			case TelephonyManager.CALL_STATE_RINGING:
				if("18256969095".equals(incomingNumber))
				{
					
					Toast.makeText(getApplicationContext(), "黑名单号码被挂起", Toast.LENGTH_LONG).show();
				}
				System.out.println("RINGING");
				break;
				 
			default:
				break;
			}
			super.onCallStateChanged(state, incomingNumber);
			
		}
	}
	
	public void onDestroy()
	{
		super.onDestroy();
	}
}
