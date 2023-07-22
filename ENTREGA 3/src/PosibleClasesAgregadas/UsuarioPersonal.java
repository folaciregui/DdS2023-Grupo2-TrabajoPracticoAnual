import java.nio.charset.UnmappableCharacterException;

public class UsuarioPersonal extends UsuarioGeneral {
    private List<Membresia> membresias;
    private Localizacion localizacionAsociada;
    private List<Monitoreable> serviciosDeInteres;
    private List<HoraNotificacion> horariosNotificacion;
    private List<EmpresaPrestadora> empresasDeInteres;

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
    public void registrarIncidente(Monitoreable unMonitoreable, UsuarioPersonal unUsuario){
        //void?
        //para mi el metodo va sin el parametro del UsuarioPersonal ya que es solo para mandarselo al incidente
        Incidente unIncidente = new Incidente(unMonitoreable, this);
    }
}
