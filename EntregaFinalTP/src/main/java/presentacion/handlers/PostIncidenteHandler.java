package presentacion.handlers;

import dominio.servicios.Estado;
import dominio.servicios.Incidente;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;
import persistencia.repositories.RepositorioIncidentes;
import presentacion.utils.Notificaciones;

public class PostIncidenteHandler implements Handler {
    private final RepositorioIncidentes repositorioIncidentes;
    Notificaciones notificacion = new Notificaciones();

    public PostIncidenteHandler() {
        this.repositorioIncidentes = new RepositorioIncidentes();
    }

    @Override
    public void handle(@NotNull Context context) throws Exception {
        String bodyString = context.body();
        Incidente incidente = context.bodyAsClass(Incidente.class);

        incidente.setEstado(Estado.ABIERTO);

        System.out.println("Creando incidente: " + bodyString);
        System.out.println(incidente);
        
        this.repositorioIncidentes.agregar(incidente);

        notificacion.enviarEmail(incidente.getUsuarioCreador().getEmail(), "APERTURA", incidente);

        context.status(201);
    }

}
