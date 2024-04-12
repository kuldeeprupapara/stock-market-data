package com.stock.data.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ExchangeList {
    @SerializedName("data")
    private List<Exchange> exchanges;
}
