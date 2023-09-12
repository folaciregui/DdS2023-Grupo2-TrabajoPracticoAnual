package com.example.hibernate.dominio;

import javax.persistence.*;

@Entity

@IdClass(ClaveCompuestaMembresia.class)
public class Membresia {
    public Comunidad getId_comunidad() {
        return id_comunidad;
    }

    public void setId_comunidad(Comunidad id_comunidad) {
        this.id_comunidad = id_comunidad;
    }

    public UsuarioGeneral getId_usuario_general() {
        return id_usuario_general;
    }

    public void setId_usuario_general(UsuarioGeneral id_usuario_general) {
        this.id_usuario_general = id_usuario_general;
    }

    public RolDePermiso getRolDePermiso() {
        return rolDePermiso;
    }

    public void setRolDePermiso(RolDePermiso rolDePermiso) {
        this.rolDePermiso = rolDePermiso;
    }

    public RolDeImpacto getRolDeImpacto() {
        return rolDeImpacto;
    }

    public void setRolDeImpacto(RolDeImpacto rolDeImpacto) {
        this.rolDeImpacto = rolDeImpacto;
    }

    @Id
    @ManyToOne
    private Comunidad id_comunidad;

    @Id
    @ManyToOne
    private UsuarioGeneral id_usuario_general;

    @Enumerated(EnumType.STRING)
    private RolDePermiso rolDePermiso;

    @Enumerated(EnumType.STRING)
    private RolDeImpacto rolDeImpacto;
}
