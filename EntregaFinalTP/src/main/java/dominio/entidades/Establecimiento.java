package dominio.entidades;

import dominio.servicios.Monitoreable;
import dominio.servicios.TipoDeEstablecimiento;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "establecimiento")
public class Establecimiento {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Embedded
    private Ubicacion ubicacion;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_establecimiento")
    private TipoDeEstablecimiento tipoDeEstablecimiento;

    @Transient
    private List<Monitoreable> monitoreables;

    @Transient
    private Localizacion localizacion;
}
