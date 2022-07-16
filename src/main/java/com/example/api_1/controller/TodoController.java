package com.example.api_1.controller;


import com.example.api_1.entity.TodoEntity;
import com.example.api_1.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @PostMapping
    public ResponseEntity createTodo(@RequestBody TodoEntity todo, @RequestParam Long userId){
        try{
            return ResponseEntity.ok(todoService.createTodo(todo, userId));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произщшла ошибка");
        }
    }

    @PutMapping
    public ResponseEntity completeTodo(@RequestParam Long id){
        try{
            return ResponseEntity.ok(todoService.completed(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произщшла ошибка");
        }
    }

}
