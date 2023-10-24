package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ClienteDTO;
import com.example.demo.entities.DocumentPruebaMDB;

public interface PruebaService {

    public DocumentPruebaMDB getTodos(String name);

    public String buscarPorUserPassword(String u, String p);

    public List<ClienteDTO> getAllClientes();

}
