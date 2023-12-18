package dominio.entidades;


import dominio.usuariosycomunidades.UsuarioGeneral;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "empprest_x_orgcontrol")
@Getter
@Setter
public class EmpPrest_X_OrgControl {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "tipo")
    private TipoDeOrganizacion tipoDeOrganizacion;

    @Column(name = "nombre")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "persona_a_cargo_id", referencedColumnName = "id")
    private UsuarioGeneral personaACargo;
}
