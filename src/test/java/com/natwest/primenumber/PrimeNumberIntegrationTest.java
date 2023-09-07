package com.natwest.primenumber;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Tag;

@SpringBootTest(classes = PrimenumberApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Tag("Integration")
public class PrimeNumberIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGeneratePrimesEndpoint() {
        String url = "http://localhost:" + port + "/primes/10"; // Adjust the URL based on your endpoint
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);

        assertEquals(200, responseEntity.getStatusCode().value());
        String responseBody = responseEntity.getBody();
        assertNotNull(responseBody);
        System.out.println(responseBody);
        // Add more assertions as needed to validate the response data
    }
}
