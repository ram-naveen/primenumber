package com.natwest.primenumber.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PrimeNumberJsonResponse {
    @JsonProperty("Initial")
	private Integer initial;
    
    @JsonProperty("Primes")
	private List<Integer> primes;
	
	public PrimeNumberJsonResponse(int initial, List<Integer> primes) {
		this.initial = initial;
		this.primes = primes;
	}
	
	@Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final PrimeNumberJsonResponse other = (PrimeNumberJsonResponse) obj;
        if ((this.initial == null) ? (other.initial != null) : !this.initial.equals(other.initial)) {
            return false;
        }

        if ((this.primes == null) ? (other.primes != null) : !this.primes.equals(other.primes)) {
            return false;
        }
        
        return true;
    }
}
