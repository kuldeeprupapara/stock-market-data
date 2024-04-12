package com.stock.service;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.stock.api.ReferenceDataApiImpl;
import com.stock.api.StockAPIImpl;
import com.stock.data.dto.*;
import java.util.*;
import java.util.function.Supplier;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CacheService {
  @Autowired private ReferenceDataApiImpl serviceAPI;
  @Autowired private StockAPIImpl stockAPI;
  private final Table<String, LocalDate, Map<String, TimeSeriesEntry>> intraDayData =
      HashBasedTable.create();

  private final Table<String, LocalDate, StockQuote> symbolQuote = HashBasedTable.create();
  private final Table<String, LocalDate, Map<String, TimeSeriesEntry>> timeSeries =
      HashBasedTable.create();

  private final Set<StockDetail> stockLists = new HashSet<>();
  private final Set<ETF> etfs = new HashSet<>();
  private final Set<Indices> indices = new HashSet<>();
  private final Set<Cryptocurrencies> cryptocurrencies = new HashSet<>();
  private final Set<Exchange> exchanges = new HashSet<>();
  private final Set<ForexPairs> forexPairs = new HashSet<>();

  public Map<String, TimeSeriesEntry> getIntraDayData(String interval, String symbol) {
    final LocalDate date = getLocalDate();
    if (!intraDayData.contains(interval, date)) {
      final TimeSeriesIntraDay intraDay = stockAPI.getIntraDay(interval, symbol.toUpperCase());
      final Map<String, TimeSeriesEntry> timeSeriesEntryMap = intraDay.getTimeSeriesMap();
      intraDayData.put(symbol, date, timeSeriesEntryMap);
    }
    return intraDayData.get(interval, date);
  }

  public Map<String, TimeSeriesEntry> getTimeSeries(String symbol) {
    final LocalDate date = getLocalDate();
    return checkAndGet(
        symbol, date, this.timeSeries, () -> stockAPI.getTimeSeries(symbol).getTimeSeriesDaily());
  }

  public StockQuote getQuote(String symbol) {
    final LocalDate date = getLocalDate();
    return checkAndGet(
        symbol, date, this.symbolQuote, () -> stockAPI.getQuoteBySymbol(symbol).getStockQuote());
  }

  public Set<StockDetail> getStockLists() {
    return checkAndGet(this.stockLists, () -> this.serviceAPI.getStockList().getData());
  }

  public Set<ETF> getEtfs() {
    return checkAndGet(this.etfs, () -> this.serviceAPI.getETFList().getEtfs());
  }

  public Set<Indices> getIndices() {
    return checkAndGet(this.indices, () -> this.serviceAPI.getIndicesList().getIndices());
  }

  public Set<Cryptocurrencies> getCryptocurrencies() {
    return checkAndGet(
        this.cryptocurrencies, () -> this.serviceAPI.getCryptoCurrencyList().getCryptocurrencies());
  }

  public Set<Exchange> getExchanges() {
    return checkAndGet(this.exchanges, () -> this.serviceAPI.getExchangesList().getExchanges());
  }

  public Set<ForexPairs> getForexPairs() {
    return checkAndGet(this.forexPairs, () -> this.serviceAPI.getForexPairList().getData());
  }

  // for trading data
  private <V> V checkAndGet(
      String symbol, LocalDate date, Table<String, LocalDate, V> table, Supplier<V> supplier) {
    if (!table.contains(symbol, date)) {
      table.put(symbol, date, supplier.get());
    }
    return table.get(symbol, date);
  }

  // for reference data
  private <T> Set<T> checkAndGet(Set<T> set, Supplier<List<T>> supplier) {
    if (set.isEmpty()) {
      set.addAll(supplier.get());
    }
    return set;
  }

  private String checkWeekendBefore(LocalDate date) {
    return date.minusDays(1).dayOfWeek().getAsText();
  }

  private LocalDate getLocalDate() {
    final LocalDate date = LocalDate.now();
    final String day = checkWeekendBefore(date);
    if (day.equalsIgnoreCase("sunday")) {
      return date.minusDays(3);
    } else if (day.equalsIgnoreCase("saturday")) {
      return date.minusDays(2);
    }
    return date.minusDays(1);
  }
}
