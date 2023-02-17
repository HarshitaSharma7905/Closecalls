package com.example.closecalls;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.VideoView;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;

import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    VideoView videoView;
    Button btnLogin,btnRegister;
    String one_time_password,mobile,otpG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        btnLogin=findViewById(R.id.btnLogin);
        btnRegister=findViewById(R.id.btnRegister);
        videoView=findViewById(R.id.videoView);
        String vPath="android.resource://"+getPackageName()+"/raw/gamevideo";
        Uri  videoURI=Uri.parse(vPath);
        videoView.setVideoURI(videoURI);
        videoView.start();
//        register btn
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onClick(View v) {

                final EditText register = new EditText(MainActivity.this);
                Drawable img = MainActivity.this.getResources().getDrawable(R.drawable.ic_baseline_phone_android_24);
                register.setBackgroundResource(R.drawable.input);
                register.setSingleLine();
                register.setHint("Your Mobile Number");
                register.setCompoundDrawablesWithIntrinsicBounds(img, null, null, null);
                register.setCompoundDrawablePadding(20);
                register.setInputType(InputType.TYPE_CLASS_NUMBER);
                register.setGravity(Gravity.LEFT);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                register.setLayoutParams(lp);
                new AlertDialog.Builder(MainActivity.this)
                        .setIcon(R.drawable.ic_baseline_send_to_mobile_56)
                        .setTitle("REGISTER")
                        .setView(register,40,60,40,60)
                        .setNegativeButton("Cancel",null)
                        .setPositiveButton("Register", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();

                               String mob=register.getText().toString();
                               if(mob.isEmpty()||mob.length()!=10)
                               {
                                   new AlertDialog.Builder(MainActivity.this)
                                           .setIcon(R.drawable.ic_baseline_warning_amber_56)
                                           .setTitle("Failed")
                                           .setMessage("Enter Valid Mobile Number")
                                           .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                               @Override
                                               public void onClick(DialogInterface dialog, int which) {
                                                   dialog.dismiss();
                                               }
                                           }).show();
                               }
                               else
                               {
                                   //             Register API CALL:----

                                   new AlertDialog.Builder(MainActivity.this)
                                           .setIcon(R.drawable.ic_baseline_check_box_56)
                                           .setTitle("Success")
                                           .setMessage("Register Done Successfully")
                                           .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                               @Override
                                               public void onClick(DialogInterface dialog, int which) {
                                                   dialog.dismiss();
                                               }
                                           }).show();
                               }


                            }
                        }).show();

            }
        });
//        Login
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @SuppressLint({"ResourceType", "NewApi", "UseCompatLoadingForDrawables"})
            @Override
            public void onClick(View v) {
                final EditText input = new EditText(MainActivity.this);
                Drawable img = MainActivity.this.getResources().getDrawable(R.drawable.ic_baseline_phone_android_24);
                input.setBackgroundResource(R.drawable.input);
                input.setSingleLine();
                input.setHint("Your Mobile Number");
                input.setCompoundDrawablesWithIntrinsicBounds(img, null, null, null);
                input.setCompoundDrawablePadding(20);
                input.setInputType(InputType.TYPE_CLASS_NUMBER);
                input.setGravity(Gravity.LEFT);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                input.setLayoutParams(lp);
               new AlertDialog.Builder(MainActivity.this)
                       .setIcon(R.drawable.ic_baseline_send_to_mobile_56)
                       .setTitle("LOGIN")
                       .setView(input,40,60,40,60)
                       .setNegativeButton("Cancel",null)
                       .setPositiveButton("SEND OTP", new DialogInterface.OnClickListener(){
                           @Override
                           public void onClick(DialogInterface dialog, int which) {
                                mobile=input.getText().toString();
                               if(mobile.isEmpty() || mobile.length()!=10)
                               {
                                   alertBox("Enter Valid Mobile Number");
                               }
                               else{
//                                   generate OTP
                                   final Random myRandom = new Random();
//                                   one_time_password=String.valueOf(myRandom.nextInt(100000));
                                   one_time_password="1234567";
//                                   SMS Sending API Integration by using SMS Service
                                   sendSMS(mobile,one_time_password);

//

                                   dialog.dismiss();
                               final EditText otp = new EditText(MainActivity.this);
                               Drawable img_otp = MainActivity.this.getResources().getDrawable(R.drawable.ic_baseline_password_24);

                               otp.setBackgroundResource(R.drawable.input);
                               otp.setSingleLine();
                               otp.setHint("Enter Your OTP");
                               otp.setCompoundDrawablesWithIntrinsicBounds(img_otp, null, null, null);
                               otp.setCompoundDrawablePadding(20);
                               otp.setInputType(InputType.TYPE_CLASS_NUMBER);
                               otp.setGravity(Gravity.LEFT);
                               LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                                       LinearLayout.LayoutParams.MATCH_PARENT,
                                       LinearLayout.LayoutParams.MATCH_PARENT);
                               otp.setLayoutParams(lp);
                               new AlertDialog.Builder(MainActivity.this)
                                       .setTitle(R.drawable.ic_baseline_login_56)
                                       .setTitle("LOGIN")
                                       .setView(otp,40,60,40,60)
                                       .setNegativeButton("CANCEL",null)
                                       .setPositiveButton("LOGIN", new DialogInterface.OnClickListener() {
                                           @Override
                                           public void onClick(DialogInterface dialog, int which) {

                                                otpG=otp.getText().toString();
                                               if(otpG.isEmpty()){
                                                 alertBox("Enter OTP");
                                               }
                                               else{

//                                                   OTP verification Here
                                                   if(otpG.equals(one_time_password))
                                                   {
                                                       dialog.dismiss();
//                                                   Intent to home
                                                       Intent home=new Intent(MainActivity.this,DashboardActivity.class);
                                                       home.putExtra("mobile",mobile);
                                                       startActivity(home);
                                                       finish();
                                                   }
                                                   else{
                                                       alertBox("Enter valid OTP ");
                                                   }
//
                                               }
                                           }
                                       }).show();
                           }}
                       }).show();


            }
        });
    }
    public void alertBox(String s){
        new AlertDialog.Builder(MainActivity.this)
                .setIcon(R.drawable.ic_baseline_warning_amber_56)
                .setTitle("Failed")
                .setMessage(s)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).show();


    }
    public void sendSMS(String phoneNo, String msg) {
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null, msg, null, null);
            Toast.makeText(getApplicationContext(), "Message Sent",
                    Toast.LENGTH_LONG).show();
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(),ex.getMessage().toString(),
                    Toast.LENGTH_LONG).show();
            ex.printStackTrace();
        }
    }

}