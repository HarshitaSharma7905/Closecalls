package com.example.closecalls;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class OrdersActivity extends AppCompatActivity {

    TextView btnBack;
    TextView btnPlay,btnStatus,btnOrder;
    String match_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);
        getSupportActionBar().hide();
        btnBack=findViewById(R.id.btnBack);
        btnPlay=findViewById(R.id.play);
        btnStatus=findViewById(R.id.status);
        btnOrder=findViewById(R.id.orders);
        Bundle bundle1=getIntent().getExtras();
        match_id=bundle1.getString("match_id");
        btnStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent status=new Intent(OrdersActivity.this,MatchStatusActivity.class);
                status.putExtra("match_id",match_id);
                startActivity(status);

            }
        });
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent play=new Intent(OrdersActivity.this,GameActivity.class);
                play.putExtra("match_id",match_id);
                startActivity(play);

            }
        });

//        BACK BUTTON:-----
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iBack=new Intent(OrdersActivity.this,DashboardActivity.class);
                startActivity(iBack);
                finish();
            }
        });
    }
}