package io.yac.rates.domain;

import java.util.Currency;
import java.util.Date;

/**
 * Created by geoffroy on 18/02/2016.
 */
public class EuroExchangeRate {

    private Currency currency;
    private Double amount;
    private Date date;

    public EuroExchangeRate() {
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
