package com.example.pruebaquileia.controller;

import com.example.pruebaquileia.model.Menu;
import com.example.pruebaquileia.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/menu")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/all")
    public List<Menu> getAllMenus(){
        return menuService.getAllMenus();
    }
    @GetMapping("{id}")
    public Optional<Menu> getMenu (@PathVariable("id") Integer id){
        return menuService.getMenu(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Menu saveMenu (@RequestBody Menu menu){
        return menuService.saveMenu(menu);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteMenu(@PathVariable("id")Integer id){
        return menuService.deleteMenu(id);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Menu updateMenu(@RequestBody Menu menu){
        return menuService.updateMenu(menu);
    }
}
