package com.example.hibernate.persistencia;

import com.example.hibernate.dominio.*;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;

import static com.example.hibernate.dominio.ClasificacionConfianza.CONFIABLENIVEL2;
import static java.util.Arrays.asList;
import java.util.ArrayList;
public class RepoIncidentes {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo-hibernate-PU");
    EntityManager em = emf.createEntityManager();
    public List<Incidente> obtenerTodos() {
        TypedQuery<Incidente> query = em.createQuery("SELECT u FROM Incidente u", Incidente.class);

        return query.getResultList();
    }

    public List<Incidente> obtenerIncidentesPorUsuario(int idUsuario) {

        List<Incidente> incidentesPorUsuario = new ArrayList<>();

        List<Incidente> todosLosIncidentes = this.obtenerTodos();

        for (Incidente incidente : todosLosIncidentes) {
            if (incidente.getUsuarioCreador().getId() == idUsuario || incidente.getUsuarioCerrador().getId() == idUsuario) {
                incidentesPorUsuario.add(incidente);
            }
        }

        return incidentesPorUsuario;
    }

    /*
    public Incidente obtenerUnoCualquiera() {
        Incidente incidente = new Incidente();

        incidente.setId(1);

        Usuario creador = new Usuario();
        creador.setId(1);
        creador.setActividadIncidentes(new ArrayList<>());
        NivelConfianza nivelConfianza = new NivelConfianza();
        nivelConfianza.setNivelNumerico(5);
        nivelConfianza.setClasificacion(CONFIABLENIVEL2);
        creador.setNivelConfianza(nivelConfianza);

        incidente.setUsuarioCreador(creador);

        Usuario cerrador = new Usuario();
        cerrador.setId(1);
        cerrador.setActividadIncidentes(new ArrayList<>());
        NivelConfianza nivelDeConfianza = new NivelConfianza();
        nivelDeConfianza.setNivelNumerico(5);
        nivelDeConfianza.setClasificacion(CONFIABLENIVEL2);
        cerrador.setNivelConfianza(nivelDeConfianza);

        incidente.setUsuarioCreador(cerrador);

        incidente.setFechaInicio(LocalDateTime.now());
        incidente.setFechaCierre(LocalDateTime.now());

        incidente.setEstaCerrado(true);


        Monitoreable monitoreable = new Monitoreable();
        monitoreable.setId(1);
        monitoreable.setIncidentes(new ArrayList<>());

        incidente.setMonitoreable(monitoreable);

        return incidente;
    }
    */


}
