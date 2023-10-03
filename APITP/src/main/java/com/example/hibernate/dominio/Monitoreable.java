package com.example.hibernate.dominio;

import java.util.List;

public class Monitoreable{
    private int id;
    private List<Incidente> incidentes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public List<Incidente> getIncidentes() {
        return incidentes;
    }

    public void setIncidentes(List<Incidente> incidentes) {
        this.incidentes = incidentes;
    }



}