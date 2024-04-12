package com.stock.symbol;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
public class StockSymbol {
  private String ticker;
  private String name;
  private String exchange;

  @Override
  public String toString() {
    return "ticker='"
        + ticker
        + ", name='"
        + name
        + ", exchange='"
        + exchange
        + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    StockSymbol symbol = (StockSymbol) o;
    return Objects.equals(ticker, symbol.ticker) && Objects.equals(name, symbol.name) && Objects.equals(exchange, symbol.exchange);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ticker, name, exchange);
  }
}
