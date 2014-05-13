package com.shixforever.wow.util;

import java.util.HashMap;

import android.app.Activity;
import android.graphics.Bitmap;

/**********************************************************
 * @文件名称：FusionField.java
 * @文件作者：xiongjiangwei
 * @创建时间：2013-1-16 下午02:26:24
 * @文件描述：全局静态变量类
 * @修改历史：2013-1-16创建初始版本
 **********************************************************/
public class FusionField
{
	public static Activity baseActivity = null;
	public static float widthScale = 0;
	public static float HeightScale = 0;
	public static float density = 0;
	public static HashMap<String, Bitmap> imageMap = new HashMap<String, Bitmap>();
}
