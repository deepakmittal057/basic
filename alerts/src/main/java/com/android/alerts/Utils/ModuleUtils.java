package com.android.alerts.Utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.PopupWindow;

public class ModuleUtils {

    public static PopupWindow getPopupWindow(Context context, View view){
        DisplayMetrics displayMetrics = ModuleUtils.getDisplaySize(context);
        PopupWindow popupWindow = new PopupWindow(view,displayMetrics.widthPixels, displayMetrics.heightPixels, true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        return popupWindow;
    }


    public static DisplayMetrics getDisplaySize(Context context){
        Display display = ((Activity)context).getWindowManager().getDefaultDisplay();
        final Point size = new Point();
        display.getSize(size);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return displayMetrics;
    }
}
