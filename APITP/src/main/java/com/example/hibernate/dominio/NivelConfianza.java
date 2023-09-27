package com.example.hibernate.dominio;

import static java.lang.Double.max;

public class NivelConfianza {
    public ClasificacionConfianza getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(ClasificacionConfianza clasificacion) {
        this.clasificacion = clasificacion;
    }

    private ClasificacionConfianza clasificacion;

    public double getNivelNumerico() {
        return nivelNumerico;
    }

    public void setNivelNumerico(double nivelNumerico) {
        this.nivelNumerico = nivelNumerico;
    }

    private double nivelNumerico;
    public NivelConfianza( ){
        nivelNumerico=5;
        this.setClasificacion(ClasificacionConfianza.CONFIABLENIVEL2);
//        clasificacion= CONFIABLENIVEL2;
    }
    public void calcularpuntos(double puntos){
        nivelNumerico = Math.max((double) 0, nivelNumerico+puntos);
        if(nivelNumerico<2){
            setClasificacion(ClasificacionConfianza.NOCONFIABLE);
        } else if (nivelNumerico<3){
            setClasificacion(ClasificacionConfianza.CONRESERVAS);
        } else if (nivelNumerico<5){
            setClasificacion(ClasificacionConfianza.CONFIABLENIVEL1);
        } else{
            setClasificacion(ClasificacionConfianza.CONFIABLENIVEL2);
        }
    }
}
