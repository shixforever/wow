package com.shixforever.wow.db;

import java.util.ArrayList;
import java.util.List;

import com.shixforever.wow.Battlefield;
import com.shixforever.wow.Profession;
import com.shixforever.wow.Skills;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DBManager
{
	private DBHelper helper;
	private SQLiteDatabase db;
	private static final String DATABASE_NAME = "wow.db";
	private static final int DATABASE_VERSION = 1;

	public DBManager(Context context)
	{
		helper = new DBHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
		// ��ΪgetWritableDatabase�ڲ�������mContext.openOrCreateDatabase(mName, 0, mFactory);
		// ����Ҫȷ��context�ѳ�ʼ��,���ǿ��԰�ʵ��DBManager�Ĳ������Activity��onCreate��
		db = helper.getWritableDatabase();
	}

	/**
	 * add persons
	 * @param persons
	 */
	public void add(List<Skills> persons)
	{
		db.beginTransaction(); // ��ʼ����
		try
		{
			for (Skills person : persons)
			{
				db.execSQL("INSERT INTO wowskill VALUES(null, ?, ?, ?)", new Object[]
				{ person.name, person.age, person.info });
			}
			db.setTransactionSuccessful(); // ��������ɹ����
		}
		finally
		{
			db.endTransaction(); // ��������
		}
	}

	/**
	 * update person's age
	 * @param person
	 */
	public void updateAge(Skills person)
	{
		ContentValues cv = new ContentValues();
		cv.put("age", person.age);
		db.update("wowskill", cv, "name = ?", new String[]
		{ person.name });
	}

	/**
	 * delete old person
	 * @param person
	 */
	public void deleteOldPerson(Skills person)
	{
		db.delete("wowskill", "age >= ?", new String[]
		{ String.valueOf(person.age) });
	}

	/**
	 * 
	 * query all persons, return list
	 * @return List<Person>
	 */
	public List<ArrayList<Skills>> query(String[] titles)
	{
		List<ArrayList<Skills>> allskills = new ArrayList<ArrayList<Skills>>();
		for (int i = 0; i < titles.length; i++)
		{
			ArrayList<Skills> persons = new ArrayList<Skills>();
			Cursor c = queryTheCursor("wowskill", titles[i]);
			while (c.moveToNext())
			{
				Skills person = new Skills();
				person._id = c.getInt(c.getColumnIndex("_id"));
				person.name = c.getString(c.getColumnIndex("name"));
				person.age = c.getString(c.getColumnIndex("age"));
				person.info = c.getString(c.getColumnIndex("info"));
				person.introduce = c.getString(c.getColumnIndex("introduce"));
				person.picflag=c.getString(c.getColumnIndex("picflag"));
				persons.add(person);
			}
			c.close();
			allskills.add(persons);
		}
		return allskills;
	}

	/**
	 * 
	 * query all persons, return list
	 * @return List<Person>
	 */
	public ArrayList<Profession> queryPro(String name)
	{
		// List<Profession> professions = new ArrayList<Profession>();
		ArrayList<Profession> persons = new ArrayList<Profession>();
		Cursor c = queryTheCursor("profession", name);
		while (c.moveToNext())
		{
			Profession person = new Profession();
			person._id = c.getInt(c.getColumnIndex("_id"));
			person.name = c.getString(c.getColumnIndex("name"));
			person.introduce = c.getString(c.getColumnIndex("introduce"));
			person.pvp = c.getString(c.getColumnIndex("pvp"));
			person.pve = c.getString(c.getColumnIndex("pve"));
			persons.add(person);
		}
		c.close();
		return persons;
	}

	/**
	 * 
	 * query all persons, return list
	 * @return List<Person>
	 */
	public ArrayList<Battlefield> queryBat(String name)
	{
		ArrayList<Battlefield> battlefields = new ArrayList<Battlefield>();
		Cursor c = queryTheCursor("battlefield", name);
		while (c.moveToNext())
		{
			Battlefield battlefield = new Battlefield();
			battlefield._id = c.getInt(c.getColumnIndex("_id"));
			battlefield.name = c.getString(c.getColumnIndex("name"));
			battlefield.introduce = c.getString(c.getColumnIndex("introduce"));
			battlefield.tactics = c.getString(c.getColumnIndex("tactics"));
			battlefields.add(battlefield);
		}
		c.close();
		return battlefields;
	}

	/**
	 * 
	 * query all persons, return cursor
	 * @return	Cursor
	 */
	public Cursor queryTheCursor(String table, String name)
	{
		Cursor c = db.rawQuery("SELECT * FROM " + table + " where name ='" + name + "'", null);
		return c;
	}

	/**
	 * close database
	 */
	public void closeDB()
	{
		db.close();
	}

}
