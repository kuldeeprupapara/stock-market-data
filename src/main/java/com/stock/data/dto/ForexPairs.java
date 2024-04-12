package com.stock.data.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ForexPairs {
  private String symbol;

  @SerializedName("currency_group")
  private String currencyGroup;

  @SerializedName("currency_base")
  private String currencyBase;

  @SerializedName("currency_quote")
  private String currencyQuote;
}
