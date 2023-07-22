import java.time.LocalDateTime;
public class Indicente {
    private Motivo descripcion;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaCierre;
    private Monitoreable monitoreable;
    private String observaciones;
    private Estado estado;
    private Integer genteAfectada;
    private UsuarioPersonal creador;
    public Incidente(Monitoreable unMonitoreable, UsuarioPersonal unUsuario){
        this.monitoreable = unMonitoreable;
        this.creador = unUsuario;
        this.fechaInicio = LocalDateTime.now();
    }
    public void notificarComunidades(){
        //toDo no es requerimiento para la entrega3
        //no se si es necesario que este en esta clase el metodo
        // deberia mandar el incidente para que las comunidades lo guarden en su lista
        //un metodo que llama al metodo del usuario para avisar a cada membresia para que notifique a su respectiva comunidad
    }
    public Estado getEstado(){
        return this.estado;
    }

    public LocalDateTime getFechaInicio(){
        return this.fechaInicio;
    }

    public LocalDateTime getFechaCierre(){
        return this.fechaCierre;
    }
}
