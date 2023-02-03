package com.example.pruebaquileia.service;

import com.example.pruebaquileia.model.Ingrediente;
import com.example.pruebaquileia.repository.IngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredienteService {

    @Autowired
    private IngredienteRepository ingredienteRepository;

    public List<Ingrediente> getAllIngredientes(){
        return ingredienteRepository.getAllIngredientes();
    }
    public Optional<Ingrediente> getIngrediente(Integer id){
        return ingredienteRepository.getIngrediente(id);
    }
    public Ingrediente saveIngrediente (Ingrediente ingrediente){
        if (ingrediente.getId()==null){
            return ingredienteRepository.saveIngrediente(ingrediente);
        }else {
            Optional<Ingrediente>ingredienteEncontrado = getIngrediente(ingrediente.getId());
            if(ingredienteEncontrado.isEmpty()){
                return ingredienteRepository.saveIngrediente(ingrediente);
            }else {
                return ingrediente;
            }
        }
    }
    public boolean deleteIngrediente(Integer id){
        Boolean respuesta = getIngrediente(id).map(e ->{
            ingredienteRepository.deleteIngrediente(e.getId());
            return true;
        }).orElse(false);
        return respuesta;
    }
    public Ingrediente updateIngrediente(Ingrediente ingrediente){
        if(ingrediente.getId()!=null){
            Optional<Ingrediente> ingredienteEncontrado = getIngrediente(ingrediente.getId());
            if (!ingredienteEncontrado.isEmpty()){
                if (ingrediente.getNombre() != null){
                    ingredienteEncontrado.get().setNombre(ingrediente.getNombre());
                }
                if (ingrediente.getCalorias()!= null){
                    ingredienteEncontrado.get().setCalorias(ingrediente.getCalorias());
                }
                if (ingrediente.getMenus()!=null){
                    ingredienteEncontrado.get().setMenus(ingrediente.getMenus());
                }
                return ingredienteRepository.saveIngrediente(ingredienteEncontrado.get());
            }
        }
        return ingrediente;
    }
}
