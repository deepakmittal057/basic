package com.android.alerts;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import com.android.alerts.adapter.SlideImage;

import java.util.ArrayList;
import java.util.List;

public class FullScreenPicture {

    PopupWindow popupWindow;
    ViewPager pictureVP;
    private List<Integer> imageArray=new ArrayList<>();
    SlideImage adapter;
    int i=0;
    Context context;

    public FullScreenPicture(Context context) {
        this.context=context;
    }

    public void setImageArray(List<Integer> imageArray){
        this.imageArray=imageArray;
    }

    public void setUp(){
        //((Activity)context).getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        LayoutInflater layoutInflater = (LayoutInflater) ((Activity)context).getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.pager, null, false);
        pictureVP = (ViewPager) view.findViewById(R.id.pictureVP);

        Display display = ((Activity)context).getWindowManager().getDefaultDisplay();
        final Point size = new Point();
        display.getSize(size);

        DisplayMetrics displayMetrics = ((Activity)context).getResources().getDisplayMetrics();
        int width = displayMetrics.widthPixels;
        int hight = displayMetrics.heightPixels;
        popupWindow = new PopupWindow(view, width, hight, true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        //popupWindow.setBackgroundDrawable(activity.getResources().getDrawable(R.drawable.back_black));
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
        adapter = new SlideImage(context, imageArray);
        pictureVP.setAdapter(adapter);
        pictureVP.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i2) {
                //arrayPosition=i;
            }

            @Override
            public void onPageSelected(int i) {
                // here you will get the position of selected page
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }
}