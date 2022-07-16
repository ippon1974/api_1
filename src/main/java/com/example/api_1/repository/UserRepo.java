package com.example.api_1.repository;

import com.example.api_1.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
}
