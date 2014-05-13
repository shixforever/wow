package com.shixforever.wow.adapter;

import java.util.ArrayList;

import com.shixforever.wow.R;
import com.shixforever.wow.Skills;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class InfoAdapter extends BaseAdapter
{
	private Context context;
	private ArrayList<Skills> skills;

	public InfoAdapter(Context context, ArrayList<Skills> skills)
	{
		this.context = context;
		this.skills = skills;
	}
	
	@Override
	public int getCount()
	{
		return skills.size();
	}

	@Override
	public Object getItem(int position)
	{
		return skills.get(position);
	}

	@Override
	public long getItemId(int position)
	{
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		ViewHolder holder;
		if (convertView == null)
		{
			convertView= LayoutInflater.from(context).inflate(R.layout.infoitem, null);
			holder= new ViewHolder();
			holder.tvname= (TextView) convertView.findViewById(R.id.tvlv);
			convertView.setTag(holder);
		}
		else
		{
			holder= (ViewHolder) convertView.getTag();
		}
		System.out.println(skills.get(position).age+"================");
		holder.tvname.setText(skills.get(position).age);
		return convertView;
	}

	class ViewHolder
	{
		TextView tvname;
	}
}
