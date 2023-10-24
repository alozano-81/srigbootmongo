package com.example.demo.entities;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("cliente")
public class ClientEntity {
    @Id
    private String id;

    private long nit;
    private long digVertificacion;
    private String nombreComercial;
    private String razonSocial;
    private String regimen;
    private String direccion;
    private long departamento;
    private long municipio;
    private long pais;
    private String email;
    private String telefono;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;
    private String usuarioCreacion;
    private String usuarioModificacion;

}
