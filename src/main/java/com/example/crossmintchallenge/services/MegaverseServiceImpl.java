package com.example.crossmintchallenge.services;

import com.example.crossmintchallenge.gateway.ComethsGateway;
import com.example.crossmintchallenge.gateway.SoloonsGateway;
import com.example.crossmintchallenge.gateway.dto.MapResponse;
import com.example.crossmintchallenge.gateway.map.MapGateway;
import com.example.crossmintchallenge.gateway.PolyanetsGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
@Slf4j
public class MegaverseServiceImpl implements MegaverseService {

    private final MapGateway mapGateway;
    private final MapGoalService mapGoalService;

    @Override
    public String createMegaverse() {
        log.info("Fetch megaverse goal map");
        Optional<MapResponse> mapToCreate = mapGateway.getMapGoal();
        if(!mapToCreate.isPresent()){
            log.error("Error fetching megaverse goal map");
            throw new RuntimeException("Error fetching megaverse goal map");
        }
        List<List<String>> goalMap = mapToCreate.get().getGoal();
        log.info("Start building megaverse map");
        mapGoalService.process(goalMap);

        log.info("Finishing building megaverse map");
        return "success";

    }


}
