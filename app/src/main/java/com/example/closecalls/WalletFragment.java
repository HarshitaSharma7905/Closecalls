package com.example.closecalls;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.text.InputType;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


public class WalletFragment extends Fragment {
    TextView balance,balanceUnUtilized,balanceWining;
    TextView btnAccount,btnKYC,btnPaymentHistory;
    Button btnAddCash,btnWithdrawal;


    public WalletFragment() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_wallet, container, false);
        //         WALLET SECTION:-------------------------
        balance=view.findViewById(R.id.balance);
        balanceUnUtilized=view.findViewById(R.id.balanceUnUtilize);
        balanceWining=view.findViewById(R.id.balanceWining);
        btnAddCash=view.findViewById(R.id.btnAddCash);
        btnWithdrawal=view.findViewById(R.id.btnWithdrawal);
//        set values to wallet session
        balance.setText("1000");
        balanceUnUtilized.setText("500");
        balanceWining.setText("500");

//        ACTIVITY SECTION:----------------------------
        btnAccount=view.findViewById(R.id.btnAccount);
        btnKYC=view.findViewById(R.id.btnKYC);
        btnPaymentHistory=view.findViewById(R.id.btnPaymentHistory);

//        ADD CASH TO WALLET:-----
         btnAddCash.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onClick(View v) {
                final EditText input = new EditText(getContext());
                Drawable img = getContext().getResources().getDrawable(R.drawable.ic_baseline_currency_rupee_28);
                input.setBackgroundResource(R.drawable.input);
                input.setSingleLine();
                input.setHint("Amount");
                input.setTextSize(24);
                input.setCompoundDrawablesWithIntrinsicBounds(img, null, null, null);
                input.setCompoundDrawablePadding(20);
                input.setInputType(InputType.TYPE_CLASS_NUMBER);
                input.setGravity(Gravity.LEFT);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                input.setLayoutParams(lp);
                new AlertDialog.Builder(getContext())
                        .setIcon(R.drawable.ic_baseline_wallet_36)
                        .setTitle("Add Cash To Wallet")
                        .setView(input,90,50,90,50)
                        .setNegativeButton("Cancel",null)
                        .setPositiveButton("Add Cash", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
//                                payment getway integration here:-----
                                String amount=input.getText().toString();
                                if(amount.isEmpty()){
                                    new AlertDialog.Builder(getContext())
                                            .setIcon(R.drawable.ic_baseline_warning_amber_56)
                                            .setTitle("Failed")
                                            .setMessage("Enter Valid Amount")
                                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    dialog.dismiss();
                                                }
                                            }).show();
                                }
                                else{
//                       { payment add api integration here}
                                }
                            }
                        }).show();

            }
        });

//        BUTTON FOR BANK ACCOUNT:------
        btnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iAccount=new Intent(getContext(),BankAccountVerificationActivity.class);
                startActivity(iAccount);
            }
        });
//        BUTTON FOR KYC:-----------------------------
        btnKYC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iKyc=new Intent(getContext(),KYCActivity.class);
                startActivity(iKyc);
            }
        });
//        BUTTON FOR PAYMENT HISTORY:----------------------
        btnPaymentHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iPayment=new Intent(getContext(),PaymentHistoryActivity.class);
                startActivity(iPayment);
            }
        });
        //        WITHDRAW FUND:-----
        btnWithdrawal.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onClick(View v) {
                final EditText withdrawRequest = new EditText(getContext());
                Drawable img2 = getContext().getResources().getDrawable(R.drawable.ic_baseline_currency_rupee_28);
                withdrawRequest.setBackgroundResource(R.drawable.input);
                withdrawRequest.setSingleLine();
                withdrawRequest.setHint("Amount");
                withdrawRequest.setTextSize(24);
                withdrawRequest.setCompoundDrawablesWithIntrinsicBounds(img2, null, null, null);
                withdrawRequest.setCompoundDrawablePadding(20);
                withdrawRequest.setInputType(InputType.TYPE_CLASS_NUMBER);
                withdrawRequest.setGravity(Gravity.LEFT);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                withdrawRequest.setLayoutParams(lp);
                new AlertDialog.Builder(getContext())
                        .setIcon(R.drawable.ic_baseline_wallet_36)
                        .setTitle("Withdraw To Account")
                        .setView(withdrawRequest,90,50,90,50)
                        .setNegativeButton("Cancel",null)
                        .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
//                                payment geteway integration here:-----
                                int amountRequest=Integer.parseInt(withdrawRequest.getText().toString());
                                int wining=Integer.parseInt(balanceWining.getText().toString());
                                if(amountRequest<=wining){
//                                    payment process successfully:---
//                                    payment{integration code here}
//                                    success massage
                                    new AlertDialog.Builder(getContext())
                                            .setIcon(R.drawable.ic_baseline_check_box_56)
                                            .setTitle("Success")
                                            .setMessage("Your Payment has been process for Withdrawal successfully")
                                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    dialog.dismiss();
                                                }
                                            }).show();

                                }
                                else {
                                    new AlertDialog.Builder(getContext())
                                            .setIcon(R.drawable.ic_baseline_warning_amber_56)
                                            .setTitle("Failed")
                                            .setMessage("Enter Valid Amount")
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
        return view;
    }
}