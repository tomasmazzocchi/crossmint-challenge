package com.example.crossmintchallenge.gateway.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class MapResponse {
    @JsonProperty("goal")
    private List<List<String>> goal;
}
