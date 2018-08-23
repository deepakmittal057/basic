package com.deepak.basic;


import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.android.alerts.AllAlerts;
import com.android.alerts.FullScreenPicture;
import com.android.alerts.LoadingAlert;
import com.android.alerts.interfaces.OnClickListener;
import com.android.alerts.interfaces.OnItemSelectListener;
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

        final CharSequence[] items = {"Phone Memory - "+"10"+" free space", "SD Card - "+"20"+" MB free space"};
        View view= LayoutInflater.from(this).inflate(R.layout.hi,null);
        final AllAlerts alerts=new AllAlerts(this);
        //alerts.withItemSelect("title",items);
        alerts.withItemSelectRadioButton("title",items);
        alerts.setOnItemSelectListener(new OnItemSelectListener() {
            @Override
            public void selectedItem(int i) {
                Toast.makeText(MainActivity.this, String.valueOf(i), Toast.LENGTH_SHORT).show();
            }
        });
        /*alerts.simpleAlert("title","message","YES","NO");
        alerts.setOnClickListener(new OnClickListener() {
            @Override
            public void positive() {
                Toast.makeText(MainActivity.this, "positive button", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void negative() {
                Toast.makeText(MainActivity.this, "negative button", Toast.LENGTH_SHORT).show();
            }
        });*/




        final LoadingAlert loadingAlert=new LoadingAlert(this);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //loadingAlert.alertShow("data comming");
            }
        },500);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //loadingAlert.alertHide();
                //fullScreenPicture.showAlert();
            }
        },5000);
    }

}
