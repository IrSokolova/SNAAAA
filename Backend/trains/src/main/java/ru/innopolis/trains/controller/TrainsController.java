package ru.innopolis.trains.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.innopolis.trains.dto.TrainDto;
import ru.innopolis.trains.dto.TrainsSearchRequest;
import ru.innopolis.trains.service.TrainService;

@Controller
@RequiredArgsConstructor
@RequestMapping("trains")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TrainsController {

    private final TrainService trainService;

    @ResponseBody
    @GetMapping("all")
    public List<TrainDto> getAllTrains() {
        return trainService.getAllTrains();
    }

    @ResponseBody
    @PutMapping("search")
    public List<TrainDto> searchTrainsByFilter(@RequestBody TrainsSearchRequest searchRequest) {
        return trainService.searchTrainByFilter(searchRequest);
    }
}
