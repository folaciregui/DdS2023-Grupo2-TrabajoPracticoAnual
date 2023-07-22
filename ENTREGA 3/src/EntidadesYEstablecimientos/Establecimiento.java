package EntidadesYEstablecimientos;

import java.util.List;

public class Establecimiento {
    private String nombre;
    private Ubicacion ubicacion;
    private List<Monitoreable> servicios;
    private Localizacion localizacion;

    public void altaEstablecimiento (Establecimiento establecimiento) {
        //TODO
        return;
    }

    public void bajaEstablecimiento (Establecimiento establecimiento) {
        //TODO
        return;
    }

    public void modificacionDisponibilidad(Establecimiento establecimiento) {
        //TODO
        return;
    }

    public List<Monitoreable> getMonitoreable(){
        return this.servicios;
    }
}
}
