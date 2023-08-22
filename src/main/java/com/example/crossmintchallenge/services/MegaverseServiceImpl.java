package com.example.crossmintchallenge.services;

import com.example.crossmintchallenge.gateway.ComethsGateway;
import com.example.crossmintchallenge.gateway.SoloonsGateway;
import com.example.crossmintchallenge.gateway.map.MapGateway;
import com.example.crossmintchallenge.gateway.PolyanetsGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MegaverseServiceImpl implements MegaverseService {

    private final PolyanetsGateway polyanetsGateway;
    private final SoloonsGateway soloonsGateway;
    private final ComethsGateway comethsGateway;

    @Override
    public String createMegaverse(int matrixSize) {
        StringBuilder crossBuilder = new StringBuilder();

        for (int row = 0; row < matrixSize; row++) {
            for (int column = 0; column < matrixSize; column++) {
                if(((row == column) || ((row+column)==(matrixSize-1))) && (row >= 2 && row < matrixSize - 2)) {
                    crossBuilder.append("X");
                    polyanetsGateway.postAstralObject(row, column, null, null);
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
    public void deleteAstralObject(int row, int column) {
        polyanetsGateway.deleteAstralObject(row, column);
    }
}
