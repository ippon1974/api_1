package com.example.api_1.service;

import com.example.api_1.entity.AirlinesEntity;
import com.example.api_1.entity.TestEntity;
import com.example.api_1.exception.AirlinesNotFoundException;
import com.example.api_1.exception.TestNotFoundException;
import com.example.api_1.model.Airlines;
import com.example.api_1.model.Test;
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

    public Airlines getOne(Long id) throws AirlinesNotFoundException {
        AirlinesEntity air = airlinesRepo.findById(id).get();
        if(air == null) {
            throw new AirlinesNotFoundException("Пользователь с таким именем не нейден");
        }
        return Airlines.toModel(air);
    }

}
