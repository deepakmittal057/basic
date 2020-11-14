package com.deepak.basic;

import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.android.alerts.FullScreenPicture;



/**
 * Created by deepak.mittal on 5/10/2018.
 */

public class Activity2 extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
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
