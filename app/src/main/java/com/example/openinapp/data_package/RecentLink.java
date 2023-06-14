package com.example.openinapp.data_package;

import com.google.gson.annotations.SerializedName;

public  class RecentLink {
    @SerializedName("url_id")
    private int url_id;
    @SerializedName("web_link")
    private String web_link;
    @SerializedName("smart_link")
    private String mart_link;
    @SerializedName("title")
    private String title;
    @SerializedName("total_clicks")
    private int total_clicks;
    @SerializedName("original_image")
    private String original_image;
    @SerializedName("thumbnail")
    private String thumbnail;
    @SerializedName("times_ago")
    private String timesAgo;
    @SerializedName("created_at")
    private String created_at;
    @SerializedName("domain_id")
    private String domain_id;
    @SerializedName("url_prefix")
    private String url_prefix;
    @SerializedName("url_suffix")
    private String url_suffix;
    @SerializedName("app")
    private String app;

    public int getUrl_id() {
        return url_id;
    }

    public void setUrl_id(int url_id) {
        this.url_id = url_id;
    }

    public String getWeb_link() {
        return web_link;
    }

    public void setWeb_link(String web_link) {
        this.web_link = web_link;
    }

    public String getMart_link() {
        return mart_link;
    }

    public void setMart_link(String mart_link) {
        this.mart_link = mart_link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTotal_clicks() {
        return total_clicks;
    }

    public void setTotal_clicks(int total_clicks) {
        this.total_clicks = total_clicks;
    }

    public String getOriginal_image() {
        return original_image;
    }

    public void setOriginal_image(String original_image) {
        this.original_image = original_image;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTimesAgo() {
        return timesAgo;
    }

    public void setTimesAgo(String timesAgo) {
        this.timesAgo = timesAgo;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getDomain_id() {
        return domain_id;
    }

    public void setDomain_id(String domain_id) {
        this.domain_id = domain_id;
    }

    public String getUrl_prefix() {
        return url_prefix;
    }

    public void setUrl_prefix(String url_prefix) {
        this.url_prefix = url_prefix;
    }

    public String getUrl_suffix() {
        return url_suffix;
    }

    public void setUrl_suffix(String url_suffix) {
        this.url_suffix = url_suffix;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }
    // Getters for all the fields
}