package dominio.usuariosycomunidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dominio.entidades.EmpPrest_X_OrgControl;
import dominio.validador.Cuenta;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "usuario_general")
@Getter
@Setter
public class UsuarioGeneral {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "email")
    private String email;

    @JsonIgnore
    @OneToOne(mappedBy = "usuarioGeneral", cascade = CascadeType.ALL)
    private Cuenta cuenta;

    @Column(name = "horario_de_notificacion", columnDefinition = "TIME")
    private LocalTime horarioDeNotificacion;

    @Transient
    private TipoDeNotificacion tipoDeNotificacion;

    @Transient
    private FrecuenciaNotificacion frecuenciaNotificacion;

    @Transient
    private EmpPrest_X_OrgControl empresaDeInteres;


}
