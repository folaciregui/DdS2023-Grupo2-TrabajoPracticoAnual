package presentacion.handlers;

import dominio.entidades.Entidad;
import persistencia.repositories.RepositorioEntidades;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;
import java.util.List;

public class GetEntidadesHandler implements Handler {
    private final RepositorioEntidades repoEntidades;

    public GetEntidadesHandler() {
        this.repoEntidades = new RepositorioEntidades();
    }

    @Override
    public void handle(@NotNull Context context) throws Exception {
        List<Entidad> entidades = this.repoEntidades.buscarTodos();
        context.json(entidades);
    }
}


