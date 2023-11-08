package com.example.hibernate.dominio;


import javax.persistence.*;

@Entity
public class Entidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_entidad;

    @Column(name="nombre")
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Organizacion getEmpresaPrestadora() {
        return empresaPrestadora;
    }

    public void setEmpresaPrestadora(Organizacion empresaPrestadora) {
        this.empresaPrestadora = empresaPrestadora;
    }

    public Organizacion getOrganismoDeControl() {
        return organismoDeControl;
    }

    public void setOrganismoDeControl(Organizacion organismoDeControl) {
        this.organismoDeControl = organismoDeControl;
    }

    public String getTipoEntidad() {
        return tipoEntidad;
    }

    public void setTipoEntidad(String tipoEntidad) {
        this.tipoEntidad = tipoEntidad;
    }

    public TipoMedio getTipoMedio() {
        return tipoMedio;
    }

    public void setTipoMedio(TipoMedio tipoMedio) {
        this.tipoMedio = tipoMedio;
    }


    @ManyToOne
    private Organizacion empresaPrestadora;

    @ManyToOne
    private Organizacion organismoDeControl;

    @Column(name="tipoEntidad")
    private String tipoEntidad;

    @Enumerated(EnumType.STRING)
    private TipoMedio tipoMedio;

    public void setId_entidad(Long idEntidad) {
        this.id_entidad = idEntidad;
    }

    public Long getId_entidad() {
        return id_entidad;
    }
}
