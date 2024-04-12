package com.stock.data.dto;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Objects;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Cryptocurrencies {
  @SerializedName("symbol")
  private String symbol;

  @SerializedName("available_exchanges")
  private List<String> availableExchanges;

  @SerializedName("currency_base")
  private String currencyBase;

  @SerializedName("currency_quote")
  private String currencyQuote;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Cryptocurrencies that = (Cryptocurrencies) o;
    return Objects.equals(symbol, that.symbol) && Objects.equals(availableExchanges, that.availableExchanges) && Objects.equals(currencyBase, that.currencyBase) && Objects.equals(currencyQuote, that.currencyQuote);
  }

  @Override
  public int hashCode() {
    return Objects.hash(symbol, availableExchanges, currencyBase, currencyQuote);
  }
}
