package com.alerts;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;

import com.alerts.interfaces.OnClickListener;
import com.alerts.interfaces.OnItemSelectListener;

public class AllAlerts {
    private static AllAlerts allAlerts;
    private OnClickListener onClickListener;
    private OnItemSelectListener onItemSelectListener;
    private AlertDialog.Builder builder;
    public static AllAlerts getIntance() {
        if(allAlerts==null){
            allAlerts=new AllAlerts();
        }
        return allAlerts;
    }




    public AlertDialog.Builder simpleAlert(Context context,String title,String message,String positiveButtonName,String negativeButtonName){
        builder=new AlertDialog.Builder(context);
        builder.setCancelable(false);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton(positiveButtonName, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                onClickListener.positive();
            }
        });

        builder.setNegativeButton(negativeButtonName, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                onClickListener.negative();
            }
        });
        builder.show();
        return builder;
    }

    public AlertDialog.Builder withCustomView(Context context,View view){
        builder=new AlertDialog.Builder(context);
        builder.setView(view);
        builder.setCancelable(false);
        builder.show();
        return builder;
    }

    public AlertDialog.Builder withItemSelect(Context context,String title,CharSequence[] items){
        builder=new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setCancelable(false);
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                onItemSelectListener.selectedItem(i);
            }
        });

        builder.show();
        return builder;
    }

    public AlertDialog.Builder withItemSelectRadioButton(Context context,String title,CharSequence[] items){
        builder=new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setCancelable(false);
        builder.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int i) {
                dialog.dismiss();
                onItemSelectListener.selectedItem(i);
            }});
        builder.show();
        return builder;
    }


    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener=onClickListener;
    }
    public void setOnItemSelectListener(OnItemSelectListener onItemSelectListener) {
        this.onItemSelectListener=onItemSelectListener;
    }
}
