package com.shixforever.wow;

import java.util.ArrayList;
import com.shixforever.wow.db.DBManager;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class BattlefieldDetailActivity extends Activity {
	private String battlefield;
	private DBManager mgr;
	private ArrayList<Battlefield> battlefielddetail;
	private TextView tv_introduce;
	private TextView tv_tactics;
	private RadioGroup radioGroup1;
	private RadioButton radio0;
	private RadioButton radio1;
	private ImageView iv_map;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_battlefield_detail);
		initView();
		initData();
	}

	private void initView() {
		Bundle bundle = this.getIntent().getExtras();
		if (bundle != null) {
			battlefield = bundle.getString("battlefield");
		}
		mgr = new DBManager(this);
		battlefielddetail = mgr.queryBat(battlefield);
		tv_introduce = (TextView) findViewById(R.id.tv_introduce);
		tv_tactics = (TextView) findViewById(R.id.tv_tactics);
		tv_introduce.setText(battlefielddetail.get(0).introduce);
		tv_tactics.setText(battlefielddetail.get(0).tactics);
		radioGroup1 = (RadioGroup) findViewById(R.id.radioGroup1);
		radio0 = (RadioButton) findViewById(R.id.radio0);
		radio1 = (RadioButton) findViewById(R.id.radio1);
		iv_map = (ImageView) findViewById(R.id.iv_map);
		radioGroup1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
				case R.id.radio0:
					tv_introduce.setVisibility(View.VISIBLE);
					tv_tactics.setVisibility(View.GONE);
					break;
				case R.id.radio1:
					tv_introduce.setVisibility(View.GONE);
					tv_tactics.setVisibility(View.VISIBLE);
					break;
				default:
					break;
				}
			}
		});

	}

	private void initData() {
		if (battlefield.equals("战歌峡谷")) {
			iv_map.setImageResource(R.drawable.zc_zg);
		} else if (battlefield.equals("阿拉希")) {
			iv_map.setImageResource(R.drawable.zc_alx);
		} else if (battlefield.equals("奥山")) {
			iv_map.setImageResource(R.drawable.zc_as);
		} else if (battlefield.equals("风暴之眼")) {
			iv_map.setImageResource(R.drawable.zc_fbzy);
		} else if (battlefield.equals("远古海滩")) {
			iv_map.setImageResource(R.drawable.zc_yght);
		} else if (battlefield.equals("征服之岛")) {
			iv_map.setImageResource(R.drawable.zc_zfzd);
		} else if (battlefield.equals("双子峰")) {
			iv_map.setImageResource(R.drawable.zc_szf);
		} else if (battlefield.equals("吉尔尼斯")) {
			iv_map.setImageResource(R.drawable.zc_jens);
		} else if (battlefield.equals("寇魔古寺")) {
			iv_map.setImageResource(R.drawable.zc_kmgs);
		} else if (battlefield.equals("碎银矿坑")) {
			iv_map.setImageResource(R.drawable.zc_sykk);
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		mgr.closeDB();
	}
}
