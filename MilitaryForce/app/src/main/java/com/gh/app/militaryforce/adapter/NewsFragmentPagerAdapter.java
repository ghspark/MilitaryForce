package com.gh.app.militaryforce.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.gh.app.militaryforce.fragment.DomesticFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gaohang on 15/9/24.
 */
public class NewsFragmentPagerAdapter extends FragmentPagerAdapter {
    private FragmentManager manager;
    private List<String> indicator_name;

    public NewsFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        this.indicator_name=new ArrayList<String>();
    }

    public void addDatas(List<String> list_str){
        indicator_name.addAll(list_str);
    }


    @Override
    public Fragment getItem(int position) {
        return new DomesticFragment();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return indicator_name.get(position);
    }

    @Override
    public int getCount() {
        return indicator_name.size();
    }
}
