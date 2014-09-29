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

	//覆盖CharacterStyle类中的updateDrawState方法，并在该方法中设置了文字和背景颜色
	@Override
	public void updateDrawState(TextPaint tp) 
	{
		// TODO Auto-generated method stub
		tp.bgColor = mBackgroundColor;
		tp.setColor(mTextColor);
	}
}
