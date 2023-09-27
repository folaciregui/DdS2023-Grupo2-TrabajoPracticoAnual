package com.example.hibernate.dominio;

import java.time.LocalDateTime;

import java.time.Duration;
public class Incidente {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsuarioCreador(Usuario usuarioCreador) {
        this.usuarioCreador = usuarioCreador;
    }

    public void setUsuarioCerrador(Usuario usuarioCerrador) {
        this.usuarioCerrador = usuarioCerrador;
    }

    public boolean isEstaCerrado() {
        return estaCerrado;
    }

    public void setEstaCerrado(boolean estaCerrado) {
        this.estaCerrado = estaCerrado;
    }

    private int id;
    private Usuario usuarioCreador;
    private Usuario usuarioCerrador;
    private LocalDateTime fechaInicio;

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

    private LocalDateTime fechaCierre;
    private boolean estaCerrado;

    public Monitoreable getMonitoreable() {
        return monitoreable;
    }

    public void setMonitoreable(Monitoreable monitoreable) {
        this.monitoreable = monitoreable;
    }

    private Monitoreable monitoreable;
    public boolean getEstaCerrado(){
        return estaCerrado;
    }
    public boolean mismoCreadorCerrador(){
        if (this.getEstaCerrado()){
            return usuarioCerrador == usuarioCreador;
        } else {
            return false;
        }
    }
    public boolean tiempoAbiertoMenorA(double segundos){
        return Duration.between(fechaCierre,fechaInicio ).getSeconds() < segundos;
    }
    public Usuario getUsuarioCreador() {
        return usuarioCreador;
    }

    public Usuario getUsuarioCerrador() {
        return usuarioCerrador;
    }
}
