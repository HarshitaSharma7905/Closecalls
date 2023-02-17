package com.example.closecalls;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomAdapterHome extends  RecyclerView.Adapter<CustomAdapterHome.ViewHolder>{
    ArrayList<HomeModel.data> list;
    Context context;

    public CustomAdapterHome(ArrayList<HomeModel.data> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.matchlist,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final HomeModel.data dataList=list.get(position);
        holder.match_id.setText(dataList.getMatch_id());
        holder.series.setText(dataList.getSeries());
        holder.venue.setText(dataList.getVenue());
        holder.team_a.setText(dataList.getTeam_a_short());
        holder.team_b.setText(dataList.getTeam_b_short());
        holder.timeDate.setText(dataList.getMatch_time()+","+dataList.getMatch_date());
        holder.match_type.setText(dataList.getMatch_type());
        String url_img_a=dataList.getTeam_a_img();
        Picasso.get()
                .load(url_img_a)
                .into(holder.img_a);
        String url_img_b=dataList.getTeam_b_img();
        Picasso.get()
                .load(url_img_b)
                .into(holder.img_b);
        holder.btnGame.setVisibility(View.VISIBLE);
        if(dataList.getMatch_status().equals("Live")){
//            holder.matchStatus.setVisibility(View.VISIBLE);
//            holder.btnGame.setVisibility(View.VISIBLE);
        }
        else
        {
//

        }
//        enter into game
        holder.btnGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String match_id=holder.match_id.getText().toString();
                String venue=holder.venue.getText().toString();
                Intent iGame=new Intent(v.getContext(),GameActivity.class);
                iGame.putExtra("match_id",match_id);
                iGame.putExtra("venue",venue);
                v.getContext().startActivity(iGame);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{
        TextView series,venue,team_a,team_b,timeDate,match_type,matchStatus,match_id,btnGame,timer;
        ImageView img_a,img_b;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            match_id=itemView.findViewById(R.id.match_id);
            series=itemView.findViewById(R.id.series);
            venue=itemView.findViewById(R.id. venue);
            team_a=itemView.findViewById(R.id.team_a);
            team_b=itemView.findViewById(R.id.team_b);
            timeDate=itemView.findViewById(R.id.timeDate);
            match_type=itemView.findViewById(R.id.match_type);
            matchStatus=itemView.findViewById(R.id.matchStatus);
            img_a=itemView.findViewById(R.id.img_a);
            img_b=itemView.findViewById(R.id.img_b);
            btnGame=itemView.findViewById(R.id.btnGame);
            timer=itemView.findViewById(R.id.timer);
        }
    }
}
