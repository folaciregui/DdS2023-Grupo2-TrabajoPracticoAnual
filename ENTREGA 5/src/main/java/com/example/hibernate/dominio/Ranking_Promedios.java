package com.example.hibernate.dominio;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Ranking_Promedios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_ranking_promiedos;

    @Column(name="fecha")
    private LocalDateTime fecha;

    @OneToMany(mappedBy = "rankingPromedios")
    private List<Ranking_Entidad> ranking_entidad;
    public void setId_ranking_promiedos(Long idRankingPromiedos) {
        this.id_ranking_promiedos = idRankingPromiedos;
    }

    public Long getId_ranking_promiedos() {
        return id_ranking_promiedos;
    }
}
