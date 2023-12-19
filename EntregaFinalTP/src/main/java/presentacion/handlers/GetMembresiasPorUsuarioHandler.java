package presentacion.handlers;

import dominio.entidades.Entidad;
import dominio.usuariosycomunidades.Membresia;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;
import persistencia.repositories.RepositorioMembresias;
import persistencia.repositories.RepositorioServicios;

import java.util.List;

public class GetMembresiasPorUsuarioHandler implements Handler {

    private final RepositorioMembresias repositorioMembresias;

    public GetMembresiasPorUsuarioHandler() {
        this.repositorioMembresias = new RepositorioMembresias();
    }

    @Override
    public void handle(@NotNull Context context) throws Exception {
        Integer id_usuario = Integer.valueOf(context.pathParam("usuarioId"));
        List<Membresia> membresias = this.repositorioMembresias.buscarPorUsuario(id_usuario);
        context.json(membresias);
    }
}
