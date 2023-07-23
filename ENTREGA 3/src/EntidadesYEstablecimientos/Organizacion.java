package EntidadesYEstablecimientos;

import Servicios.Monitoreable;

import java.util.List;
import java.util.stream.Collectors;

public class Organizacion extends Entidad{
    private List<Sucursal> establecimientos;

    @Override
    public List<Monitoreable> getMonitoreables(){
        List<Monitoreable> listaMonitoreables = establecimientos.stream()
        .flatMap(sucursal -> sucursal.getMonitoreables().stream())
        .collect(Collectors.toList());
        return listaMonitoreables;
    }
}
