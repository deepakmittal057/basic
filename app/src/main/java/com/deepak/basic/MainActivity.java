package com.deepak.basic;


import android.graphics.Color;
import android.os.Handler;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.alerts.FullScreenPicture;
import com.basicmodule.Controller.CameraController;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    CameraController cameraController;
    private ArrayList<Integer> imageArray=new ArrayList<>();
    private ArrayList<String> imageArrayUrl=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hi);
        final FullScreenPicture fullScreenPicture=FullScreenPicture.getInstance();
        fullScreenPicture.build(this);
        imageArray.add(R.mipmap.ic_launcher);
        imageArray.add(R.mipmap.ic_launcher);
        imageArray.add(R.mipmap.ic_launcher);
        //fullScreenPicture.setImageArray(imageArray);
        fullScreenPicture.setBackGroundColor(Color.BLACK);


        imageArrayUrl.add("https://wallpaperbrowse.com/media/images/sunflowers-mr.jpg");
        imageArrayUrl.add("https://wallpaperbrowse.com/media/images/sunflowers-mr.jpg");
        imageArrayUrl.add("https://wallpaperbrowse.com/media/images/sunflowers-mr.jpg");
        imageArrayUrl.add("https://wallpaperbrowse.com/media/images/sunflowers-mr.jpg");
        fullScreenPicture.setImageArrayUrl(imageArrayUrl);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                fullScreenPicture.showAlert();

            }
        }, 1000);


        /*final CharSequence[] items = {"Phone Memory - "+"10"+" free space", "SD Card - "+"20"+" MB free space"};
        View view= LayoutInflater.from(this).inflate(R.layout.hi,null);
        final AllAlerts alerts=AllAlerts.getIntance();

        //alerts.withItemSelect("title",items);
        alerts.withItemSelectRadioButton(this,"title",items);
        alerts.setOnItemSelectListener(new OnItemSelectListener() {
            @Override
            public void selectedItem(int i) {
                Toast.makeText(MainActivity.this, String.valueOf(i), Toast.LENGTH_SHORT).show();
            }
        });*/
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




        /*final LoadingAlert loadingAlert=new LoadingAlert(this);
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
                fullScreenPicture.showAlert();
            }
        },5000);*/
    }

}
