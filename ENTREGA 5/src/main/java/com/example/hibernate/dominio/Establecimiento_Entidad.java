package com.example.hibernate.dominio;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

@Entity
@IdClass(ClaveCompuestaEstablecimientoEntidad.class)
public class Establecimiento_Entidad {
    public Entidad getId_entidad() {
        return id_entidad;
    }

    public void setId_entidad(Entidad id_entidad) {
        this.id_entidad = id_entidad;
    }

    public Establecimiento getId_establecimiento() {
        return id_establecimiento;
    }

    public void setId_establecimiento(Establecimiento id_establecimiento) {
        this.id_establecimiento = id_establecimiento;
    }

    @Id
    @ManyToOne
    private Entidad id_entidad;

    @Id
    @ManyToOne
    private Establecimiento id_establecimiento;

}
