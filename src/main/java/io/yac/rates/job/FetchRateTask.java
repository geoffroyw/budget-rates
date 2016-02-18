package io.yac.rates.job;

import io.yac.rates.domain.CurrencyRate;
import io.yac.rates.domain.ExchangeRate;
import io.yac.rates.domain.repository.CurrencyRateRepository;
import io.yac.rates.service.consumer.ecb.ECBRate;
import io.yac.rates.service.consumer.ecb.ECBRateServiceFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by geoffroy on 18/02/2016.
 */
public class FetchRateTask {

    @Autowired
    ECBRateServiceFacade ecbRateService;

    @Autowired
    CurrencyRateRepository rateRepository;

    @Scheduled(cron = "30 14 * * * *") //Every day at 14:30
    public void fetchRate() {
        List<ECBRate> ecbRates = ecbRateService.fetchRates();

        for (ECBRate ecbRate : ecbRates) {
            CurrencyRate currencyRate = rateRepository.findByCurrency(ecbRate.getCurrency());
            if (currencyRate == null) {
                currencyRate = new CurrencyRate();
                currencyRate.setCurrency(ecbRate.getCurrency());
                currencyRate.setRates(new ArrayList<>());
            }
            currencyRate.getRates()
                    .add(ExchangeRate.builder().amount(ecbRate.getRate()).date(ecbRate.getDate()).build());
            currencyRate.setLastUpdatedOn(new Date());

            rateRepository.save(currencyRate);
        }

    }
}
