package com.example.hibernate.dominio;

import java.util.List;

public class Usuario {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;

    public boolean isMalandra() {
        return malandra;
    }

    public void setMalandra(boolean malandra) {
        this.malandra = malandra;
    }

    //agregamos lista de incidentes
    private boolean malandra=false;
    private NivelConfianza nivelConfianza = new NivelConfianza();

    public List<Incidente> getActividadIncidentes() {
        return actividadIncidentes;
    }


    public void setActividadIncidentes(List<Incidente> actividadIncidentes) {
        this.actividadIncidentes = actividadIncidentes;
    }

    private List<Incidente> actividadIncidentes;

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