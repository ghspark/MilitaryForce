package com.gh.app.militaryforce.util;

import com.gh.app.militaryforce.bean.City;
import com.gh.app.militaryforce.bean.CityLists;
import com.gh.app.militaryforce.bean.News;
import com.gh.app.militaryforce.bean.NewsResult;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gaohang on 15/9/23.
 */
public class JsonTools {

    /**
     * 解析城市列表
     */

    public static List<City> parseCityList(String citys){
        CityLists cityLists=null;
        Gson gson=new Gson();
        cityLists=gson.fromJson(citys,CityLists.class);
        return cityLists.getResult();
    }

    /**
     * 解析新闻列表
     */
public static List<News> parseNewsList(String news){
    List<News> news_list=new ArrayList<News>();
    Gson gson=new Gson();
    NewsResult newsResult=new NewsResult();
    newsResult=gson.fromJson(news, NewsResult.class);
    return newsResult.getShowapi_res_body().getPagebean().getContentlist();
}

}
