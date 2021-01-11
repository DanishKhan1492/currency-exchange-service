package com.learning.microservice.currencyexchangeservice.repository;

import com.learning.microservice.currencyexchangeservice.model.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Muhammad Danish Khan
 * @created 6/1/21 - 5:02 PM
 */

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Integer> {
    ExchangeValue findByFromAndTo(String from, String to);
}
