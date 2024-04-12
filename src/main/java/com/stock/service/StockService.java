package com.stock.service;

import com.opencsv.CSVReader;
import com.stock.data.dto.StockQuote;
import com.stock.data.dto.TimeSeriesEntry;
import com.stock.symbol.StockSymbol;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {

  @Autowired private CacheService cacheService;
  private final Set<StockSymbol> cachedAllSymbol = new HashSet<>();

  public Map<String, TimeSeriesEntry> getIntraDayData(String interval, String symbol) {
    return cacheService.getIntraDayData(interval, symbol);
  }

  public StockQuote getQuoteBySymbol(String symbol) {
    return cacheService.getQuote(symbol);
  }

  public Map<String, TimeSeriesEntry> getTimeSeries(String symbol) {
    return cacheService.getTimeSeries(symbol);
  }

  public Set<StockSymbol> getAllSymbols() {
    if (cachedAllSymbol.isEmpty()) {
      cachedAllSymbol.addAll(getAll());
    }
    return cachedAllSymbol;
  }

  private Set<StockSymbol> getAll() {
    final Set<StockSymbol> stockSymbols = new HashSet<>();
    try (BufferedReader reader =
            new BufferedReader(new FileReader("src/main/resources/stock_info.csv"));
        CSVReader csvReader = new CSVReader(reader); ) {
      csvReader.skip(1);
      readSymbolsFromFile(csvReader, stockSymbols);
    } catch (Exception ignored) {

    }
    return stockSymbols;
  }

  private void readSymbolsFromFile(CSVReader reader, Set<StockSymbol> symbols) {
    try {
      String[] line;
      while (((line) = reader.readNext()) != null) {
        final StockSymbol symbol = getSymbol(line);
        symbols.add(symbol);
      }
    } catch (Exception e) {

    }
  }

  private StockSymbol getSymbol(final String[] str) {
    return new StockSymbol(str[0], str[1], str[2]);
  }
}
