package com.example.openinapp.data_package.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.openinapp.R;
import com.example.openinapp.adapter_package.Recentlink_Adapter;
import com.example.openinapp.adapter_package.Toplinks_Adapter;
import com.example.openinapp.data_package.AllMethod_Variable;
import com.example.openinapp.data_package.RecentLink;
import com.example.openinapp.data_package.TopLink;

import java.util.ArrayList;
import java.util.List;

public class RecentLinks extends Fragment {

View view;
    List<RecentLink> recentLinks=new ArrayList<>();
RecyclerView  recyclerView;
    public RecentLinks() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        recentLinks= AllMethod_Variable.dashboardResponse_for_ALLdata.getData().getRecentLinks();
        view = inflater.inflate(R.layout.fragment_recent_links, container, false);
        recyclerView=view.findViewById(R.id.recyclivew_recentlink);
        set_data_on_top_links();

        return view;
    }
    void set_data_on_top_links(){
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        Recentlink_Adapter recentlink_adapter=new Recentlink_Adapter(recentLinks,requireContext());
        recyclerView.setAdapter(recentlink_adapter);




    }

}