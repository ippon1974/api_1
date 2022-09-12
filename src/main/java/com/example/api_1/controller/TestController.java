package com.example.api_1.controller;

import com.example.api_1.entity.TestEntity;
import com.example.api_1.entity.UserEntity;
import com.example.api_1.exception.TestAlreadyExistExeption;
import com.example.api_1.exception.TestNotFoundException;
import com.example.api_1.exception.UserNotFoundException;
import com.example.api_1.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
//@CrossOrigin(origins = "http://23.105.246.179:3000")
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<TestEntity> getAll(){
        return testService.findAllElements();
    }

//    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping()
    @ResponseStatus(HttpStatus.ACCEPTED)
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
    @ResponseStatus(HttpStatus.ACCEPTED)
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

    @PutMapping("/{id}")
    public ResponseEntity updateUser(@RequestBody TestEntity newuser, @PathVariable Long id) {
        try {
            return ResponseEntity.ok(testService.updateUser(id, newuser));
        }
        catch (UserNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Произщшла ошибка");
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity deleteUser(@PathVariable Long id){
        try {
            return ResponseEntity.ok(testService.delete(id));
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Произщшла ошибка");
        }
    }



}
