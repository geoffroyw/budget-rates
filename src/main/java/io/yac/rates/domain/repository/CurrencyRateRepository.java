package io.yac.rates.domain.repository;

import io.yac.rates.domain.CurrencyRate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by geoffroy on 18/02/2016.
 */
@Repository
public interface CurrencyRateRepository extends MongoRepository<CurrencyRate, Long> {

    CurrencyRate findByCurrency(String currency);
}
