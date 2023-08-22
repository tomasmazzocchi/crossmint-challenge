package com.example.crossmintchallenge.gateway;

import com.example.crossmintchallenge.gateway.dto.PolyanetResponse;

public interface PolyanetsGateway {
    PolyanetResponse postPolyanet(int row, int column);

    void deletePolyanet(int row, int column);
}
