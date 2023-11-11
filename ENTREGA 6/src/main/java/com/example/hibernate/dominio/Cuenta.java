package com.example.hibernate.dominio;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name="usuarioGeneral")
    private UsuarioGeneral usuarioGeneral;

    @Column
    private String nombre_identificador;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre_identificador() {
        return nombre_identificador;
    }

    public void setNombre_identificador(String nombre_identificador) {
        this.nombre_identificador = nombre_identificador;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Column
    private String apellido;

    @Column
    private String usuario;
}
