package com.example.openinapp.data_package;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.openinapp.data_package.fragment.RecentLinks;
import com.example.openinapp.data_package.fragment.TopLinks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TabAdapter extends FragmentPagerAdapter {
    private final List<Fragment> mFragmentList = new ArrayList<> ();



    public TabAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }



    @NonNull
    @Override
    public Fragment getItem(int position) {


        Fragment fragment=null;
        switch (position){


            case 0:


                fragment= new TopLinks();




                break;
            case 1:


                fragment=new RecentLinks();

                break;


        }
        return  fragment;

    }



    @Override
    public int getCount() {

        return 2;
    }


    @Override
    public CharSequence getPageTitle(int position) {

        String name="";
        switch (position){
            case 0:
                name="Top Links";
                break;
            case  1:
                name="Recent Links";
                break;

        }

        return name;
    }

}
