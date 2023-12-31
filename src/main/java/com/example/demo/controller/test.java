package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.dto.ClienteDTO;
import com.example.demo.service.PruebaService;

@RestController
@RequestMapping("api/pruebaMB")
public class test {

    @Autowired
    PruebaService pruebaService;

    @GetMapping("/entrar")
    public ResponseEntity<String> pruebaNavi() {

        pruebaService.getTodos("yo");
        System.out.println("llega");

        return new ResponseEntity<>("OKK", HttpStatus.ACCEPTED);
    }

    @PostMapping(value = "/validar-ingreso", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> validarIngresoSesion(
            @RequestParam(value = "usuario", required = false) String usuario,
            @RequestParam(value = "password", required = false) String password) {
        // System.out.println("====>" + usuario);
        // System.out.println("==+++==>" + password);
        String out = "";
        try {
            out = pruebaService.buscarPorUserPassword(usuario, password);
            if (out.equals("error")) {
                System.out.println("mostrar error: " + out);
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, out);
            }
            System.out.println("llega ytr");
            return new ResponseEntity<>(out, HttpStatus.ACCEPTED);

        } catch (Exception e) {
            return new ResponseEntity<>(out, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/get-all-clientes")
    public ResponseEntity<List<ClienteDTO>> getAll() {
        List<ClienteDTO> out = new ArrayList<>();
        out = pruebaService.getAllClientes();
        System.out.println("llega");

        // return new ResponseEntity<>("OKK", HttpStatus.ACCEPTED);
        return new ResponseEntity<>(out, HttpStatus.ACCEPTED);
    }

}
