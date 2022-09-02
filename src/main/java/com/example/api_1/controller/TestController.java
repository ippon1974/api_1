package com.example.api_1.controller;

import com.example.api_1.entity.TestEntity;
import com.example.api_1.entity.UserEntity;
import com.example.api_1.model.Test;
import com.example.api_1.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<TestEntity> getAll(){
        return testService.findAllElements();
    }



}
