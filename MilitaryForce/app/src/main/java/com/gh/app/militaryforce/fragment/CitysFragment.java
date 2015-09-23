package com.gh.app.militaryforce.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.gh.app.militaryforce.MainActivity;
import com.gh.app.militaryforce.R;
import com.gh.app.militaryforce.adapter.CitysAdapter;
import com.gh.app.militaryforce.bean.City;
import com.gh.app.militaryforce.ui.MyLetterSortView;
import com.gh.app.militaryforce.util.AppController;
import com.gh.app.militaryforce.util.JsonTools;
import com.gh.app.militaryforce.util.T;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import butterknife.Bind;
import butterknife.ButterKnife;


public class CitysFragment extends BaseFragment {


    private View view;
    private ListView city_list;
    private MyLetterSortView myLetterSortView;
    private CitysAdapter mAdapter;
    private List<City> list_city;
    private ImageView imageView;
    private TextView tv_mid_letter;
    private LinearLayout back_li;
    private String currentCityName;
    private static String CITYS_URL = "http://v.juhe.cn/movie/citys?key=853dcc3f53fca20427f180420b609c6a";

    @Bind(R.id.secTitle)
    TextView secTitle;

    @Bind(R.id.back)
    Button back;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.city_select, container, false);
        currentCityName = getActivity().getIntent().getExtras().get("nowCityName").toString();
        initTitleBar();
        initView();
        initData();
        ButterKnife.bind(view);
        return view;
    }


    public void initTitleBar() {
        back = (Button) view.findViewById(R.id.back);
        secTitle = (TextView) view.findViewById(R.id.secTitle);
        secTitle.setText(R.string.city_select);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });

    }

    @Override
    public void initView() {
        city_list = (ListView) view.findViewById(R.id.city_list);
        myLetterSortView = (MyLetterSortView) view
                .findViewById(R.id.right_letter);
        tv_mid_letter = (TextView) view.findViewById(R.id.tv_mid_letter);
        myLetterSortView.setTextView(tv_mid_letter);
        city_list.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent it = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("selectCityName", list_city.get(position).getCity_name());
                it.putExtras(bundle);
                it.setClass(getActivity(), MainActivity.class);
                getActivity().setResult(1, it);
                getActivity().finish();

            }
        });
        myLetterSortView.setOnTouchingLetterChangedListener(new MyLetterSortView.OnTouchingLetterChangedListener() {

            @Override
            public void onTouchingLetterChanged(String s) {
                int position = mAdapter.getPositionForSection(s.charAt(0));
                if (position != -1) {
                    city_list.setSelection(position);
                }
            }
        });
        //imageView.setOnClickListener(this);
    }


    @Override
    public void initData() {
        StringRequest request = new StringRequest(CITYS_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {

                //list_city=JsonTools.parseCityList(s);
                loadData(JsonTools.parseCityList(s));

            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                T.d(getActivity(), "对不起，下载出错了");
            }
        });

        AppController.getInstance().addToRequestQueue(request);

    }

    public void loadData(List<City> mListCity) {

        list_city = mListCity;

        //T.d(getActivity(),getActivity().getIntent().getExtras().get("nowCityName").toString());


        mAdapter = new CitysAdapter(view.getContext());
        mAdapter.addData(list_city);
        Set<String> mSet = new TreeSet<String>();
        for (City mcity : list_city) {
            mSet.add(mcity.getCity_pre());
        }
        String[] mLetter;
        mLetter = new String[mSet.size()];

        Iterator it = mSet.iterator();
        int i = 0;
        while (it.hasNext()) {
            mLetter[i] = (String) it.next();
            i++;
        }
        myLetterSortView.addDatas(mLetter);
        myLetterSortView.invalidate();
        mAdapter.setCurrentCity(currentCityName);
        city_list.setAdapter(mAdapter);
    }

}
