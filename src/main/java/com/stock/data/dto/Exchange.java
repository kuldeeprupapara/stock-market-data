package com.stock.data.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
public class Exchange {
    private String name;
    private String code;
    private String country;
    private String timezone;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exchange exchange = (Exchange) o;
        return Objects.equals(name, exchange.name) && Objects.equals(code, exchange.code) && Objects.equals(country, exchange.country) && Objects.equals(timezone, exchange.timezone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, code, country, timezone);
    }
}
