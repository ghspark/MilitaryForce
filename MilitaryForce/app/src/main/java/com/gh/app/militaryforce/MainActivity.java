package com.gh.app.militaryforce;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.gh.app.militaryforce.activity.CityActivity;
import com.gh.app.militaryforce.ui.MainTab;
import com.gh.app.militaryforce.widget.MyFragmentTabHost;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends FragmentActivity implements View.OnClickListener {
    @Bind(R.id.tabhost)
    MyFragmentTabHost mTabHost;
    @Bind(R.id.left_point)
    ImageView left_point;

    @Bind(R.id.city_name)
    TextView city_name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initViews();

    }

    public void initViews() {
        //mTabHost.setup(getLocalActivityManager());
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        mTabHost.getTabWidget().setDividerDrawable(null);
        initTabs();
        mTabHost.setCurrentTab(0);
        left_point.setOnClickListener(this);


    }

    private void initTabs() {
        MainTab[] tabs = MainTab.values();
        final int size = tabs.length;
        for (int i = 0; i < size; i++) {
            MainTab mainTab = tabs[i];
            TabHost.TabSpec tab = mTabHost.newTabSpec(getString(mainTab.getResName()));
            final View indicator = LayoutInflater.from(getApplicationContext())
                    .inflate(R.layout.tab_indicator, null);
            TextView title = (TextView) indicator.findViewById(R.id.tab_title);

            ImageView icon = (ImageView) indicator.findViewById(R.id.tab_icon);
            Drawable drawable = this.getResources().getDrawable(
                    mainTab.getResIcon());
            icon.setImageDrawable(drawable);
            title.setCompoundDrawablesWithIntrinsicBounds(null, null, null,
                    null);
            title.setText(getString(mainTab.getResName()));
            tab.setIndicator(indicator);
            tab.setContent(new TabHost.TabContentFactory() {

                @Override
                public View createTabContent(String tag) {
                    return new View(MainActivity.this);
                }
            });
            mTabHost.addTab(tab, mainTab.getClz(), null);

        }

    }

    public void selectCity() {
        RotateAnimation ra = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        ra.setDuration(500);
        left_point.startAnimation(ra);
        ra.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent it=new Intent();
                Bundle bundle=new Bundle();
                bundle.putString("nowCityName", city_name.getText().toString());
                it.putExtras(bundle);
                it.setClass(getApplicationContext(), CityActivity.class);
                startActivityForResult(it,0);

            }



            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
     if(resultCode==1){
      String cityName=data.getExtras().get("selectCityName").toString();
         city_name.setText(cityName);
     }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.left_point:
                selectCity();
                break;

            default:
                break;
        }
    }
}
