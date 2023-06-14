package com.example.openinapp.data_package;

import com.google.gson.annotations.SerializedName;

public class DashboardResponse {
    @SerializedName("status")
    private boolean status;
    @SerializedName("statusCode")
    private int statusCode;
    @SerializedName("message")
    private String message;
    @SerializedName("support_whatsapp_number")
    private String support_whatsapp_number;
    @SerializedName("extra_income")
    private double extra_income;
    @SerializedName("total_links")
    private int total_links;
    @SerializedName("total_clicks")
    private int total_clicks;
    @SerializedName("today_clicks")
    private int today_clicks;
    @SerializedName("top_source")
    private String top_source;
    @SerializedName("top_location")
    private String top_location;
    @SerializedName("startTime")
    private String startTime;
    @SerializedName("links_created_today")
    private int links_created_today;
    @SerializedName("applied_campaign")
    private int applied_campaign;
    @SerializedName("data")
    private Data data;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSupport_whatsapp_number() {
        return support_whatsapp_number;
    }

    public void setSupport_whatsapp_number(String support_whatsapp_number) {
        this.support_whatsapp_number = support_whatsapp_number;
    }

    public double getExtra_income() {
        return extra_income;
    }

    public void setExtra_income(double extra_income) {
        this.extra_income = extra_income;
    }

    public int getTotal_links() {
        return total_links;
    }

    public void setTotal_links(int total_links) {
        this.total_links = total_links;
    }

    public int getTotal_clicks() {
        return total_clicks;
    }

    public void setTotal_clicks(int total_clicks) {
        this.total_clicks = total_clicks;
    }

    public int getToday_clicks() {
        return today_clicks;
    }

    public void setToday_clicks(int today_clicks) {
        this.today_clicks = today_clicks;
    }

    public String getTop_source() {
        return top_source;
    }

    public void setTop_source(String top_source) {
        this.top_source = top_source;
    }

    public String getTop_location() {
        return top_location;
    }

    public void setTop_location(String top_location) {
        this.top_location = top_location;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public int getLinks_created_today() {
        return links_created_today;
    }

    public void setLinks_created_today(int links_created_today) {
        this.links_created_today = links_created_today;
    }

    public int getApplied_campaign() {
        return applied_campaign;
    }

    public void setApplied_campaign(int applied_campaign) {
        this.applied_campaign = applied_campaign;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}