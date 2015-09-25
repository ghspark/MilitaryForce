package com.gh.app.militaryforce.util;

/**
 * Created by gaohang on 15/9/24.
 */
public class NewsUrlUtil {
    private static final String
    baseUrl="http://apis.baidu.com/showapi_open_bus/channel_news/search_news";


    public static String getNewsUrl(String id,String name,int page){
        String url=baseUrl+"?"+"channelId="+id+"&"+"channelName="+name+"&"+"page="+page;
        return url;
    }
}
