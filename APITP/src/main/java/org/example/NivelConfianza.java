package org.example;

public class NivelConfianza {
    private Clasificacionconfianza clasificacion;
    private double nivelNumerico;
    public NivelConfianza( ){
        nivelNumerico=5;
        clasificacion= CONFIABLENIVEL2;
    }
    public void calcularpuntos(double puntos){
        nivelNumerico += puntos;

    }
}
