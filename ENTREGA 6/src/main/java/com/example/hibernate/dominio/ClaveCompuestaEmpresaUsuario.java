package com.example.hibernate.dominio;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

public class ClaveCompuestaEmpresaUsuario implements Serializable {
    private UsuarioGeneral usuarioGeneral;
    private Organizacion empresaPrestadora;
}
