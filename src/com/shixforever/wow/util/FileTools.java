package com.shixforever.wow.util;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
/**
 * �ļ����?��
 * 
 * @author chenkangpeng
 * 
 */
public class FileTools
{
	/***
	 * ���assets �ļ����е��ļ���
	 * 
	 * @param context �����Ķ���
	 * @param name �ļ���
	 * @return ������
	 */
	public static InputStream getStreamFromAssets(Context context, String name)
	{
		InputStream is= null;
		try
		{
			is= context.getResources().getAssets().open(name);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return is;
	}
	/**
	 * ���resource�е�ͼƬ�ļ�
	 * 
	 * @param context
	 * @param name
	 * @return
	 */
	public static Bitmap getBitmapFromResource(Context context, String name)
	{
		int id= getResource(context, name);
		return BitmapFactory.decodeResource(context.getResources(), id);
	}
	public static int getResource(Context context, String name)
	{
		return context.getResources().getIdentifier(name, "drawable", context.getPackageName());
	}
	/**
	 * ���ֽ����鱣��Ϊһ���ļ�
	 * 
	 * @param b
	 * @param outputFile
	 * @return
	 */
	public static String saveFileFromBytes(byte[] b, String savePath, String outputFile)
	{
		File dfile= new File(savePath);
		if (!dfile.exists())
		{
			dfile.mkdirs();
		}
		File ret= null;
		BufferedOutputStream stream= null;
		try
		{
			ret= new File(outputFile);
			FileOutputStream fstream= new FileOutputStream(ret);
			stream= new BufferedOutputStream(fstream);
			stream.write(b);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (stream != null)
			{
				try
				{
					stream.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
		return outputFile;
	}
	/***
	 * 
	 * @param bm Ҫ�����bitmap����
	 * @param directory �ļ���Ŀ¼
	 * @param fileName �ļ���
	 * @return
	 */
	public static File saveFileFromBitmap(Bitmap bm, String directory, String fileName)
	{
		File dfile= new File(directory);
		if (!dfile.exists())
		{
			dfile.mkdirs();
		}
		File ret= null;
		BufferedOutputStream stream= null;
		try
		{
			ret= new File(directory + fileName);
			if (ret.exists())
			{
				ret.delete();
			}
			stream= new BufferedOutputStream(new FileOutputStream(ret));
			bm.compress(Bitmap.CompressFormat.JPEG, 80, stream);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (stream != null)
			{
				try
				{
					stream.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
		return ret;
	}
	/***
	 * 
	 * @param bm Ҫ�����bitmap����
	 * @param directory �ļ���Ŀ¼
	 * @param fileName �ļ���
	 * @return
	 */
	public static File saveFileFromBitmap(Bitmap bm, String fileName)
	{
		File ret= null;
		BufferedOutputStream stream= null;
		try
		{
			ret= new File(fileName);
			if (ret.exists())
			{
				ret.delete();
			}
			stream= new BufferedOutputStream(new FileOutputStream(ret));
			bm.compress(Bitmap.CompressFormat.JPEG, 80, stream);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (stream != null)
			{
				try
				{
					stream.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
		return ret;
	}
}
