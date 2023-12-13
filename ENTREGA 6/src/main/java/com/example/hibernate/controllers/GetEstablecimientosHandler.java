package com.example.hibernate.controllers;
import com.example.hibernate.persistencia.RepositorioEstablecimientos;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class GetEstablecimientosHandler implements Handler {
    private final RepositorioEstablecimientos repoEstablecimientos;

    public GetEstablecimientosHandler() {
        this.repoEstablecimientos = new RepositorioEstablecimientos();
    }

    @Override
    public void handle(@NotNull Context context) throws Exception {
        context.json(repoEstablecimientos.obtenerTodas());
    }
}
