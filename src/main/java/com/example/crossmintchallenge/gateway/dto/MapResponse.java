package com.example.crossmintchallenge.gateway.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MapResponse {
    @JsonProperty("goal")
    private List<List<String>> goal;
}
