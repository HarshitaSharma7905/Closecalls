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

public class BankAccountVerificationActivity extends AppCompatActivity {
TextView btnBack;
EditText edtName,edtAccount,edtBank,edtCode,edtBranch,edtState;
ImageView photo;
Button btnPhoto,btnSubmit;
    Bitmap bitmap=null;
    private String base64Image;
    String name,account,bank,code,branch,state;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_account_verification);
        getSupportActionBar().hide();
        btnBack=findViewById(R.id.btnBack);
        btnPhoto=findViewById(R.id.btnPhoto);
        btnSubmit=findViewById(R.id.btnSubmit);
        photo=findViewById(R.id.photo);
        edtName=findViewById(R.id.edtName);
        edtAccount=findViewById(R.id.edtAccount);
        edtBank=findViewById(R.id.edtBank);
        edtCode=findViewById(R.id.edtCode);
        edtBranch=findViewById(R.id.edtBranch);
        edtState=findViewById(R.id.edtState);
        //        launch activity
        ActivityResultLauncher<Intent> activityResultLauncher=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {


                if(result.getResultCode()== Activity.RESULT_OK)
                {
                    Intent data=result.getData();
                    Uri uri=data.getData();
                    try {
                        bitmap= MediaStore.Images.Media.getBitmap(getContentResolver(),uri);
                        photo.setImageBitmap(bitmap);
                        encodeImage(bitmap);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
//open gallery
        btnPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_PICK);
                intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                activityResultLauncher.launch(intent);
            }
        });
//        submit btn
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name=edtName.getText().toString();
                account=edtAccount.getText().toString();
                bank=edtBank.getText().toString();
                code=edtCode.getText().toString();
                branch=edtBranch.getText().toString();
                state=edtState.getText().toString();
                if(name.isEmpty()||account.isEmpty()||bank.isEmpty()||code.isEmpty()||branch.isEmpty()||state.isEmpty()){
                    new AlertDialog.Builder(BankAccountVerificationActivity.this)
                            .setIcon(R.drawable.ic_baseline_warning_amber_56)
                            .setTitle("Failed")
                            .setMessage("Enter required Field")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            }).show();
                }
                else
                {
//                    API Sending code here


                }
            }
        });

//        back btn
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back=new Intent(BankAccountVerificationActivity.this,DashboardActivity.class);
                startActivity(back);
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
            base64Image= Base64.encodeToString(bytes,Base64.DEFAULT);

        }
        else
        {
            base64Image=null;
        }

    }
}