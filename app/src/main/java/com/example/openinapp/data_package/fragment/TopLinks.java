package com.example.openinapp.data_package.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.openinapp.R;
import com.example.openinapp.adapter_package.Toplinks_Adapter;
import com.example.openinapp.data_package.AllMethod_Variable;
import com.example.openinapp.data_package.TopLink;

import java.util.ArrayList;
import java.util.List;


public class TopLinks extends Fragment {

    View view;
    RecyclerView recyclerView;


    List<TopLink> topLink=new ArrayList<>();
    public TopLinks() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        topLink= AllMethod_Variable.dashboardResponse_for_ALLdata.getData().getTopLinks();
        view = inflater.inflate(R.layout.fragment_top_links, container, false);
        recyclerView=view.findViewById(R.id.recyclivew_toplink);
        set_data_on_top_links();

        return view;
    }
     void set_data_on_top_links(){
         LinearLayoutManager linearLayoutManager=new LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false);
         recyclerView.setLayoutManager(linearLayoutManager);
         Toplinks_Adapter toplinks_adapter=new Toplinks_Adapter(topLink,requireContext());
         recyclerView.setAdapter(toplinks_adapter);




     }

}