package io.yac.rates.controller;

import io.yac.rates.controller.exceptions.UnknownCurrencyException;
import io.yac.rates.domain.CurrencyRate;
import io.yac.rates.domain.ExchangeRate;
import io.yac.rates.domain.exception.NoRateException;
import io.yac.rates.domain.repository.CurrencyRateRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by geoffroy on 18/02/2016.
 */
@RestController
public class RateController {

    public static final String EUR = "EUR";
    private static final Logger LOG = LoggerFactory.getLogger(RateController.class);
    @Autowired
    CurrencyRateRepository rateRepository;

    public RateController() {
    }

    RateController(CurrencyRateRepository rateRepository) {
        this.rateRepository = rateRepository;
    }

    @RequestMapping(value = "/convert")
    public RateConversionResponse convert(@PathParam(value = "amount") BigDecimal amount,
                                          @PathParam(value = "amountCurrency") String amountCurrency,
                                          @PathParam(value = "toCurrency") String toCurrency)
            throws UnknownCurrencyException, NoRateException {
        RateConversionRequest request =
                RateConversionRequest.builder().amount(amount).amountCurrency(amountCurrency).toCurrency(toCurrency)
                        .build();
        LOG.info("Currency conversion request received " + request);

        RateConversionResponse response = processRequest(request);
        LOG.info("Currency conversion response " + response + "  for request" + request);
        return response;

    }


    RateConversionResponse processRequest(RateConversionRequest request)
            throws UnknownCurrencyException, NoRateException {
        String fromCurrency = request.getAmountCurrency();
        String toCurrency = request.getToCurrency();

        CurrencyRate rateOfFromCurrency = rateRepository.findByCurrency(fromCurrency);
        CurrencyRate rateOfToCurrency = rateRepository.findByCurrency(toCurrency);

        if (rateOfFromCurrency == null && !EUR.equalsIgnoreCase(fromCurrency)) {
            throw new UnknownCurrencyException("Currency " + fromCurrency + " is not supported");
        }
        if (rateOfToCurrency == null && !EUR.equalsIgnoreCase(toCurrency)) {
            throw new UnknownCurrencyException("Currency " + toCurrency + " is not supported");
        }

        BigDecimal convertedAmount = request.getAmount();
        Date asOf;
        if (EUR.equalsIgnoreCase(fromCurrency)) {
            ExchangeRate rate = rateOfToCurrency.getLatestRate();
            convertedAmount = convertedAmount.multiply(rate.getAmount());
            asOf = rate.getDate();
        } else {
            if (EUR.equalsIgnoreCase(toCurrency)) {
                ExchangeRate rate = rateOfFromCurrency.getLatestRate();
                convertedAmount = convertedAmount.divide(rate.getAmount(), 2);
                asOf = rate.getDate();
            } else {
                asOf = rateOfFromCurrency.getLatestRate().getDate();
                convertedAmount = convertedAmount.multiply(rateOfToCurrency.getLatestRate().getAmount())
                        .divide(rateOfFromCurrency.getLatestRate().getAmount(), 2);
            }
        }

        return new RateConversionResponse(asOf, fromCurrency, toCurrency, request.getAmount(), convertedAmount);
    }
}
