package presentacion.handlers;

import dominio.servicios.Incidente;
import dominio.servicios.IncidentesNotificables;
import dominio.usuariosycomunidades.Membresia;
import dominio.usuariosycomunidades.RolDeImpacto;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;
import persistencia.repositories.RepositorioIncidentes;
import persistencia.repositories.RepositorioIncidentesNotificables;
import persistencia.repositories.RepositorioMembresias;

import java.util.ArrayList;
import java.util.List;

public class GetIncidentesPorRolImpactoHandler implements Handler {

    private final RepositorioIncidentes repositorioIncidentes;
    private final RepositorioMembresias repositorioMembresias = new RepositorioMembresias();
    private final RepositorioIncidentesNotificables repositorioIncidentesNotificables = new RepositorioIncidentesNotificables();

    public GetIncidentesPorRolImpactoHandler(){
        this.repositorioIncidentes = new RepositorioIncidentes();
    }


    @Override
    public void handle(@NotNull Context context) throws Exception {
        Integer usuarioId = Integer.valueOf(context.pathParam("usuarioId"));
        RolDeImpacto rolDeImpacto = RolDeImpacto.valueOf(context.pathParam("rol"));

        List<Membresia> membresiasDelUsuario = this.repositorioMembresias.buscarPorUsuario(usuarioId);

        List<Membresia> membresiasPorImpacto = this.filtrarPorImpacto(membresiasDelUsuario, rolDeImpacto);

        List<IncidentesNotificables> notificables = this.repositorioIncidentesNotificables.buscarTodos();

        List<Incidente> incidentes = new ArrayList<>();

        for(IncidentesNotificables en : notificables){
            for(Membresia m : membresiasPorImpacto){
                if(en.getComunidad() == m.getComunidad()){
                    incidentes.add(en.getIncidente());
                }
            }
        }
        context.json(incidentes);
    }

    private List<Membresia> filtrarPorImpacto(List<Membresia> membresias, RolDeImpacto rolDeImpacto) {
        List<Membresia> membresiasPorImpacto = new ArrayList<>();
        for(Membresia m : membresias){
            if(m.getRolDeImpacto() == rolDeImpacto){
                membresiasPorImpacto.add(m);
            }
        }
        return membresiasPorImpacto;
    }
}
