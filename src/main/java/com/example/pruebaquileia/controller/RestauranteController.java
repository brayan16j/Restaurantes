package com.example.pruebaquileia.controller;


import com.example.pruebaquileia.model.Restaurante;
import com.example.pruebaquileia.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/restaurante")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class RestauranteController {

    @Autowired
    private RestauranteService restauranteService;

    @GetMapping("/all")
    public List<Restaurante> getAllRestaurantes(){
        return restauranteService.getAllRestaurantes();
    }
    @GetMapping("{id}")
    public Optional<Restaurante> getRestaurante(@PathVariable("id") Integer id){
        return restauranteService.getRestaurante(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Restaurante saveRestaurante(@RequestBody Restaurante restaurante){
        return restauranteService.saveRestaurante(restaurante);
    }
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
