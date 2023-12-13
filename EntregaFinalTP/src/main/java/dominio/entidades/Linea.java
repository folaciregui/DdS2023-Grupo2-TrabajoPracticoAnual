package dominio.entidades;

import java.util.List;
public class Linea extends Entidad {
    private TipoDeMedio medioDeTransporte;
    private Estacion origen;
    private Estacion destino;
    private List<Estacion> establecimientos;

}
