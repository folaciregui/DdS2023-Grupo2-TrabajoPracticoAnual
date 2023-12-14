package presentacion.handlers;

import dominio.entidades.Entidad;
import dominio.usuariosycomunidades.Membresia;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;
import persistencia.repositories.RepositorioMembresias;
import persistencia.repositories.RepositorioServicios;

import java.util.List;

public class GetMembresiasHandler implements Handler {

    private final RepositorioMembresias repositorioMembresias;

    public GetMembresiasHandler() {
        this.repositorioMembresias = new RepositorioMembresias();
    }

    @Override
    public void handle(@NotNull Context context) throws Exception {
        //context.json(repositorioMembresias.buscarTodos());
        List<Membresia> membresias = this.repositorioMembresias.buscarTodos();
        context.json(membresias);
        //context.json(repositorioMembresias.buscarPorUsuario(1));
    }
}
