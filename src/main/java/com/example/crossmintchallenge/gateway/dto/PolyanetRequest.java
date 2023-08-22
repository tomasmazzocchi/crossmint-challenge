package com.example.crossmintchallenge.gateway.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PolyanetRequest {
    @JsonProperty("row")
    private int row;

    @JsonProperty("column")
    private int column;

    @JsonProperty("color")
    private String color;

    @JsonProperty("direction")
    private String direction;

    @JsonProperty("candidateId")
    @Builder.Default
    private String candidateId = "bdecc463-fde6-4d9e-be34-c405ed8e61b5";

    private static String getCandidateId() {
        return System.getProperty("default.candidate-id");
    }
}
