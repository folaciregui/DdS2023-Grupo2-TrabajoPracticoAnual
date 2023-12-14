package presentacion.handlers;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;
import persistencia.repositories.RepositorioIncidentes;

public class GetIncidentesHandler implements Handler {

    private final RepositorioIncidentes repositorioIncidentes;

    public GetIncidentesHandler(){
        this.repositorioIncidentes = new RepositorioIncidentes();
    }

    @Override
    public void handle(@NotNull Context context) throws Exception {
        Integer entidadId = Integer.valueOf(context.pathParam("entidadId"));
        Integer establecimientoId = Integer.valueOf(context.pathParam("establecimientoId"));
        context.json(repositorioIncidentes.buscarPorEntidadEstablecimiento(entidadId, establecimientoId));

    }
}
