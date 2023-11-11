package com.example.hibernate.dominio;

import javax.persistence.*;

@Entity
public class Establecimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_establecimiento;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public TipoSucursal getTipoSucursal() {
        return tipoSucursal;
    }

    public void setTipoSucursal(TipoSucursal tipoSucursal) {
        this.tipoSucursal = tipoSucursal;
    }

    public String getTipoEstablecimiento() {
        return tipoEstablecimiento;
    }

    public void setTipoEstablecimiento(String tipoEstablecimiento) {
        this.tipoEstablecimiento = tipoEstablecimiento;
    }

    @OneToOne
    @JoinColumn(name="ubicacion")
    private Ubicacion ubicacion;

    @Enumerated(EnumType.STRING)
    private TipoSucursal tipoSucursal;

    @Column
    private String tipoEstablecimiento;

    @Column
    private String nombre;


    public void setId_establecimiento(Long idEstablecimiento) {
        this.id_establecimiento = idEstablecimiento;
    }

    public Long getId_establecimiento() {
        return id_establecimiento;
    }
}
