package com.example.hibernate.dominio;

import javax.persistence.*;
import java.sql.Time;

@Entity
public class HorarioNotificacion {
    public Time getHorarioNotificacion() {
        return horarioNotificacion;
    }

    public void setHorarioNotificacion(Time horarioNotificacion) {
        this.horarioNotificacion = horarioNotificacion;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_horarioNotificacion;

    @Column(name="horarioNotificacion")
    private Time horarioNotificacion;

    public void setId_horarioNotificacion(Long idHorarioNotificacion) {
        this.id_horarioNotificacion = idHorarioNotificacion;
    }

    public Long getId_horarioNotificacion() {
        return id_horarioNotificacion;
    }
}
