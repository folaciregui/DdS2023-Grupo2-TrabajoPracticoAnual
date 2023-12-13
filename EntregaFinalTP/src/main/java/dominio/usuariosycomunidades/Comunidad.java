package dominio.usuariosycomunidades;

import dominio.servicios.Incidente;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "comunidad")
public class Comunidad {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Transient
    private List<Membresia> miembros;

    @Transient
    private List<Incidente> incidentesNotificables;
}
