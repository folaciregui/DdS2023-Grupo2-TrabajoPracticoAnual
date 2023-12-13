package com.example.hibernate.controllers;
import com.example.hibernate.persistencia.RepositorioServicios;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class GetServiciosHandler implements Handler {
    private final RepositorioServicios repoServicios;

    public GetServiciosHandler() {
        this.repoServicios = new RepositorioServicios();
    }

    @Override
    public void handle(@NotNull Context context) throws Exception {
        context.json(repoServicios.obtenerTodas());
    }
}
