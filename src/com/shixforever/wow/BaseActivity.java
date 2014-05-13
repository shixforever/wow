package com.shixforever.wow;


import com.shixforever.wow.util.FusionField;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class BaseActivity extends FragmentActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		FusionField.baseActivity = this;
	}
	
}
