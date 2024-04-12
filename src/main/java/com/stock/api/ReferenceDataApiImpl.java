package com.stock.api;

import com.stock.data.dto.*;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Service
public class ReferenceDataApiImpl {
  private final String API_KEY = System.getenv("API_KEY");
  private final String API_HOST = "twelve-data1.p.rapidapi.com";
  private ReferenceDataApi api;

  @PostConstruct
  public void init() {
    final String BASE_URL = "https://twelve-data1.p.rapidapi.com/";
    Retrofit retrofit =
        new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    api = retrofit.create(ReferenceDataApi.class);
  }

  public StockList getStockList() {
    return execute(this.api.getStockList(API_KEY, API_HOST));
  }

  public ForexPairList getForexPairList() {
    return execute(this.api.getForexPairList(API_KEY, API_HOST));
  }

  public CryptocurrenciesList getCryptoCurrencyList() {
    return execute(this.api.getCryptoCurrencyList(API_KEY, API_HOST));
  }

  public ETFList getETFList() {
    return execute(this.api.getETFList(API_KEY, API_HOST));
  }

  public IndicesList getIndicesList() {
    return execute(this.api.getIndicesList(API_KEY, API_HOST));
  }

  public ExchangeList getExchangesList() {
    return execute(this.api.getExchangesList(API_KEY, API_HOST));
  }

  private <T> T execute(Call<T> call) {
    try {
      Response<T> response = call.execute();
      System.out.println(response.body());
      return response.body();
    } catch (Exception e) {

    }
    return null;
  }
}
