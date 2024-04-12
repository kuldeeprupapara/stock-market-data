package com.stock.data.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@NoArgsConstructor
@Getter
@Setter
public class GlobalQuote {
  @SerializedName("Global Quote")
  private StockQuote stockQuote;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GlobalQuote that = (GlobalQuote) o;
    return Objects.equals(stockQuote, that.stockQuote);
  }

  @Override
  public int hashCode() {
    return Objects.hash(stockQuote);
  }
}
