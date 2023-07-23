package EntidadesYEstablecimientos;

import Servicios.Disponibilidad;
import Servicios.Monitoreable;

import java.util.List;
import java.util.stream.Collectors;

public class Estacion extends Establecimiento{
    private List<Linea> lineas;
    private String nombre;
    private Ubicacion ubicacion;
    private List<Monitoreable> monitoreables;
    private Localizacion localizacion;

    public void altaServicio(Monitoreable servicio) {
        monitoreables.add(servicio);
        return;
    }

    public void bajaServicio(Monitoreable servicio) {
        monitoreables.remove(servicio);
        return;
    }

    public List<Monitoreable> serviciosDisponibles(){
        return monitoreables.stream().filter(monitoreable -> monitoreable.getDisponibilidad().equals(Disponibilidad.ACTIVO)).collect(Collectors.toList());
    }

    public List<Linea> getLineas() {
        return lineas;
    }

    public void setLineas(List<Linea> lineas) {
        this.lineas = lineas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public List<Monitoreable> getMonitoreables() {
        return monitoreables;
    }

    public void setMonitoreables(List<Monitoreable> monitoreables) {
        this.monitoreables = monitoreables;
    }

    public Localizacion getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(Localizacion localizacion) {
        this.localizacion = localizacion;
    }


}
