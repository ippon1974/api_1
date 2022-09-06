package com.example.api_1.repository;

import com.example.api_1.entity.TestEntity;
import com.example.api_1.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TestRepo extends JpaRepository<TestEntity, Long> {
    @Query(value = "SELECT * FROM test ORDER BY id DESC", nativeQuery = true)
    public List<TestEntity> findAllByOrderByIdDesc();

    @Query("select t from TestEntity t order by t.id desc")
    public List<TestEntity> findAll();

    TestEntity findByUsername(String username);

}

