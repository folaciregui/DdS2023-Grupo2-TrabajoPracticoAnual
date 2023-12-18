package dominio.entidades;

import dominio.rankings.RankingsIncidente;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "entidad")
@Getter
@Setter
public class Entidad {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "empresa_prestadora_id", referencedColumnName = "id")
    private EmpresaPrestadora empresaPrestadora;

    @ManyToOne
    @JoinColumn(name = "organismo_control_id", referencedColumnName = "id")
    private OrganismoDeControl organismoDeControl;

    /*@ManyToOne
    @JoinColumn(name = "empresa_prestadora_id", referencedColumnName = "id")
    private EmpPrest_X_OrgControl empresaPrestadora_;

    @ManyToOne
    @JoinColumn(name = "organismo_control_id", referencedColumnName = "id")
    private EmpPrest_X_OrgControl organismoDeControl_;*/

    //@OneToMany(mappedBy = "entidad")
    //private List<RankingsIncidente> rankingsSemanales;

    //@Column(name = "medio_de_transporte")
    //private String medioDeTransporte;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_entidad")
    private TipoDeEntidad tipoDeEntidad;

    //@OneToMany(mappedBy = "entidad")
    //private List<Entidad_X_Establecimiento> relacionEstablecimientos;


}
