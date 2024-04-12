package com.stock.data.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
public abstract class MarketEntity {
  @SerializedName("symbol")
  protected String symbol;

  @SerializedName("name")
  protected String name;

  @SerializedName("currency")
  protected String currency;

  @SerializedName("exchange")
  protected String exchange;

  @SerializedName("mic_code")
  protected String micCode;

  @SerializedName("country")
  private String country;

  public MarketEntity(
      String symbol,
      String name,
      String currency,
      String exchange,
      String micCode,
      String country) {
    this.symbol = symbol;
    this.name = name;
    this.currency = currency;
    this.exchange = exchange;
    this.micCode = micCode;
    this.country = country;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    MarketEntity that = (MarketEntity) o;
    return Objects.equals(symbol, that.symbol) && Objects.equals(name, that.name) && Objects.equals(currency, that.currency) && Objects.equals(exchange, that.exchange) && Objects.equals(micCode, that.micCode) && Objects.equals(country, that.country);
  }

  @Override
  public int hashCode() {
    return Objects.hash(symbol, name, currency, exchange, micCode, country);
  }
}
