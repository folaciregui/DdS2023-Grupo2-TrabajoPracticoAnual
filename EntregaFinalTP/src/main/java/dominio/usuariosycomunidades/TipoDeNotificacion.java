package dominio.usuariosycomunidades;

import javax.persistence.*;
import java.util.Objects;


public class TipoDeNotificacion {
    private String tipo;
    private NotificacionCorreoElectronico tipo1 = new NotificacionCorreoElectronico();
    private NotificacionWhatsApp tipo2 = new NotificacionWhatsApp();
    
    public void enviarNotif(){
        if(Objects.equals(tipo, "correoElectronico")){
            tipo1.enviarNotif();
        }else{
            tipo2.enviarNotif();
        }

    }
}
