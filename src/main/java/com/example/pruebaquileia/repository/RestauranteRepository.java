package com.example.pruebaquileia.repository;

import com.example.pruebaquileia.model.Restaurante;
import com.example.pruebaquileia.repository.crudrepository.RestauranteCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RestauranteRepository {
    @Autowired
    private RestauranteCrudRepository restauranteCrudRepository;

    public List<Restaurante> getAllRestaurantes(){
        return (List<Restaurante>) restauranteCrudRepository.findAll();
    }

    public Optional<Restaurante> getRestaurante(Integer id){
        return restauranteCrudRepository.findById(id);
    }

    public Restaurante saveRestaurante(Restaurante restaurante){
        return restauranteCrudRepository.save(restaurante);
    }
    public boolean deleteRestaurante(Integer id){
         restauranteCrudRepository.deleteById(id);
         return true;
    }
    public Restaurante updateRestaurante(Restaurante restaurante){
        return restauranteCrudRepository.save(restaurante);
    }
    //JPPLQ

}
