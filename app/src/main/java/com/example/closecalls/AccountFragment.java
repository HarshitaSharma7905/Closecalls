package com.example.closecalls;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class AccountFragment extends Fragment {
TextView name,email,mobile,city,btnHistory,btnTerm,btnPrivacy,btnWithdrawal,btnContact;

    public AccountFragment() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_account, container, false);
//        user details
        name=view.findViewById(R.id.name);
        email=view.findViewById(R.id.gmail);
        mobile=view.findViewById(R.id.mobile);
        city=view.findViewById(R.id.city);
//        set Share preference value
        name.setText("Krishna Mohan Sharma");
        email.setText("krishna@gmail.com");
        mobile.setText("8707049371");
        city.setText("Pune,Maharashtra");
//        other activites button
        btnHistory=view.findViewById(R.id.btnHistory);
        btnTerm=view.findViewById(R.id.btnTerm);
        btnPrivacy=view.findViewById(R.id.btnPrivacy);
        btnWithdrawal=view.findViewById(R.id.btnWithdrawal);
        btnContact=view.findViewById(R.id.btnContact);
//        History
        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iHistory=new Intent(getContext(),PaymentHistoryActivity.class);
                startActivity(iHistory);
            }
        });
//        Terms and conditions
        btnTerm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iTerm=new Intent(getContext(),TermConditationActivity.class);
                startActivity(iTerm);
            }
        });
//        btn privacy policy
        btnPrivacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iPrivate=new Intent(getContext(),PrivacyPolicyActivity.class);
                startActivity(iPrivate);
            }
        });
//        btn for withdrawal
        btnWithdrawal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iWithdraw=new Intent(getContext(),WithdralPolicyActivity.class);
                startActivity(iWithdraw);

            }
        });
//        btn contact
        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iContact=new Intent(getContext(),ContactActivity.class);
                startActivity(iContact);
            }
        });

        return view;
    }
}