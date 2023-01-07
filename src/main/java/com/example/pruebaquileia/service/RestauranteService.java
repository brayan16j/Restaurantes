package com.example.pruebaquileia.service;

import com.example.pruebaquileia.model.Menu;
import com.example.pruebaquileia.model.Restaurante;
import com.example.pruebaquileia.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    public List<Restaurante> getAllRestaurantes(){
        return restauranteRepository.getAllRestaurantes();
    }
    public Optional<Restaurante> getRestaurante(Integer id){
        return restauranteRepository.getRestaurante(id);
    }
    public Restaurante saveRestaurante(Restaurante restaurante){
        if(restaurante.getId()==null){
            return restauranteRepository.saveRestaurante(restaurante);
        }else {
            Optional<Restaurante> restauranteEncontrado = getRestaurante(restaurante.getId());
            if(restauranteEncontrado.isEmpty()){
                return restauranteRepository.saveRestaurante(restaurante);
            }else {
                return restaurante;
            }
        }
    }
    public boolean deleteRestaurante(Integer id){
        Boolean respuesta = getRestaurante(id).map(e ->{
            restauranteRepository.deleteRestaurante(e.getId());
            return true;
        }).orElse(false);
        return respuesta;
    }
    public Restaurante updateRestaurante(Restaurante restaurante){
        if (restaurante.getId()!=null){
            Optional<Restaurante> restauranteEncontrado = getRestaurante(restaurante.getId());
            if (!restauranteEncontrado.isEmpty()){
                if (restaurante.getRazonSocial() !=null){
                    restauranteEncontrado.get().setRazonSocial(restaurante.getRazonSocial());
                }
                if (restaurante.getTipoRestaurante() !=null){
                    restauranteEncontrado.get().setTipoRestaurante(restaurante.getTipoRestaurante());
                }
                if (restaurante.getCiudad() !=null){
                    restauranteEncontrado.get().setCiudad(restaurante.getCiudad());
                }
                if (restaurante.getHoraApertura() !=null){
                    restauranteEncontrado.get().setHoraApertura(restaurante.getHoraApertura());
                }
                if (restaurante.getHoraCierre() !=null){
                    restauranteEncontrado.get().setHoraCierre(restaurante.getHoraCierre());
                }
                if (restaurante.getMenus() !=null){
                    restauranteEncontrado.get().setMenus(restaurante.getMenus());
                }

                return restauranteRepository.saveRestaurante(restauranteEncontrado.get());
            }
        }
        return restaurante;
    }

}
