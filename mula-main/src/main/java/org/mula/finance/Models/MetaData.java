package org.mula.finance.Models;

import com.google.gson.annotations.SerializedName;


public class MetaData {
    @SerializedName("1. Information")
    private String information;
    @SerializedName("2. Symbol")
    private String symbol;
    @SerializedName("3. Last Refreshed")
    private String lastRefresh;
    @SerializedName("4. Interval")
    private String interval;
    @SerializedName("5. Output Size")
    private String outputSize;
    @SerializedName("6. Time Zone")
    private String timezone;

    public MetaData(String information, String symbol, String lastRefresh, String interval, String outputSize, String timezone){
        this.information = information;
        this.symbol = symbol;
        this.lastRefresh = lastRefresh;
        this.interval = interval;
        this.outputSize = outputSize;
        this.timezone = timezone;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getLastRefresh() {
        return lastRefresh;
    }

    public void setLastRefresh(String lastRefresh) {
        this.lastRefresh = lastRefresh;
    }

    public String getOutputSize() {
        return outputSize;
    }

    public void setOutputSize(String outputSize) {
        this.outputSize = outputSize;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
}


