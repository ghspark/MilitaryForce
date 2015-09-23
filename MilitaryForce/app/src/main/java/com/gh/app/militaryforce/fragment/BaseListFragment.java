package com.gh.app.militaryforce.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gh.app.militaryforce.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BaseListFragment extends Fragment {


    public BaseListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_base_list, container, false);
    }


}
