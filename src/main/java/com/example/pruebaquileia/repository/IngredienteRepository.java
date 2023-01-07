package com.example.pruebaquileia.repository;

import com.example.pruebaquileia.model.Ingrediente;
import com.example.pruebaquileia.repository.crudrepository.IngredienteCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class IngredienteRepository {
    @Autowired
    private IngredienteCrudRepository ingredienteCrudRepository;

    public List<Ingrediente> getAllIngredientes(){
        return (List<Ingrediente>) ingredienteCrudRepository.findAll();
    }
    public Optional<Ingrediente> getIngrediente(Integer id){
        return ingredienteCrudRepository.findById(id);
    }
    public Ingrediente saveIngrediente(Ingrediente ingrediente){
        return ingredienteCrudRepository.save(ingrediente);
    }
    public boolean deleteIngrediente(Integer id){
        ingredienteCrudRepository.deleteById(id);
        return true;
    }
    public Ingrediente updateIngrediente(Ingrediente ingrediente){
        return ingredienteCrudRepository.save(ingrediente);
    }
}
