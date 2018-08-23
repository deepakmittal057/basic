package com.android.alerts;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Toast;

import com.android.alerts.interfaces.OnClickListener;
import com.android.alerts.interfaces.OnItemSelectListener;

public class AllAlerts {
    Context context;
    OnClickListener onClickListener;
    OnItemSelectListener onItemSelectListener;

    public AllAlerts(Context context) {
        this.context = context;
    }

    public AlertDialog.Builder simpleAlert(String title,String message,String positiveButtonName,String negativeButtonName){
        AlertDialog.Builder builder=new AlertDialog.Builder(context);
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

    public AlertDialog.Builder withCustomView(View view){
        AlertDialog.Builder builder=new AlertDialog.Builder(context);
        builder.setView(view);
        builder.setCancelable(false);
        builder.show();
        return builder;
    }

    public AlertDialog.Builder withItemSelect(String title,CharSequence[] items){
        AlertDialog.Builder builder=new AlertDialog.Builder(context);
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

    public AlertDialog.Builder withItemSelectRadioButton(String title,CharSequence[] items){
        AlertDialog.Builder builder=new AlertDialog.Builder(context);
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
