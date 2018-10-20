package com.deepak.basic;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.android.alerts.FullScreenPicture;
import com.deepak.basicmodule.Base.BaseActivity;


/**
 * Created by deepak.mittal on 5/10/2018.
 */

public class Activity2 extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hi);
        final FullScreenPicture fullScreenPicture=FullScreenPicture.getInstance();
        fullScreenPicture.build(this);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                fullScreenPicture.setUp();
            }
        },500);

    }
}
