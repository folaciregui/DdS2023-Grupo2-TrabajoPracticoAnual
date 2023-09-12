package com.example.hibernate.dominio;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

public class ClaveCompuestaIncidente implements Serializable {
    private Comunidad id_comunidad;
    private Incidente id_incidente;
}
