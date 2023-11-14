package com.example.hibernate;

import io.javalin.Javalin;
import io.javalin.plugin.hibernate.HibernatePlugin;

import controllers.EntidadController;
import controllers.EstablecimientoController;
import controllers.ServicioController;

public class Main {
    public static void main(String[] args) {
        // Configurar Javalin
        Javalin app = Javalin.create(config -> {
            config.registerPlugin(new HibernatePlugin(ConfigHibernate::new));
        }).start(7000);

        // Rutas
        app.get("/api/entidades", EntidadController::getEntidades);
        app.get("/api/entidades/:entidadId/establecimientos", EstablecimientoController::getEstablecimientos);
        app.get("/api/establecimientos/:establecimientoId/servicios", ServicioController::getServicios);

        // Otros controladores y rutas...

        // Detener la aplicación al cerrar
        app.events(event -> event.serverStopping(ConfigHibernate::closeSessionFactory));
    }
}
