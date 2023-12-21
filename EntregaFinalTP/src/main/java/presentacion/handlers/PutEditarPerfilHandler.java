package presentacion.handlers;

import dominio.servicios.Incidente;
import dominio.usuariosycomunidades.UsuarioGeneral;
import dominio.validador.Cuenta;
import dominio.validador.UsuarioEditado;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;
import persistencia.repositories.RepositorioCuentas;
import persistencia.repositories.RepositorioUsuariosGenerales;

public class PutEditarPerfilHandler implements Handler {

    private RepositorioUsuariosGenerales repositorioUsuariosGenerales = new RepositorioUsuariosGenerales();
    private RepositorioCuentas repositorioCuentas = new RepositorioCuentas();

    @Override
    public void handle(@NotNull Context context) throws Exception {
        Integer usuarioId = Integer.valueOf(context.pathParam("usuarioId"));

        UsuarioEditado usuarioGeneralModificado = context.bodyAsClass(UsuarioEditado.class);

        System.out.println("Nombre modificado: " + usuarioGeneralModificado.getNombre());
        System.out.println("Apellido modificado: " + usuarioGeneralModificado.getApellido());
        System.out.println("Email modificado: " + usuarioGeneralModificado.getNombre());

        UsuarioGeneral usuarioGeneral = this.repositorioUsuariosGenerales.buscarPorId(usuarioId);
        Cuenta cuenta = this.repositorioCuentas.buscarPorUsuario(usuarioGeneral.getId());

        if(!usuarioGeneralModificado.getNombre().isEmpty() || usuarioGeneralModificado.getNombre() == null){
            usuarioGeneral.setNombre(usuarioGeneralModificado.getNombre());
        }
        if(!usuarioGeneralModificado.getApellido().isEmpty() || usuarioGeneralModificado.getApellido() == null){
            usuarioGeneral.setApellido(usuarioGeneralModificado.getApellido());
        }
        if(!usuarioGeneralModificado.getEmail().isEmpty() || usuarioGeneralModificado.getEmail() == null){
            usuarioGeneral.setEmail(usuarioGeneralModificado.getEmail());
            usuarioGeneral.getCuenta().setNombre(usuarioGeneralModificado.getEmail());
        }

        repositorioUsuariosGenerales.actualizarPerfil(usuarioGeneral);
        context.status(201);
    }
}
