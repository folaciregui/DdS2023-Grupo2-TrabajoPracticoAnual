package com.example.hibernate.controllers;
import com.example.hibernate.persistencia.RepositorioEntidades;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;
import java.util.List;

public class GetEntidadesHandler implements Handler {
    private final RepositorioEntidades repoEntidades;

    public GetEntidadesHandler() {
        this.repoEntidades = new RepositorioEntidades();
    }

    @Override
    public void handle(@NotNull Context context) throws Exception {
        context.json(repoEntidades.obtenerTodas());
    }
}

