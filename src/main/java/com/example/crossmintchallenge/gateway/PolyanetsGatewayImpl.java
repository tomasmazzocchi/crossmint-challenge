package com.example.crossmintchallenge.gateway;

import com.example.crossmintchallenge.gateway.dto.PolyanetRequest;
import com.example.crossmintchallenge.gateway.dto.PolyanetResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class PolyanetsGatewayImpl implements PolyanetsGateway {

    private final RestTemplate restTemplate;
    private static final String API_URL = "https://challenge.crossmint.io/api/polyanets";

    public PolyanetResponse postPolyanet(Long row, Long column){
        return restTemplate.postForObject(API_URL, getPolyanetRequest(row, column), PolyanetResponse.class);
    }

    public void deletePolyanet(Long row, Long column){
        //restTemplate.delete(API_URL, getPolyanetRequest(row, column));

        HttpHeaders headers = new HttpHeaders();
      //  headers.setContentType(MediaType.APPLICATION_JSON); // Set the Content-Type header

        HttpEntity<PolyanetRequest> requestEntity = new HttpEntity<>(getPolyanetRequest(row, column), headers);

        restTemplate.exchange(API_URL, HttpMethod.DELETE, requestEntity, PolyanetResponse.class);
    }

    private PolyanetRequest getPolyanetRequest(Long row, Long column) {
        return PolyanetRequest.builder().row(row).column(column).build();
    }
}
