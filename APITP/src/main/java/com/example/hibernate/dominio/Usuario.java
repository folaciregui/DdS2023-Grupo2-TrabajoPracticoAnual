package com.example.hibernate.dominio;

import java.util.List;

import static com.example.hibernate.dominio.ClasificacionConfianza.CONFIABLENIVEL2;

public class Usuario {

    private int id;
    private List<Incidente> actividadIncidentes;
    private NivelConfianza nivelConfianza;
    private Comunidad comunidad;

    public Comunidad getComunidad() {
        return comunidad;
    }

    public void setComunidad(Comunidad comunidad_) {
        this.comunidad = comunidad_;
    }

    private void setInicial(){
        NivelConfianza nivel = new NivelConfianza();
        nivel.setNivelNumerico(5);
        nivel.setClasificacion(CONFIABLENIVEL2);
    }

    private boolean malandra=false;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public boolean isMalandra() {
        return malandra;
    }

    public void setMalandra(boolean malandra) {
        this.malandra = malandra;
    }

    //agregamos lista de incidentes


    public List<Incidente> getActividadIncidentes() {
        return actividadIncidentes;
    }


    public void setActividadIncidentes(List<Incidente> actividadIncidentes) {
        this.actividadIncidentes = actividadIncidentes;
    }



    //hacer builder o inicializar
    public void actualizar_puntos(double puntos){
        nivelConfianza.calcularpuntos(puntos);
    }
    public void setNivelConfianza(NivelConfianza nivelConfianza) {
        this.nivelConfianza = nivelConfianza;
    }
    public NivelConfianza getNivelConfianza() {
        return nivelConfianza;
    }
}