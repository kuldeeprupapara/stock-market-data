package com.stock.controller;

import com.stock.data.dto.*;
import com.stock.service.ReferenceDataService;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/get")
public class ReferenceDataController {
  @Autowired ReferenceDataService service;

  @GetMapping("/stocks")
  public Set<StockDetail> getStocks() {
    return service.getStockDetails();
  }

  @GetMapping("/forex_pairs")
  public Set<ForexPairs> getForexPair() {
    return service.getForexPairs();
  }

  @GetMapping("/cryptocurrencies")
  public Set<Cryptocurrencies> getCryptoCurrency() {
    return service.getCryptocurrencies();
  }

  @GetMapping("/etf")
  public Set<ETF> getETF() {
    return service.getEtfs();
  }

  @GetMapping("/indices")
  public Set<Indices> getIndices() {
    return service.getIndices();
  }

  public Set<Exchange> getExchange() {
    return service.getExchanges();
  }
}
