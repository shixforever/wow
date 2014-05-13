package com.shixforever.wow;

import com.shixforever.wow.util.FileTools;

import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends BaseActivity {
	private Skills skills;
	private TextView tv_count;
	private ImageView iv_skillicon;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.detail);
		Bundle bundle = this.getIntent().getExtras();
		if (bundle != null) {
			skills = (Skills) bundle.getSerializable("skill");
		}
		initView();
	}

	private void initView() {
		tv_count = (TextView) findViewById(R.id.tv_count);
		tv_count.setText(skills.info);
		iv_skillicon = (ImageView) findViewById(R.id.iv_skillicon);
		if (skills.name.equals(getResources().getString(R.string.lj))) {
			iv_skillicon.setImageResource(R.drawable.lj);
		} else if (skills.name.equals(getResources().getString(R.string.mw))) {
			iv_skillicon.setImageResource(R.drawable.mw);
		} else if (skills.name.equals(getResources()
				.getString(R.string.duanzao))) {
			iv_skillicon.setImageResource(R.drawable.duanzao);
		} else if (skills.name.equals(getResources().getString(R.string.zb))) {
			iv_skillicon.setImageResource(R.drawable.zb);
		} else if (skills.name.equals(getResources().getString(R.string.fm))) {
			iv_skillicon.setImageResource(R.drawable.fm);
		} else if (skills.name.equals(getResources().getString(R.string.gc))) {
			iv_skillicon.setImageResource(R.drawable.gc);
		} else if (skills.name.equals(getResources().getString(R.string.zp))) {
			iv_skillicon.setImageResource(R.drawable.zp);
		} else if (skills.name.equals(getResources().getString(R.string.cf))) {
			iv_skillicon.setImageResource(R.drawable.cf);
		} else if (skills.name.equals(getResources().getString(R.string.cy))) {
			iv_skillicon.setImageResource(R.drawable.cy);
		} else if (skills.name.equals(getResources().getString(R.string.ck))) {
			iv_skillicon.setImageResource(R.drawable.ck);
		} else if (skills.name.equals(getResources().getString(R.string.bp))) {
			iv_skillicon.setImageResource(R.drawable.bp);
		} else if (skills.name.equals(getResources().getString(R.string.dy))) {
			iv_skillicon.setImageResource(R.drawable.dy);
		} else if (skills.name.equals(getResources().getString(R.string.pr))) {
			iv_skillicon.setImageResource(R.drawable.pr);
		} else if (skills.name.equals(getResources().getString(R.string.kg))) {
			iv_skillicon.setImageResource(R.drawable.kg);
		} else if (skills.name.equals(getResources().getString(R.string.jj))) {
			iv_skillicon.setImageResource(R.drawable.jj);
		}
		if (skills.picflag.equals("0")) {

		} else {
			iv_skillicon.setImageResource(FileTools.getResource(
					DetailActivity.this, skills.picflag.toString()));
		}
	}
}
