package EntidadesYEstablecimientos;

import Servicios.Monitoreable;

import java.util.List;

public class Sucursal extends Establecimiento{
    private TipoDeSucursal tipo;
    private String nombre;
    private Ubicacion ubicacion;
    private List<Monitoreable> monitoreables;
    private Localizacion localizacion;

    public TipoDeSucursal getTipo() {
        return tipo;
    }

    public void setTipo(TipoDeSucursal tipo) {
        this.tipo = tipo;
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
