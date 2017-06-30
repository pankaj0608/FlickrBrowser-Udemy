package com.example.pankaj.flickrbrowser;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by pankaj on 6/30/2017.
 */
public class BaseActivity extends AppCompatActivity {

    private Toolbar mToolBar;

    protected Toolbar activateToolbar() {
        if(mToolBar == null) {
            mToolBar = (Toolbar) findViewById(R.id.app_bar);

            if(mToolBar != null) {
                setSupportActionBar(mToolBar);
            }
        }

        return mToolBar;
    }
}
