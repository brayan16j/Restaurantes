package com.example.pruebaquileia.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "restaurante")
@NoArgsConstructor
@Getter
@Setter
public class Restaurante implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String razonSocial;
    private Integer tipoRestaurante;
    private String ciudad;
    private String horaApertura;
    private String horaCierre;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "restaurante")
    @JsonIgnoreProperties({"restaurante", "ingredientes"})
    public List<Menu> menus;


}
