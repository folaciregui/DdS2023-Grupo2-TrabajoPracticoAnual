package com.example.hibernate.dominio;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

public class ClaveCompuestaEstablecimientoEntidad implements Serializable {
    private Long id_entidad;
    private Long id_establecimiento;

}
