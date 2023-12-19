package dominio.validador;

import dominio.usuariosycomunidades.UsuarioGeneral;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "cuenta")
@Getter
@Setter
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "usuario_general_id", referencedColumnName = "id", unique = true)
    private UsuarioGeneral usuarioGeneral;

    @Column(name = "nombre_identificador")
    private String nombre;

    @Column(name = "contrasenia")
    private String contrasenia;

}
