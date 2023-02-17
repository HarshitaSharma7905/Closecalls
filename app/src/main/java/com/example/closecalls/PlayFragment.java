package com.example.closecalls;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PlayFragment extends Fragment {

    public PlayFragment() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ListView batsmanList,blowerList;
        ImageView img_a,img_b;
        TextView team_name_a,team_a_score,team_a_over,team_name_b,team_b_score,team_b_over,result,runNeed,
                remBall,rrr,crr,target;
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_play, container, false);
        img_a=view.findViewById(R.id.img_a);
        img_b=view.findViewById(R.id.img_b);
        batsmanList=view.findViewById(R.id.batsmanList);
        blowerList=view.findViewById(R.id.blowerList);
        team_name_a=view.findViewById(R.id.team_name_a);
        team_a_score=view.findViewById(R.id.team_a_score);
        team_a_over=view.findViewById(R.id.team_a_over);
        team_name_b=view.findViewById(R.id.team_name_b);
        team_b_score=view.findViewById(R.id.team_b_score);
        team_b_over=view.findViewById(R.id.team_b_over);
        result=view.findViewById(R.id.result);
        runNeed=view.findViewById(R.id.runNeed);
        remBall=view.findViewById(R.id.remBall);
        rrr=view.findViewById(R.id.rrr);
        crr=view.findViewById(R.id.crr);
        target=view.findViewById(R.id.target);
      Bundle bundle=getArguments();
      String match=bundle.getString("match_id");

//        APIScore apiScore=RetrofitClass.getRetrofitInterface().create(APIScore.class);
//        Call<ScoreModel> scoreData=apiScore.getMatchScore("2623");
//        scoreData.enqueue(new Callback<ScoreModel>() {
//            @Override
//            public void onResponse(Call<ScoreModel> call, Response<ScoreModel> response) {
//                if(response.isSuccessful()){
////                    String img_url_a=response.body().getData().getScorecard().getTeamA().getTeamAScore().getFlag();
////                    Picasso.get()
////                            .load(img_url_a)
////                            .into(img_a);
////                    team_name_a.setText(response.body().getData().getScorecard().getTeamA().getTeamAScore().getShort_name());
////                    team_a_score.setText(response.body().getData().getScorecard().getTeamA().getTeamAScore().getScore()+"-"+response.body().getData().getScorecard().getTeamA().getTeamAScore().getWicket());
////                    team_a_over.setText(response.body().getData().getScorecard().getTeamA().getTeamAScore().getOver());
////
////                    String img_url_b=response.body().getData().getScorecard().getTeamB().getTeamBScore().getFlag();
////                    Picasso.get()
////                            .load(img_url_a)
////                            .into(img_b);
////                    team_name_b.setText(response.body().getData().getScorecard().getTeamB().getTeamBScore().getShort_name());
////                    team_b_score.setText(response.body().getData().getScorecard().getTeamB().getTeamBScore().getScore()+"-"+response.body().getData().getScorecard().getTeamB().getTeamBScore().getWicket());
////                    team_b_over.setText(response.body().getData().getScorecard().getTeamB().getTeamBScore().getOver());
////                    result.setText(response.body().getData().getResult());
//
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ScoreModel> call, Throwable t) {
//
//            }
//        });

        return view;
    }
}