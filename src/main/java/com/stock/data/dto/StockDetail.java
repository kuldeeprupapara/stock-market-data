package com.stock.data.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
public class StockDetail extends MarketEntity {
  @SerializedName("type")
  private String type;

  public StockDetail(
      String symbol,
      String name,
      String currency,
      String exchange,
      String micCode,
      String country,
      String type) {
    super(symbol, name, currency, exchange, micCode, country);
    this.type = type;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    StockDetail detail = (StockDetail) o;
    return Objects.equals(type, detail.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), type);
  }
}
