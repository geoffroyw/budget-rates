package io.yac.rates.domain;

import io.yac.rates.domain.exception.NoRateException;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

/**
 * Created by geoffroy on 18/02/2016.
 */
public class CurrencyRate {

    @Id
    private String id;
    private String currency;
    private Date lastUpdatedOn;
    private List<ExchangeRate> rates;

    public CurrencyRate() {
    }

    public CurrencyRate(String id, String currency, Date lastUpdatedOn,
                        List<ExchangeRate> rates) {
        this.id = id;
        this.currency = currency;
        this.lastUpdatedOn = lastUpdatedOn;
        this.rates = rates;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Date getLastUpdatedOn() {
        return lastUpdatedOn;
    }

    public void setLastUpdatedOn(Date lastUpdatedOn) {
        this.lastUpdatedOn = lastUpdatedOn;
    }

    public List<ExchangeRate> getRates() {
        return rates;
    }

    public void setRates(List<ExchangeRate> rates) {
        this.rates = rates;
    }

    public ExchangeRate getLatestRate() throws NoRateException {
        if (getRates() == null || getRates().isEmpty()) {
            throw new NoRateException("No rate for currency " + getCurrency());
        }
        ExchangeRate latestRate = null;
        for (ExchangeRate exchangeRate : getRates()) {
            if (latestRate == null) {
                latestRate = exchangeRate;
            } else {
                if (latestRate.getDate().before(exchangeRate.getDate())) {
                    latestRate = exchangeRate;
                }
            }
        }
        return latestRate;
    }

    public static class Builder {
        private String id;
        private String currency;
        private Date lastUpdatedOn;
        private List<ExchangeRate> rates;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder currency(String currency) {
            this.currency = currency;
            return this;
        }

        public Builder lastUpdatedOn(Date lastUpdatedOn) {
            this.lastUpdatedOn = lastUpdatedOn;
            return this;
        }

        public Builder rates(List<ExchangeRate> rates) {
            this.rates = rates;
            return this;
        }

        public CurrencyRate build() {
            return new CurrencyRate(id, currency, lastUpdatedOn, rates);
        }
    }
}
