package org.example;

import java.util.List;

public class Monitoreable{
    private int id;

    public List<Incidente> getIncidentes() {
        return incidentes;
    }

    public void setIncidentes(List<Incidente> incidentes) {
        this.incidentes = incidentes;
    }

    private List<Incidente> incidentes;

}