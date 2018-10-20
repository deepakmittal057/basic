package com.android.alerts;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.android.alerts.Utils.ModuleUtils;




public class LoadingAlert {

    private PopupWindow popupWindow;
    private View view;
    private TextView textTv;
    private static LoadingAlert loadingAlert;


    public static LoadingAlert getInstance(){
        if(loadingAlert==null){
            loadingAlert=new LoadingAlert();
        }
        return loadingAlert;
    }

    public void builder(Context context){
        //activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = LayoutInflater.from(context).inflate(R.layout.loading_alert, null, false);
        textTv=(TextView)view.findViewById(R.id.textTv);
        popupWindow = ModuleUtils.getPopupWindow(context,view);
        alertHide();
    }




    public void alertShow(String s){
        try {
            if(!popupWindow.isShowing()){
                    textTv.setText(s);
                    popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void alertHide(){
        try {
            if(popupWindow.isShowing()){
                    popupWindow.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
