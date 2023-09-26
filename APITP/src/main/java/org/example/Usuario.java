package org.example;

import java.util.List;

public class Usuario {
    private int usuario;

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