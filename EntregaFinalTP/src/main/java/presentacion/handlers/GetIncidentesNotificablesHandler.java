package presentacion.handlers;

import dominio.servicios.Incidente;
import dominio.servicios.IncidentesNotificables;
import dominio.usuariosycomunidades.Membresia;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;
import persistencia.repositories.RepositorioIncidentes;
import persistencia.repositories.RepositorioIncidentesNotificables;
import persistencia.repositories.RepositorioMembresias;

import java.util.ArrayList;
import java.util.List;

public class GetIncidentesNotificablesHandler implements Handler {

    private final RepositorioIncidentesNotificables repositorioIncidentesNotificables;
    private final RepositorioMembresias repositorioMembresias = new RepositorioMembresias();

    public GetIncidentesNotificablesHandler(){
        this.repositorioIncidentesNotificables = new RepositorioIncidentesNotificables();
    }


    @Override
    public void handle(@NotNull Context context) throws Exception {
        Integer usuarioId = Integer.valueOf(context.pathParam("usuarioId"));

        List<Membresia> membresiasDelUsuario = this.repositorioMembresias.buscarPorUsuario(usuarioId);

        List<IncidentesNotificables> notificables = this.repositorioIncidentesNotificables.buscarTodos();

        List<Incidente> incidentes = new ArrayList<>();

        for(IncidentesNotificables en : notificables){
            for(Membresia m : membresiasDelUsuario){
                if(en.getComunidad() == m.getComunidad()){
                    incidentes.add(en.getIncidente());
                }
            }
        }
        context.json(incidentes);

    }
}
