package com.example.hibernate;

import io.javalin.Javalin;
import io.javalin.plugin.hibernate.HibernatePlugin;

import controllers.EntidadController;
import controllers.EstablecimientoController;
import controllers.ServicioController;

public class Main {
    public static void main(String[] args) {
        try {
            // Configurar Javalin
            Javalin app = Javalin.create(config -> {
                config.registerPlugin(new HibernatePlugin(ConfigHibernate::new));
            }).start(3000);
            System.out.println("Servidor Javalin iniciado correctamente en el puerto 3000 antes de los get");
            // Rutas
            alert("JAVALIN CREADO");
            app.get("/api/entidades", EntidadController::getEntidades);
            app.get("/api/entidades/:entidadId/establecimientos", EstablecimientoController::getEstablecimientos);
            app.get("/api/establecimientos/:establecimientoId/servicios", ServicioController::getServicios);
            app.get("/api/entidades/:entidadId/establecimientos", ctx -> {
                // Obtener el parámetro de la URL (entidadId)
                String entidadId = ctx.pathParam("entidadId");
                
                // Lógica para obtener los establecimientos de la entidad con ID entidadId
                // ...
            
                // Devolver la lista de establecimientos como JSON
                ctx.json(listaDeEstablecimientos);
            });
            

            // Detener la aplicación al cerrar
            //app.events(event -> event.serverStopping(ConfigHibernate::closeSessionFactory));

            // Mensaje de registro indicando que el servidor se inició correctamente
            System.out.println("Servidor Javalin iniciado correctamente en el puerto 3000");
        } catch (Exception e) {
            // Si hay algún error al iniciar el servidor, imprime un mensaje de error
            e.printStackTrace();
            System.err.println("Error al iniciar el servidor Javalin: " + e.getMessage());
        }
    }
}
