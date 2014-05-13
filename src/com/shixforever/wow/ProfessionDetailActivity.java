package com.shixforever.wow;

import java.util.ArrayList;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.ScrollView;
import android.widget.TextView;
import com.shixforever.wow.R;
import com.shixforever.wow.db.DBManager;

/**
 * @author shixiang
 * 
 */
public class ProfessionDetailActivity extends BaseActivity implements
		OnClickListener {
	private String profession;
	private ArrayList<Profession> professiondetail;
	private DBManager mgr;
	private TextView tv_introduce;
	private TextView tv_pvp;
	private TextView tv_pve;
	private RadioButton radio0;
	private RadioButton radio1;
	private RadioButton radio2;
	private RadioGroup radioGroup1;
	private TextView tv_ilike;
	private ImageView iv_pro;
	private ScrollView sv_all;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.profession_detail);
		initView();
		initData();
	}

	private void initView() {
		Bundle bundle = this.getIntent().getExtras();
		if (bundle != null) {
			profession = bundle.getString("profession");
		}
		mgr = new DBManager(this);
		professiondetail = mgr.queryPro(profession);
		tv_introduce = (TextView) findViewById(R.id.tv_introduce);
		tv_pvp = (TextView) findViewById(R.id.tv_pvp);
		tv_pve = (TextView) findViewById(R.id.tv_pve);
		tv_introduce.setText(professiondetail.get(0).introduce);
		tv_pvp.setText(professiondetail.get(0).pvp);
		tv_pve.setText(professiondetail.get(0).pve);
		radioGroup1 = (RadioGroup) findViewById(R.id.radioGroup1);
		radio0 = (RadioButton) findViewById(R.id.radio0);
		radio1 = (RadioButton) findViewById(R.id.radio1);
		radio2 = (RadioButton) findViewById(R.id.radio2);
		tv_ilike = (TextView) findViewById(R.id.tv_ilike);
		iv_pro = (ImageView) findViewById(R.id.iv_pro);
		sv_all=(ScrollView) findViewById(R.id.sv_all);
		radioGroup1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
				case R.id.radio0:
					tv_introduce.setVisibility(View.VISIBLE);
					tv_pvp.setVisibility(View.GONE);
					tv_pve.setVisibility(View.GONE);
					sv_all.smoothScrollTo(0, 0);
					break;
				case R.id.radio1:
					tv_introduce.setVisibility(View.GONE);
					tv_pvp.setVisibility(View.VISIBLE);
					tv_pve.setVisibility(View.GONE);
					sv_all.smoothScrollTo(0, 0);
					break;
				case R.id.radio2:
					tv_introduce.setVisibility(View.GONE);
					tv_pvp.setVisibility(View.GONE);
					tv_pve.setVisibility(View.VISIBLE);
					sv_all.smoothScrollTo(0, 0);
					break;
				default:
					break;
				}
			}
		});
	}

	private void initData() {
		if (professiondetail.get(0).name.equals("法师")) {
			radio0.setText("职业介绍");
			radio1.setText("PVP心的");
			radio2.setText("输出循环");
			tv_ilike.setText("法爷威武");
			iv_pro.setImageResource(R.drawable.fs);
		} else if (professiondetail.get(0).name.equals("战士")) {
			radio0.setText("我叫MT");
			radio1.setText("战斗PVP");
			radio2.setText("武器输出");
			tv_ilike.setText("天堂在左 战士向右");
			iv_pro.setImageResource(R.drawable.zs);
		} else if (professiondetail.get(0).name.equals("骑士")) {
			radio0.setText("奶奶奶骑");
			radio1.setText("惩戒骑");
			radio2.setText("防骑");
			tv_ilike.setText("我们是圣骑士，不要让仇恨蒙蔽了我们的双眼。——乌萨尔");
			iv_pro.setImageResource(R.drawable.qs);
		} else if (professiondetail.get(0).name.equals("死亡骑士")) {
			radio0.setText("血DK");
			radio1.setText("邪DK");
			radio2.setText("冰DK");
			tv_ilike.setText("我的眼前只有一片黑暗!");
			iv_pro.setImageResource(R.drawable.dk);
		} else if (professiondetail.get(0).name.equals("武僧")) {
			radio0.setText("踏风步法");
			radio1.setText("青龙之赐");
			radio2.setText("醉拳大师");
			tv_ilike.setText("酒酒酒酒酒酒酒");
			iv_pro.setImageResource(R.drawable.ws);
		} else if (professiondetail.get(0).name.equals("萨满")) {
			radio0.setText("元素萨");
			radio1.setText("增强萨");
			radio2.setText("奶萨");
			tv_ilike.setText("元素之力");
			iv_pro.setImageResource(R.drawable.sm);
		} else if (professiondetail.get(0).name.equals("小D")) {
			radio0.setText("平衡德");
			radio1.setText("野德");
			radio2.setText("熊德");
			tv_ilike.setText("会卖萌，求包养");
			iv_pro.setImageResource(R.drawable.xd);
		} else if (professiondetail.get(0).name.equals("牧师")) {
			radio0.setText("神牧");
			radio1.setText("戒律牧");
			radio2.setText("暗牧");
			tv_ilike.setText("一个成功的奶身后总有一地坟包");
			iv_pro.setImageResource(R.drawable.ms);
		}else if (professiondetail.get(0).name.equals("盗贼")) {
			radio0.setText("刺杀");
			radio1.setText("战斗");
			radio2.setText("敏锐");
			tv_ilike.setText("我是盗贼不是什么潜行者");
			iv_pro.setImageResource(R.drawable.dz);
		}else if (professiondetail.get(0).name.equals("猎人")) {
			radio0.setText("射击");
			radio1.setText("兽王");
			radio2.setText("生存");
			tv_ilike.setText("LR什么的最讨厌了(见面就被啪啪啪射死了XD)");
			iv_pro.setImageResource(R.drawable.lr);
		}else if (professiondetail.get(0).name.equals("术士")) {
			radio0.setText("痛苦");
			radio1.setText("毁灭");
			radio2.setText("恶魔");
			tv_ilike.setText("你们这是自寻死路～");
			iv_pro.setImageResource(R.drawable.ss);
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		mgr.closeDB();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}
}
