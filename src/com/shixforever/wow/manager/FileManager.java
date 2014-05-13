package com.shixforever.wow.manager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import com.shixforever.wow.module.Files;
import com.shixforever.wow.module.Module;
import com.shixforever.wow.util.FusionField;

import android.os.Environment;

/**********************************************************
 * @文件名称：FileManager.java
 * @文件作者：xiongjiangwei
 * @创建时间：2013-1-14 上午09:19:29
 * @文件描述：文件管理
 * @修改历史：2013-1-14创建初始版本
 **********************************************************/
public class FileManager
{
	public static final String DATABASE_NAME = "wow.db";
	private static final String SYS_DATABASE_PATH = "/data/data/" + FusionField.baseActivity.getPackageName()
			+ "/databases/";
	private static FileManager manager = null;
	public static final String IMAGE_SDCARD_PATH = Environment.getExternalStorageDirectory() + "/focustech/typ/image/";

	private FileManager()
	{

	}

	public static FileManager getInstance()
	{
		if (manager == null)
		{
			manager = new FileManager();
		}
		return manager;
	}

	/**
	 * 复制assets目录下的数据库文件到系统文件夹下
	 */
	public void moveToSystemDatabaseDir(CopyFileListener copy)
	{
		if (isFileExists(SYS_DATABASE_PATH + DATABASE_NAME))
		{
			copy.onCopyFinish();
			return;
		}
		InputStream is = null;
		FileOutputStream fos = null;
		try
		{
			int byteRead = 0;
			is = FusionField.baseActivity.getAssets().open(DATABASE_NAME);
			File file = new File(SYS_DATABASE_PATH);
			if (!file.exists())
			{
				file.mkdirs();
			}
			File file1 = new File(SYS_DATABASE_PATH + DATABASE_NAME);
			if (!file1.exists())
			{
				file1.createNewFile();
			}
			byte[] b = new byte[1024];
			fos = new FileOutputStream(SYS_DATABASE_PATH + DATABASE_NAME);
			while ((byteRead = is.read(b)) != -1)
			{
				fos.write(b, 0, byteRead);
			}
			copy.onCopyFinish();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (is != null)
				{
					is.close();
				}
				if (fos != null)
				{
					fos.close();
				}
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}

	/**
	 * 复制数据库中所有的文件到sdcard中，避免重复读取数据库
	 * @param filesList
	 * @param copy
	 * @return
	 */
	public boolean copyAllFilesToSDCard(ArrayList<Module> filesList, CopyFileListener copy)
	{
		boolean isCopyFinish = false;
		Files file;
		for (int i = 0; i < filesList.size(); i++)
		{
			file = (Files) filesList.get(i);
			copyAllFilesToSDCard(file.key);
			if (file.key.equals(((Files) filesList.get(filesList.size() - 1)).key))
			{
				copy.onCopyFinish();
			}
		}
		return isCopyFinish;
	}

	/**
	 * 复制单个文件到sdcard中
	 * @param key
	 */
	public void copyAllFilesToSDCard(String key)
	{
		// FileOutputStream fos = null;
		// try
		// {
		// File file = new File(IMAGE_SDCARD_PATH);
		// if (!file.exists())
		// {
		// file.mkdirs();
		// }
		// File file1 = new File(IMAGE_SDCARD_PATH + key);
		// if (!file1.exists() && file1.getTotalSpace() == 0)
		// {
		// file1.createNewFile();
		// }
		// else
		// {
		// return;
		// }
		// byte[] b = DataManager.getInstance().getImageByteByKey(key);
		// fos = new FileOutputStream(IMAGE_SDCARD_PATH + key);
		// fos.write(b);
		// }
		// catch (IOException e)
		// {
		// e.printStackTrace();
		// }
		// finally
		// {
		// try
		// {
		// if (fos != null)
		// {
		// fos.close();
		// }
		// }
		// catch (IOException e)
		// {
		// e.printStackTrace();
		// }
		// }
	}

	/**
	 * 文件是否存在
	 * @param filePath
	 * @return
	 */
	public boolean isFileExists(String filePath)
	{
		// File file = new File(filePath);
		// if (file.exists() && file.getTotalSpace() != 0)
		// {
		// return true;
		// }
		return false;
	}

}
