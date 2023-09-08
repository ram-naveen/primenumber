package com.natwest.primenumber.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import com.natwest.primenumber.dto.PrimeNumberJsonResponse;

@Service
public class PrimeNumberService {
	public PrimeNumberJsonResponse generatePrimes(int number) {
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= number; i++) {
            if (isNumberPrime(i)) {
                primes.add(i);
            }
        }
        PrimeNumberJsonResponse primeNumberJsonResponse = new PrimeNumberJsonResponse(number, primes);
        return primeNumberJsonResponse;
    }

    private boolean isNumberPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}


