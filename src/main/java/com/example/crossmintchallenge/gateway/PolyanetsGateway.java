package com.example.crossmintchallenge.gateway;

import com.example.crossmintchallenge.gateway.dto.PolyanetResponse;

public interface PolyanetsGateway {
    PolyanetResponse postPolyanet(Long row, Long column);

    void deletePolyanet(Long row, Long column);
}
