package com.example.pruebaquileia.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RestauranteDto {
    private Integer id;
    private String razonSocial;
    private String nombreComercial;
    private Integer tipoRestaurante;
    private String ciudad;
    private String horaApertura;
    private String horaCierre;
 }
