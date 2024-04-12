package com.stock.data.dto;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StockList{
  @SerializedName("data")
  private List<StockDetail> data;
}
