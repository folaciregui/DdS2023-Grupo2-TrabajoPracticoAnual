package dominio.usuariosycomunidades;

import dominio.servicios.Incidente;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "comunidad")
@Getter
@Setter
public class Comunidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Transient
    private List<Membresia> miembros;

    @Transient
    private List<Incidente> incidentesNotificables;
}
