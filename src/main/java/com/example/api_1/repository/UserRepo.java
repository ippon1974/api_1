package com.example.api_1.repository;

import com.example.api_1.entity.TestEntity;
import com.example.api_1.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<UserEntity, Long> {

    @Query("select t from UserEntity t order by t.id desc")
    public List<UserEntity> findAll();

    UserEntity findByUsername(String username);
}
