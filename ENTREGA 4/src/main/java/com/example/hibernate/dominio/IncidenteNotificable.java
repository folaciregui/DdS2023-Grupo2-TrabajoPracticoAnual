package com.example.hibernate.dominio;

import javax.persistence.*;

@Entity
@IdClass(ClaveCompuestaIncidente.class)
public class IncidenteNotificable {
    public Comunidad getId_comunidad() {
        return id_comunidad;
    }

    public void setId_comunidad(Comunidad id_comunidad) {
        this.id_comunidad = id_comunidad;
    }

    public Incidente getId_incidente() {
        return id_incidente;
    }

    public void setId_incidente(Incidente id_incidente) {
        this.id_incidente = id_incidente;
    }

    @Id
    @ManyToOne
    private Comunidad id_comunidad;

    @Id
    @ManyToOne
    private Incidente id_incidente;
}
