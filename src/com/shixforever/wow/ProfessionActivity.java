package com.shixforever.wow;

import java.util.ArrayList;
import java.util.HashMap;
import com.shixforever.wow.adapter.GridViewAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

/**
 * ȫְҵ����
 * @author shixiang
 *
 */
public class ProfessionActivity extends BaseActivity
{
	private GridView gv_profession;
	private int[] image;
	private String[] text;
	private GridViewAdapter gridViewAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.profession_view);
		initView();
	}

	private void initView()
	{
		gv_profession = (GridView) findViewById(R.id.gv_profession);
		text = getResources().getStringArray(R.array.professions);
		ArrayList<HashMap<String, Object>> lstImageItem = new ArrayList<HashMap<String, Object>>();
		for (int i = 0; i < 11; i++)
		{
			HashMap<String, Object> map = new HashMap<String, Object>();
			if (text[i].equals(getResources().getString(R.string.fs)))
			{
				map.put("ItemImage", R.drawable.fs2);//
			}
			else if (text[i].equals(getResources().getString(R.string.zs)))
			{
				map.put("ItemImage", R.drawable.zs2);// ���ͼ����Դ��ID
			}
			else if (text[i].equals(getResources().getString(R.string.qs)))
			{
				map.put("ItemImage", R.drawable.qs2);// ���ͼ����Դ��ID
			}
			else if (text[i].equals(getResources().getString(R.string.dk)))
			{
				map.put("ItemImage", R.drawable.dk2);// ���ͼ����Դ��ID
			}
			else if (text[i].equals(getResources().getString(R.string.ws)))
			{
				map.put("ItemImage", R.drawable.ws);// ���ͼ����Դ��ID
			}
			else if (text[i].equals(getResources().getString(R.string.sm)))
			{
				map.put("ItemImage", R.drawable.sm2);// ���ͼ����Դ��ID
			}
			else if (text[i].equals(getResources().getString(R.string.xd)))
			{
				map.put("ItemImage", R.drawable.xd2);// ���ͼ����Դ��ID
			}
			else if (text[i].equals(getResources().getString(R.string.ms)))
			{
				map.put("ItemImage", R.drawable.ms2);// ���ͼ����Դ��ID
			}
			else if (text[i].equals(getResources().getString(R.string.dz)))
			{
				map.put("ItemImage", R.drawable.dz2);// ���ͼ����Դ��ID
			}
			else if (text[i].equals(getResources().getString(R.string.lr)))
			{
				map.put("ItemImage", R.drawable.lr2);// ���ͼ����Դ��ID
			}
			else if (text[i].equals(getResources().getString(R.string.ss)))
			{
				map.put("ItemImage", R.drawable.ss2);// ���ͼ����Դ��ID
			}
			map.put("ItemText", text[i]);//
			lstImageItem.add(map);
		}
		gridViewAdapter = new GridViewAdapter(this, lstImageItem);
		gv_profession.setAdapter(gridViewAdapter);
		gv_profession.setOnItemClickListener(new ItemClickListener());
	}

	class ItemClickListener implements OnItemClickListener
	{
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3)
		{
			HashMap<String, Object> item = (HashMap<String, Object>) arg0.getItemAtPosition(arg2);
			Intent intent = new Intent(ProfessionActivity.this, ProfessionDetailActivity.class);
			Bundle bundle = new Bundle();
			bundle.putString("profession", (String) item.get("ItemText"));
			intent.putExtras(bundle);
			ProfessionActivity.this.startActivity(intent);
		}
	}
}
