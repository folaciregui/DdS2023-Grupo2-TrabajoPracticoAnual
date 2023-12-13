package com.example.hibernate.dominio;


import javax.persistence.*;


    @Entity
    public class Entidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_entidad;

    @Column(name="nombre")
    private String nombre;
    @ManyToOne
    private Organizacion empresaPrestadora;

    @ManyToOne
    private Organizacion organismoDeControl;

    @Column(name="tipoEntidad")
    private String tipoEntidad;

    @Enumerated(EnumType.STRING)
    private TipoMedio tipoMedio;
    //getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Organizacion getEmpresaPrestadora() {
        return empresaPrestadora;
    }

    public void setEmpresaPrestadora(Organizacion unaEmpresaPrestadora) {
        empresaPrestadora = unaEmpresaPrestadora;
    }

    public Organizacion getOrganismoDeControl() {
        return organismoDeControl;
    }

    public void setOrganismoDeControl(Organizacion unOrganismoDeControl) {
        organismoDeControl = unOrganismoDeControl;
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


    public void setId_entidad(Long idEntidad) {
        this.id_entidad = idEntidad;
    }

    public Long getId_entidad() {
        return id_entidad;
    }
}
