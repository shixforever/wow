package com.shixforever.wow;

import android.os.Bundle;
import android.app.Activity;
import android.view.Window;

/**
 * author activity
 * @author shixiang
 *
 */
public class AboutAuthorActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_about_author);
    }
}
