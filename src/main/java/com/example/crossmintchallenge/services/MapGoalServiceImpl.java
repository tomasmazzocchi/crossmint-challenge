package com.example.crossmintchallenge.services;

import com.example.crossmintchallenge.gateway.ComethsGateway;
import com.example.crossmintchallenge.gateway.PolyanetsGateway;
import com.example.crossmintchallenge.gateway.SoloonsGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
@Slf4j
public class MapGoalServiceImpl implements MapGoalService {

    private final PolyanetsGateway polyanetsGateway;
    private final SoloonsGateway soloonsGateway;
    private final ComethsGateway comethsGateway;

    @Override
    public void process(List<List<String>> goalMap) {
        IntStream.range(0, goalMap.size()).forEach(row -> processColumn(row, goalMap.get(row)));
    }

    private void processColumn(int row, List<String> columns) {
        IntStream.range(0, columns.size()).forEach(column -> processCell(row, column, columns.get(column)));
    }

    private void processCell(int row, int column, String command) {
        String[] commandArray = command.split("_");
        if(commandArray.length>1){
            switch (commandArray[1]) {
                case "POLYANET" -> polyanetsGateway.postAstralObject(row, column, null, null);
                case "SOLOON" -> soloonsGateway.postAstralObject(row, column, commandArray[0].toLowerCase(), null);
                case "COMETH" -> comethsGateway.postAstralObject(row, column, null, commandArray[0].toLowerCase());
            }
        }
    }
}
