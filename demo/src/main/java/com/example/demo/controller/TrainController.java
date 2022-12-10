package com.example.demo.controller;

import com.example.demo.model.TrainModel;
import com.example.demo.repository.TrainRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class TrainController {
    // standard constructors

    private TrainRepository trainRepository;

    @GetMapping("/train")
    public List<TrainModel> getTrains() {
        return (List<TrainModel>) trainRepository.findAll();
    }

}
