package dominio.servicios;


import dominio.usuariosycomunidades.Comunidad;

import javax.persistence.*;

@Entity
@Table(name = "incidentes_notificables")
public class IncidentesNotificables {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "incidente_id", referencedColumnName = "id")
    private Incidente incidente;

    @ManyToOne
    @JoinColumn(name = "comunidad_id", referencedColumnName = "id")
    private Comunidad comunidad;

}
