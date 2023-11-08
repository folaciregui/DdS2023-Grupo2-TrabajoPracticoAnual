package com.example.hibernate.dominio;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

@Entity
@IdClass(ClaveCompuestaHorario.class)
public class Horario_Usuario {

    public UsuarioGeneral getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(UsuarioGeneral id_usuario) {
        this.id_usuario = id_usuario;
    }

    public HorarioNotificacion getHorario_particular() {
        return horario_particular;
    }

    public void setHorario_particular(HorarioNotificacion horario_particular) {
        this.horario_particular = horario_particular;
    }

    @Id
    @ManyToOne
    private UsuarioGeneral id_usuario;

    @Id
    @ManyToOne
    private HorarioNotificacion horario_particular;
}
