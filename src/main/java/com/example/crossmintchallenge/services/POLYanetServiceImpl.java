package com.example.crossmintchallenge.services;

import com.example.crossmintchallenge.gateway.PolyanetsGateway;
import com.example.crossmintchallenge.gateway.dto.PolyanetRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class POLYanetServiceImpl implements POLYanetService {

    private final PolyanetsGateway polyanetsGateway;

    @Override
    public String createCross(int matrixSize) {
        StringBuilder crossBuilder = new StringBuilder();


        for (int row = 0; row < matrixSize; row++) {
            for (int column = 0; column < matrixSize; column++) {
                if(((row == column) || ((row+column)==(matrixSize-1))) && (row >= 2 && row < matrixSize - 2)) {
                    crossBuilder.append("X");
                    polyanetsGateway.postPolyanet(row, column);
                } else {
                    crossBuilder.append("*");
                }
            }
            crossBuilder.append("\n");
        }
        log.info(crossBuilder.toString());
        return crossBuilder.toString().trim();
    }

    @Override
    public void deletePolyanet(int row, int column) {
        polyanetsGateway.deletePolyanet(row, column);
    }
}
