package io.yac.rates.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/**
 * Created by geoffroy on 18/02/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RateConversionRequest {

    @JsonProperty
    private BigDecimal amount;

    @JsonProperty
    private String amountCurrency;

    @JsonProperty
    private String toCurrency;

    public RateConversionRequest() {
    }

    private RateConversionRequest(BigDecimal amount, String amountCurrency, String toCurrency) {
        this.amount = amount;
        this.amountCurrency = amountCurrency;
        this.toCurrency = toCurrency;
    }

    public static Builder builder() {
        return new Builder();
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getAmountCurrency() {
        return amountCurrency;
    }

    public void setAmountCurrency(String amountCurrency) {
        this.amountCurrency = amountCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    @Override
    public String toString() {
        return "RateConversionRequest{" +
                "amount=" + amount +
                ", amountCurrency='" + amountCurrency + '\'' +
                ", toCurrency='" + toCurrency + '\'' +
                '}';
    }

    public static class Builder {
        private BigDecimal amount;
        private String amountCurrency;
        private String toCurrency;

        public Builder amount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }

        public Builder amountCurrency(String amountCurrency) {
            this.amountCurrency = amountCurrency;
            return this;
        }

        public Builder toCurrency(String toCurrency) {
            this.toCurrency = toCurrency;
            return this;
        }

        public RateConversionRequest build() {
            return new RateConversionRequest(amount, amountCurrency, toCurrency);
        }
    }
}
