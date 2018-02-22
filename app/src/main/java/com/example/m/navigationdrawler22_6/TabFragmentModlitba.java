package com.example.m.navigationdrawler22_6;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class TabFragmentModlitba extends Fragment {

    public  static TabLayout tabLayout;
    public  static ViewPager viewPager;
    public  static int int_items= 3;



    public TabFragmentModlitba() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View m = inflater.inflate(R.layout.fragment_tab,null);
        tabLayout=(TabLayout)m.findViewById(R.id.tabs);
        viewPager=(ViewPager)m.findViewById(R.id.viewpager);
        //set an adpater

        viewPager.setAdapter(new MyAdapter1( getChildFragmentManager()));

        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });
        return m;


    }

}
