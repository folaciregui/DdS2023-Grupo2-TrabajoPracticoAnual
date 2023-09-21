package org.example;

import java.time.LocalDateTime;

import java.time.Duration;
public class Incidente {
    private int id;
    private Usuarioi usuarioCreador;
    private Usuarioi usuarioCerrador;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaCierre;
    public void puntosporincidente(){
        if(Duration.between(fechaCierre,fechaInicio ).getSeconds()<180 && usuarioCerrador==usuarioCreador){
            usuarioCerrador.actualizar_puntos(-0.2);
        } else if (1==0){ //esta es la del medio despues la hago
        } else{
            usuarioCerrador.actualizar_puntos(0.5);
            usuarioCreador.actualizar_puntos(0.5);
        }
    }

}
