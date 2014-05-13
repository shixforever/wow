package com.shixforever.wow;

import android.os.Bundle;
import android.app.Activity;
import android.view.Window;

/**
 * 防骗
 * @author shixiang
 *	2013/3/5
 */
public class DeceptionActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_deception);
    }
}
