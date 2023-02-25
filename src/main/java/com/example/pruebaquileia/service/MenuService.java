package com.example.pruebaquileia.service;

import com.example.pruebaquileia.model.Menu;
import com.example.pruebaquileia.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    public List<Menu> getAllMenus(){
        return menuRepository.getAllMenus();
    }
    public Optional<Menu>getMenu(Integer id){
        return menuRepository.getMenu(id);
    }

    public Menu saveMenu(Menu menu){
        if(menu.getId()==null){
            return menuRepository.saveMenu(menu);
        }else {
            Optional<Menu> menuEncontrado = getMenu(menu.getId());
            if (menuEncontrado.isEmpty()){
                return menuRepository.saveMenu(menu);
            }else {
                return menu;
            }
        }
    }
    public boolean deleteMenu (Integer id){
        Boolean respuesta = getMenu(id).map(e ->{
            menuRepository.deleteMenu(e.getId());
            return true;
        }).orElse(false);
        return respuesta;
    }
    public Menu updateMenu(Menu menu){
        if (menu.getId()!=null){
            Optional<Menu> menuEncontrado = getMenu(menu.getId());
            if (!menuEncontrado.isEmpty()){
                if (menu.getTipoMenu() != null){
                    menuEncontrado.get().setTipoMenu(menu.getTipoMenu());
                }
                if (menu.getPrecio()!=null){
                    menuEncontrado.get().setPrecio(menu.getPrecio());
                }
                if (menu.getRestaurante()!=null){
                    menuEncontrado.get().setRestaurante(menu.getRestaurante());
                }
                if (menu.getIngredientes()!=null){
                    menuEncontrado.get().setIngredientes(menu.getIngredientes());
                }

                return menuRepository.saveMenu(menuEncontrado.get());
            }
        }
        return menu;
    }

}
