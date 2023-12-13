package com.example.hibernate;

import io.javalin.Javalin;
import com.example.hibernate.controllers.GetEntidadesHandler;
import com.example.hibernate.controllers.GetEstablecimientosHandler;
import com.example.hibernate.controllers.GetServiciosHandler;
import com.example.hibernate.dominio.Incidente;


public class Main {
    public static void main(String[] args) {
        try {
            // Configurar Javalin
            Javalin app = Javalin.create()
                    .get("/", ctx -> ctx.result("Hello World"))
                    .start(3000);
            System.out.println("Servidor Javalin iniciado correctamente en el puerto 3000 antes de los get");
            // Rutas
            app.get("/api/entidades", new GetEntidadesHandler());
            app.get("/api/entidades/:entidadId/establecimientos", new GetEstablecimientosHandler());
            app.get("/api/establecimientos/:establecimientoId/servicios", new GetServiciosHandler());
            app.get("/api/obtenerIncidente", new ObtenerIncidenteHandler());
            app.get("/api/entidades/:entidadId/establecimientos", ctx -> {
                // Obtener el parámetro de la URL (entidadId)
                String entidadId = ctx.pathParam("entidadId");
                // Lógica para obtener los establecimientos de la entidad con ID entidadId
                // ...

            });

            System.out.println("Servidor Javalin iniciado correctamente en el puerto 3000");
        } catch (Exception e) {
            // Si hay algún error al iniciar el servidor, imprime un mensaje de error
            e.printStackTrace();
            System.err.println("Error al iniciar el servidor Javalin: " + e.getMessage());
        }
    }
}
