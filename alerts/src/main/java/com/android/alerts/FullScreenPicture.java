package com.android.alerts;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import com.android.alerts.Utils.ModuleUtils;
import com.android.alerts.adapter.SlideImage;
import java.util.ArrayList;
import java.util.List;

public class FullScreenPicture {

    PopupWindow popupWindow;
    ViewPager viewPager;
    private List<Integer> imageArray=new ArrayList<>();
    SlideImage adapter;
    Context context;
    View view;


    public FullScreenPicture(Context context) {
        this.context=context;
        LayoutInflater layoutInflater = (LayoutInflater) ((Activity)context).getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(R.layout.pager, null, false);
        viewPager = (ViewPager) view.findViewById(R.id.pictureVP);
        popupWindow = ModuleUtils.getPopupWindow(context,view);

    }

    public void setImageArray(List<Integer> imageArray){
        this.imageArray.clear();
        this.imageArray=imageArray;
        adapter = new SlideImage(context, imageArray);
        viewPager.setAdapter(adapter);
    }



    public void showAlert(){
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
    }


    public void setUp(){
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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



}