package com.example.hibernate.dominio;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Organizacion {

    public Long getCuit() {
        return cuit;
    }

    public void setCuit(Long cuit) {
        this.cuit = cuit;
    }

    public TipoOrganizacion getTipoOrganizacion() {
        return tipoOrganizacion;
    }

    public void setTipoOrganizacion(TipoOrganizacion tipoOrganizacion) {
        this.tipoOrganizacion = tipoOrganizacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public UsuarioGeneral getPersonaACargo() {
        return personaACargo;
    }

    public void setPersonaACargo(UsuarioGeneral personaACargo) {
        this.personaACargo = personaACargo;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cuit;

    @Enumerated(EnumType.STRING)
    private TipoOrganizacion tipoOrganizacion;

    @Column(name="nombre")
    private String nombre;

    @OneToOne
    @JoinColumn(name="usuarioGeneral")
    private UsuarioGeneral personaACargo;

    public void setId(Long id) {
        this.cuit = id;
    }

    public Long getId() {
        return cuit;
    }
}
