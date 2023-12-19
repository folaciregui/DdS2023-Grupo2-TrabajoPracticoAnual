package presentacion.controllers;

import dominio.usuariosycomunidades.Comunidad;
import dominio.usuariosycomunidades.Membresia;
import dominio.usuariosycomunidades.RolDeImpacto;
import dominio.usuariosycomunidades.UsuarioGeneral;
import io.javalin.http.Context;
import persistencia.repositories.RepositorioMembresias;
import persistencia.repositories.RepositorioUsuariosGenerales;
import presentacion.handlers.ICrudViewsHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MembresiasController extends Controller implements ICrudViewsHandler {

    private RepositorioMembresias repositorioMembresias;
    private RepositorioUsuariosGenerales repositorioUsuariosGenerales;

    public MembresiasController(RepositorioMembresias repositorioMembresias, RepositorioUsuariosGenerales repositorioUsuariosGenerales) {
        this.repositorioMembresias = repositorioMembresias;
        this.repositorioUsuariosGenerales = repositorioUsuariosGenerales;
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


    public void comunidadesPorUsuario(Context context) throws Exception{
        Integer id = context.sessionAttribute("id"); // no lo guarda bien
        System.out.println("El id es " + id);

        //UsuarioGeneral usuarioGeneral = this.repositorioUsuariosGenerales.buscarPorId(id);
        List<Membresia> membresiasPorUsuario = this.repositorioMembresias.buscarPorUsuario(id);
        /*List<Comunidad> comunidades = new ArrayList<>();

        for(Membresia m : membresiasPorUsuario){
            comunidades.add(m.getComunidad());
        }*/

        Map<String, Object> model = new HashMap<>();
        model.put("membresiasPorUsuario", membresiasPorUsuario);
        context.render("comunidadesPorUsuario.hbs", model);

    }

    public void cambiarRol(Context context) throws Exception {
        Integer usuario_id = context.sessionAttribute("id");
        Integer comunidad_id = Integer.valueOf(context.formParam("comunidadId"));
        RolDeImpacto rol = RolDeImpacto.valueOf(context.formParam("rol"));

        Membresia membresia = this.repositorioMembresias.encontrarMembresia(usuario_id, comunidad_id, rol);
        this.repositorioMembresias.cambiarRol(membresia);

        List<Membresia> membresiasPorUsuario = this.repositorioMembresias.buscarPorUsuario(usuario_id);

        Map<String, Object> model = new HashMap<>();
        model.put("membresiasPorUsuarioEditado", membresiasPorUsuario);
        context.render("comunidadesPorUsuarioEditado.hbs", model);

    }
}
