package com.example.pruebaquileia.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

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

    @ManyToOne
    @JoinColumn(name = "menuId")
    @JsonIgnoreProperties({"ingrediente"})
    private Menu menu;
}
