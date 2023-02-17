package com.example.closecalls;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DashboardActivity extends AppCompatActivity {
    TextView btnHome,btnUpcoming,btnHistory,btnWallet,btnAccount,navTitle;
    int fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        getSupportActionBar().hide();
        btnHome=findViewById(R.id.btnHome);
        btnUpcoming=findViewById(R.id.btnUpcoming);
        btnHistory=findViewById(R.id.btnHistory);
        btnWallet=findViewById(R.id.btnWallet);
        btnAccount=findViewById(R.id.btnAccount);
        navTitle=findViewById(R.id.navTitle);
//        Bundle bundle=getIntent().getExtras();
//         fragment=Integer.parseInt(bundle.getString("fragment"));
       defaultFragment(fragment);
        //btn home
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentMethod(new HomeFragment(),1 );
                navTitle.setText("Home");
                resetBtnWhite();
                btnHome.setCompoundDrawableTintList(ColorStateList.valueOf(Color.parseColor("#F44336")));
                btnHome.setTextColor(getResources().getColor(R.color.red));
                
            }
        });
        //btn upcoming
        btnUpcoming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentMethod(new UpcomingFragment(),1);
                navTitle.setText("Upcoming Matches");
                resetBtnWhite();
                btnUpcoming.setCompoundDrawableTintList(ColorStateList.valueOf(Color.parseColor("#F44336")));
                btnUpcoming.setTextColor(getResources().getColor(R.color.red));
            }
        });
        //btn HISTORY:----
        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentMethod(new HistoryFragment(),1);
                navTitle.setText("Transaction History");
                resetBtnWhite();
                btnHistory.setCompoundDrawableTintList(ColorStateList.valueOf(Color.parseColor("#F44336")));
                btnHistory.setTextColor(getResources().getColor(R.color.red));
            }
        });
        //btnWallet
        btnWallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentMethod(new WalletFragment(),1);
                navTitle.setText("Wallet");
                resetBtnWhite();
                btnWallet.setCompoundDrawableTintList(ColorStateList.valueOf(Color.parseColor("#F44336")));
                btnWallet.setTextColor(getResources().getColor(R.color.red));
            }
        });
        //btn ACCOUNT:---
        btnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentMethod(new AccountFragment(),1);
                navTitle.setText("Account");
                resetBtnWhite();
                btnAccount.setCompoundDrawableTintList(ColorStateList.valueOf(Color.parseColor("#F44336")));
                btnAccount.setTextColor(getResources().getColor(R.color.red));
            }
        });
    }
//    reset btn color
    public  void resetBtnWhite(){
        btnHome.setCompoundDrawableTintList(ColorStateList.valueOf(Color.parseColor("#FFFFFF")));
        btnHome.setTextColor(getResources().getColor(R.color.white));
        btnUpcoming.setCompoundDrawableTintList(ColorStateList.valueOf(Color.parseColor("#FFFFFF")));
        btnUpcoming.setTextColor(getResources().getColor(R.color.white));
        btnHistory.setCompoundDrawableTintList(ColorStateList.valueOf(Color.parseColor("#FFFFFF")));
        btnHistory.setTextColor(getResources().getColor(R.color.white));
        btnWallet.setCompoundDrawableTintList(ColorStateList.valueOf(Color.parseColor("#FFFFFF")));
        btnWallet.setTextColor(getResources().getColor(R.color.white));
        btnAccount.setCompoundDrawableTintList(ColorStateList.valueOf(Color.parseColor("#FFFFFF")));
        btnAccount.setTextColor(getResources().getColor(R.color.white));
    }
//    fragment method
    public void fragmentMethod(Fragment fragment,int flag){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction ft=fragmentManager.beginTransaction();
        if(flag==0){
            ft.add(R.id.container,fragment);
        }
        else {
            ft.replace(R.id.container,fragment);
        }
        ft.commit();
    }
    public void btnBack(int fragment){
        if(fragment==5){
            fragmentMethod(new AccountFragment(),1);
            navTitle.setText("Account");
            resetBtnWhite();
            btnAccount.setCompoundDrawableTintList(ColorStateList.valueOf(Color.parseColor("#F44336")));
            btnAccount.setTextColor(getResources().getColor(R.color.red));

        }
    }
//    default fragment method
    public void defaultFragment(int fragment){
        if(fragment==3){
            fragmentMethod(new HistoryFragment(),0);
            navTitle.setText("Transaction History");
            resetBtnWhite();
            btnHistory.setCompoundDrawableTintList(ColorStateList.valueOf(Color.parseColor("#F44336")));
            btnHistory.setTextColor(getResources().getColor(R.color.red));

        }else if(fragment==4){
            fragmentMethod(new WalletFragment(),1);
            navTitle.setText("Wallet");
            resetBtnWhite();
            btnWallet.setCompoundDrawableTintList(ColorStateList.valueOf(Color.parseColor("#F44336")));
            btnWallet.setTextColor(getResources().getColor(R.color.red));

        }else if(fragment==5){
            fragmentMethod(new AccountFragment(),1);
            navTitle.setText("Account");
            resetBtnWhite();
            btnAccount.setCompoundDrawableTintList(ColorStateList.valueOf(Color.parseColor("#F44336")));
            btnAccount.setTextColor(getResources().getColor(R.color.red));

        }else{
            fragmentMethod(new HomeFragment(),0);
            navTitle.setText("Home");
            btnHome.setCompoundDrawableTintList(ColorStateList.valueOf(Color.parseColor("#F44336")));
            btnHome.setTextColor(getResources().getColor(R.color.red));
        }
    }
}