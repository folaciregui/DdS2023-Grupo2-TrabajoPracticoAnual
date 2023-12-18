package dominio.usuariosycomunidades;

import dominio.entidades.EmpresaPrestadora;
import dominio.entidades.Localizacion;
import dominio.servicios.Incidente;
import dominio.servicios.Monitoreable;

import java.util.List;

public class UsuarioPersonal extends UsuarioGeneral{
    private List<Membresia> membresias;
    private Localizacion localizacion;
    private List<Monitoreable> serviciosDeInteres;
    private List<Horario> horariosNotificacion;
    private List<EmpresaPrestadora> empresasDeInteres;
    private List<Incidente> incidentes;

}
