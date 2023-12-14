package dominio.entidades;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "entidad_x_establecimiento")
@Getter
@Setter
public class Entidad_X_Establecimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "entidad_id", referencedColumnName = "id")
    private Entidad entidad;

    @ManyToOne
    @JoinColumn(name = "establecimiento_id", referencedColumnName = "id")
    private Establecimiento establecimiento;
}
