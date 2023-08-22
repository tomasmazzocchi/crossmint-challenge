package com.example.crossmintchallenge.gateway.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public class PolyanetRequest {
    @JsonProperty("row")
    private Long row;

    @JsonProperty("column")
    private Long column;

        @JsonProperty("candidateId")
        @Builder.Default
        private String candidateId = "bdecc463-fde6-4d9e-be34-c405ed8e61b5";

        private static String getCandidateId() {
        return System.getProperty("default.candidate-id");
    }
}
