package com.stock.service;

import com.stock.data.dto.*;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReferenceDataService {
  @Autowired private CacheService cacheService;

  public Set<StockDetail> getStockDetails() {
    return this.cacheService.getStockLists();
  }

  public Set<ForexPairs> getForexPairs() {
    return this.cacheService.getForexPairs();
  }

  public Set<Cryptocurrencies> getCryptocurrencies() {
    return this.cacheService.getCryptocurrencies();
  }

  public Set<ETF> getEtfs() {
    return this.cacheService.getEtfs();
  }

  public Set<Indices> getIndices() {
    return this.cacheService.getIndices();
  }

  public Set<Exchange> getExchanges() {
    return this.cacheService.getExchanges();
  }
}
