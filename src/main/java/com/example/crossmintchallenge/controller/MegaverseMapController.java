package com.example.crossmintchallenge.controller;

import com.example.crossmintchallenge.services.MegaverseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/megaverse")
@RequiredArgsConstructor
@Slf4j
public class MegaverseMapController {

    private final MegaverseService polYanetService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createMegaverse(@RequestParam int matrixSize){
        log.info("Creating a Cross shape within a matrix of size {}", matrixSize);
        return polYanetService.createMegaverse(matrixSize);
    }
    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteAstralObject(@RequestParam int row, @RequestParam int column){
        polYanetService.deleteAstralObject(row, column);
    }
}
