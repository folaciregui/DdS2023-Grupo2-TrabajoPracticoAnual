package dominio.entidades;

import dominio.usuariosycomunidades.UsuarioEmpresarial;
import dominio.usuariosycomunidades.UsuarioPersonal;
import lombok.Cleanup;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "empresa_prestadora")
@Getter
@Setter
public class EmpresaPrestadora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "cuit")
    private String cuit;

    @Transient
    private UsuarioEmpresarial personaACargo;

    @Transient
    private Entidad entidad;

    @Transient
    private List<UsuarioPersonal> usuariosInteresados;
}
