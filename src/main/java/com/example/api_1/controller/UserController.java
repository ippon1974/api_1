package com.example.api_1.controller;

import com.example.api_1.entity.UserEntity;
import com.example.api_1.exception.UserAlreadyExistExeption;
import com.example.api_1.exception.UserNotFoundException;
import com.example.api_1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity registration(@RequestBody UserEntity user){
        try {
           userService.registration(user);
            return ResponseEntity.ok("Пользователь успешно сохранен");
        }catch (UserAlreadyExistExeption e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Произщшла ошибка");
        }
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<UserEntity> getAll(){
        return userService.findAllElements();
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity getOneUser(@RequestParam long id){
        try {
            return ResponseEntity.ok(userService.getOne(id));
        }catch (UserNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Произщшла ошибка");
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity updateUser(@RequestBody UserEntity newuser, @PathVariable Long id) {
        try {
            return ResponseEntity.ok(userService.updateUser(id, newuser));
        }
        catch (UserNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Произщшла ошибка");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        try {
            return ResponseEntity.ok(userService.delete(id));
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Произщшла ошибка");
        }
    }





}
