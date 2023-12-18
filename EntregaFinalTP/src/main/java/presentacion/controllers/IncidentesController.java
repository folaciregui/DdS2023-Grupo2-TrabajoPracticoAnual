package presentacion.controllers;

import dominio.entidades.Entidad;
import dominio.servicios.Estado;
import dominio.servicios.Incidente;
import io.javalin.http.Context;
import persistencia.repositories.RepositorioEntidades;
import persistencia.repositories.RepositorioIncidentes;
import presentacion.handlers.ICrudViewsHandler;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class IncidentesController extends Controller implements ICrudViewsHandler {

    RepositorioIncidentes repositorioIncidentes = null;

    public IncidentesController(RepositorioIncidentes repositorioIncidentes) {
        this.repositorioIncidentes = repositorioIncidentes;
    }

    @Override
    public void index(Context context) {
        Map<String, Object> model = new HashMap<>();
        List<Incidente> incidentes = this.repositorioIncidentes.buscarTodos();
        model.put("incidentes", incidentes);
        context.render("incidentes.hbs", model);

    }
    @Override
    public void show(Context context) {

    }

    @Override
    public void create(Context context) {

    }

    @Override
    public void save(Context context) {

    }

    @Override
    public void edit(Context context) {

    }

    @Override
    public void update(Context context) {

    }

    @Override
    public void delete(Context context) {

    }

    public void filtrarIncidentes(Context context) throws Exception {

        String estadoString = context.formParam("estadoSeleccionado");
        Estado estado = Estado.valueOf(estadoString);

        if (repositorioIncidentes == null) {
            repositorioIncidentes = new RepositorioIncidentes(); // Reemplaza con el tipo y la lógica real
        }

        List<Incidente> incidentes = this.repositorioIncidentes.buscarTodos();

        List<Incidente> incidentesFiltrados = incidentes.stream()
                .filter(incidente -> incidente.getEstado() == estado)
                .collect(Collectors.toList());

        Map<String, Object> model = new HashMap<>();
        model.put("incidentes", incidentesFiltrados);
        context.render("incidentes.hbs", model);
    }
}
