package com.shixforever.wow;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.view.View;

public class PaintView extends View
{
	private Paint mPaint;
	private int marginWidth = 20; // 左右与边缘的距离
	private int m_fontSize = 40;
	private int m_textColor = Color.rgb(28, 28, 28);
	private int m_backColor = 0xffff9e85; // 背景颜色
	private String text;
	public PaintView(Context context,String text)
	{
		super(context);
		mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);// 画笔
		mPaint.setTextAlign(Align.LEFT);// 做对其
		mPaint.setTextSize(m_fontSize);// 字体大小
		mPaint.setColor(m_textColor);// 字体颜色
		this.text=text;
	}

	@Override
	protected void onDraw(Canvas canvas)
	{
		super.onDraw(canvas);
		canvas.drawColor(m_backColor);
		canvas.drawText(text, marginWidth, m_fontSize, mPaint);
	}
	
}
