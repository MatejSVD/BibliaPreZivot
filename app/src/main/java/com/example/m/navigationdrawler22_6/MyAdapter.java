package com.example.m.navigationdrawler22_6;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import static com.example.m.navigationdrawler22_6.TabFragment.int_items;

/**
 * Created by Admin on 3/1/2017.
 */

public class MyAdapter  extends FragmentPagerAdapter {

    private static int NUM_ITEMS = 3;

    public MyAdapter(FragmentManager fm)
    {

        super(fm);
    }


    public int getCount() {


        return int_items;
    }





    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new NaDnes1();
            case 1:
                return new Kalendar2();
            case 2:
                return new Modlitba3();
        }
        return null;
    }

    @Override


    public CharSequence getPageTitle(int position){
        switch (position){
            case 0:
                return "Na dnes";
            case 1:
                return "Kalendár";
            case 2:
                return "Modlitba";
        }

        return null;
    }
}
