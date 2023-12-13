package dominio.servicios;


import dominio.entidades.Entidad;
import dominio.entidades.Establecimiento;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name = "entidad_X_establecimiento")
public class Entidad_X_Establecimiento {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "establecimiento_id", referencedColumnName = "id")
    private Establecimiento establecimiento;

    @ManyToOne
    @JoinColumn(name = "entidad_id", referencedColumnName = "id")
    private Entidad entidad;
}
