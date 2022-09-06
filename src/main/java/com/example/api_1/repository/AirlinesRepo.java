package com.example.api_1.repository;

import com.example.api_1.entity.AirlinesEntity;
import com.example.api_1.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AirlinesRepo extends JpaRepository<AirlinesEntity, Long> {
    @Query(value = "SELECT * FROM airlines ORDER BY airlines_id DESC", nativeQuery = true)
    public List<AirlinesEntity> findAllByOrderByIdDesc();
}
