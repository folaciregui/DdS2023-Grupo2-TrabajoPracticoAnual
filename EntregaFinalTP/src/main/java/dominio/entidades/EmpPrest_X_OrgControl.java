package dominio.entidades;


import dominio.usuariosycomunidades.UsuarioGeneral;

import javax.persistence.*;

@Entity
@Table(name = "empprest_x_orgcontrol")
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
