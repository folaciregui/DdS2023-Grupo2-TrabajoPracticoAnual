package presentacion.handlers;

import persistencia.repositories.RepositorioServicios;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class GetServiciosHandler implements Handler {
    private final RepositorioServicios repoServicios;

    public GetServiciosHandler() {
        this.repoServicios = new RepositorioServicios();
    }

    @Override
    public void handle(@NotNull Context context) throws Exception {
        Integer establecimientoId = Integer.valueOf(context.pathParam("establecimientoId"));
        context.json(repoServicios.buscarPorEstablecimiento(establecimientoId));
    }
}
