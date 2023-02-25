package com.example.pruebaquileia.service;

import com.example.pruebaquileia.dto.RestauranteDto;
import com.example.pruebaquileia.model.Restaurante;
import com.example.pruebaquileia.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestauranteServicioImpl implements RestauranteServicioDto {
    @Autowired
    private RestauranteRepository restauranteRepository;

    @Override
    public RestauranteDto crearRestaurante(RestauranteDto restauranteDto) {
        /*
        //Convertimos de DTO a entidad
        Restaurante restaurante = new Restaurante();
        restaurante.setRazonSocial(restauranteDto.getRazonSocial());
        restaurante.setNombreComercial(restauranteDto.getNombreComercial());
        restaurante.setTipoRestaurante(restauranteDto.getTipoRestaurante());
        restaurante.setCiudad(restauranteDto.getCiudad());
        restaurante.setHoraApertura(restauranteDto.getHoraApertura());
        restaurante.setHoraCierre(restauranteDto.getHoraCierre());

        Restaurante nuevoRestaurante = restauranteRepository.saveRestaurante(restaurante);

        //Convertimos de entidad a DTO

        RestauranteDto restauranteRespuesta = new RestauranteDto();
        restauranteRespuesta.setId(nuevoRestaurante.getId());
        restauranteRespuesta.setRazonSocial(nuevoRestaurante.getRazonSocial());
        restauranteRespuesta.setNombreComercial(nuevoRestaurante.getNombreComercial());
        restauranteRespuesta.setTipoRestaurante(nuevoRestaurante.getTipoRestaurante());
        restauranteRespuesta.setCiudad(nuevoRestaurante.getCiudad());
        restauranteRespuesta.setHoraApertura(nuevoRestaurante.getHoraApertura());
        restauranteRespuesta.setHoraCierre(nuevoRestaurante.getHoraCierre());
        */
        Restaurante restaurante = mapearEntidad(restauranteDto);
        Restaurante nuevoRestaurante = restauranteRepository.saveRestaurante(restaurante);
        RestauranteDto restauranteRespuesta = mapearDTO(nuevoRestaurante);
        return restauranteRespuesta;
    }

    @Override
    public List<RestauranteDto> obtenerTodosRestaurantes() {
        List<Restaurante> restaurantes = restauranteRepository.getAllRestaurantes();
        return restaurantes.stream().map(restaurante -> mapearDTO(restaurante)).collect(Collectors.toList());
    }
    // Este Metodo convierte entidad a DTO
    private RestauranteDto mapearDTO(Restaurante restaurante){
        RestauranteDto restauranteDto =new RestauranteDto();

        restauranteDto.setId(restaurante.getId());
        restauranteDto.setRazonSocial(restaurante.getRazonSocial());
        restauranteDto.setNombreComercial(restaurante.getNombreComercial());
        restauranteDto.setTipoRestaurante(restaurante.getTipoRestaurante());
        restauranteDto.setCiudad(restaurante.getCiudad());
        restauranteDto.setHoraApertura(restaurante.getHoraApertura());
        restauranteDto.setHoraCierre(restaurante.getHoraCierre());

        return restauranteDto;

    }
    // Convierte de DTO a Entidad
    private Restaurante mapearEntidad(RestauranteDto restauranteDto){
        Restaurante restaurante = new Restaurante();

        restaurante.setId(restauranteDto.getId());
        restaurante.setRazonSocial(restauranteDto.getRazonSocial());
        restaurante.setNombreComercial(restauranteDto.getNombreComercial());
        restaurante.setTipoRestaurante(restauranteDto.getTipoRestaurante());
        restaurante.setCiudad(restauranteDto.getCiudad());
        restaurante.setHoraApertura(restauranteDto.getHoraApertura());
        restaurante.setHoraCierre(restauranteDto.getHoraCierre());

        return restaurante;

    }
}
