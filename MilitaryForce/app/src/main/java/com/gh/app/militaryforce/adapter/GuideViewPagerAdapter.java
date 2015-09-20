package com.gh.app.militaryforce.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import java.util.List;

/**
 * Created by gaohang on 15/9/20.
 */
public class GuideViewPagerAdapter extends PagerAdapter {

    private List<View> list_view;
    private Context context;

    public GuideViewPagerAdapter(List<View> list_view, Context context) {
        this.list_view = list_view;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list_view.size();
    }

    @Override
    public void destroyItem(View container, int position, Object object) {
        ((ViewPager)container).removeView(list_view.get(position));

    }

    @Override
    public Object instantiateItem(View container, int position) {
        ((ViewPager)container).addView(list_view.get(position));
        return list_view.get(position);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==object);
    }


}
