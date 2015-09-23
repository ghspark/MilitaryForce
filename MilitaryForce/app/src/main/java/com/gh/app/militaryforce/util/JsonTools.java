package com.gh.app.militaryforce.util;

import com.gh.app.militaryforce.bean.City;
import com.gh.app.militaryforce.bean.CityLists;
import com.google.gson.Gson;

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
}
