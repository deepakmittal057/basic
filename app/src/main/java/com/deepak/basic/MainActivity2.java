package com.deepak.basic;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.alerts.LoadingAlert;
import com.basicmodule.controller.AppNavigationController;
import com.basicmodule.controller.CameraController;
import com.basicmodule.utils.Permission;
import com.theartofdev.edmodo.cropper.CropImage;

public class MainActivity2 extends AppCompatActivity {

    CameraController cameraController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final LoadingAlert loadingAlert=LoadingAlert.getInstance();
        loadingAlert.builder(this);
        final AppNavigationController appNavigationController=new AppNavigationController(this);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loadingAlert.alertShow("");
                //appNavigationController.Wf(Activity2.class);
            }
        },1000);


        //cameraController=new CameraController(this);
        //cameraController.OpenCam();
    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CameraController.CAMERA_CAPTURE_IMAGE_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                try {
                    if (cameraController.uriiii != null && !cameraController.uriiii.equals(Uri.EMPTY) && !cameraController.uriiii.equals("null")) {
                        CropImage.activity(cameraController.uriiii).setOutputCompressQuality(70).start(this);
                        //CropImage.activity(cameraController.uriiii).start(this);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (requestCode == CameraController.GET_IMAGE_GALLARY) {
            if (resultCode == RESULT_OK) {
                final Uri imageUri = data.getData();
                try {
                    if (imageUri != null && !imageUri.equals(Uri.EMPTY) && !imageUri.equals("null")) {
                        CropImage.activity(imageUri).start(this);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                final Uri cropImagePath = result.getUri();
                //Uri bitmap= new ImageCompress(ProfileActivity.this).imageCompress(cropImagePath);
                //Toast.makeText(this, ""+cropImagePath.getPath(), Toast.LENGTH_SHORT).show();
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }
        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode,String[] permissions,int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == Permission.IMAGE_STOREAGE_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                cameraController.OpenCam();
            }
        }
    }
}
