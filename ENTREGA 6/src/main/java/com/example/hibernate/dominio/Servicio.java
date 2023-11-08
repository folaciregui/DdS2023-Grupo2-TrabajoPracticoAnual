package com.example.hibernate.dominio;

import javax.persistence.*;

@Entity
public class Servicio {
    public Tramo getTramo() {
        return tramo;
    }

    public void setTramo(Tramo tramo) {
        this.tramo = tramo;
    }

    public TipoServicio getTipoDeServicio() {
        return tipoDeServicio;
    }

    public void setTipoDeServicio(TipoServicio tipoDeServicio) {
        this.tipoDeServicio = tipoDeServicio;
    }

    public Disponibilidad getEstado() {
        return estado;
    }

    public void setEstado(Disponibilidad estado) {
        this.estado = estado;
    }

    public Establecimiento getServicios() {
        return servicios;
    }

    public void setServicios(Establecimiento servicios) {
        this.servicios = servicios;
    }

    public CategoriaServicio getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaServicio categoria) {
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Tramo tramo;
    @Enumerated(EnumType.STRING)
    private TipoServicio tipoDeServicio;
    @Enumerated(EnumType.STRING)
    private Disponibilidad estado;

    @ManyToOne
    private Establecimiento servicios;

    @Enumerated(EnumType.STRING)
    private CategoriaServicio categoria;
    @Column
    private String nombre; //porque es fk? en el der

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
