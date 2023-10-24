package com.example.demo.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ClienteDTO {
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
