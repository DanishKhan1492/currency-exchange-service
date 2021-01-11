package com.learning.microservice.currencyexchangeservice.resources;

import com.learning.microservice.currencyexchangeservice.model.ExchangeValue;
import com.learning.microservice.currencyexchangeservice.repository.ExchangeValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author Muhammad Danish Khan
 * @created 6/1/21 - 3:10 PM
 */

@RestController
public class CurrencyExchangeServiceResource {
    @Autowired
    private Environment environment;

    @Autowired
    private ExchangeValueRepository exchangeValueRepository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
     public ExchangeValue retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to){
        ExchangeValue exchangeValue = exchangeValueRepository.findByFromAndTo(from,to);
        exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
        return exchangeValue;
     }

}
