package com.gh.app.militaryforce.bean;

import java.util.List;

/**
 * Created by gaohang on 15/9/24.
 */
public class News {
    private String channelId;
    private String channelName;
    private Comments comment;
    private String desc;
    private List<Images> imageurls;
    private String link;
    private String nid;
    private String pubDate;
    private String source;
    private String title;

    @Override
    public String toString() {
        return "News{" +
                "channelId='" + channelId + '\'' +
                ", channelName='" + channelName + '\'' +
                ", comment=" + comment +
                ", desc='" + desc + '\'' +
                ", imageurls="  +
                ", link='" + link + '\'' +
                ", nid='" + nid + '\'' +
                ", pubDate='" + pubDate + '\'' +
                ", source='" + source + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public Comments getComment() {
        return comment;
    }

    public void setComment(Comments comment) {
        this.comment = comment;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<Images> getImageurls() {
        return imageurls;
    }

    public void setImageurls(List<Images> imageurls) {
        this.imageurls = imageurls;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

















