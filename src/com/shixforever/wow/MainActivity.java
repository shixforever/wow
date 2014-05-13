package com.shixforever.wow;

import com.aphidmobile.flip.FlipViewController;
import com.shixforever.wow.adapter.TravelAdapter;
import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class MainActivity extends Activity {
	private FlipViewController flipView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		flipView = new FlipViewController(this, FlipViewController.HORIZONTAL);
		flipView.setAdapter(new TravelAdapter(this));
		setContentView(flipView);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		flipView.onResume();
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		flipView.onPause();
	}
}