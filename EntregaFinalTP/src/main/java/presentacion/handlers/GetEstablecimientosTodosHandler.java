package presentacion.handlers;


import persistencia.repositories.RepositorioEstablecimientos;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class GetEstablecimientosTodosHandler implements Handler {
    private final RepositorioEstablecimientos repoEstablecimientos;

    public GetEstablecimientosTodosHandler() {
        this.repoEstablecimientos = new RepositorioEstablecimientos();
    }

    @Override
    public void handle(@NotNull Context context) throws Exception {
        context.json(repoEstablecimientos.buscarTodos());
    }
}
