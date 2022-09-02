package com.example.api_1.repository;

import com.example.api_1.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepo extends JpaRepository<TestEntity, Long>  {

}
