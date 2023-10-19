package com.example.hibernate.dominio;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

public class ClaveCompuestaMembresia implements Serializable {
    private Comunidad id_comunidad;
    private UsuarioGeneral id_usuario_general;
}
