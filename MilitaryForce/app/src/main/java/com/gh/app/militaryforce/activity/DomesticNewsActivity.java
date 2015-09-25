package com.gh.app.militaryforce.activity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;

import com.gh.app.militaryforce.R;
import com.gh.app.militaryforce.base.BaseActivity;
import com.gh.app.militaryforce.util.T;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by gaohang on 15/9/25.
 */
public class DomesticNewsActivity extends BaseActivity{
    private String url;
    @Bind(R.id.d_news_container)
    WebView d_news_container;
@Bind(R.id.back)
    ImageView back;
    @OnClick(R.id.back)
    public void back(View v){
        this.finish();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        ButterKnife.bind(this);
        initData();
    }

    @Override
    public void initData() {
      url= getIntent().getExtras().getString("d_url");
        url=url==null ? "http://www.baidu.com" : url;
        T.d(this,url);
        d_news_container.loadUrl(url);

    }
}
