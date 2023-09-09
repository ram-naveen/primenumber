package com.natwest.primenumber;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.*;
import org.json.JSONException;
import org.junit.jupiter.api.Tag;

@SpringBootTest(classes = PrimenumberApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Tag("Integration")
public class PrimeNumberIntegrationTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @ParameterizedTest
    @CsvSource(value={
    		"0#{\"Initial\":0,\"Primes\":[]}",           		// Input: http://localhost:8080/primes/0, Expected: {"Initial":0,"Primes":[]}
    		"1#{\"Initial\":1,\"Primes\":[]}",           		// Input: http://localhost:8080/primes/1, Expected: {"Initial":1,"Primes":[]}
            "10#{\"Initial\":10,\"Primes\":[2,3,5,7]}",  		// Input: http://localhost:8080/primes/10, Expected: {"Initial":10,"Primes":[2,3,5,7]}
            "15#{\"Initial\":15,\"Primes\":[2,3,5,7,11,13]}",  	// Input: http://localhost:8080/primes/10, Expected: {"Initial":10,"Primes":[2,3,5,7]}
    }, delimiter = '#')
    public void testGeneratePrimesEndpoint(int input, String expectedResponseBody) throws JSONException {
        String url = "http://localhost:" + port + "/primes/" + input;
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        assertEquals(200, responseEntity.getStatusCode().value());
        
        String responseBody = responseEntity.getBody();
        assertNotNull(responseBody);
        
       // String expectedResponseBody = "{\"Initial\":10,\"Primes\":[2,3,5,7]}";
		JSONAssert.assertEquals(expectedResponseBody, responseBody, true);
    }
}
