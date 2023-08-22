package com.example.crossmintchallenge.gateway.map;

import com.example.crossmintchallenge.gateway.dto.MapResponse;

import java.util.Optional;

public interface MapGateway {

    Optional<MapResponse> getMapGoal();
}
