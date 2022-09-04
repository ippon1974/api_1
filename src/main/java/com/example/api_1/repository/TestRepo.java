package com.example.api_1.repository;

import com.example.api_1.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestRepo extends JpaRepository<TestEntity, Long> {
    public List<TestEntity> findAllByOrderByIdAsc();

    public List<TestEntity> findAllByOrderByIdDesc();
}

