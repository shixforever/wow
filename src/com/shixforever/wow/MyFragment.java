package com.shixforever.wow;

import java.util.ArrayList;

import com.shixforever.wow.adapter.InfoAdapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;

public class MyFragment extends Fragment implements OnItemSelectedListener, OnItemClickListener, OnClickListener
{
	private int position;
	private ArrayList<Skills> skill;
	private InfoAdapter infoAdapter;
	private Context context;

	public static MyFragment newInstance(String content, int position, Context context, ArrayList<Skills> skill)
	{
		MyFragment fragment = new MyFragment();
		fragment.position = position;
		fragment.skill = skill;
		fragment.context = context;
		return fragment;
	}

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View v = null;
		View v2 = null;
		v = LayoutInflater.from(this.getActivity()).inflate(R.layout.page_pic, null);
		v2 = LayoutInflater.from(this.getActivity()).inflate(R.layout.head, null);
		ListView lv = (ListView) v.findViewById(R.id.lvinfo);
		lv.addHeaderView(v2);
		TextView tv_test = (TextView) v2.findViewById(R.id.tv_test);
		ImageView iv_skillicon = (ImageView) v2.findViewById(R.id.iv_skillicon);
		tv_test.setText(skill.get(0).introduce);
		if (skill.get(0).name.equals(getResources().getString(R.string.lj)))
		{
			iv_skillicon.setImageResource(R.drawable.lj);
		}
		else if (skill.get(0).name.equals(getResources().getString(R.string.mw)))
		{
			iv_skillicon.setImageResource(R.drawable.mw);
		}
		else if (skill.get(0).name.equals(getResources().getString(R.string.duanzao)))
		{
			iv_skillicon.setImageResource(R.drawable.duanzao);
		}
		else if (skill.get(0).name.equals(getResources().getString(R.string.zb)))
		{
			iv_skillicon.setImageResource(R.drawable.zb);
		}
		else if (skill.get(0).name.equals(getResources().getString(R.string.fm)))
		{
			iv_skillicon.setImageResource(R.drawable.fm);
		}
		else if (skill.get(0).name.equals(getResources().getString(R.string.gc)))
		{
			iv_skillicon.setImageResource(R.drawable.gc);
		}
		else if (skill.get(0).name.equals(getResources().getString(R.string.zp)))
		{
			iv_skillicon.setImageResource(R.drawable.zp);
		}
		else if (skill.get(0).name.equals(getResources().getString(R.string.cf)))
		{
			iv_skillicon.setImageResource(R.drawable.cf);
		}
		else if (skill.get(0).name.equals(getResources().getString(R.string.cy)))
		{
			iv_skillicon.setImageResource(R.drawable.cy);
		}
		else if (skill.get(0).name.equals(getResources().getString(R.string.ck)))
		{
			iv_skillicon.setImageResource(R.drawable.ck);
		}
		else if (skill.get(0).name.equals(getResources().getString(R.string.bp)))
		{
			iv_skillicon.setImageResource(R.drawable.bp);
		}
		else if (skill.get(0).name.equals(getResources().getString(R.string.dy)))
		{
			iv_skillicon.setImageResource(R.drawable.dy);
		}
		else if (skill.get(0).name.equals(getResources().getString(R.string.pr)))
		{
			iv_skillicon.setImageResource(R.drawable.pr);
		}
		else if (skill.get(0).name.equals(getResources().getString(R.string.kg)))
		{
			iv_skillicon.setImageResource(R.drawable.kg);
		}
		else if (skill.get(0).name.equals(getResources().getString(R.string.jj)))
		{
			iv_skillicon.setImageResource(R.drawable.jj);
		}
		infoAdapter = new InfoAdapter(context, skill);
		lv.setAdapter(infoAdapter);
		lv.setOnItemClickListener(new OnItemClickListener()
		{
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id)
			{
				if (position > 0)
				{
					Intent intent = new Intent(context, DetailActivity.class);
					Bundle bundle = new Bundle();
					bundle.putSerializable("skill", skill.get(position - 1));
					intent.putExtras(bundle);
					context.startActivity(intent);
				}
			}
		});
		return v;
	}

	@Override
	public void onClick(View v)
	{

	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id)
	{

	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
	{

	}

	@Override
	public void onNothingSelected(AdapterView<?> parent)
	{

	}

}
