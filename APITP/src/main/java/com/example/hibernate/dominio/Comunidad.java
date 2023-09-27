package com.example.hibernate.dominio;

import java.util.List;

public class Comunidad{
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public NivelConfianza getNivelConfianza() {
        return nivelConfianza;
    }

    public void setNivelConfianza(NivelConfianza nivelConfianza) {
        this.nivelConfianza = nivelConfianza;
    }

    private int id;

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    private List<Usuario> usuarios;
    private NivelConfianza nivelConfianza;
    public void actualizar_puntos(double puntos){
        nivelConfianza.calcularpuntos(puntos);
    }
}
