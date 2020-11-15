package com.basicmodule.utils;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Build;

import static android.content.Context.LOCATION_SERVICE;

/**
 * Created by deepak.mittal on 4/27/2018.
 */

public class Permission {
    private Activity activity;
    public static int IMAGE_STOREAGE_PERMISSION=100;
    public static int IMAGE_REQUEST_CODE_ASK_PERMISSIONS = 201;
    public Permission(Activity activity) {
        this.activity=activity;
    }

    public boolean checkStorage(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if(activity.checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED
                    || activity.checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED
                    || activity.checkSelfPermission(Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED)
            {
                activity.requestPermissions(new String[]{
                        Manifest.permission.READ_EXTERNAL_STORAGE
                , Manifest.permission.WRITE_EXTERNAL_STORAGE
                        , Manifest.permission.CAMERA},IMAGE_STOREAGE_PERMISSION);
                return false;
            }
            else {
                return true;
            }
        }else {
            return true;
        }
    }


    public boolean setLocation() {
        LocationManager locationManager = (LocationManager) activity.getSystemService(LOCATION_SERVICE);
        if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
           return true;
        } else {
            //showGPSDisabledAlertToUser();
            return false;
        }
    }

   /* private void showGPSDisabledAlertToUser() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(activity);
        alertDialogBuilder.setMessage(R.string.alertMsg)
                .setCancelable(false)
                .setPositiveButton(R.string.positiveAlertBtn,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent callGPSSettingIntent = new Intent(
                                        android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                                activity.startActivity(callGPSSettingIntent);
                            }
                        });
        alertDialogBuilder.setNegativeButton(R.string.alertNegativeBtn,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }*/
}
