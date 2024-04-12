package com.stock.data.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class StockQuote {
    @SerializedName("01. symbol")
    private String symbol;

    @SerializedName("02. open")
    private String open;

    @SerializedName("03. high")
    private String high;

    @SerializedName("04. low")
    private String low;

    @SerializedName("05. price")
    private String price;

    @SerializedName("06. volume")
    private String volume;

    @SerializedName("07. latest trading day")
    private String latestTradingDay;

    @SerializedName("08. previous close")
    private String previousClose;

    @SerializedName("09. change")
    private String change;

    @SerializedName("10. change percent")
    private String changePercent;

}
