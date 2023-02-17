package com.example.closecalls;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MatchStatusActivity extends AppCompatActivity {

    TextView btnBack;
    TextView btnPlay,btnStatus,btnOrder;
    String match_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_status);
        getSupportActionBar().hide();
        btnBack=findViewById(R.id.btnBack);
        btnPlay=findViewById(R.id.play);
        btnStatus=findViewById(R.id.status);
        btnOrder=findViewById(R.id.orders);
        Bundle bundle1=getIntent().getExtras();
        match_id=bundle1.getString("match_id");

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent game=new Intent(MatchStatusActivity.this,GameActivity.class);
                game.putExtra("match_id",match_id);
        startActivity(game);

            }
        });
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent orders=new Intent(MatchStatusActivity.this,OrdersActivity.class);
                orders.putExtra("match_id",match_id);
                startActivity(orders);

            }
        });

//        BACK BUTTON:-----
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iBack=new Intent(MatchStatusActivity.this,DashboardActivity.class);
                startActivity(iBack);
                finish();
            }
        });
    }
}