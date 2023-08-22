package com.example.crossmintchallenge.gateway;

import com.example.crossmintchallenge.gateway.dto.PolyanetResponse;

public interface MegaverseGateway {

    PolyanetResponse postAstralObject(int row, int column, String color, String direction);

    void deleteAstralObject(int row, int column);
}
