package com.gh.app.militaryforce.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.gh.app.militaryforce.R;
import com.gh.app.militaryforce.base.BaseActivity;
import com.gh.app.militaryforce.fragment.CitysFragment;

import butterknife.ButterKnife;

/**
 * Created by gaohang on 15/9/23.
 */
public class CityActivity extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citys);
        ButterKnife.bind(this);
        initView();
    }


    @Override
    public void initView() {
        //tag=(Tag) getIntent().getSerializableExtra("key");
        FragmentManager fragmentManger=getFragmentManager();
        FragmentTransaction transaction=fragmentManger.beginTransaction();
        CitysFragment citysFragment=new CitysFragment();
        transaction.add(R.id.city_fragment_container, citysFragment,"无锡市");
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
