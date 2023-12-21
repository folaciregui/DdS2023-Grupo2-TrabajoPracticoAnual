package presentacion.handlers;

import dominio.usuariosycomunidades.UsuarioGeneral;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;
import persistencia.repositories.RepositorioUsuariosGenerales;

public class GetIdUsuarioPorEmailHandler implements Handler {

    private final RepositorioUsuariosGenerales repositorioUsuariosGenerales;
    public GetIdUsuarioPorEmailHandler(){this.repositorioUsuariosGenerales = new RepositorioUsuariosGenerales();}

    @Override
    public void handle(@NotNull Context context) throws Exception {
        String email = context.pathParam("email");
        UsuarioGeneral usuarioGeneral = repositorioUsuariosGenerales.buscarPorEmail(email);
        context.sessionAttribute("id", usuarioGeneral.getId());
        System.out.println("--------------------------------------EL ID DE USUARIO ES " + context.sessionAttribute("id"));
        context.json(usuarioGeneral);
    }
}
