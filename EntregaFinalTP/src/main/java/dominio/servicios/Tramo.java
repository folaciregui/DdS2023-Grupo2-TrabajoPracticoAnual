package dominio.servicios;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tramo")
@Getter
@Setter
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
