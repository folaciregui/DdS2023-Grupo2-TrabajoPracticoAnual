package presentacion.controllers;

import dominio.usuariosycomunidades.UsuarioGeneral;
import io.javalin.http.Context;
import persistencia.repositories.RepositorioCuentas;
import persistencia.repositories.RepositorioUsuariosGenerales;
import presentacion.handlers.ICrudViewsHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MiCuentaController extends Controller implements ICrudViewsHandler {

    RepositorioUsuariosGenerales repositorioUsuariosGenerales = null;

    public MiCuentaController(RepositorioUsuariosGenerales repositorioUsuariosGenerales){
        this.repositorioUsuariosGenerales = repositorioUsuariosGenerales;
    }

    public void obtenerDatosCuenta(Context context) {
        System.out.println("el id es " + context.sessionAttribute("id"));
        Integer id = context.sessionAttribute("id");

        UsuarioGeneral usuarioGeneral = repositorioUsuariosGenerales.buscarPorId(id);

        Map<String, Object> model = new HashMap<>();
        model.put("datos", usuarioGeneral);
        context.render("miCuentaDatos.hbs", model);
    }

    @Override
    public void index(Context context) {

    }

    @Override
    public void show(Context context) {

    }

    @Override
    public void create(Context context) {

    }

    @Override
    public void save(Context context) {

    }

    @Override
    public void edit(Context context) {

    }

    @Override
    public void update(Context context) {

    }

    @Override
    public void delete(Context context) {

    }


    public void editarPerfil(Context context) {
        Integer id = context.sessionAttribute("id");
        UsuarioGeneral usuarioGeneral = repositorioUsuariosGenerales.buscarPorId(id);

        if(!Objects.equals(context.formParam("nombre"), "")){
            usuarioGeneral.setNombre(context.formParam("nombre"));
        }
        if(!Objects.equals(context.formParam("apellido"), "")){
            usuarioGeneral.setApellido(context.formParam("apellido"));
        }
        if(!Objects.equals(context.formParam("nombre_de_usuario"), "")){
            usuarioGeneral.getCuenta().setNombre(context.formParam("nombre_de_usuario"));
        }
        if(!Objects.equals(context.formParam("contrasenia"), "")){
            usuarioGeneral.getCuenta().setContrasenia(context.formParam("contrasenia"));
        }

        this.repositorioUsuariosGenerales.actualizarPerfil(usuarioGeneral);

        context.redirect("/menu");
    }
}
