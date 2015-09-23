package com.gh.app.militaryforce;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.gh.app.militaryforce.ui.MainTab;
import com.gh.app.militaryforce.widget.MyFragmentTabHost;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends FragmentActivity {
    @Bind(R.id.tabhost)
    MyFragmentTabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initViews();

    }

    public void initViews(){
        //mTabHost.setup(getLocalActivityManager());
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        mTabHost.getTabWidget().setDividerDrawable(null);
        initTabs();
        mTabHost.setCurrentTab(0);

    }

    private void initTabs(){
        MainTab[] tabs = MainTab.values();
        final int size = tabs.length;
        for (int i = 0; i < size; i++) {
            MainTab mainTab = tabs[i];
            TabHost.TabSpec tab = mTabHost.newTabSpec(getString(mainTab.getResName()));
            final View indicator = LayoutInflater.from(getApplicationContext())
                    .inflate(R.layout.tab_indicator, null);
            TextView title = (TextView) indicator.findViewById(R.id.tab_title);

            ImageView icon= (ImageView) indicator.findViewById(R.id.tab_icon);
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


//            mTabHost.getTabWidget().getChildAt(i).setOnTouchListener(new View.OnTouchListener() {
//                @Override
//                public boolean onTouch(View v, MotionEvent event) {
//                    for (int j = 0; j < size; j++) {
//                        if(j==i){
//                            TextView tab_title = (TextView) indicator.findViewById(R.id.tab_title);
//                            tab_title.setTextColor(getResources().getColor(R.color.dark_blue));
//                        }
//                    }
//                    return false;
//                }
//            });


        }

    }


}
