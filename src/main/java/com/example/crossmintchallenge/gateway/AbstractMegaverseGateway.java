package com.example.crossmintchallenge.gateway;

import com.example.crossmintchallenge.gateway.dto.PolyanetRequest;
import com.example.crossmintchallenge.gateway.dto.PolyanetResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

public abstract class AbstractMegaverseGateway implements MegaverseGateway {

    private final RestTemplate restTemplate;
    private final String API_URL;

    public AbstractMegaverseGateway(String API_URL, RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.API_URL = API_URL;
    }

    public PolyanetResponse postAstralObject(int row, int column, String color, String direction) {
        return restTemplate.postForObject(API_URL, getPolyanetRequest(row, column, color, direction)
                , PolyanetResponse.class);
    }

    public void deleteAstralObject(int row, int column) {

        HttpHeaders headers = new HttpHeaders();

        HttpEntity<PolyanetRequest> requestEntity = new HttpEntity<>(getPolyanetRequest(row, column, null, null)
                , headers);

        restTemplate.exchange(API_URL, HttpMethod.DELETE, requestEntity, PolyanetResponse.class);
    }

    private PolyanetRequest getPolyanetRequest(int row, int column, String color, String direction) {
        return PolyanetRequest.builder()
                .row(row)
                .column(column)
                .color(color)
                .direction(direction)
                .build();
    }

}
