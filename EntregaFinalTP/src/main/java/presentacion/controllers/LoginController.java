package presentacion.controllers;

import dominio.usuariosycomunidades.UsuarioGeneral;
import dominio.validador.Cuenta;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;
import persistencia.repositories.RepositorioCuentas;
import persistencia.repositories.RepositorioEntidades;
import persistencia.repositories.RepositorioUsuariosGenerales;
import presentacion.handlers.ICrudViewsHandler;

public class LoginController extends Controller implements ICrudViewsHandler {

    private RepositorioCuentas repositorioDeCuentas = null;

    private RepositorioUsuariosGenerales repositorioUsuariosGenerales;

    public LoginController(RepositorioUsuariosGenerales repositorioUsuariosGenerales) {
        this.repositorioUsuariosGenerales = repositorioUsuariosGenerales;
    }

    public void login(Context context){

        UsuarioGeneral usuarioGeneral = new UsuarioGeneral();

        Cuenta cuenta = new Cuenta();
        cuenta.setNombre(context.formParam("nombre_de_usuario"));
        cuenta.setContrasenia(context.formParam("contrasenia"));
        cuenta.setUsuarioGeneral(usuarioGeneral);

        usuarioGeneral.setCuenta(cuenta);
        usuarioGeneral.setEmail(context.formParam("nombre_de_usuario"));

        this.repositorioUsuariosGenerales.guardar(usuarioGeneral);

        context.sessionAttribute("id_usuario", this.repositorioUsuariosGenerales.buscar(usuarioGeneral));

        context.status(HttpStatus.CREATED);
        context.redirect("/menu");
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
}
