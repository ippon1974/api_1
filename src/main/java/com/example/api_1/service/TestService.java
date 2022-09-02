package com.example.api_1.service;

import com.example.api_1.entity.TestEntity;
import com.example.api_1.model.Test;
import com.example.api_1.repository.TestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    @Autowired
    private TestRepo testRepo;

    public List<TestEntity> findAllElements() {
        return testRepo.findAll();
    }

}
