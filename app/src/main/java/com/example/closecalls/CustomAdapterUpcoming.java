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

public class CustomAdapterUpcoming extends  RecyclerView.Adapter<CustomAdapterUpcoming.ViewHolder>{
    ArrayList<HomeModel.data> list;
    Context context;

    public CustomAdapterUpcoming(ArrayList<HomeModel.data> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomAdapterUpcoming.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.matchlist,parent,false);
        CustomAdapterUpcoming.ViewHolder viewHolder=new CustomAdapterUpcoming.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapterUpcoming.ViewHolder holder, int position) {
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

//        enter into game


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{
        TextView series,venue,team_a,team_b,timeDate,match_type,matchStatus,match_id;
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
        }
    }
}
