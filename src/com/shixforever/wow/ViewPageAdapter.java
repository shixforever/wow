package com.shixforever.wow;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPageAdapter extends FragmentPagerAdapter implements
		IconPagerAdapter {
	private Context context;
	private List<ArrayList<Skills>> urList;
	protected static String[] titles;
	protected static final int[] ICONS = new int[] {};
	
	public ViewPageAdapter(FragmentManager fm, Context context,
			List<ArrayList<Skills>> urList, String[] CONTENT) {
		super(fm);
		this.context = context;
		this.urList = urList;
		this.titles = CONTENT;
	}
	
	@Override
	public Fragment getItem(int position) {
		return MyFragment.newInstance(titles[position % titles.length], position,
				context, urList.get(position));
	}
	
	@Override
	public int getCount() {
		return urList.size();
	}
	
	@Override
	public CharSequence getPageTitle(int position) {
		return ViewPageAdapter.titles[position % titles.length];
	}
	
	@Override
	public int getIconResId(int index) {
		return ICONS[index % ICONS.length];
	}
}
