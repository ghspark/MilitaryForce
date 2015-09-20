package com.gh.app.militaryforce.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.gh.app.militaryforce.MainActivity;
import com.gh.app.militaryforce.R;
import com.gh.app.militaryforce.adapter.GuideViewPagerAdapter;
import com.gh.app.militaryforce.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by gaohang on 15/9/20.
 */
public class GuideActivity extends BaseActivity{

    private List<View> list_view;
    private GuideViewPagerAdapter mAdapter;
    private static final int point[]={R.id.iv1,R.id.iv2,R.id.iv3};
    private  ImageView iv;

    @Bind(R.id.guide_vp)
    android.support.v4.view.ViewPager guide_vp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        ButterKnife.bind(this);
        initView();
    }

    @Override
    public void initView() {
        View firstView= LayoutInflater.from(getApplicationContext()).inflate(R.layout.adapter_first,null);
        View secondView=LayoutInflater.from(getApplicationContext()).inflate(R.layout.adapter_second,null);
        View thirdView=LayoutInflater.from(getApplicationContext()).inflate(R.layout.adapter_third,null);
        list_view=new ArrayList<View>();
        list_view.add(firstView);
        list_view.add(secondView);
        list_view.add(thirdView);
        mAdapter=new GuideViewPagerAdapter(list_view,getApplicationContext());
        guide_vp.setAdapter(mAdapter);

        guide_vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for(int i=0;i<point.length;i++){
                  iv= (ImageView) findViewById(point[i]);
                    if(i==position){
                        iv.setImageResource(R.drawable.login_point_selected);
                    }else{
                        iv.setImageResource(R.drawable.login_point);
                    }
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        thirdView.findViewById(R.id.bt_goin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itent = new Intent();
                itent.setClass(getApplicationContext(), MainActivity.class);
                startActivity(itent);
                finish();
            }
        });


    }

    @Override
    public void initData() {
    }
}
