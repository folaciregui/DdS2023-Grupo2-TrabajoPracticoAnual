package com.example.hibernate.dominio;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Ranking_MayorCantidadIncidentes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="fecha")
    private LocalDateTime fecha;

    @OneToMany(mappedBy = "rankingMayorCantidadIncidentes")
    private List<Ranking_Entidad>  ranking_entidad;
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
