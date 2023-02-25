package com.example.pruebaquileia.controller;


import com.example.pruebaquileia.dto.RestauranteDto;
import com.example.pruebaquileia.model.Restaurante;
import com.example.pruebaquileia.service.RestauranteService;
import com.example.pruebaquileia.service.RestauranteServicioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/restaurante")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class RestauranteController {

    @Autowired
    private RestauranteService restauranteService;
    /*@Autowired
    private RestauranteServicioDto restauranteServicioDto;*/

    @GetMapping("/all")
    public List<Restaurante> getAllRestaurantes(){
        return restauranteService.getAllRestaurantes();
    }
    //Controller por DTO
    /*
    @GetMapping("/all")
    public List<RestauranteDto> listarRestaurantes(){
        return restauranteServicioDto.obtenerTodosRestaurantes();
    }*/

    @GetMapping("{id}")
    public Optional<Restaurante> getRestaurante(@PathVariable("id") Integer id){
        return restauranteService.getRestaurante(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Restaurante saveRestaurante(@RequestBody Restaurante restaurante){
        return restauranteService.saveRestaurante(restaurante);
    }
    /*
    @PostMapping("/save")
    public ResponseEntity<RestauranteDto> guardarRestaurante(@RequestBody RestauranteDto restauranteDto ){
        return new ResponseEntity<>(restauranteServicioDto.crearRestaurante(restauranteDto),HttpStatus.CREATED);

    }*/

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteRestaurante(@PathVariable("id")Integer id){
        return restauranteService.deleteRestaurante(id);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Restaurante updateRestaurante(@RequestBody Restaurante restaurante){
        return restauranteService.updateRestaurante(restaurante);
    }

}
