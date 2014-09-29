package com.example.textviewtest;

import android.text.TextPaint;
import android.text.style.CharacterStyle;

public class ColorSpan extends CharacterStyle
{
	private int mTextColor;
	private int mBackgroundColor;
	
	public ColorSpan (int mTextColor, int mBackgroundColor)
	{
		this.mTextColor = mTextColor;
		this.mBackgroundColor = mBackgroundColor;
	}

	//����CharacterStyle���е�updateDrawState���������ڸ÷��������������ֺͱ�����ɫ
	@Override
	public void updateDrawState(TextPaint tp) 
	{
		// TODO Auto-generated method stub
		tp.bgColor = mBackgroundColor;
		tp.setColor(mTextColor);
	}
}
