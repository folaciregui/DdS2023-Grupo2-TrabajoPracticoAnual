package EntidadesYEstablecimientos;

import Servicios.Monitoreable;

import java.util.List;

public class Establecimiento {
    private String nombre;
    private Ubicacion ubicacion;
    private List<Monitoreable> monitoreables;
    private Localizacion localizacion;

    //public void modificacionDisponibilidad(Establecimiento establecimiento) {
        //TODO
    //    return;
    //}

    public List<Monitoreable> getMonitoreable(){
        return this.monitoreables;
    }
}

