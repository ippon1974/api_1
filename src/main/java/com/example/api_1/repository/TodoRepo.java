package com.example.api_1.repository;

import com.example.api_1.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.nio.file.LinkOption;

public interface TodoRepo extends JpaRepository<TodoEntity, Long> {

}
