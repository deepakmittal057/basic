package com.android.alerts;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
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
    Context context;
    View view;
    int width;
    int hight;

    public FullScreenPicture(Context context) {
        this.context=context;
        getDisplaySize();
        LayoutInflater layoutInflater = (LayoutInflater) ((Activity)context).getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(R.layout.pager, null, false);
        pictureVP = (ViewPager) view.findViewById(R.id.pictureVP);
        popupWindow = new PopupWindow(view, width, hight, true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);

    }
    
    public void setImageArray(List<Integer> imageArray){
        this.imageArray.clear();
        this.imageArray=imageArray;
    }




    public void setAdapter(){
        adapter = new SlideImage(context, imageArray);
        pictureVP.setAdapter(adapter);
    }

    public void showAlert(){
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
    }


    public void setUp(){
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

    public void setBackGroundColor(int color){
        //popupWindow.setBackgroundDrawable(context.getResources().getDrawable(back_black));
        popupWindow.setBackgroundDrawable(new ColorDrawable(color));
    }


    private void getDisplaySize() {
        Display display = ((Activity)context).getWindowManager().getDefaultDisplay();
        final Point size = new Point();
        display.getSize(size);

        DisplayMetrics displayMetrics = ((Activity)context).getResources().getDisplayMetrics();
        width = displayMetrics.widthPixels;
        hight = displayMetrics.heightPixels;
    }
}