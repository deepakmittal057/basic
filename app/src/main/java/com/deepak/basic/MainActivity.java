package com.deepak.basic;


import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.alerts.FullScreenPicture;
import com.android.alerts.LoadingAlert;
import com.deepak.basicmodule.Controller.CameraController;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    CameraController cameraController;
    private ArrayList<Integer> imageArray=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hi);
        final FullScreenPicture fullScreenPicture=new FullScreenPicture(this);
        imageArray.add(R.mipmap.ic_launcher);
        imageArray.add(R.mipmap.ic_launcher);
        imageArray.add(R.mipmap.ic_launcher);
        fullScreenPicture.setImageArray(imageArray);
        fullScreenPicture.setBackGroundColor(Color.BLACK);

        final LoadingAlert loadingAlert=new LoadingAlert(this);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loadingAlert.alertShow("data comming");
            }
        },500);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loadingAlert.alertHide();
                fullScreenPicture.showAlert();
            }
        },5000);
    }

}
