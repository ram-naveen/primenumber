package com.natwest.primenumber;

import org.junit.jupiter.api.Test;
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

    @Test
    public void testGeneratePrimesEndpoint() throws JSONException {
        String url = "http://localhost:" + port + "/primes/10";
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        assertEquals(200, responseEntity.getStatusCode().value());
        
        String responseBody = responseEntity.getBody();
        assertNotNull(responseBody);
        
        String expectedResponseBody = "{\"Initial\":10,\"Primes\":[2,3,5,7]}";
		JSONAssert.assertEquals(expectedResponseBody, responseBody, true);
    }
}
