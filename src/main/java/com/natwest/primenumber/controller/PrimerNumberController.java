package com.natwest.primenumber.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.natwest.primenumber.dto.PrimeNumberJsonResponse;
import com.natwest.primenumber.service.PrimeNumberService;

@RestController
public class PrimerNumberController {
	 @Autowired
	 private PrimeNumberService primeNumberService;
	 
	 private Logger logger = LoggerFactory.getLogger(PrimerNumberController.class);
	 
	    @RequestMapping(value="/primes/{number}", method = RequestMethod.GET, produces = "application/json")
	    public PrimeNumberJsonResponse generatePrimes(@PathVariable(value="number") int number) {
	        logger.info("Received request to generates prime numbers up to {}", number);
	        PrimeNumberJsonResponse response = primeNumberService.generatePrimes(number);
	        return response;
	    }
}
