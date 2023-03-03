package com.example.pruebaquileia.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "restaurante", uniqueConstraints = {@UniqueConstraint(columnNames = {"razonSocial"})})
@NoArgsConstructor
@Getter
@Setter
public class Restaurante implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "razonSocial", length = 50, nullable = false)
    private String razonSocial;
    private String nombreComercial;
    private String tipoRestaurante;
    private String ciudad;
    private String horaApertura;
    private String horaCierre;

    @OneToMany(mappedBy = "restaurante", cascade = CascadeType.ALL) //orphanRemoval = true
    @JsonIgnoreProperties({"restaurante", "ingredientes"})
    @JsonManagedReference
    public Set<Menu> menus = new HashSet<>();
}
