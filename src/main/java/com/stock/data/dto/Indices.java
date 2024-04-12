package com.stock.data.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Indices extends MarketEntity {
  public Indices(
      String symbol,
      String name,
      String currency,
      String exchange,
      String micCode,
      String country) {
    super(symbol, name, currency, exchange, micCode, country);
  }
}
