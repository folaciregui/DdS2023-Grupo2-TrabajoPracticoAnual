package dominio.entidades;

import dominio.usuariosycomunidades.UsuarioEmpresarial;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "organismo_control")
@Getter
@Setter
public class OrganismoDeControl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "cuit")
    private String cuit;

    @Transient
    private UsuarioEmpresarial personaACargo;
}
