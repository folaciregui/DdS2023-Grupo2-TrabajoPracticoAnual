package Servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Monitoreable {
    private String nombre;
    private Disponibilidad estado;
    private List<Incidente> incidentesActivos;
    private List<Incidente> incidentesInactivos;
    public void registrarIncidente(Incidente unIncidente){
        incidentesActivos.add(unIncidente);
    }
    public void cerrar(Incidente unIncidente){
        incidentesActivos.remove(unIncidente);
        incidentesInactivos.add(unIncidente);
    }
    public List<Incidente> getIncidentesAbiertos(){
        return this.incidentesActivos;
    }

    public List<Incidente> getIncidentesInactivos(){
        return this.incidentesInactivos;
    }
    public List<Incidente> getIncidentesTotales(){
        List<Incidente> todosIncidentes = Stream.concat(this.getIncidentesInactivos().stream(), this.getIncidentesAbiertos().stream())
                .collect(Collectors.toList());
        return todosIncidentes;
    }

    public Disponibilidad getDisponibilidad() {
        return estado;
    }
}
