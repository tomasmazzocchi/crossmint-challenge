package com.example.crossmintchallenge.gateway.map;

import com.example.crossmintchallenge.gateway.dto.MapResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class MapGatewayImpl implements MapGateway {
    private final RestTemplate restTemplate;
    private final String API_URL;
    private final String CANDIDATE_ID;

    public MapGatewayImpl(RestTemplate restTemplate, @Value("${crossmint.api-url}") String API_URL,
                          @Value("${crossmint.candidate-id}") String CANDIDATE_ID) {
        this.restTemplate = restTemplate;
        this.API_URL = API_URL;
        this.CANDIDATE_ID = CANDIDATE_ID;
    }


    @Override
    public Optional<MapResponse> getMapGoal() {
        return Optional.ofNullable(
                restTemplate.getForObject(API_URL.concat(String.format("/map/%s/goal", CANDIDATE_ID)), MapResponse.class)
        );
    }
}
