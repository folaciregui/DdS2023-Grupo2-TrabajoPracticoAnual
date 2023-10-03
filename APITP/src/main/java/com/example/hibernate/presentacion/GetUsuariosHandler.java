package com.example.hibernate.presentacion;

import com.example.hibernate.persistencia.RepoIncidentes;
import com.example.hibernate.persistencia.RepoUsuarios;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class GetUsuariosHandler implements Handler{

    private final RepoUsuarios repoUsuarios;

    public GetUsuariosHandler() {
        this.repoUsuarios = new RepoUsuarios();
    }

    @Override
    public void handle(@NotNull Context context) throws Exception {
        context.json(repoUsuarios.obtenerTodosLosUsuarios());
    }
}
