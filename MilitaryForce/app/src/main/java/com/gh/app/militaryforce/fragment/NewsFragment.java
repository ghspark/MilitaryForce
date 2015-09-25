package com.gh.app.militaryforce.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gh.app.militaryforce.R;
import com.gh.app.militaryforce.adapter.NewsFragmentPagerAdapter;
import com.gh.app.militaryforce.util.T;
import com.viewpagerindicator.TabPageIndicator;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {
    private List<String> list_newstitle_name;
    private static final String []TITLE_NAME={"国内焦点","国际焦点","军事焦点","财经焦点","互联网焦点","汽车焦点","理财最新"};
    private NewsFragmentPagerAdapter mAdapter;
    private ViewPager pager;
    private TabPageIndicator indicator;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView=inflater.inflate(R.layout.fragment_news, container, false);
        ButterKnife.bind(rootView);
        initViews(rootView);
        initDatas();
        return rootView;
    }

    private void initViews(View view){
        pager= (ViewPager) view.findViewById(R.id.pager);
        indicator= (TabPageIndicator) view.findViewById(R.id.indicator);
    }



    private void initDatas(){
        list_newstitle_name=new ArrayList<String>();
        list_newstitle_name.add("国内");
        list_newstitle_name.add("国际");
        list_newstitle_name.add("军事");
        list_newstitle_name.add("财经");
        list_newstitle_name.add("汽车");
        list_newstitle_name.add("理财");
        list_newstitle_name.add("互联网");
        mAdapter= new NewsFragmentPagerAdapter(getActivity().getSupportFragmentManager());
        mAdapter.addDatas(list_newstitle_name);
        if(pager!=null) {
            pager.setAdapter(mAdapter);
            indicator.setViewPager(pager);
        }else{
            T.d(getActivity(),"error");
        }


    }


}
