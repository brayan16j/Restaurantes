package com.example.pruebaquileia.controller;

import com.example.pruebaquileia.model.Ingrediente;
import com.example.pruebaquileia.service.IngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ingrediente")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class IngredienteController {

    @Autowired
    private IngredienteService ingredienteService;

    @GetMapping("/all")
    public List<Ingrediente> getAllIngredientes(){
        return ingredienteService.getAllIngredientes();
    }
    @GetMapping("{id}")
    public Optional<Ingrediente> getIngrediente (@PathVariable("id") Integer id){
        return ingredienteService.getIngrediente(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Ingrediente saveIngrediente (@RequestBody Ingrediente ingrediente){
        return ingredienteService.saveIngrediente(ingrediente);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteIngrediente(@PathVariable("id")Integer id){
        return ingredienteService.deleteIngrediente(id);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Ingrediente updateIngrediente(@RequestBody Ingrediente ingrediente){
        return ingredienteService.updateIngrediente(ingrediente);
    }
}
