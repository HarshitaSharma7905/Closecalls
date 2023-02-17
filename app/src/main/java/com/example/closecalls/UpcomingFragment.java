package com.example.closecalls;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpcomingFragment extends Fragment {
    RecyclerView upcomingView;


    public UpcomingFragment() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_upcoming, container, false);
        upcomingView=view.findViewById(R.id.upcomingView);
        upcomingView.setLayoutManager(new LinearLayoutManager(getContext()));
        upcomingView.setHasFixedSize(true);
        APIUpcoming apiUpcoming=RetrofitClass.getRetrofitInterface().create(APIUpcoming.class);
        Call<HomeModel> dataList=apiUpcoming.getUpcomingData();
        dataList.enqueue(new Callback<HomeModel>() {
            @Override
            public void onResponse(Call<HomeModel> call, Response<HomeModel> response) {
                if(response.isSuccessful()){
                    ArrayList<HomeModel.data> data=response.body().getData();
                    CustomAdapterUpcoming customAdapterUpcoming=new CustomAdapterUpcoming(data,getContext());
                    upcomingView.setAdapter(customAdapterUpcoming);

                }else{
                    Toast.makeText(getContext(), "No Data Found", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<HomeModel> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
        return view;
    }
}