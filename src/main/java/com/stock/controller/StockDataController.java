package com.stock.controller;

import com.stock.data.dto.StockQuote;
import com.stock.data.dto.TimeSeriesEntry;
import com.stock.service.StockService;
import com.stock.symbol.StockSymbol;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
@RequestMapping("/get")
public class StockDataController {
  @Autowired private StockService service;

  @GetMapping("/intraday")
  public Map<String, TimeSeriesEntry> getIntraDayData(
      @RequestParam String interval, @RequestParam String symbol) {
    return service.getIntraDayData(interval, symbol);
  }

  @GetMapping("/quote")
  public StockQuote getQuoteBySymbol(@RequestParam String symbol) {
    return service.getQuoteBySymbol(symbol);
  }

  @GetMapping("/time-series")
  public Map<String, TimeSeriesEntry> getTimeSeries(@RequestParam String symbol) {
    return service.getTimeSeries(symbol.toUpperCase());
  }

  @GetMapping("/symbols")
  public Set<StockSymbol> getAllSymbol() {
    return service.getAllSymbols();
  }
}
