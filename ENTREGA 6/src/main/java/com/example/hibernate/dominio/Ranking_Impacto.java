package com.example.hibernate.dominio;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Ranking_Impacto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Impacto;

    @Column(name="fecha")
    private LocalDateTime fecha;

    @OneToMany(mappedBy = "rankingImpacto")
    private List<Ranking_Entidad> ranking_entidad;
    public void setId_Impacto(Long idImpacto) {
        this.id_Impacto = idImpacto;
    }

    public Long getId_Impacto() {
        return id_Impacto;
    }
}
