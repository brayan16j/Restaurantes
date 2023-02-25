package com.example.pruebaquileia.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer tipoMenu;
    private String nombreMenu;
    private Float precio;
    /*
    @ManyToOne(
            fetch = FetchType.EAGER,
            optional = false//Un menu no puede existir sin un restaurante
            cascade = CascadeType.PERSIST
            )
    */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restauranteId")
    @JsonIgnoreProperties({"menus"})
    @JsonBackReference
    private Restaurante restaurante;

    @ManyToMany
    @JoinTable(name = "menu_ingrediente",
            joinColumns = @JoinColumn(name = "menu_id"),
            inverseJoinColumns = @JoinColumn(name = "ingrediente_id"))
    public List<Ingrediente> ingredientes;
}
