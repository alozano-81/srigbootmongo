package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.ClientEntity;
import com.example.demo.entities.DocumentPruebaMDB;
import com.example.demo.entities.LogEntity;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.repository.DocumentoRepository;
import com.example.demo.repository.LoginRepository;
import com.example.demo.service.PruebaService;
import com.example.demo.dto.ClienteDTO;
import com.example.demo.dto.LoginDTO;

@Service
public class PruebaImplService implements PruebaService {

    @Autowired
    DocumentoRepository documentoRepository;

    @Autowired
    LoginRepository loginRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public DocumentPruebaMDB getTodos(String name) {
        DocumentPruebaMDB out = new DocumentPruebaMDB();
        List<DocumentPruebaMDB> list = documentoRepository.getTodos(name);
        System.out.println("VER: " + list);
        return out;
    }

    @Override
    public String buscarPorUserPassword(String u, String p) {
        String retorno = "";

        try {
            LogEntity resultado = loginRepository.buscarByUser(u, p);
            LoginDTO objeto = modelMapper.map(resultado, LoginDTO.class);

            if (objeto != null) {
                System.out.println("ver: " + resultado);
                retorno = "ok";
            }

        } catch (Exception e) {
            System.out.println("captura el error");
            retorno = "error";
        }

        return retorno;
    }

    @Override
    public List<ClienteDTO> getAllClientes() {
        List<ClienteDTO> lista = new ArrayList<>();
        
        List<ClientEntity> obj = clienteRepository.getTodos();
        for (ClientEntity c : obj) {
            ClienteDTO clientes = new ClienteDTO();
            clientes = modelMapper.map(c, ClienteDTO.class);
            lista.add(clientes);
        }
        return lista;
    }

}
