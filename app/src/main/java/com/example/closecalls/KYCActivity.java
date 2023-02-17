package com.example.closecalls;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class KYCActivity extends AppCompatActivity {
TextView btnBack;
EditText edtName,edtMobile,edtEmail;
ImageView adhaarFont,adhaarBack,pancardFront;
Button btnAdhaarFront,btnAdhaarBack,btnPanCard,btnSubmit;
String name,mobile,email,AFront,ABack,PFront;
Bitmap bitmap=null,bitmap2=null,bitmap3=null;
private String base64Image1,base64Image2,base64Image3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kycactivity);
        getSupportActionBar().hide();
        btnBack=findViewById(R.id.btnBack);
        edtName=findViewById(R.id.name);
        edtMobile=findViewById(R.id.mobile);
        edtEmail=findViewById(R.id.email);
        adhaarFont=findViewById(R.id.adhaarFront);
        adhaarBack=findViewById(R.id.adhaarBack);
        pancardFront=findViewById(R.id.panCardFront);
        btnAdhaarFront=findViewById(R.id.btnAdhaarFront);
        btnAdhaarBack=findViewById(R.id.btnAdhaarBack);
        btnPanCard=findViewById(R.id.btnPanCardFront);
        btnSubmit=findViewById(R.id.btnSubmit);
//        getting users details
        name=edtName.getText().toString();
        mobile=edtMobile.getText().toString();
        email=edtEmail.getText().toString();
        //launch activity
        ActivityResultLauncher<Intent> activityResultLauncher=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {

                if(result.getResultCode()== Activity.RESULT_OK)
                {
                    Intent data=result.getData();
                    Uri uri=data.getData();
                    try {
                        bitmap=MediaStore.Images.Media.getBitmap(getContentResolver(),uri);
                        encodeImage(bitmap);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
//        btn to submit
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.isEmpty()||mobile.isEmpty()||email.isEmpty()){
                    new AlertDialog.Builder(KYCActivity.this)
                            .setIcon(R.drawable.ic_baseline_warning_amber_56)
                            .setTitle("Failed")
                            .setMessage("Enter Required Details")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            }).show();
                }
                else
                {
//                    sending details to API:-----
                }
            }
        });

// open front page
        btnAdhaarFront.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_PICK);
                intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                activityResultLauncher.launch(intent);
            }
        });
        // open back page
        btnAdhaarBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_PICK);
                intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                activityResultLauncher.launch(intent);
            }
        });
        // open front page
        btnPanCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_PICK);
                intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                activityResultLauncher.launch(intent);
            }
        });


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iBack=new Intent(KYCActivity.this,DashboardActivity.class);
                startActivity(iBack);
            }
        });
    }
//    bitmap
private void encodeImage(Bitmap bitmap) {
    ByteArrayOutputStream byteArrayOutputStream;
    byteArrayOutputStream=new ByteArrayOutputStream();
    if(bitmap !=null)
    {
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
        byte[] bytes = byteArrayOutputStream.toByteArray();
        base64Image1= Base64.encodeToString(bytes,Base64.DEFAULT);

    }
    else
    {
        base64Image1=null;
    }

}

}