package com.example.pruebaquileia.repository;

import com.example.pruebaquileia.model.Menu;
import com.example.pruebaquileia.repository.crudrepository.MenuCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MenuRepository {

    @Autowired
    private MenuCrudRepository menuCrudRepository;

    public List<Menu> getAllMenus(){
        return (List<Menu>) menuCrudRepository.findAll();
    }
    public Optional<Menu> getMenu(Integer id){
        return menuCrudRepository.findById(id);
    }
    public Menu saveMenu(Menu menu){
        return menuCrudRepository.save(menu);
    }
    public boolean deleteMenu(Integer id){
        menuCrudRepository.deleteById(id);
        return true;
    }
    public Menu updateMenu(Menu menu){
        return menuCrudRepository.save(menu);
    }
}
