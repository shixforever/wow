package com.shixforever.wow;

import net.youmi.android.YoumiAdManager;
import net.youmi.android.banner.AdSize;
import net.youmi.android.banner.AdView;
import net.youmi.android.spot.SpotManager;
import com.shixforever.wow.manager.CopyFileListener;
import com.shixforever.wow.manager.FileManager;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

/**********************************************************
 * LoadingActivity.java
 **********************************************************/
public class LoadingActivity extends BaseActivity implements OnClickListener {
	private Button bt_business;
	private Button bt_profession;
	private Button bt_battlefield;
	private Button bt_aboutauthor;
	private Button bt_more;
	private long mExitTime;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.loading);
		initView();
		mHandler.sendEmptyMessage(0);
		YoumiAdManager.getInstance(this).init("3d97604be3542f82",
				"58b793aecd77bdfa", false);
		SpotManager.getInstance(LoadingActivity.this).showSpotAds(
				LoadingActivity.this);
		//
		LinearLayout adLayout = (LinearLayout) findViewById(R.id.adLayout);
		AdView adView = new AdView(this, AdSize.SIZE_320x50);
		adLayout.addView(adView);
		SpotManager.getInstance(this).loadSpotAds();
	}

	private void initView() {
		bt_business = (Button) findViewById(R.id.bt_business);
		bt_business.setOnClickListener(this);
		bt_profession = (Button) findViewById(R.id.bt_profession);
		bt_profession.setOnClickListener(this);
		bt_battlefield = (Button) findViewById(R.id.bt_battlefield);
		bt_battlefield.setOnClickListener(this);
		bt_aboutauthor = (Button) findViewById(R.id.bt_aboutauthor);
		bt_aboutauthor.setOnClickListener(this);
		bt_more = (Button) findViewById(R.id.bt_more);
		bt_more.setOnClickListener(this);
	}

	private Thread copyDbThread = new Thread() {
		public void run() {
			FileManager.getInstance().moveToSystemDatabaseDir(copyDB);
		};
	};

	// private Thread thread = new Thread()
	// {
	// public void run()
	// {
	// FileManager.getInstance().copyAllFilesToSDCard(dataManager.getAllFiles(),
	// copyFiles);
	// };
	// };

	private Handler mHandler = new Handler() {
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case 0:
				copyDbThread.start();
				break;
			case 1:
				// startActivity(new Intent(LoadingActivity.this,
				// BaseViewPageActivity.class));
				// finish();
				// Toast.makeText(LoadingActivity.this, R.string.copy_finish,
				// Toast.LENGTH_LONG).show();
				break;
			}
		};
	};

	private CopyFileListener copyDB = new CopyFileListener() {
		@Override
		public void onCopyFinish() {
			mHandler.sendEmptyMessage(1);
		}
	};

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bt_business:
			startActivity(new Intent(LoadingActivity.this,
					BaseViewPageActivity.class));
			break;
		case R.id.bt_profession:
			startActivity(new Intent(LoadingActivity.this,
					ProfessionActivity.class));
			break;
		case R.id.bt_battlefield:
			startActivity(new Intent(LoadingActivity.this,
					BattlefieldActivity.class));
			break;
		case R.id.bt_aboutauthor:
			startActivity(new Intent(LoadingActivity.this,
					AboutAuthorActivity.class));
			break;
		case R.id.bt_more:
			startActivity(new Intent(LoadingActivity.this, MainActivity.class));
			break;
		default:
			break;
		}
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {

			// closeDialog();
			if ((System.currentTimeMillis() - mExitTime) > 2000) {
				Object mHelperUtils;
				Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
				mExitTime = System.currentTimeMillis();
			} else {

				finish();
			}
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	// 退出dialog
	protected void closeDialog() {
		AlertDialog.Builder builder = new Builder(LoadingActivity.this);
		builder.setMessage(R.string.log_out_msg);
		builder.setTitle(R.string.log_out_title);
		builder.setPositiveButton(R.string.positivebutton,
				new android.content.DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
						LoadingActivity.this.finish();
					}
				});
		builder.setNegativeButton(R.string.negativebutton,
				new android.content.DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
					}
				});
		builder.create().show();
	}
	// private CopyFileListener copyFiles = new CopyFileListener()
	// {
	// @Override
	// public void onCopyFinish()
	// {
	// mHandler.sendEmptyMessage(2);
	// }
	// };
}
