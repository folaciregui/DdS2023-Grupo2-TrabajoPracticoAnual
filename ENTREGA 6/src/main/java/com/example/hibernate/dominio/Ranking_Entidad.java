package com.example.hibernate.dominio;

import javax.persistence.*;

@Entity
@IdClass(ClaveCompuestaRanking.class)
public class Ranking_Entidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_ranking;

    public Long getId_ranking() {
        return id_ranking;
    }

    public void setId_ranking(Long id_ranking) {
        this.id_ranking = id_ranking;
    }

    public Entidad getId_entidad() {
        return id_entidad;
    }

    public void setId_entidad(Entidad id_entidad) {
        this.id_entidad = id_entidad;
    }

    public Ranking_Promedios getRankingPromedios() {
        return rankingPromedios;
    }

    public void setRankingPromedios(Ranking_Promedios rankingPromedios) {
        this.rankingPromedios = rankingPromedios;
    }

    public Ranking_Impacto getRankingImpacto() {
        return rankingImpacto;
    }

    public void setRankingImpacto(Ranking_Impacto rankingImpacto) {
        this.rankingImpacto = rankingImpacto;
    }

    public Ranking_MayorCantidadIncidentes getRankingMayorCantidadIncidentes() {
        return rankingMayorCantidadIncidentes;
    }

    public void setRankingMayorCantidadIncidentes(Ranking_MayorCantidadIncidentes rankingMayorCantidadIncidentes) {
        this.rankingMayorCantidadIncidentes = rankingMayorCantidadIncidentes;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    @Id
    @ManyToOne
    private Entidad id_entidad;


    @ManyToOne
//    @JoinColumn(name = "id_ranking_promedios")
    private Ranking_Promedios rankingPromedios;

    @ManyToOne
//    @JoinColumn(name = "id_ranking_impacto")
    private Ranking_Impacto rankingImpacto;

    @ManyToOne
//    @JoinColumn(name = "id_ranking_mayorCantidadIncidentes")
    private Ranking_MayorCantidadIncidentes rankingMayorCantidadIncidentes;

    @Column(name="posicion")
    private int posicion;
}
