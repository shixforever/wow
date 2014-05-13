package com.shixforever.wow.adapter;

import com.aphidmobile.utils.AphidLog;
import com.aphidmobile.utils.IO;
import com.aphidmobile.utils.UI;
import com.shixforever.wow.DeceptionActivity;
import com.shixforever.wow.R;
import com.shixforever.wow.WowerActivity;
import com.shixforever.wow.module.Travels;
import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class TravelAdapter extends BaseAdapter {
	private LayoutInflater inflater;

	private int repeatCount = 1;
	private Context context;

	public TravelAdapter(Context context) {
		inflater = LayoutInflater.from(context);
		this.context = context;
	}

	@Override
	public int getCount() {
		return 2 * repeatCount;
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		View layout = convertView;
		if (convertView == null) {
			layout = inflater.inflate(R.layout.item_view, null);
			AphidLog.d("created new view from adapter: %d", position);
		}
		final Travels.Data data = Travels.IMG_DESCRIPTIONS.get(position
				% Travels.IMG_DESCRIPTIONS.size());
		UI.<TextView> findViewById(layout, R.id.title).setText(
				AphidLog.format("%s", data.title));

		UI.<ImageView> findViewById(layout, R.id.photo).setImageBitmap(
				IO.readBitmap(inflater.getContext().getAssets(),
						data.imageFilename));

		UI.<TextView> findViewById(layout, R.id.description).setText(
				Html.fromHtml(data.description));

		UI.<Button> findViewById(layout, R.id.wikipedia).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						if (position == 0) {
							Intent intent = new Intent(context,
									WowerActivity.class);
							// Bundle bundle = new Bundle();
							// bundle.putString("profession", (String)
							// item.get("ItemText"));
							// intent.putExtras(bundle);
							context.startActivity(intent);
						}
						if (position == 1) {
							Intent intent = new Intent(context,
									DeceptionActivity.class);
							// Bundle bundle = new Bundle();
							// bundle.putString("profession", (String)
							// item.get("ItemText"));
							// intent.putExtras(bundle);
							context.startActivity(intent);
						}
					}
				});
		return layout;
	}

	public int getRepeatCount() {
		return repeatCount;
	}

	public void setRepeatCount(int repeatCount) {
		this.repeatCount = repeatCount;
	}
}
