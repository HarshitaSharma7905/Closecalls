package com.example.closecalls;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ContactActivity extends AppCompatActivity {
TextView btnBack;
TextView edtName,edtEmail,edtMobile,edtMessage;
Button btnSubmit;
String name,email,mobile,message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        getSupportActionBar().hide();
        btnBack=findViewById(R.id.btnBack);
        btnSubmit=findViewById(R.id.btnSubmit);
        edtName=findViewById(R.id.name);
        edtEmail=findViewById(R.id.gmail);
        edtMobile=findViewById(R.id.mobile);
        edtMessage=findViewById(R.id.message);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back=new Intent(ContactActivity.this,DashboardActivity.class);
                back.putExtra("fragment",5);
                startActivity(back);
            }
        });
//        Submit
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name=edtName.getText().toString();
                email=edtEmail.getText().toString();
                mobile=edtMobile.getText().toString();
                message=edtMessage.getText().toString();
              if(name.isEmpty()||email.isEmpty()||mobile.isEmpty()||message.isEmpty()){
                  new AlertDialog.Builder(ContactActivity.this)
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
                  APIContact apiContact=RetrofitDashboard.getRetrofitInstanceData().create(APIContact.class);
                  Call<ContactModel> modelCall= apiContact.querySubmit(name,email,mobile,message);
                  modelCall.enqueue(new Callback<ContactModel>() {
                      @Override
                      public void onResponse(Call<ContactModel> call, Response<ContactModel> response) {
                          if (response.isSuccessful()){
                              new AlertDialog.Builder(ContactActivity.this)
                                      .setTitle("Success")
                                      .setIcon(R.drawable.ic_baseline_check_box_56)
                                      .setMessage("Your Query Submitted Successfully We will contact you soon.")
                                      .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                          @Override
                                          public void onClick(DialogInterface dialog, int which) {
                                              dialog.dismiss();
                                          }
                                      }).show();
                          }
                      }

                      @Override
                      public void onFailure(Call<ContactModel> call, Throwable t) {

                      }
                  });
              }
            }
        });
    }
}