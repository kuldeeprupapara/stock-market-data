package com.stock.api;

import com.stock.data.dto.GlobalQuote;
import com.stock.data.dto.TimeSeriesIntraDay;
import java.util.Map;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.QueryMap;

public interface StockAPI {
  @GET("/query")
  Call<TimeSeriesIntraDay> getIntraDayTimeSeriesData(
      @HeaderMap Map<String, String> headers, @QueryMap Map<String, String> queries);

  @GET("/query")
  Call<GlobalQuote> getQuoteBySymbol(
      @HeaderMap Map<String, String> headers, @QueryMap Map<String, String> queries);

  @GET("/query")
  Call<TimeSeriesIntraDay> getTimeSeries(
      @HeaderMap Map<String, String> headers, @QueryMap Map<String, String> queries);
}
