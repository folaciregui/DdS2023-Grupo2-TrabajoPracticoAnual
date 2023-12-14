package dominio.servicios;

import dominio.usuariosycomunidades.UsuarioGeneral;
import dominio.usuariosycomunidades.UsuarioPersonal;
import lombok.Getter;
import lombok.Setter;
import persistencia.converters.LocalDateAttributeConverter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "incidente")
@Getter
@Setter
public class Incidente implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "descripcion")
    private Motivo descripcion;

    @ManyToOne
    @JoinColumn(name = "creador_id", referencedColumnName = "id")
    private UsuarioGeneral usuarioCreador;
    // guardar el id en la sesion para cuando abre un incidente guardarlo aca

    @Transient
    private UsuarioGeneral usuarioCerrador;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private Estado estado;

    @Column(name = "observaciones")
    private String observaciones;


    @Column(name = "fecha_inicio")
    @Convert(converter = LocalDateAttributeConverter.class)
    private Date fechaInicio;


    @Column(name = "fecha_cierre")
    @Convert(converter = LocalDateAttributeConverter.class)
    private Date fechaCierre;

    @ManyToOne
    @JoinColumn(name = "servicio_id", referencedColumnName = "id")
    private Servicio servicio;

    @Transient
    private Integer cantPersonasAfectadas;

}
