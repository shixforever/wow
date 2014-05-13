package com.shixforever.wow;

import java.util.ArrayList;
import java.util.HashMap;
import com.shixforever.wow.adapter.GridViewAdapter;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.AdapterView.OnItemClickListener;

/**
 * zhanchang
 * @author shixiang
 *
 */
public class BattlefieldActivity extends Activity
{
	private GridView gv_battlefield;
	private GridViewAdapter gridViewAdapter;
	private int[] image;
	private String[] text;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_battlefield);
		initView();
	}

	private void initView()
	{
		gv_battlefield = (GridView) findViewById(R.id.gv_battlefield);
		text = getResources().getStringArray(R.array.battlefields);
		ArrayList<HashMap<String, Object>> lstImageItem = new ArrayList<HashMap<String, Object>>();
		for (int i = 0; i < text.length; i++)
		{
			HashMap<String, Object> map = new HashMap<String, Object>();
			if (text[i].equals(getResources().getString(R.string.zgxg)))
			{
				map.put("ItemImage", R.drawable.zg);//
			}
			else if (text[i].equals(getResources().getString(R.string.alx)))
			{
				map.put("ItemImage", R.drawable.alx);// ���ͼ����Դ��ID
			}
			else if (text[i].equals(getResources().getString(R.string.fbzy)))
			{
				map.put("ItemImage", R.drawable.fbzy);// ���ͼ����Դ��ID
			}
			else if (text[i].equals(getResources().getString(R.string.yght)))
			{
				map.put("ItemImage", R.drawable.yght);// ���ͼ����Դ��ID
			}
			else if (text[i].equals(getResources().getString(R.string.zfzd)))
			{
				map.put("ItemImage", R.drawable.zfzd);// ���ͼ����Դ��ID
			}
			else if (text[i].equals(getResources().getString(R.string.szf)))
			{
				map.put("ItemImage", R.drawable.szf);// ���ͼ����Դ��ID
			}
			else if (text[i].equals(getResources().getString(R.string.jens)))
			{
				map.put("ItemImage", R.drawable.jens);// ���ͼ����Դ��ID
			}
			else if (text[i].equals(getResources().getString(R.string.kmgs)))
			{
				map.put("ItemImage", R.drawable.kmgs);// ���ͼ����Դ��ID
			}
			else if (text[i].equals(getResources().getString(R.string.sykk)))
			{
				map.put("ItemImage", R.drawable.sykk);// ���ͼ����Դ��ID
			}
			else if (text[i].equals(getResources().getString(R.string.as)))
			{
				map.put("ItemImage", R.drawable.as);// ���ͼ����Դ��ID
			}
			map.put("ItemText", text[i]);
			lstImageItem.add(map);
		}
		gridViewAdapter = new GridViewAdapter(this, lstImageItem);
		gv_battlefield.setAdapter(gridViewAdapter);
		gv_battlefield.setOnItemClickListener(new ItemClickListener());
	}
	
	class ItemClickListener implements OnItemClickListener
	{
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3)
		{
			HashMap<String, Object> item = (HashMap<String, Object>) arg0.getItemAtPosition(arg2);
			Intent intent = new Intent(BattlefieldActivity.this, BattlefieldDetailActivity.class);
			Bundle bundle = new Bundle();
			bundle.putString("battlefield", (String) item.get("ItemText"));
			intent.putExtras(bundle);
			BattlefieldActivity.this.startActivity(intent);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		getMenuInflater().inflate(R.menu.activity_battlefield, menu);
		return true;
	}

}
