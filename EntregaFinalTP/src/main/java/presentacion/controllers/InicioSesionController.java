package presentacion.controllers;

import dominio.usuariosycomunidades.UsuarioGeneral;
import dominio.validador.Cuenta;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;
import jakarta.servlet.http.HttpSession;
import persistencia.repositories.RepositorioCuentas;
import persistencia.repositories.RepositorioUsuariosGenerales;
import presentacion.handlers.ICrudViewsHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InicioSesionController extends Controller implements ICrudViewsHandler {

    private final RepositorioCuentas repositorioCuentas;
    private final RepositorioUsuariosGenerales repositorioUsuariosGenerales;

    public InicioSesionController(RepositorioCuentas repositorioCuentas, RepositorioUsuariosGenerales repositorioUsuariosGenerales) {
        this.repositorioCuentas = repositorioCuentas;
        this.repositorioUsuariosGenerales = repositorioUsuariosGenerales;
    }

    public void validarUsuario(Context context){
        Cuenta cuenta = new Cuenta();
        cuenta.setNombre(context.formParam("nombre_de_usuario"));
        cuenta.setContrasenia(context.formParam("contrasenia"));

        if(this.existeCuenta(cuenta)){
            context.status(HttpStatus.CREATED);
            Integer id_usuario = null;
            List<Cuenta> cuentas = repositorioCuentas.buscarTodos();
            for (Cuenta c : cuentas){
                if (c.getNombre().equals(cuenta.getNombre()) && c.getContrasenia().equals(cuenta.getContrasenia())) {
                    id_usuario = c.getUsuarioGeneral().getId();
                }
            }

            //UsuarioGeneral usuarioGeneral = this.repositorioUsuariosGenerales.buscarPorId(id_usuario);

            System.out.println("--------------EL ID ES " + id_usuario);

            context.sessionAttribute("id", id_usuario);
            System.out.println("--------------EL ID ES " + context.sessionAttribute("id"));

            UsuarioGeneral usuario = this.repositorioUsuariosGenerales.buscarPorId(id_usuario);

            //Map<String, Object> model = new HashMap<>();
            //model.put("miCuenta", usuario);
            //context.render("miCuentaCL.hbs", model);

            context.redirect("/menu");
        }else{
            context.html("<html><head><script>" +
                    "alert('El usuario no se encuentra registrado. Revise los datos e intente nuevamente.');" +
                    "window.location.href = '/inicioSesion';" +
                    "</script></head></html>");

            //context.redirect("/usuarioNoRegistrado");
            /*try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            context.redirect("/paginaInicio");*/
        }
    }


    private boolean existeCuenta(Cuenta cuenta){

        List<Cuenta> cuentas = repositorioCuentas.buscarTodos();

        for (Cuenta c : cuentas) {
            if (c.getNombre().equals(cuenta.getNombre()) && c.getContrasenia().equals(cuenta.getContrasenia())) {
                return true;
            }
        }

        return false;
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
