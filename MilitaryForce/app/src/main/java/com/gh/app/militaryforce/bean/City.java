package com.gh.app.militaryforce.bean;

/**
 * Created by gaohang on 15/9/23.
 */
public class City {
    private int id;
    private String city_name;
    private String city_pre;
    private String city_pinyin;
    private String city_short;
    private int count;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getCity_pre() {
        return city_pre;
    }

    public void setCity_pre(String city_pre) {
        this.city_pre = city_pre;
    }

    public String getCity_pinyin() {
        return city_pinyin;
    }

    public void setCity_pinyin(String city_pinyin) {
        this.city_pinyin = city_pinyin;
    }

    public String getCity_short() {
        return city_short;
    }

    public void setCity_short(String city_short) {
        this.city_short = city_short;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
