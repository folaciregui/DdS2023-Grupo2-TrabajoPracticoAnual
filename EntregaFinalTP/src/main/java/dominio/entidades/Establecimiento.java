package dominio.entidades;

import dominio.servicios.Monitoreable;
import dominio.servicios.TipoDeEstablecimiento;
import lombok.Getter;
import lombok.Setter;
import persistencia.converters.BigDecimalAttributeConverter;
import persistencia.converters.LocalDateAttributeConverter;

import javax.persistence.*;
import java.math.BigDecimal;
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

    /*@Embedded
    @Convert(converter = BigDecimalAttributeConverter.class)
    private Ubicacion ubicacion;*/

    @Column(name = "latitud")
    @Convert(converter = BigDecimalAttributeConverter.class)
    private BigDecimal latitud;

    @Column(name = "altitud")
    @Convert(converter = BigDecimalAttributeConverter.class)
    private BigDecimal altitud;

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
