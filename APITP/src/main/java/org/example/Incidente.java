package org.example;

import java.time.LocalDateTime;

import java.time.Duration;
public class Incidente {
    private int id;
    private Usuarioi usuarioCreador;
    private Usuarioi usuarioCerrador;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaCierre;

    public boolean mismoCreadorCerrador(){
        return usuarioCerrador == usuarioCreador;
    }
    public boolean tiempoAbiertoMenorA(double segundos){
        return Duration.between(fechaCierre,fechaInicio ).getSeconds() < segundos;
    }
    public Usuarioi getUsuarioCreador() {
        return usuarioCreador;
    }

    public Usuarioi getUsuarioCerrador() {
        return usuarioCerrador;
    }
}
