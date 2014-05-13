package com.shixforever.wow;

import java.util.ArrayList;
import java.util.List;
import com.shixforever.wow.db.DBManager;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Window;

public class BaseViewPageActivity extends BaseActivity
{
	private ViewPager myViewPager;
	private ViewPageAdapter viewPageAdapter;
	private String[] titles;
	private DBManager mgr;
	private List<ArrayList<Skills>> allskills;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main);
		mgr = new DBManager(this);
		initView();
	}

	private void initView()
	{
		titles = getResources().getStringArray(R.array.skills);
		query();
		viewPageAdapter = new ViewPageAdapter(getSupportFragmentManager(), BaseViewPageActivity.this, allskills, titles);
		myViewPager = (ViewPager) findViewById(R.id.vPager);
		myViewPager.setAdapter(viewPageAdapter);
		myViewPager.setCurrentItem(1);
		TitlePageIndicator titleIndicator = (TitlePageIndicator) findViewById(R.id.titles);
		titleIndicator.setViewPager(myViewPager);
	}

	@Override
	protected void onDestroy()
	{
		super.onDestroy();
		mgr.closeDB();
	}

	/**
	 * 
	 * @param view
	 */
	public void query()
	{
		allskills = mgr.query(titles);
	}
}