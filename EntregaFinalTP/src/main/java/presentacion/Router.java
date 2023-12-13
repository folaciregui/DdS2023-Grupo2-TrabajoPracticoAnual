package presentacion;

import presentacion.controllers.*;

public class Router {

    public static void init() {
        /*Server.app().get("/", ctx -> {
            ctx.sessionAttribute("item1", "Cosa 1");
            ctx.result("Hola mundo");
        });
        Server.app().get("/saluda", ctx -> {
            ctx.result("Hola "
                    + ctx.queryParam("nombre")
                    + ", " + ctx.sessionAttribute("item1")
            );
        });
        Server.app().get("/saludo-para/{nombre}", ctx -> ctx.result("Hola "
                + ctx.pathParam("nombre")
        ));*/

        Server.app().get("/paginaInicio", ctx -> {ctx.render("inicio.hbs");});

        Server.app().get("/inicioSesion", ctx -> {
            // Lógica para manejar la ruta /inicioSesion
            ctx.render("inicioSesion.hbs");
        });
        Server.app().get("/registro", ctx -> {
            ctx.render("registro.hbs");
        });

        Server.app().post("/login", ((LoginController) FactoryController.controller("Login"))::login);
        Server.app().post("/iniciarSesion", ((InicioSesionController) FactoryController.controller("IniciarSesion"))::validarUsuario);

        Server.app().get("/menu", ctx -> {ctx.render("menu.hbs");});

        Server.app().get("/cargarDatosEntidades", ctx -> {ctx.render("cargarDatosEntidades.hbs");});
        Server.app().post("/cargarDatosEntidades", ((EntidadesController) FactoryController.controller("Entidades"))::cargarEntidades);
        //Server.app().get("/exitoso", ctx -> {ctx.render("cargarDatosEntidadesExitoso.hbs");});

        Server.app().get("/consultaIncidentesPorEstado", ctx -> {ctx.render("consultaIncidentes.hbs");});

        Server.app().post("/filtrarIncidentes", ((IncidentesController) FactoryController.controller("Incidentes"))::filtrarIncidentes);

        Server.app().get("/incidentes", ctx -> {ctx.render("incidentes.hbs");});

        Server.app().get("/rankings", ctx -> {ctx.render("rankings.hbs");});
        Server.app().post("/rankingsFiltrados", ((RankingsController) FactoryController.controller("Rankings"))::filtrarRankings);
        Server.app().get("/rankingsFiltrados", ctx -> {ctx.render("rankingsFiltrados.hbs");});

        Server.app().get("/miCuenta", ctx -> {ctx.render("miCuenta.hbs");});
        /*
        Server.app().get("entidades", ((EntidadesController) FactoryController.controller("Entidades"))::index);

        Server.app().routes(() -> {
            get("entidades", ((EntidadesController) FactoryController.controller("Entidades"))::index);
            //get("servicios/crear", ((ServiciosController) FactoryController.controller("Servicios"))::create, TipoRol.ADMINISTRADOR);
            //get("servicios/{id}", ((ServiciosController) FactoryController.controller("Servicios"))::show);
            //get("servicios/{id}/editar", ((ServiciosController) FactoryController.controller("Servicios"))::edit);
            //post("servicios/{id}", ((ServiciosController) FactoryController.controller("Servicios"))::update);
            //post("servicios", ((ServiciosController) FactoryController.controller("Servicios"))::save);
            //delete("servicios/{id}", ((ServiciosController) FactoryController.controller("Servicios"))::delete);

            /*
            path("servicios/{id}/tareas", () -> {
                get(((TareasController) FactoryController.controller("Tareas"))::index);
                //TODO
            });*/
        //});
    }
}