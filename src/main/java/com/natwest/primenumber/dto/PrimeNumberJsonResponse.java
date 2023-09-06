package com.natwest.primenumber.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PrimeNumberJsonResponse {
    @JsonProperty("Initial")
	private int initial;
    
    @JsonProperty("Primes")
	private List<Integer> primes = new ArrayList<>();
	
	public PrimeNumberJsonResponse(int initial, List<Integer> primes) {
		this.initial = initial;
		this.primes = primes;
	}
}
