package io.yac.rates.controller;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.yac.rates.serializer.JsonDateSerializer;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by geoffroy on 18/02/2016.
 */
public class RateConversionResponse {

    @JsonSerialize(using = JsonDateSerializer.class)
    private Date asOf;
    private String fromCurrency;
    private String toCurrency;
    private BigDecimal amountInFromCurrency;
    private BigDecimal amountInToCurrency;

    private RateConversionResponse() {
    }

    public RateConversionResponse(Date asOf, String fromCurrency, String toCurrency,
                                  BigDecimal amountInFromCurrency, BigDecimal amountInToCurrency) {
        this.asOf = asOf;
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.amountInFromCurrency = amountInFromCurrency;
        this.amountInToCurrency = amountInToCurrency;
    }

    public Date getAsOf() {
        return asOf;
    }

    public void setAsOf(Date asOf) {
        this.asOf = asOf;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    public BigDecimal getAmountInFromCurrency() {
        return amountInFromCurrency;
    }

    public void setAmountInFromCurrency(BigDecimal amountInFromCurrency) {
        this.amountInFromCurrency = amountInFromCurrency;
    }

    public BigDecimal getAmountInToCurrency() {
        return amountInToCurrency;
    }

    public void setAmountInToCurrency(BigDecimal amountInToCurrency) {
        this.amountInToCurrency = amountInToCurrency;
    }

    @Override
    public String toString() {
        return "RateConversionResponse{" +
                "asOf=" + asOf +
                ", fromCurrency='" + fromCurrency + '\'' +
                ", toCurrency='" + toCurrency + '\'' +
                ", amountInFromCurrency=" + amountInFromCurrency +
                ", amountInToCurrency=" + amountInToCurrency +
                '}';
    }
}
