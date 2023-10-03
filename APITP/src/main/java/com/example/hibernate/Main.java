package com.example.hibernate;

import com.example.hibernate.presentacion.*;
import io.javalin.Javalin;

public class Main {
    public static void main(String[] args) {
        Javalin app = Javalin.create()
                .get("/", ctx -> ctx.result("Hello World"))
                .start(4567);

        //Pruebas
        app.get("/api/usuarios", new GetUsuariosHandler());
        app.get("/api/incidentes", new GetIncidenteHandler());
        app.post("/api/incidentes", new PostIncidenteHandler());

        // Permite a los usuarios obtener su grado de confianza proporcionando su ID de usuario.
        app.get("/api/grado-de-confianza/{idUsuario}", new GetGradoDeConfianzaUsuarioHandler());

        // Permite a las comunidades obtener su grado de confianza proporcionando su ID de comunidad.
        app.get("/api/grado-de-confianza/{idComunidad}", new GetGradoDeConfianzaComunidadHandler());

        app.exception(IllegalArgumentException.class, (e, ctx)-> {
            ctx.status(400).result(e.getMessage());
        });

    }
}
