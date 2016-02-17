package io.yac.rates.service;

import io.yac.rates.Application;
import io.yac.rates.iface.ecb.v2.ECBRate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by geoffroy on 17/02/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class RateConsumerServiceTest {

    @Autowired
    RateConsumerService rateConsumerService;


    @Test
    public void testConsumeRates() {
        ECBRate ecbRates = rateConsumerService.consumeRates();
        System.out.println(ecbRates);
    }
}