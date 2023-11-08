package com.example.hibernate.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ubicacion {
    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    @Id
    private Long id_ubicacion;
    @Column
    private String calle;
    @Column
    private int altura;


    public void setId_ubicacion(Long idUbicacion) {
        this.id_ubicacion = idUbicacion;
    }

    public Long getId_ubicacion() {
        return id_ubicacion;
    }
}
