package EntidadesYEstablecimientos;

import Servicios.Incidente;
import Servicios.Monitoreable;

import java.util.List;
import java.util.stream.Collectors;

public class Organizacion extends Entidad{
    private List<Sucursal> establecimientos;
    List<Sucursal> getEstablecimientos(){
        return this.establecimientos;
    }

    public List<Incidente> getIncidentesInactivos() {
        List<Incidente> todosLosIncidentes = this.getEstablecimientos().stream() // Obtener la lista de establecimientos de la línea
                .flatMap(establecimiento -> establecimiento.getMonitoreable().stream()) // Obtener todas las listas de monitoreables de cada establecimiento y combinarlas en una sola lista
                .flatMap(monitoreable -> monitoreable.getIncidentesInactivos().stream()) // Obtener todos los incidentes de cada monitoreable y combinarlos en una sola lista
                .collect(Collectors.toList()); // Recolectar en una lista

        return todosLosIncidentes;
    }
    @Override
    public List<Monitoreable> getMonitoreables(){
        List<Monitoreable> listaMonitoreables = establecimientos.stream()
        .flatMap(sucursal -> sucursal.getMonitoreables().stream())
        .collect(Collectors.toList());
        return listaMonitoreables;
    }
}
