package com.example.hibernate.dominio;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

public class ClaveCompuestaEstablecimientoEntidad implements Serializable {
    private Entidad id_entidad;
    private Establecimiento id_establecimiento;
}
