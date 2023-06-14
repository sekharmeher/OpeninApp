package com.example.openinapp.data_package;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public  class Data {
    @SerializedName("recent_links")
    private List<RecentLink> recentLinks;
    @SerializedName("top_links")
    private List<TopLink> topLinks;

    private Map<String, Integer> overall_url_chart;

    public List<RecentLink> getRecentLinks() {
        return recentLinks;
    }

    public void setRecentLinks(List<RecentLink> recentLinks) {
        this.recentLinks = recentLinks;
    }

    public List<TopLink> getTopLinks() {
        return topLinks;
    }

    public void setTopLinks(List<TopLink> topLinks) {
        this.topLinks = topLinks;
    }

    public Map<String, Integer> getOverall_url_chart() {
        return overall_url_chart;
    }

    public void setOverall_url_chart(Map<String, Integer> overall_url_chart) {
        this.overall_url_chart = overall_url_chart;
    }
}