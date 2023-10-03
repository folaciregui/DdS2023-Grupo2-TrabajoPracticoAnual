package com.example.hibernate.presentacion;

import com.example.hibernate.persistencia.RepoIncidentes;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;
public class GetIncidenteHandler implements Handler{

    private final RepoIncidentes repoIncidentes;

    public GetIncidenteHandler() {
        this.repoIncidentes = new RepoIncidentes();
    }

    @Override
    public void handle(@NotNull Context context) throws Exception {
        context.json(repoIncidentes.obtenerTodos());
    }


}
