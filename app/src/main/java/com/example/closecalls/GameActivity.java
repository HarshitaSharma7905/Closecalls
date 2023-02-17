package com.example.closecalls;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class GameActivity extends AppCompatActivity {
    TextView btnBack;
    TextView btnPlay,btnStatus,btnOrder;
    String match_id;
    RecyclerView batsmanList,blowerList,lastballs;
    ImageView img_a,img_b;
    TextView team_name_a,team_a_score,team_a_over,team_name_b,team_b_score,team_b_over,result,runNeed,
            remBall,rrr,crr,target,partnership,lastWicket;
    public static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        img_a=findViewById(R.id.img_a);
        img_b=findViewById(R.id.img_b);
        batsmanList=findViewById(R.id.batsmanList);
        blowerList=findViewById(R.id.blowerList);
        team_name_a=findViewById(R.id.team_name_a);
        team_a_score=findViewById(R.id.team_a_score);
        team_a_over=findViewById(R.id.team_a_over);
        team_name_b=findViewById(R.id.team_name_b);
        team_b_score=findViewById(R.id.team_b_score);
        team_b_over=findViewById(R.id.team_b_over);
        result=findViewById(R.id.result);
        runNeed=findViewById(R.id.runNeed);
        remBall=findViewById(R.id.remBall);
        rrr=findViewById(R.id.rrr);
        crr=findViewById(R.id.crr);
        target=findViewById(R.id.target);
        partnership=findViewById(R.id.partnership);
        lastWicket=findViewById(R.id.lastWicket);
        btnBack=findViewById(R.id.btnBack);
        btnPlay=findViewById(R.id.play);
        btnStatus=findViewById(R.id.status);
        btnOrder=findViewById(R.id.orders);
        lastballs=findViewById(R.id.lastballs);
        batsmanList.setLayoutManager(new LinearLayoutManager(this));
        batsmanList.setHasFixedSize(true);
        blowerList.setLayoutManager(new LinearLayoutManager(this));
        blowerList.setHasFixedSize(true);
        lastballs.setLayoutManager(new LinearLayoutManager(this));
        lastballs.setHasFixedSize(true);

        Bundle bundle1=getIntent().getExtras();
         match_id=bundle1.getString("match_id");

        btnStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             Intent status=new Intent(GameActivity.this,MatchStatusActivity.class);
                status.putExtra("match_id",match_id);
             startActivity(status);

            }
        });
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent orders=new Intent(GameActivity.this,OrdersActivity.class);
                orders.putExtra("match_id",match_id);
                startActivity(orders);
                btnOrder.setBackground(getResources().getDrawable(R.drawable.underline));
                btnPlay.setBackground(getResources().getDrawable(R.drawable.nullunderline));
                btnStatus.setBackground(getResources().getDrawable(R.drawable.nullunderline));
            }
        });

//        BACK BUTTON:-----
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iBack=new Intent(GameActivity.this,DashboardActivity.class);
                startActivity(iBack);
                finish();
            }
        });
        getSupportActionBar().hide();

//        API CALL
        APIScore apiScore=RetrofitClass.getRetrofitInterface().create(APIScore.class);
        Call<ScoreModel> scoreList=apiScore.getMatchScore(match_id);
        scoreList.enqueue(new Callback<ScoreModel>() {
            @Override
            public void onResponse(Call<ScoreModel> call, Response<ScoreModel> response) {
                if(response.isSuccessful()){
                    String url_a=response.body().getData().getScorecard().getTeamA().getTeamAScore().getFlag();
                    Picasso.get()
                            .load(url_a)
                            .into(img_a);
                    team_name_a.setText(response.body().getData().getScorecard().getTeamA().getTeamAScore().getShort_name());
                    team_a_score.setText(response.body().getData().getScorecard().getTeamA().getTeamAScore().getScore()+"-"+response.body().getData().getScorecard().getTeamA().getTeamAScore().getWicket());
                    team_a_over.setText(response.body().getData().getScorecard().getTeamA().getTeamAScore().getOver());

                    String url_b=response.body().getData().getScorecard().getTeamB().getTeamBScore().getFlag();
                    Picasso.get()
                            .load(url_b)
                            .into(img_b);
                    team_name_b.setText(response.body().getData().getScorecard().getTeamB().getTeamBScore().getShort_name());
                    team_b_score.setText(response.body().getData().getScorecard().getTeamB().getTeamBScore().getScore()+"-"+response.body().getData().getScorecard().getTeamB().getTeamBScore().getWicket());
                    team_b_over.setText(response.body().getData().getScorecard().getTeamB().getTeamBScore().getOver());

//                        batsman adapter
                    CustomBatsmanAdapter customBatsmanAdapter=new CustomBatsmanAdapter(response.body().getData().getScorecard().getTeamA().getBatsman(),GameActivity.this);
                    batsmanList.setAdapter(customBatsmanAdapter);
//                    blower
                    CustomBolwerAdapter customBolwerAdapter=new CustomBolwerAdapter(response.body().getData().getScorecard().getTeamB().getBolwer(),GameActivity.this);
                    blowerList.setAdapter(customBolwerAdapter);
//                    result
                    if(response.body().getData().getResult().isEmpty()){
                        result.setVisibility(View.GONE);
                    }
                    else
                    {
                        result.setText(response.body().getData().getResult());
                    }
                }
            }

            @Override
            public void onFailure(Call<ScoreModel> call, Throwable t) {

            }
        });
//        API Details
        APIMatchDetails apiMatchDetails=RetrofitClass.getRetrofitInterface().create(APIMatchDetails.class);
        Call<MatchDetailsModel> data=apiMatchDetails.getMatchDetails(match_id);
        data.enqueue(new Callback<MatchDetailsModel>() {
            @Override
            public void onResponse(Call<MatchDetailsModel> call, Response<MatchDetailsModel> response) {
                runNeed.setText(response.body().getData().getRun_need());
                remBall.setText(response.body().getData().getBall_rem());
                rrr.setText(response.body().getData().getRr_rate());
                crr.setText(response.body().getData().getCurr_rate());
                target.setText(response.body().getData().getTarget());
                partnership.setText(response.body().getData().getPartnership().getRun()+"("+response.body().getData().getPartnership().getBall()+")");
                lastWicket.setText(response.body().getData().getLastwicket().getPlayer()+"-"+response.body().getData().getLastwicket().getRun()+"("+response.body().getData().getLastwicket().getBall()+")");
//    last balls
                CustomBallAdapter customBallAdapter=new CustomBallAdapter(response.body().getData().getLast36ball().getList(),GameActivity.this);
                lastballs.setAdapter(customBallAdapter);
            }

            @Override
            public void onFailure(Call<MatchDetailsModel> call, Throwable t) {

            }
        });


    }




}