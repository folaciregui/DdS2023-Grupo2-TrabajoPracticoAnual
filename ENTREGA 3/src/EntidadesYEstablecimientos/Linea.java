package EntidadesYEstablecimientos;

import java.util.List;

public class Linea extends Entidad{
    private String nombre;
    private MedioDeTransporte medioDeTransporte;
    private Estacion estacionDeOrigen;
    private Estacion estacionDeDestino;
    private List<Estacion> establecimientos;

    @Override
    public List<Monitoreable> getMonitoreables(){
        List<Monitoreable> listaMonitoreables = establecimientos.stream()
        .flatMap(estacion -> estacion.getMonitoreables().stream())
        .collect(Collectors.toList());
        return listaMonitoreables;
    }
}
