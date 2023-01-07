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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer tipoMenu;
    private String nombreMenu;
    private Float precio;

    @ManyToOne
    @JoinColumn(name = "restauranteId")
    @JsonIgnoreProperties({"menus"})
    private Restaurante restaurante;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "menu")
    @JsonIgnoreProperties({"menu","restaurante"})
    public List<Ingrediente> ingredientes;
}
