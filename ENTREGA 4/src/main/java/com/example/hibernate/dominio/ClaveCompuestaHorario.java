package com.example.hibernate.dominio;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

public class ClaveCompuestaHorario implements Serializable {
    private UsuarioGeneral id_usuario;
    private HorarioNotificacion horario_particular;
}
