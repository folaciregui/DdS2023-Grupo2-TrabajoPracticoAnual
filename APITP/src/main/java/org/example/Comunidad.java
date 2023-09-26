package org.example;

import java.util.List;

public class Comunidad{
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
