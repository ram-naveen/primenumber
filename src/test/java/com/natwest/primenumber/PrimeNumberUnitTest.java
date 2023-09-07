package com.natwest.primenumber;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.natwest.primenumber.dto.PrimeNumberJsonResponse;
import com.natwest.primenumber.service.PrimeNumberService;

@SpringBootTest
@Tag("Unit")
class PrimenumberUnitTest {
	
	@Autowired
	private PrimeNumberService primeNumberService;

	@ParameterizedTest
    @CsvSource(value={
    		"1:[]",
            "0:[]",
            "2:[2]",               // Input: 2, Expected: [2]
            "11:[2,3,5,7,11]",        // Input: 10, Expected: [2, 3, 5, 7]
            "20:[2,3,5,7,11,13,17,19]", // Input: 20, Expected: [2, 3, 5, 7, 11, 13, 17, 19]
            
    }, delimiter = ':')
    public void testNonEmptyPrimeNumberJsonResponse(int input, String expectedPrimesString) {
		List<Integer> expectedPrimes = parseCsvList(expectedPrimesString);
		PrimeNumberJsonResponse expectedPrimeNumberJson= new PrimeNumberJsonResponse(input, expectedPrimes);
    	PrimeNumberJsonResponse  generatedPrimeNumberJson = primeNumberService.generatePrimes(input);
        assertEquals(expectedPrimeNumberJson, generatedPrimeNumberJson);
    }
    
    private List<Integer> parseCsvList(String csvList) {
    	csvList = csvList.replace("[", "");
    	csvList = csvList.replace("]", "");
        String[] parts = csvList.trim().split(",");
        List<Integer> result = new ArrayList<>();
        for (String part : parts) {
        	if (part.length() > 0) {
        		result.add(Integer.parseInt(part.trim()));
        	}
        }
        return result;
    }   
}
