package com.example.api_1.service;

import com.example.api_1.entity.AirlinesEntity;
import com.example.api_1.repository.AirlinesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirlineService {
    @Autowired
    private AirlinesRepo airlinesRepo;

    public List<AirlinesEntity> findAllElements() {
        return airlinesRepo.findAll();
    }

}
