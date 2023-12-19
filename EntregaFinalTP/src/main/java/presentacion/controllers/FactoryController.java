package presentacion.controllers;

import persistencia.repositories.*;

public class FactoryController {

    public static Object controller(String nombre) {
        Object controller = null;
        switch (nombre) {
            case "Entidades": controller = new EntidadesController(new RepositorioEntidades()); break;
            case "Login": controller = new LoginController(new RepositorioUsuariosGenerales()); break;
            case "IniciarSesion": controller = new InicioSesionController(new RepositorioCuentas(), new RepositorioUsuariosGenerales()); break;
            case "Incidentes": controller = new IncidentesController(new RepositorioIncidentes()); break;
            case "Rankings": controller = new RankingsController(new RepositorioRankings()); break;
            case "Membresias": controller = new MembresiasController(new RepositorioMembresias(), new RepositorioUsuariosGenerales()); break;
            case "MiCuenta": controller = new MiCuentaController(new RepositorioUsuariosGenerales());
            //case "Tareas": controller = new TareasController(new RepositorioEntidades()); break;
        }
        return controller;
    }
}