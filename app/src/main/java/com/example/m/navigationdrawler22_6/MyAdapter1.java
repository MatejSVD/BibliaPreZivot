package com.example.m.navigationdrawler22_6;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import static com.example.m.navigationdrawler22_6.TabFragment.int_items;

/**
 * Created by Admin on 3/1/2017.
 */

public class MyAdapter1  extends FragmentPagerAdapter {


    public MyAdapter1(FragmentManager fm)
    {
        super(fm);
    }
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new ModlitbaTab1();

            case 1:
                return new ModlitbaTab2();
            case 2:
                return new ModlitbaTab3();



        }
        return null;
    }

    @Override
    public int getCount() {


        return int_items;
    }

    public CharSequence getPageTitle(int position){
        switch (position){
            case 0:
                return "Ráno";
            case 1:
                return "Na obed";
            case 2:
                return "Večer";



        }

        return null;
    }
}
