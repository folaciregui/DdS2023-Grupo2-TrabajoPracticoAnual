package dominio.servicios;


import javax.persistence.*;

@Entity
@Table(name = "tramo")
public class Tramo {

    @Id
    @GeneratedValue
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "parte_inicial")
    private TipoTramo parteInicial;

    @Enumerated(EnumType.STRING)
    @Column(name = "parte_final")
    private TipoTramo parteFinal;
}
