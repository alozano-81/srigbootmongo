package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo.entities.LogEntity;

public interface LoginRepository extends MongoRepository<LogEntity, String>{
    @Query("{user: '?0',password: '?1'}")
    //{user: 'jjjj',password: '1234'}
    LogEntity buscarByUser(String user, String password);
}
