package com.example.closecalls;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomBatsmanAdapter extends RecyclerView.Adapter<CustomBatsmanAdapter.ViewHolder>{
    ArrayList<ScoreModel.DataTeam.ScorecardTeam.TeamA.Batsman> batsman;
    Context context;

    public CustomBatsmanAdapter(ArrayList<ScoreModel.DataTeam.ScorecardTeam.TeamA.Batsman> batsman, Context context) {
        this.batsman = batsman;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.batsman,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ScoreModel.DataTeam.ScorecardTeam.TeamA.Batsman batsmanlist=batsman.get(position);
        holder.batsman_name.setText(batsmanlist.getName());
        holder.balls.setText(batsmanlist.getBall());
        holder.run.setText(batsmanlist.getRun());
        holder.fours.setText(batsmanlist.getFours());
        holder.sixes.setText(batsmanlist.getSixes());
        holder.sr.setText(batsmanlist.getStrike_rate());



    }

    @Override
    public int getItemCount() {
        return batsman.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
       TextView batsman_name,run,balls,fours,sixes,sr;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            batsman_name=itemView.findViewById(R.id.batsman_name);
            run=itemView.findViewById(R.id.run);
            balls=itemView.findViewById(R.id.balls);
            fours=itemView.findViewById(R.id.fours);
            sixes=itemView.findViewById(R.id.sixes);
            sr=itemView.findViewById(R.id.sr);

        }
    }
}
