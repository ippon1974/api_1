package com.example.api_1.service;

import com.example.api_1.entity.UserEntity;
import com.example.api_1.exception.UserAlreadyExistExeption;
import com.example.api_1.exception.UserNotFoundException;
import com.example.api_1.model.User;
import com.example.api_1.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.spi.LocaleNameProvider;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

     public UserEntity registration(UserEntity user) throws UserAlreadyExistExeption {
         if(userRepo.findByUsername(user.getUsername()) != null){
             throw  new UserAlreadyExistExeption("Пользователь с таким именем уже существует");
         }
         return userRepo.save(user);
     }


    public List<UserEntity> findAllElements() {
        return (List<UserEntity>)userRepo.findAll();
    }

     public User getOne(Long id) throws UserNotFoundException {
         UserEntity user = userRepo.findById(id).get();
         if(user == null) {
            throw new UserNotFoundException("Пользователь с таким именем не нейден");
         }
         return User.toModel(user);
     }


     public UserEntity update(Long id, UserEntity newuser){
         UserEntity user = userRepo.findById(id).get();
         return userRepo.findById(id)
                 .map(users -> {
                     users.setId(newuser.getId());
                     users.setUsername(newuser.getUsername());
                     return userRepo.save(users);
                 })
                 .orElseGet(() -> {
                     newuser.setId(id);
                     return userRepo.save(newuser);
                 });
     }


    public User updateUser(Long id, UserEntity newuser) throws UserNotFoundException {
        UserEntity user = userRepo.findById(id).get();
        if(user == null) {
            throw new UserNotFoundException("Пользователь с таким ID не найден");
        }
        user.setUsername(newuser.getUsername());
        user.setPassword(newuser.getPassword());
        userRepo.save(newuser);
        return User.toModel(user);
    }


     public Long delete(Long id){
         userRepo.deleteById(id);
         return id;
     }
}
