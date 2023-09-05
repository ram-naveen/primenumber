package com.natwest.primenumber.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import com.natwest.primenumber.model.PrimeNumber;

@Service
public class PrimeNumberService {
	public List<PrimeNumber> generatePrimes(int number) {
        List<PrimeNumber> primes = new ArrayList<>();
        
        for (int i = 2; i <= number; i++) {
            if (isNumberPrime(i)) {
                primes.add(new PrimeNumber(i));
            }
        }
        
        return primes;
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
