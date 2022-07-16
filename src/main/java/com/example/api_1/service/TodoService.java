package com.example.api_1.service;

import com.example.api_1.entity.TodoEntity;
import com.example.api_1.entity.UserEntity;
import com.example.api_1.model.Todo;
import com.example.api_1.repository.TodoRepo;
import com.example.api_1.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired
    private TodoRepo todoRepo;

    @Autowired
    private UserRepo userRepo;

    public Todo createTodo(TodoEntity todo, Long userId){
        UserEntity user = userRepo.findById(userId).get();
        todo.setUser(user);
        return  Todo.toModel(todoRepo.save(todo));
    }

    public Todo completed(Long id){
        TodoEntity toto = todoRepo.findById(id).get();
        toto.setCompleted(!toto.getCompleted());
        return Todo.toModel(todoRepo.save(toto));
    }

}
