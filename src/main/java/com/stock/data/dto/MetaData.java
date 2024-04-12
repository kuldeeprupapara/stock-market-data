package com.stock.data.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MetaData {
    @SerializedName("1. Information")
    private String information;

    @SerializedName("2. Symbol")
    private String symbol;

    @SerializedName("3. Last Refreshed")
    private String lastRefreshed;

    @SerializedName("4. Interval")
    private String interval;

    @SerializedName("5. Output Size")
    private String outputSize;

    @SerializedName("6. Time Zone")
    private String timeZone;
}
