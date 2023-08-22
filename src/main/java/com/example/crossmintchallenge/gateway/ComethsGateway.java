package com.example.crossmintchallenge.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ComethsGateway extends AbstractMegaverseGateway {

    public ComethsGateway(@Value("${crossmint.api-url}") String API_URL, RestTemplate restTemplate) {
        super(API_URL.concat("/comeths"), restTemplate);
    }


}
