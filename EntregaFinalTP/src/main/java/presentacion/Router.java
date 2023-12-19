package presentacion;

import presentacion.controllers.*;
import presentacion.handlers.*;

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

        Server.app().get("/prueba", ctx ->{ctx.render("prueba.hbs");});

        // CLIENTE LIVIANO
        Server.app().get("/paginaInicio", ctx -> {ctx.render("inicio.hbs");});

        Server.app().get("/inicioSesion", ctx -> {
            // Lógica para manejar la ruta /inicioSesion
            ctx.render("inicioSesion.hbs");
        });

        Server.app().get("/registro", ctx -> {ctx.render("registro.hbs");});
        Server.app().post("/login", ((LoginController) FactoryController.controller("Login"))::login);

        Server.app().post("/iniciarSesion", ((InicioSesionController) FactoryController.controller("IniciarSesion"))::validarUsuario);

        Server.app().get("/menu", ctx -> {ctx.render("menu.hbs");});

        Server.app().get("/cargarDatosEntidades", ctx -> {ctx.render("cargarDatosEntidades.hbs");});
        Server.app().post("/cargarDatosEntidades", ((EntidadesController) FactoryController.controller("Entidades"))::cargarEntidades);
        //Server.app().get("/exitoso", ctx -> {ctx.render("cargarDatosEntidadesExitoso.hbs");});

        Server.app().get("/consultaIncidentesPorEstado", ctx -> {ctx.render("consultaIncidentes.hbs");});

        Server.app().post("/filtrarIncidentes", ((IncidentesController) FactoryController.controller("Incidentes"))::filtrarIncidentes);

        Server.app().get("/incidentes", ctx -> {ctx.render("incidentes.hbs");});

        Server.app().get("/rankingsCL", ctx -> {ctx.render("rankingsCL.hbs");});
        Server.app().post("/rankingsFiltrados", ((RankingsController) FactoryController.controller("Rankings"))::filtrarRankings);
        Server.app().get("/rankingsFiltrados", ctx -> {ctx.render("rankingsFiltrados.hbs");});

        Server.app().post("/miCuentaDatos", ((MiCuentaController) FactoryController.controller("MiCuenta"))::obtenerDatosCuenta);
        Server.app().get("/miCuentaDatos", ctx -> {ctx.render("miCuentaDatos.hbs");});

        Server.app().get("/miCuentaCL", ctx -> {ctx.render("miCuentaCL.hbs");});
        Server.app().get("/miCuentaCP", ctx -> {ctx.render("miCuentaCP.hbs");});

        Server.app().get("/editarPerfil", ctx -> {ctx.render("editarPerfil.hbs");});
        Server.app().post("/editarPerfil", ((MiCuentaController) FactoryController.controller("MiCuenta"))::editarPerfil);

        Server.app().get("/comunidadesPorUsuario", ctx -> {ctx.render("comunidadesPorUsuario.hbs");});
        Server.app().post("/comunidadesPorUsuario", ((MembresiasController) FactoryController.controller("Membresias"))::comunidadesPorUsuario);
        Server.app().post("/comunidadesPorUsuarioEditado", ((MembresiasController) FactoryController.controller("Membresias"))::cambiarRol);

        //app.get("/api/entidades", new GetEntidadesHandler());
        //app.get("/api/entidades/:entidadId/establecimientos", new GetEstablecimientosHandler());
        //app.get("/api/establecimientos/:establecimientoId/servicios", new GetServiciosHandler());

        // CLIENTE PESADO
        Server.app().get("abrirIncidente", ctx ->{ctx.render("abrirIncidente.hbs");});
        Server.app().get("/api/obtenerRoles", new GetMembresiasHandler());
        Server.app().post("/api/incidentes", new PostIncidenteHandler());

        Server.app().get("/api/incidentesFiltrados/{entidadId}/{establecimientoId}", new GetIncidentesHandler());

        Server.app().get("/cerrarIncidente", ctx ->{ctx.render("cerrarIncidente.hbs");});
        Server.app().put("/api/incidentes/{incidenteId}", new PutIncidentesHandler());

        Server.app().get("/api/entidades", new GetEntidadesHandler());
        Server.app().get("/api/entidades/{entidadId}/establecimientos", new GetEstablecimientosHandler());
        Server.app().get("/api/establecimientos/{establecimientoId}/servicios", new GetServiciosHandler());
        Server.app().get("/api/servicios", new GetServiciosHandler());

        Server.app().get("/sugerenciaIncidente", ctx -> {ctx.render("sugerenciaIncidente.hbs");});
        Server.app().get("/sugerenciaPorRol", ctx -> {ctx.render("sugerenciaPorRol.hbs");});
        Server.app().get("/api/incidentesPorRolImpacto/{usuarioId}/{rol}", new GetIncidentesPorRolImpactoHandler());
        Server.app().get("/sugerenciaPorNotificables", ctx -> {ctx.render("sugerenciaPorNotificables.hbs");});
        Server.app().get("/api/incidentesPorComunidadAsociada/{usuarioId}", new GetIncidentesNotificablesHandler());

        Server.app().get("/rankingsCP", ctx -> {ctx.render("rankingsCP.hbs");});
        //Server.app().get("/rankingFiltradosCP/{tipoDeRanking}", ctx -> {ctx.render("rankingFiltradosCP.hbs");});

        /*Server.app().get("/rankingFiltradosCP/PROMEDIO_DE_CIERRE", ctx -> {ctx.render("rankingsPorTipo1.hbs");});
        Server.app().get("/rankingFiltradosCP/MAYOR_CANT_INCIDENTES", ctx -> {ctx.render("rankingsPorTipo2.hbs");});
        Server.app().get("/rankingFiltradosCP/MAYOR_IMPACTO", ctx -> {ctx.render("rankingsPorTipo3.hbs");});*/
        Server.app().get("/rankingFiltradosCP/{tipoDeRanking}", new GetRankingsHandler());

        Server.app().get("/api/obtenerComunidadesPorUsuario/{usuarioId}", new GetMembresiasPorUsuarioHandler());
        Server.app().put("/api/comunidades/{membresia_id}/{rolDeImpacto}", new PutCambioDeRolHandler());
        Server.app().put("/api/usuario/{usuarioId}", new PutEditarPerfilHandler());







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