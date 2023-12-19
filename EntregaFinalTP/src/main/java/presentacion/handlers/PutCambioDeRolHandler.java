package presentacion.handlers;

import dominio.servicios.Incidente;
import dominio.usuariosycomunidades.Membresia;
import dominio.usuariosycomunidades.RolDeImpacto;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;
import persistencia.repositories.RepositorioMembresias;

public class PutCambioDeRolHandler implements Handler {

    private RepositorioMembresias repositorioMembresias = new RepositorioMembresias();

    @Override
    public void handle(@NotNull Context context) throws Exception {
        Integer membresia_id = Integer.valueOf(context.pathParam("membresia_id"));
        RolDeImpacto rolDeImpacto = RolDeImpacto.valueOf(context.pathParam("rolDeImpacto"));

        Membresia membresia = repositorioMembresias.buscarPorId(membresia_id);
        repositorioMembresias.cambiarRol(membresia);
    }
}
