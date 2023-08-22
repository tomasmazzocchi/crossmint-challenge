package com.example.crossmintchallenge.gateway;

import com.example.crossmintchallenge.gateway.AbstractMegaverseGateway;
import com.example.crossmintchallenge.gateway.dto.PolyanetRequest;
import com.example.crossmintchallenge.gateway.dto.PolyanetResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PolyanetsGateway extends AbstractMegaverseGateway {

    public PolyanetsGateway(@Value("${crossmint.api-url}") String API_URL, RestTemplate restTemplate) {
        super(API_URL.concat("/polyanets"), restTemplate);
    }


}
