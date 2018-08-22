package com.deepak.basic;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.alerts.FullScreenPicture;
import com.deepak.basicmodule.Alerts.LoadingAlert;
import com.deepak.basicmodule.Controller.AppNavigationController;
import com.deepak.basicmodule.Controller.CameraController;
import com.deepak.basicmodule.Utils.Permission;
import com.theartofdev.edmodo.cropper.CropImage;

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
        fullScreenPicture.setAdapter();
        fullScreenPicture.setBackGroundColor(Color.BLACK);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                fullScreenPicture.showAlert();
            }
        },500);
    }

}
