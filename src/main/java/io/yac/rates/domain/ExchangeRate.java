package io.yac.rates.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by geoffroy on 18/02/2016.
 */
public class ExchangeRate {
    private BigDecimal amount;
    private Date date;

    public ExchangeRate() {
    }

    private ExchangeRate(BigDecimal amount, Date date) {
        this.amount = amount;
        this.date = date;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public static class Builder {
        private BigDecimal amount;
        private Date date;

        public Builder amount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }

        public Builder date(Date date) {
            this.date = date;
            return this;
        }

        public ExchangeRate build() {
            return new ExchangeRate(amount, date);
        }
    }
}
