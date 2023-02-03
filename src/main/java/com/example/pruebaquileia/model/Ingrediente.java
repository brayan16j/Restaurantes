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
    @SequenceGenerator(
            name = "ingrediente_sequence",
            sequenceName = "ingrediente_sequence",
            allocationSize = 1,
            initialValue = 2
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ingrediente_sequence"
    )
    private Integer id;
    private String nombre;
    private Integer calorias;

    @ManyToMany
    @JoinTable(name = "menu_ingrediente",
            joinColumns = @JoinColumn(name = "menu_id"),
            inverseJoinColumns = @JoinColumn(name = "ingrediente_id"))
    public List<Menu> menus;

}
