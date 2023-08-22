package com.example.crossmintchallenge.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class POLYanetServiceImpl implements POLYanetService {
    @Override
    public String createCross(Long matrixSize) {
        String cross = "";
        for (int row = 0; row < matrixSize; row++) {
            for (int column = 0; column < matrixSize; column++) {
                if((row == column) || ((row+column)==(matrixSize-1))) {
                    cross = cross.concat("X");
                } else {
                    cross = cross.concat(" ");
                }
            }
            cross = cross.concat("\n");
        }
        log.info(cross);
        return cross.trim();
    }
}
