package com.gh.app.militaryforce.task;

import android.os.AsyncTask;

import com.gh.app.militaryforce.bean.News;
import com.gh.app.militaryforce.util.JsonTools;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gaohang on 15/9/24.
 */
public class NewsParseTask extends AsyncTask<String,List<News>,List<News>>{
    @Override
    protected List<News> doInBackground(String... params) {
        List<News> list=new ArrayList<News>();
        list=JsonTools.parseNewsList(params[0]);
        return list;
    }
}
