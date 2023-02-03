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
    @SequenceGenerator(
            name = "restaurante_sequence",
            sequenceName = "restaurante_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "restaurante_sequence"
    )
    private Integer id;
    @Column(name = "razonSocial", length = 50, nullable = false)
    private String razonSocial;
    private String nombreComercial;
    private Integer tipoRestaurante;
    private String ciudad;
    private String horaApertura;
    private String horaCierre;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "restaurante")
    @JsonIgnoreProperties({"restaurante", "ingredientes"})
    public List<Menu> menus;


}
