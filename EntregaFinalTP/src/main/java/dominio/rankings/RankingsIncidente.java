package dominio.rankings;

import dominio.entidades.Entidad;
import lombok.Getter;
import lombok.Setter;
import persistencia.converters.LocalDateAttributeConverter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "rankings")
@Getter
@Setter
public class RankingsIncidente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "entidad_id", referencedColumnName = "id")
    private Entidad entidad;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_ranking")
    private TipoDeRanking tipoDeRanking;

    @Column(name = "posicion")
    private Integer posicion;

    @Convert(converter = LocalDateAttributeConverter.class)
    @Column(name = "fecha_ranking")
    private LocalDate fecha;
}
