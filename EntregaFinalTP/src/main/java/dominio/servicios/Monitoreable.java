package dominio.servicios;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;


public class Monitoreable {
    private String nombre;
    private Disponibilidad estado;
    private List<Incidente> incidentesActivos;
    private List<Incidente> incidentesInactivos;
}
