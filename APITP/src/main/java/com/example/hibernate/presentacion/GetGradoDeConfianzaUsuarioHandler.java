package com.example.hibernate.presentacion;

import com.example.hibernate.dominio.Usuario;
import com.example.hibernate.persistencia.RepoUsuarios;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.openapi.HttpMethod;
import io.javalin.openapi.OpenApi;
import io.javalin.openapi.OpenApiParam;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class GetGradoDeConfianzaUsuarioHandler implements Handler{

    private final RepoUsuarios repoUsuarios;

    public GetGradoDeConfianzaUsuarioHandler(){this.repoUsuarios = new RepoUsuarios();}

    @OpenApi(
            path = "/api/grado-de-confianza/{idUsuario}",
            methods = {HttpMethod.GET},
            pathParams = @OpenApiParam(name = "idUsuario", description = "ID usuario a buscar", required = true, type = Integer.class)
    )

    @Override
    public void handle(@NotNull Context context) throws Exception {
        Integer idBuscado = context.pathParamAsClass("idUsuario", Integer.class).get();

        context.json(repoUsuarios.obtenerGradoDeConfianzaPorUsuario(idBuscado));

        /*
        final Optional<Usuario> resultadoUsuarios = repoUsuarios.obtenerTodosLosUsuarios().stream()
                .filter(m -> m.getId() == idBuscado)
                .findFirst();
        if (((Optional<?>) resultadoUsuarios).isPresent()) {
            context.status(200).json(resultadoUsuarios.get());
        } else {
            context.status(404);
        }*/
    }

}
