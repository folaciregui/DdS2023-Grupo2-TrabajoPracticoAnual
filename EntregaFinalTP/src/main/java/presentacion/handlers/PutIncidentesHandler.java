package presentacion.handlers;

import dominio.servicios.Estado;
import dominio.servicios.Incidente;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;
import persistencia.repositories.RepositorioIncidentes;

public class PutIncidentesHandler implements Handler {

    private RepositorioIncidentes repositorioIncidentes = new RepositorioIncidentes();

    @Override
    public void handle(@NotNull Context context) throws Exception {
        Integer incidenteId = Integer.valueOf(context.pathParam("incidenteId"));
        Incidente incidente = repositorioIncidentes.buscarPorId(incidenteId);
        repositorioIncidentes.actualizarEstadoIncidente(incidente);
    }
}
