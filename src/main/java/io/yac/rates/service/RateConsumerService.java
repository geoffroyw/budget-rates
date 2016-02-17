package io.yac.rates.service;

import io.yac.rates.iface.ecb.v2.ECBRate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by geoffroy on 17/02/2016.
 */
@Service
public class RateConsumerService {

    private static final Logger LOG = LoggerFactory.getLogger(RateConsumerService.class);

    private static final String ECB_RATES_ENDPOINT = "https://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml";

    public ECBRate consumeRates() {

        RestTemplate restTemplate = new RestTemplate();
        ECBRate ecbRates = restTemplate.getForObject(ECB_RATES_ENDPOINT, ECBRate.class);
        LOG.info("Rates from ecb " + ecbRates);
        return ecbRates;


    }
}
