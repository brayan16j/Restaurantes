package com.example.pruebaquileia.repository.crudrepository;

import com.example.pruebaquileia.model.Restaurante;
import org.springframework.data.repository.CrudRepository;


public interface RestauranteCrudRepository extends CrudRepository<Restaurante, Integer> {

    //@Query(value = "SELECT e FROM Restaurante e WHERE e.tipoRestaurante = :id")
    //public List<Restaurante> findByIds(@Param("id") Integer id);

}
