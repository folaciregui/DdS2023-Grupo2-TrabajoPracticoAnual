package dominio.servicios;


import dominio.usuariosycomunidades.Comunidad;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "incidentes_notificables")
@Getter
@Setter
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
