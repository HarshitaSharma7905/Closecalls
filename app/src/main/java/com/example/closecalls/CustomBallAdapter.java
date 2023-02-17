package com.example.closecalls;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomBallAdapter extends RecyclerView.Adapter<CustomBallAdapter.ViewHolder> {
    ArrayList<MatchDetailsModel.Data.Last36Balls> list;
    Context context;

    public CustomBallAdapter(ArrayList<MatchDetailsModel.Data.Last36Balls> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.lastballs,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final MatchDetailsModel.Data.Last36Balls last36Balls=list.get(position);
        holder.ball.setText(last36Balls.getList().indexOf(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{
         TextView ball;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ball=itemView.findViewById(R.id.ball);

        }
    }
}
