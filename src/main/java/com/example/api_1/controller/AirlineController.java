package com.example.api_1.controller;

import com.example.api_1.entity.AirlinesEntity;
import com.example.api_1.entity.TestEntity;
import com.example.api_1.service.AirlineService;
import com.example.api_1.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/airlines")
public class AirlineController {
    @Autowired
    private final AirlineService airlineService;

    public AirlineController(AirlineService airlineService) {
        this.airlineService = airlineService;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<AirlinesEntity> getAll(){
        return airlineService.findAllElements();
    }

}
