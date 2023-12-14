package dominio.entidades;

import dominio.servicios.Monitoreable;
import dominio.servicios.TipoDeEstablecimiento;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "establecimiento")
@Getter
@Setter
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

    //@OneToMany(mappedBy = "establecimiento")
    //private List<Entidad_X_Establecimiento> relacionEntidades;

    @Transient
    private List<Monitoreable> monitoreables;

    @Transient
    private Localizacion localizacion;
}
