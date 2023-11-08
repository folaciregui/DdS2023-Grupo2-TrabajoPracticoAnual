package com.example.hibernate.dominio;

import javax.persistence.*;

@Entity
public class Tramo {
    public TipoTramo getParteInicial() {
        return parteInicial;
    }

    public void setParteInicial(TipoTramo parteInicial) {
        this.parteInicial = parteInicial;
    }

    public TipoTramo getParteFinal() {
        return parteFinal;
    }

    public void setParteFinal(TipoTramo parteFinal) {
        this.parteFinal = parteFinal;
    }

    @Id
    private Long id_ubicacion;
    @Enumerated(EnumType.STRING)
    private TipoTramo parteInicial;
    @Enumerated(EnumType.STRING)
    private TipoTramo parteFinal;
    public void setId_ubicacion(Long idUbicacion) {
        this.id_ubicacion = idUbicacion;
    }

    public Long getId_ubicacion() {
        return id_ubicacion;
    }
}
