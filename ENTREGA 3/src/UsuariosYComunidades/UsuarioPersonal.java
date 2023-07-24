package UsuariosYComunidades;

import EntidadesYEstablecimientos.*;
import Servicios.*;
import Validador.Cuenta;

import java.util.List;

public class UsuarioPersonal extends UsuarioGeneral {
    private List<Membresia> membresias;
    private Localizacion localizacionAsociada;
    private List<Monitoreable> serviciosDeInteres;
    private List<HoraNotificacion> horariosNotificacion;
    private List<EmpresaPrestadora> empresasDeInteres;

    public UsuarioPersonal(String nombreUsuario, String apellidoUsuario, Cuenta cuentaUsuario, String correoElectronicoUsuario) {
        super(nombreUsuario, apellidoUsuario, cuentaUsuario, correoElectronicoUsuario);
    }

    public void modificar(Monitoreable unMonitoreable){
        //completar
    }
    public void eliminar(Monitoreable unMonitoreable){
        //elimina de la lista?
    }
    public void setLocalizacion(Localizacion unaLocalizacion){
        localizacionAsociada = unaLocalizacion;
    }
    public void agregarServicioDeInteres(Monitoreable unMonitoreable){
        serviciosDeInteres.add(unMonitoreable);
    }
    public Incidente registrarIncidente(Monitoreable unMonitoreable){
        //void?
        //para mi el metodo va sin el parametro del UsuarioPersonal ya que es solo para mandarselo al incidente
        return new Incidente(unMonitoreable, this);
    }
}
