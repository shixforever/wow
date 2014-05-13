package com.shixforever.wow;

import java.io.Serializable;
import java.util.List;

/**
 * zc
 * @author shixiang
 *
 */
public class Battlefield implements Serializable
{
	private static final long serialVersionUID = 1L;
	public int _id;
	public String name;
	public String introduce;
	public String tactics;
	public List<String> text;

	public Battlefield()
	{
	}

	public Battlefield(String name, String introduce, String tactics)
	{
		this.name = name;
		this.introduce = introduce;
		this.tactics = tactics;
	}

	public Battlefield(String name, String introduce, String tactics, List<String> text)
	{
		this.name = name;
		this.introduce = introduce;
		this.tactics = tactics;
		this.text = text;
	}
}
