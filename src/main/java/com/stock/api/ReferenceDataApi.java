package com.stock.api;

import com.stock.data.dto.*;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface ReferenceDataApi {
  @GET("/stocks")
  Call<StockList> getStockList(
      @Header("X-RapidAPI-Key") String apiKey, @Header("X-RapidAPI-Host") String apiHost);

  @GET("/forex_pairs")
  Call<ForexPairList> getForexPairList(
      @Header("X-RapidAPI-Key") String apiKey, @Header("X-RapidAPI-Host") String apiHost);

  @GET("/cryptocurrencies")
  Call<CryptocurrenciesList> getCryptoCurrencyList(
      @Header("X-RapidAPI-Key") String apiKey, @Header("X-RapidAPI-Host") String apiHost);

  @GET("/etf")
  Call<ETFList> getETFList(
      @Header("X-RapidAPI-Key") String apiKey, @Header("X-RapidAPI-Host") String apiHost);

  @GET("/indices")
  Call<IndicesList> getIndicesList(
      @Header("X-RapidAPI-Key") String apiKey, @Header("X-RapidAPI-Host") String apiHost);

  @GET("/exchanges")
  Call<ExchangeList> getExchangesList(
      @Header("X-RapidAPI-Key") String apiKey, @Header("X-RapidAPI-Host") String apiHost);
}
