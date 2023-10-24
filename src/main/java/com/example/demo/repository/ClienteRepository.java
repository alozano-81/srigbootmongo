package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo.entities.ClientEntity;

public interface ClienteRepository extends MongoRepository<ClientEntity, String> {
    @Query(value = "{}")
    List<ClientEntity> getTodos();
}
