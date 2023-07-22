package EntidadesYEstablecimientos;

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
}
