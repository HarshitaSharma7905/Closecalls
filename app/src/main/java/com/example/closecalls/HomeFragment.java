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
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {
  RecyclerView homeView;

    public HomeFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_home, container, false);
        homeView=view.findViewById(R.id.homeView);
        homeView.setLayoutManager(new LinearLayoutManager(getContext()));
        homeView.setHasFixedSize(true);
        APIHome apiHome=RetrofitClass.getRetrofitInterface().create(APIHome.class);
      Call<HomeModel> homeData= apiHome.getHomeData();
      homeData.enqueue(new Callback<HomeModel>() {
          @Override
          public void onResponse(Call<HomeModel> call, Response<HomeModel> response) {
              if(response.isSuccessful()){
                  ArrayList<HomeModel.data> homeData=response.body().getData();
                  for (int i=0;i<homeData.size();i++);
                  CustomAdapterHome customAdapterHome=new CustomAdapterHome(homeData,getContext());
                  homeView.setAdapter(customAdapterHome);
              }
              else {
                  Toast.makeText(getContext(), "No Data", Toast.LENGTH_SHORT).show();
              }
          }

          @Override
          public void onFailure(Call<HomeModel> call, Throwable t) {
              Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();

          }
      });

        return view;
    }
}