package com.example.demo.service;

import com.example.demo.entities.DocumentPruebaMDB;

public interface PruebaService {

    public DocumentPruebaMDB getTodos(String name);

    public String buscarPorUserPassword(String u, String p);

}
