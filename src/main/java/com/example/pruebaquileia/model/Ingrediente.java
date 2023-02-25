package com.example.pruebaquileia.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "ingrediente")
@NoArgsConstructor
@Getter
@Setter
public class Ingrediente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private Integer calorias;

    @ManyToMany(mappedBy = "ingredientes")
    public List<Menu> menus;


}
