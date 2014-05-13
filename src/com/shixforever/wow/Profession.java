package com.shixforever.wow;

import java.io.Serializable;
import java.util.List;

public class Profession implements Serializable
{
	private static final long serialVersionUID = 1L;
	public int _id;
	public String name;
	public String introduce;
	public String pvp;
	public String pve;
	public List<String> text;

	public Profession()
	{
	}

	public Profession(String name, String introduce, String pvp, String pve)
	{
		this.name = name;
		this.introduce = introduce;
		this.pvp = pvp;
		this.pve = pve;
	}

	public Profession(String name, String introduce, String pvp, String pve, List<String> text)
	{
		this.name = name;
		this.introduce = introduce;
		this.pvp = pvp;
		this.pve = pve;
		this.text = text;
	}
}
