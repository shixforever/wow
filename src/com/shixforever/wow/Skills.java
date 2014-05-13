package com.shixforever.wow;
import java.io.Serializable;
import java.util.List;

public class Skills implements Serializable
{
	private static final long serialVersionUID = 1L;
	public int _id;
	public String name;
	public String age;
	public String info;
	public String introduce;
	public String picflag;
	public List<String> text;
	public Skills()
	{
		
	}
	public Skills(String name, String age, String info)
	{
		this.name = name;
		this.age = age;
		this.info = info;
	}
	public Skills(String name, String age, String info,List<String> text)
	{
		this.name = name;
		this.age = age;
		this.info = info;
		this.text=text;
	}
}