package io.yac.rates.service.consumer.ecb;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Date;

/**
 * Created by geoffroy on 18/02/2016.
 */
public class ECBRate {

    private Currency currency;
    private Date date;
    private BigDecimal rate;

    private ECBRate() {
    }

    private ECBRate(Currency currency, Date date, BigDecimal rate) {
        this.currency = currency;
        this.date = date;
        this.rate = rate;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "ECBRate{" +
                "currency=" + currency +
                ", date=" + date +
                ", rate=" + rate +
                '}';
    }


    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Currency currency;
        private Date date;
        private BigDecimal amount;

        public Builder currency(Currency currency) {
            this.currency = currency;
            return this;
        }

        public Builder date(Date date) {
            this.date = date;
            return this;
        }

        public Builder amount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }

        public ECBRate build() {
            return new ECBRate(currency, date, amount);
        }
    }
}
