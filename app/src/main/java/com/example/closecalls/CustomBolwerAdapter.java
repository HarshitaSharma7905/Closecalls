package com.example.closecalls;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomBolwerAdapter extends RecyclerView.Adapter<CustomBolwerAdapter.ViewHolder>{

    ArrayList<ScoreModel.DataTeam.ScorecardTeam.TeamB.Bolwer> bolwer;
    Context context;

    public CustomBolwerAdapter(ArrayList<ScoreModel.DataTeam.ScorecardTeam.TeamB.Bolwer> bolwer, Context context) {
        this.bolwer = bolwer;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.bolwer,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ScoreModel.DataTeam.ScorecardTeam.TeamB.Bolwer bolwerList=bolwer.get(position);
        holder.blowerName.setText(bolwerList.getName());
        holder.blower_overs.setText(bolwerList.getOver());
        holder.blower_runs.setText(bolwerList.getRun());
        holder.blower_wickets.setText(bolwerList.getWicket());
        holder.blower_eco.setText(bolwerList.getEconomy());

    }

    @Override
    public int getItemCount() {
        return bolwer.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView blowerName,blower_overs,blower_runs,blower_wickets,blower_eco;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            blowerName=itemView.findViewById(R.id.blowerName);
            blower_overs=itemView.findViewById(R.id.blower_overs);
            blower_runs=itemView.findViewById(R.id.blower_runs);
            blower_wickets=itemView.findViewById(R.id.blower_wickets);
            blower_eco=itemView.findViewById(R.id.blower_eco);

        }
    }
}
