package com.example.pruebaquileia.service;

import com.example.pruebaquileia.dto.RestauranteDto;

import java.util.List;

public interface RestauranteServicioDto {
    public RestauranteDto crearRestaurante(RestauranteDto restauranteDto);

    public List<RestauranteDto> obtenerTodosRestaurantes();

}
