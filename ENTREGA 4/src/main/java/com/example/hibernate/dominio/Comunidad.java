package com.example.hibernate.dominio;

import javax.persistence.*;

@Entity
public class Comunidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_comunidad;
    public void setId_comunidad(Long idComunidad) {
        this.id_comunidad = idComunidad;
    }

    public Long getId_comunidad() {
        return id_comunidad;
    }
}
