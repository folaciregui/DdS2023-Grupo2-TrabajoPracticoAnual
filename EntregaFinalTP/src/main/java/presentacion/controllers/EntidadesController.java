package presentacion.controllers;

import dominio.entidades.Entidad;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;
import io.javalin.http.UploadedFile;
import io.javalin.util.FileUtil;
import persistencia.repositories.RepositorioEntidades;
import presentacion.handlers.ICrudViewsHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class EntidadesController extends Controller implements ICrudViewsHandler {
    private RepositorioEntidades repositorioDeEntidades = null;

    public EntidadesController(RepositorioEntidades repositorioDeEntidades) {
        this.repositorioDeEntidades = repositorioDeEntidades;
    }

    @Override
    public void index(Context context) {
        if (repositorioDeEntidades == null) {
            // Inicializa el repositorio de entidades si es necesario
            repositorioDeEntidades = new RepositorioEntidades(); // Reemplaza con el tipo y la lógica real
            System.out.println("creando repo");
        }
        if (context == null) {
            //throw new IllegalArgumentException("El parámetro context no puede ser nulo.");
            System.out.println("contexto nulo");
        }
        Map<String, Object> model = new HashMap<>();
        List<Entidad> entidades = this.repositorioDeEntidades.buscarTodos();
        model.put("entidades", entidades);
        context.render("entidades/entidades.hbs", model);
    }

    public void cargarEntidades(Context context){
        try {
            UploadedFile archivo = context.uploadedFile("archivo-entidades");
            String pathArchivo = "src/main/resources/public/" + archivo.filename();
            FileUtil.streamToFile(archivo.content(), pathArchivo);

            // Procesar el archivo CSV y cargar los empleados en la base de datos
            List<Entidad> entidades = CsvUtil.parseCsv(pathArchivo);

            // Guardar los empleados en la base de datos
            repositorioDeEntidades.guardarTodas(entidades);

            context.html("<html><head><script>" +
                    "alert('Entidades cargadas correctamente.');" +
                    "window.location.href = '/menu';" +
                    "</script></head></html>");

        } catch (IOException e) {
            // Manejar la excepción, por ejemplo, redirigir a una página de error
            //return "redirect:/error";
        }
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
    /*
    @Override
    public void show(Context context) {
        Entidad servicio = (Entidad) this.repositorioDeEntidades.buscarPorId(Integer.parseInt(context.pathParam("id")));
        Map<String, Object> model = new HashMap<>();
        model.put("entidad", servicio);
        context.render("entidades/entidad.hbs", model);
    }

    /*
    @Override
    public void create(Context context) {
        Entidad usuarioLogueado = super.usuarioLogueado(context);

        if(usuarioLogueado == null || !usuarioLogueado.getRol().tenesPermiso("crear_servicios")) {
            throw new AccessDeniedException();
        }

        Servicio servicio = null;
        Map<String, Object> model = new HashMap<>();
        model.put("servicio", servicio);
        context.render("servicios/servicio.hbs", model);
    }

    @Override
    public void save(Context context) {
        Servicio servicio = new Servicio();
        this.asignarParametros(servicio, context);
        this.repositorioDeServicios.guardar(servicio);
        context.status(HttpStatus.CREATED);
        context.redirect("/servicios");
    }

    @Override
    public void edit(Context context) {
        Servicio servicio = (Servicio) this.repositorioDeServicios.buscar(Long.parseLong(context.pathParam("id")));
        Map<String, Object> model = new HashMap<>();
        model.put("servicio", servicio);
        context.render("servicios/servicio.hbs", model);
    }

    @Override
    public void update(Context context) {
        Servicio servicio = (Servicio) this.repositorioDeServicios.buscar(Long.parseLong(context.pathParam("id")));
        this.asignarParametros(servicio, context);
        this.repositorioDeServicios.actualizar(servicio);
        context.redirect("/servicios");
    }

    @Override
    public void delete(Context context) {
        Servicio servicio = (Servicio) this.repositorioDeServicios.buscar(Long.parseLong(context.pathParam("id")));
        this.repositorioDeServicios.eliminar(servicio);
        context.redirect("/servicios");
    }

    private void asignarParametros(Servicio servicio, Context context) {
        if(!Objects.equals(context.formParam("nombre"), "")) {
            servicio.setNombre(context.formParam("nombre"));
        }
    }*/
}