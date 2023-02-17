package com.example.closecalls;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TermConditationActivity extends AppCompatActivity {
    TextView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_conditation);
        getSupportActionBar().hide();
        btnBack=findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back=new Intent(TermConditationActivity.this,DashboardActivity.class);
                back.putExtra("fragment",5);
                startActivity(back);
            }
        });
    }
}