package org.mula.finance.Models;

import com.google.gson.annotations.SerializedName;

public class DailyPrice {

    //remember date
    @SerializedName("1. open")
    private String dailyOpen;
    @SerializedName("2. high")
    private String dailyHigh;
    @SerializedName("3. low")
    private String dailyLow;
    @SerializedName("4. close")
    private String dailyClose;
    @SerializedName("5. volume")
    private String dailyVolume;

    public DailyPrice( String dailyOpen, String dailyHigh, String dailyLow, String dailyClose, String dailyVolume){
        //this.dailyDate = dailyDate
        this.dailyOpen = dailyOpen;
        this.dailyHigh = dailyHigh;
        this.dailyLow = dailyLow;
        this.dailyClose = dailyClose;
        this.dailyVolume = dailyVolume;
    }

 /*   public String getDailyDate() {
        return dailyDate;
    }

    public void setDailyDate(String dailyDate) {
        this.dailyDate = dailyDate;
    }*/

    public String getDailyOpen() {
        return dailyOpen;
    }

    public void setDailyOpen(String dailyOpen) {
        this.dailyOpen = dailyOpen;
    }

    public String getDailyHigh() {
        return dailyHigh;
    }

    public void setDailyHigh(String dailyHigh) {
        this.dailyHigh = dailyHigh;
    }

    public String getDailyLow() {
        return dailyLow;
    }

    public void setDailyLow(String dailyLow) {
        this.dailyLow = dailyLow;
    }

    public String getDailyClose() {
        return dailyClose;
    }

    public void setDailyClose(String dailyClose) {
        this.dailyClose = dailyClose;
    }

    public String getDailyVolume() {
        return dailyVolume;
    }

    public void setDailyVolume(String dailyVolume) {
        this.dailyVolume = dailyVolume;
    }
}

