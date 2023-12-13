package dominio.usuariosycomunidades;


import javax.persistence.*;

@Entity
@Table(name = "membresia")
public class Membresia {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private UsuarioGeneral usuario;

    @ManyToOne
    @JoinColumn(name = "comunidad_id", referencedColumnName = "id")
    private Comunidad comunidad;

    @Enumerated(EnumType.STRING)
    @Column(name = "rol_de_permiso")
    private RolDePermiso rolDePermiso;

    @Enumerated(EnumType.STRING)
    @Column(name = "rol_de_impacto")
    private RolDeImpacto rolDeImpacto;
}
