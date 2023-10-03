package com.example.hibernate.presentacion;

import com.example.hibernate.dominio.Incidente;
import com.example.hibernate.persistencia.RepoIncidentes;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class PostIncidenteHandler implements Handler{

    private final RepoIncidentes repoIncidentes;

    public PostIncidenteHandler() {
        this.repoIncidentes = new RepoIncidentes();
    }

    @Override
    public void handle(@NotNull Context context) throws Exception {
        String bodyString = context.body();
        Incidente incidente = context.bodyAsClass(Incidente.class);
        System.out.println("Creando incidente: " + bodyString);
        System.out.println(incidente);
        validarNuevoincidente(incidente);
        context.status(201);
    }

    private void validarNuevoincidente(Incidente incidente) {
        if (incidente.getId() == -1) {
            throw new IllegalArgumentException("Error en el ingreso del ID.");
        }
    }

}
