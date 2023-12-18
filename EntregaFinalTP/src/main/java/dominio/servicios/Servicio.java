package dominio.servicios;


import dominio.entidades.Establecimiento;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "servicio")
@Getter
@Setter
public class Servicio extends Monitoreable{

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "descripcion")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "tramo", referencedColumnName = "id")
    private Tramo tramo;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_de_servicio")
    private TipoDeServicio tipoDeServicio;

    @Enumerated(EnumType.STRING)
    @Column(name = "categoria")
    private Categoria categoriaDeServicio;

    @ManyToOne
    @JoinColumn(name = "establecimiento_id", referencedColumnName = "id")
    private Establecimiento establecimiento;
}
