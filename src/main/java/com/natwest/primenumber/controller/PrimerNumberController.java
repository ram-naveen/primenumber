package com.natwest.primenumber.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.natwest.primenumber.dto.PrimeNumberJsonResponse;
import com.natwest.primenumber.service.PrimeNumberService;

@RestController
public class PrimerNumberController {
	 @Autowired
	 private PrimeNumberService primeNumberService;
	 
	    @RequestMapping(value="/primes/{number}", method = RequestMethod.GET, produces = "application/json")
	    public PrimeNumberJsonResponse generatePrimes(@PathVariable(value="number") int number) {
	        return primeNumberService.generatePrimes(number);
	    }
}
