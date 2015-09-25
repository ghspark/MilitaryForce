package com.gh.app.militaryforce.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.gh.app.militaryforce.R;
import com.gh.app.militaryforce.adapter.DomesticNewsAdapter;
import com.gh.app.militaryforce.bean.News;
import com.gh.app.militaryforce.util.AppController;
import com.gh.app.militaryforce.util.JsonTools;
import com.gh.app.militaryforce.util.NewsUrlUtil;
import com.gh.app.militaryforce.util.T;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by gaohang on 15/9/24.
 */
public class DomesticFragment extends BaseListFragment {
    private static String apiKey = "e21217fdcfeedba3ae183350583ba54e";
    private int page = 0;
    private List<News> list_news;
    private DomesticNewsAdapter mAdapter;

    @Bind(R.id.domestic_refresh_view)
    PullToRefreshListView refreshListView;

    @Bind(R.id.no_moredata_tv)
    TextView no_moredata_tv;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_domestic, container, false);
        ButterKnife.bind(this, rootView);
        initViews(rootView);
        initDatas();
        return rootView;
    }

    public void initViews(View view) {
        refreshListView.setMode(PullToRefreshBase.Mode.BOTH);
        refreshListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent itent = new Intent();
//                Bundle bundle = new Bundle();
//                T.d(getActivity(),list_news.get(position).getLink());
//                bundle.putString("d_url", list_news.get(position).getLink());
//                itent.putExtras(bundle);
//                itent.setClass(getActivity(), DomesticNewsActivity.class);
//                startActivity(itent);
                //T.d(getActivity(),list_news.size()+":"+position);
                if ((position - 1) <= list_news.size()) {
                    new WebView(getActivity()).loadUrl(list_news.get(position - 1).getLink());
                }

            }
        });
        list_news = new ArrayList<News>();
        mAdapter = new DomesticNewsAdapter(view.getContext());
        refreshListView.setAdapter(mAdapter);
        showData();


    }

    public void initDatas() {
        refreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                showData();

            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                showData();
//                mAdapter.notifyDataSetChanged();
//                refreshView.onRefreshComplete();
            }
        });
    }

    public void showData() {
        String url = NewsUrlUtil.getNewsUrl("5572a108b3cdc86cf39001cd", "国内焦点", page);
        page += 1;
        StringRequest domesticRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Log.d("gaohang", s);
                List<News> list = JsonTools.parseNewsList(s);
                if (list != null) {
                    list_news.addAll(list);
                    mAdapter.addDatas(list);
                    mAdapter.notifyDataSetChanged();
                    refreshListView.onRefreshComplete();
                } else {
                    T.d(getActivity(), "没有数据了");
                }


//                refreshListView.setAdapter(mAdapter);
//                refreshListView.onRefreshComplete();

            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                T.d(getActivity(), "请求数据发生错误");
                refreshListView.onRefreshComplete();
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> head = new HashMap<String, String>();
                head.put("apikey", apiKey);
                return head;
            }
        };

        AppController.getInstance().addToRequestQueue(domesticRequest);
    }


}
