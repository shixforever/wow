package com.shixforever.wow.adapter;

import java.util.ArrayList;
import java.util.HashMap;
import com.shixforever.wow.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * zhiye adapter
 * @author shixiang
 *
 */
public class GridViewAdapter extends BaseAdapter
{
	private Context context;
	private ArrayList<HashMap<String, Object>> lstImageItem;

	public GridViewAdapter(Context context, ArrayList<HashMap<String, Object>> lstImageItem)
	{
		this.context = context;
		this.lstImageItem = lstImageItem;
	}

	@Override
	public int getCount()
	{
		return lstImageItem.size();
	}

	@Override
	public Object getItem(int position)
	{
		return lstImageItem.get(position);
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
			convertView = LayoutInflater.from(context).inflate(R.layout.profession_item, null);
			holder = new ViewHolder();
			holder.tvname = (TextView) convertView.findViewById(R.id.itemText);
			holder.ivimage = (ImageView) convertView.findViewById(R.id.itemImage);
			convertView.setTag(holder);
		}
		else
		{
			holder = (ViewHolder) convertView.getTag();
		}
		holder.tvname.setText(lstImageItem.get(position).get("ItemText").toString());
		holder.ivimage.setImageResource((Integer) lstImageItem.get(position).get("ItemImage"));
		return convertView;
	}

	class ViewHolder
	{
		ImageView ivimage;
		TextView tvname;

	}
}
