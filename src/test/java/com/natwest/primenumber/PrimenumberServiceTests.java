package com.natwest.primenumber;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.natwest.primenumber.dto.PrimeNumberJsonResponse;
import com.natwest.primenumber.service.PrimeNumberService;

@SpringBootTest
class PrimenumberServiceTests {

	 private final PrimeNumberService primeNumberService = new PrimeNumberService();

	    @Test
	    public void testNonEmptyPrimeNumberJsonResponse() {
	    	 int number = 11; 
	    	 List<Integer> primes = List.of(2,3,5,7,11);
	    	 PrimeNumberJsonResponse expectedPrimeNumberJson= new PrimeNumberJsonResponse(number, primes);

	    	 PrimeNumberJsonResponse  generatedPrimeNumberJson = primeNumberService.generatePrimes(number);

	         assertEquals(expectedPrimeNumberJson, generatedPrimeNumberJson);
	    }
	    
	    @Test
	    public void testEmptyPrimeNumberJsonResponse() {
	    	 int number = 0; 
	    	 List<Integer> primes = List.of();
	    	 PrimeNumberJsonResponse expectedPrimeNumberJson= new PrimeNumberJsonResponse(number, primes);

	    	 PrimeNumberJsonResponse  generatedPrimeNumberJson = primeNumberService.generatePrimes(number);

	         assertEquals(expectedPrimeNumberJson, generatedPrimeNumberJson);
	    }
	    

	    

}
