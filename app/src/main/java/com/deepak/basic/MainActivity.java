package com.deepak.basic;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.deepak.basicmodule.Alerts.LoadingAlert;
import com.deepak.basicmodule.Controller.AppNavigationController;
import com.deepak.basicmodule.Controller.CameraController;
import com.deepak.basicmodule.Utils.Permission;
import com.theartofdev.edmodo.cropper.CropImage;

public class MainActivity extends AppCompatActivity {

    CameraController cameraController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //LoadingAlert loadingAlert=new LoadingAlert(this);
        //loadingAlert.alertShow();

        cameraController=new CameraController(this);
        cameraController.OpenCam();
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
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == Permission.IMAGE_STOREAGE_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                cameraController.OpenCam();
            }
        }
    }
}
