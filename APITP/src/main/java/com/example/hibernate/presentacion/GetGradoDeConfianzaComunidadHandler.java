package com.example.hibernate.presentacion;

import com.example.hibernate.persistencia.RepoComunidades;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.openapi.HttpMethod;
import io.javalin.openapi.OpenApi;
import io.javalin.openapi.OpenApiParam;
import org.jetbrains.annotations.NotNull;

public class GetGradoDeConfianzaComunidadHandler implements Handler{

    private final RepoComunidades repoComunidades;

    public GetGradoDeConfianzaComunidadHandler(){this.repoComunidades = new RepoComunidades();}

    @OpenApi(
            path = "/api/grado-de-confianza/{idComunidad}",
            methods = {HttpMethod.GET},
            pathParams = @OpenApiParam(name = "idComunidad", description = "ID comunidad a buscar", required = true, type = Integer.class)
    )

    @Override
    public void handle(@NotNull Context context) throws Exception {
        Integer idBuscado = context.pathParamAsClass("idComunidad", Integer.class).get();

        context.json(repoComunidades.obtenerGradoDeConfianzaPorComunidad(idBuscado));

    }

}
