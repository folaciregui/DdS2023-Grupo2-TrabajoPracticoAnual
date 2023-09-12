package com.example.hibernate.dominio;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import java.security.Identity;

@Entity
@IdClass(ClaveCompuestaEmpresaUsuario.class)
public class EmpresaPrestadora_UsuarioGeneral {

    public UsuarioGeneral getUsuarioGeneral() {
        return usuarioGeneral;
    }

    public void setUsuarioGeneral(UsuarioGeneral usuarioGeneral) {
        this.usuarioGeneral = usuarioGeneral;
    }

    public Organizacion getEmpresaPrestadora() {
        return empresaPrestadora;
    }

    public void setEmpresaPrestadora(Organizacion empresaPrestadora) {
        this.empresaPrestadora = empresaPrestadora;
    }

    @Id
    @ManyToOne
    private UsuarioGeneral usuarioGeneral;

    @Id
    @ManyToOne
    private Organizacion empresaPrestadora;

}
