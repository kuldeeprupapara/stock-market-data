package com.stock.api;

import com.stock.data.dto.GlobalQuote;
import com.stock.data.dto.TimeSeriesIntraDay;
import jakarta.annotation.PostConstruct;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Service
public class StockAPIImpl {
  private final Logger logger = LoggerFactory.getLogger(StockAPIImpl.class);

  private StockAPI stockAPI;

  private Map<String, String> header;

  @PostConstruct
  public void init() {
    final String BASE_URL = "https://alpha-vantage.p.rapidapi.com/";
    Retrofit retrofit =
        new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    stockAPI = retrofit.create(StockAPI.class);
    header =
        new HashMap<>(
            Map.of(
                "API_KEY", System.getenv("API_KEY"), "API_HOST", "alpha-vantage.p.rapidapi.com"));
  }

  public TimeSeriesIntraDay getIntraDay(String interval, String symbol) {
    final Map<String, String> queryMap =
        Map.of("interval", interval, "symbol", symbol, "function", "TIME_SERIES_INTRADAY");
    return execute(this.stockAPI.getIntraDayTimeSeriesData(header, queryMap));
  }

  public TimeSeriesIntraDay getTimeSeries(String symbol) {
    final Map<String, String> queryMap = Map.of("symbol", symbol, "function", "TIME_SERIES_DAILY");
    return execute(this.stockAPI.getTimeSeries(header, queryMap));
  }

  public GlobalQuote getQuoteBySymbol(String symbol) {
    final Map<String, String> queryMap = Map.of("symbol", symbol, "function", "GLOBAL_QUOTE");
    return execute(this.stockAPI.getQuoteBySymbol(header, queryMap));
  }

  private <T> T execute(Call<T> t) {
    try {
      Response<T> response = t.execute();
      return response.body();
    } catch (IOException e) {
      logger.info("Error occurred :\n", e);
    }
    return null;
  }
}
