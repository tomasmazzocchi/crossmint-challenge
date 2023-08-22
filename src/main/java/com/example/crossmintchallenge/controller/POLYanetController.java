package com.example.crossmintchallenge.controller;

import com.example.crossmintchallenge.services.POLYanetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/polyanets")
@RequiredArgsConstructor
@Slf4j
public class POLYanetController {

    private final POLYanetService polYanetService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createPolyanetCross(@RequestParam Long matrixSize){
        log.info("Creating a Cross shape within a matrix of size {}", matrixSize);
        return polYanetService.createCross(matrixSize);
    }
    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deletePolyanet(@RequestParam Long row, @RequestParam Long column){
        polYanetService.deletePolyanet(row, column);
    }
}
