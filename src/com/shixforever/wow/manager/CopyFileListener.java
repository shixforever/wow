package com.shixforever.wow.manager;

/**********************************************************
 * @文件名称：CopyFileListener.java
 * @文件作者：xiongjiangwei
 * @创建时间：2013-1-16 下午02:27:33
 * @文件描述：文件复制完成回调
 * @修改历史：2013-1-16创建初始版本
 **********************************************************/
public interface CopyFileListener
{
	/**
	 * 所有图片都成功复制到sdcard的回调
	 */
	public void onCopyFinish();
}
