package com.gh.app.militaryforce.bean;

import java.util.List;

/**
 * Created by gaohang on 15/9/23.
 */
public class CityLists {
    private String reason;
    private List<City> result;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<City> getResult() {
        return result;
    }

    public void setResult(List<City> result) {
        this.result = result;
    }
}
