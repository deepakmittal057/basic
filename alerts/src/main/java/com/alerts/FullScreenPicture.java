package com.alerts;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;

import androidx.viewpager.widget.ViewPager;

import com.alerts.utils.ModuleUtils;
import com.alerts.adapter.SlideImage;
import com.alerts.adapter.SlideImageUrl;

import java.util.ArrayList;
import java.util.List;

public class FullScreenPicture {

    private PopupWindow popupWindow;
    private ViewPager viewPager;
    private List<Integer> imageArray=new ArrayList<>();
    private List<String> imageArrayUrl=new ArrayList<>();
    private SlideImage adapter;
    private SlideImageUrl adapterUrl;
    private View view;
    private static FullScreenPicture fullScreenPicture;
    private Context context;

    public static FullScreenPicture getInstance(){
        if(fullScreenPicture==null){
            fullScreenPicture=new FullScreenPicture();
        }
        return fullScreenPicture;
    }


    public void build(Context context) {
        this.context=context;
        view = LayoutInflater.from(context).inflate(R.layout.pager, null, false);
        viewPager = (ViewPager) view.findViewById(R.id.pictureVP);
        popupWindow = ModuleUtils.getPopupWindow(context,view);

    }

    public void setImageArray(List<Integer> imageArray){
        this.imageArray.clear();
        this.imageArray=imageArray;
        adapter = new SlideImage(context, imageArray);
        viewPager.setAdapter(adapter);
    }

    public void setImageArrayUrl(List<String> imageArrayUrl){
        this.imageArrayUrl.clear();
        this.imageArrayUrl=imageArrayUrl;
        adapterUrl = new SlideImageUrl(context, imageArrayUrl);
        viewPager.setAdapter(adapterUrl);
    }


    public void showAlert(){
        try {
            popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
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