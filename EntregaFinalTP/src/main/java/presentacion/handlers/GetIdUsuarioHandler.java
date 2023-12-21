package presentacion.handlers;

import dominio.usuariosycomunidades.UsuarioGeneral;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;
import persistencia.repositories.RepositorioUsuariosGenerales;

public class GetIdUsuarioHandler implements Handler {
    private final RepositorioUsuariosGenerales repositorioUsuariosGenerales;
    public GetIdUsuarioHandler(){this.repositorioUsuariosGenerales = new RepositorioUsuariosGenerales();}

    @Override
    public void handle(@NotNull Context context) throws Exception {
        Integer usuarioActivoId = context.sessionAttribute("id");
        UsuarioGeneral usuarioActivo = repositorioUsuariosGenerales.buscarPorId(usuarioActivoId);
        context.json(usuarioActivo);
    }
}
