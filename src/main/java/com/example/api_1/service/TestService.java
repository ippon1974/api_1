package com.example.api_1.service;

import com.example.api_1.entity.TestEntity;
import com.example.api_1.entity.UserEntity;
import com.example.api_1.exception.TestAlreadyExistExeption;
import com.example.api_1.exception.TestNotFoundException;
import com.example.api_1.exception.UserAlreadyExistExeption;
import com.example.api_1.exception.UserNotFoundException;
import com.example.api_1.model.Test;
import com.example.api_1.model.User;
import com.example.api_1.repository.TestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    @Autowired
    private TestRepo testRepo;

    public List<TestEntity> findAllElements() {
        return testRepo.findAll();
        //return testRepo.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    public Test getOne(Long id) throws TestNotFoundException {
        TestEntity test = testRepo.findById(id).get();
        if(test == null) {
            throw new TestNotFoundException("Пользователь с таким именем не нейден");
        }
        return Test.toModel(test);
    }

    public TestEntity registration(TestEntity user) throws TestAlreadyExistExeption {
        if(testRepo.findByUsername(user.getUsername()) != null){
            throw  new TestAlreadyExistExeption("Пользователь с таким именем уже существует");
        }
        return testRepo.save(user);
    }



}


