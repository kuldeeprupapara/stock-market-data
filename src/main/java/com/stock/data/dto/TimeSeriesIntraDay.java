package com.stock.data.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class TimeSeriesIntraDay {
    @SerializedName("Time Series (1min)")
    private Map<String, TimeSeriesEntry> timeSeriesMap; // time series intra day
    @SerializedName("Time Series (Daily)")
    private Map<String, TimeSeriesEntry> timeSeriesDaily; // time series daily data
}
