package EntidadesYEstablecimientos;

import java.util.List;

public class Estacion extends Establecimiento{
    private List<Linea> lineas;
    private String nombre;
    private Ubicacion ubicacion;
    private List<Monitoreable> servicios;
    private Localizacion localizacion;

    public void altaServicio(Monitoreable servicio) {
        servicios.add(servicio);
        return;
    }

    public void bajaServicio(Monitoreable servicio) {
        servicios.remove(servicio);
        return;
    }

    public List<Monitoreable> serviciosDisponibles(){
        //TODO
        return null;
    }

}
