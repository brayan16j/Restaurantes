package com.example.pruebaquileia.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "menu")
@NoArgsConstructor
@Getter
@Setter
public class Menu implements Serializable {
    @Id
    @SequenceGenerator(
            name = "menu_sequence",
            sequenceName = "menu_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "menu_sequence"
    )
    private Integer id;
    private Integer tipoMenu;
    private String nombreMenu;
    private Float precio;
    @ManyToOne
    @JoinColumn(name = "restauranteId")
    @JsonIgnoreProperties({"menus"})
    private Restaurante restaurante;

    @ManyToMany(mappedBy = "menus")
    public List<Ingrediente> ingredientes;
}
