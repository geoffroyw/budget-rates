package io.yac.rates.domain;

import io.yac.rates.domain.exception.NoRateException;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


/**
 * Created by geoffroy on 18/02/2016.
 */
public class CurrencyRateTest {

    @Test(expected = NoRateException.class)
    public void latestRates_throws_NoRateException_if_rates_is_null() throws NoRateException {
        CurrencyRate currencyRate = CurrencyRate.builder().rates(null).build();

        currencyRate.getLatestRate();
    }

    @Test(expected = NoRateException.class)
    public void latestRates_throws_NoRateException_if_rates_is_empty_list() throws NoRateException {
        CurrencyRate currencyRate = CurrencyRate.builder().rates(new ArrayList<>()).build();

        currencyRate.getLatestRate();
    }

    @Test
    public void latestRatesIsNull_is_the_rate_if_the_highest_date() throws NoRateException {

        Date latestDate =
                Date.from(Instant.from(LocalDate.of(2016, 2, 18).atStartOfDay(ZoneId.systemDefault()).toInstant()));
        Date oldestDate =
                Date.from(Instant.from(LocalDate.of(2011, 2, 18).atStartOfDay(ZoneId.systemDefault()).toInstant()));
        ExchangeRate latestRate = ExchangeRate.builder().amount(BigDecimal.TEN).date(latestDate).build();
        ExchangeRate oldestRate = ExchangeRate.builder().amount(BigDecimal.ONE).date(oldestDate).build();

        CurrencyRate currencyRate = CurrencyRate.builder().rates(Arrays.asList(oldestRate, latestRate)).build();

        assertThat(currencyRate.getLatestRate(), is(latestRate));
    }


}