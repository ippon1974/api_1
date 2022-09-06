package com.example.api_1.controller;

import com.example.api_1.entity.TestEntity;
import com.example.api_1.exception.TestAlreadyExistExeption;
import com.example.api_1.exception.TestNotFoundException;
import com.example.api_1.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
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

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity getOneUser(@RequestParam long id){
        try {
            return ResponseEntity.ok(testService.getOne(id));
        }catch (TestNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Произщшла ошибка");
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity registration(@RequestBody TestEntity user){
        try {
            testService.registration(user);
            return ResponseEntity.ok("Пользователь успешно сохранен");
        }catch (TestAlreadyExistExeption e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Произщшла ошибка");
        }
    }









}
