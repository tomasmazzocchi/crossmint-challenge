package com.example.crossmintchallenge.gateway;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class polyanetsGatewayImpl implements polyanetsGateway {

    private final RestTemplate restTemplate;
    private static final String API_URL = "https://challenge.crossmint.io/api/polyanets";

    public void postGateway(Long row, Long column){
        //restTemplate.postForObject(API_URL, Object.class);
    }
}
