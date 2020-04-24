package org.mula.finance.Models;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class Company {
    @SerializedName("Meta Data")
    private MetaData metaData;
    @SerializedName("Time Series (60min)")
    private Map<String, DailyPrice> companyStockPrices;

    public Company(MetaData metaData, Map<String, DailyPrice> companyStockPrices){
        this.metaData = metaData;
        this.companyStockPrices = companyStockPrices;
    }

    public Map<String, DailyPrice> getCompanyStockPrices() {
        return companyStockPrices;
    }

    public void setCompanyStockPrices(Map<String, DailyPrice> companyStockPrices) {
        this.companyStockPrices = companyStockPrices;
    }
}

