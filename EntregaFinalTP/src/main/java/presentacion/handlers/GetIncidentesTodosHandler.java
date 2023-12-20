package presentacion.handlers;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;
import persistencia.repositories.RepositorioIncidentes;

public class GetIncidentesTodosHandler implements Handler {

    private final RepositorioIncidentes repositorioIncidentes;

    public GetIncidentesTodosHandler(){
        this.repositorioIncidentes = new RepositorioIncidentes();
    }

    @Override
    public void handle(@NotNull Context context) throws Exception {
        context.json(repositorioIncidentes.buscarTodos());
    }
}