package com.example.hibernate.dominio;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Incidente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Incidente;

    @Column
    private String descripcion;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    @Column
    private LocalDateTime fechaInicio;

    @Column
    private LocalDateTime fechaCierre;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(LocalDateTime fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public UsuarioGeneral getCreador() {
        return creador;
    }

    public void setCreador(UsuarioGeneral creador) {
        this.creador = creador;
    }

    public Servicio getMonitoreable() {
        return monitoreable;
    }

    public void setMonitoreable(Servicio monitoreable) {
        this.monitoreable = monitoreable;
    }

    @Column
    private String observaciones;

    @ManyToOne
    private UsuarioGeneral creador;

    @ManyToOne
    private Servicio monitoreable;

    public void setId_Incidente(Long idIncidente) {
        this.id_Incidente = idIncidente;
    }

    public Long getId_Incidente() {
        return id_Incidente;
    }
}
