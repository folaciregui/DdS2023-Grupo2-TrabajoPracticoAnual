package com.example.hibernate.persistencia;

//import io.javalin.Context;
import com.example.hibernate.dominio.CalculadoraGrados;
import com.example.hibernate.dominio.NivelConfianza;
import com.example.hibernate.dominio.Usuario;
import io.javalin.http.Context;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


import java.util.List;
import java.util.ArrayList;
public class RepoUsuarios {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo-hibernate-PU");
    EntityManager em = emf.createEntityManager();

    public List<Usuario> obtenerTodosLosUsuarios() {

        TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u", Usuario.class);

        return query.getResultList();
        //context.json(usuarios);
    }

    public Usuario getUsuario(int id) {

        TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.id = :idUsuario", Usuario.class);
        query.setParameter("idUsuario", id);

        List<Usuario> resultados = query.getResultList();

        if (!resultados.isEmpty()) {
            // Encontro el usuario
            return resultados.get(0);
        } else {
            // No encontró el usuario, devuelve null
            return null;
        }
    }

    public List<Usuario> obtenerUsuariosPorComunidad(int idComunidad) {
        List<Usuario> usuarios = this.obtenerTodosLosUsuarios();
        List<Usuario> usuariosPorComunidad = new ArrayList<>();

        for(Usuario usuario: usuarios){
            if(usuario.getComunidad().getId() == idComunidad){
                usuariosPorComunidad.add(usuario);
            }
        }

        return usuariosPorComunidad;
    }

    public NivelConfianza obtenerGradoDeConfianzaPorUsuario(Integer idBuscado) {
        return CalculadoraGrados.calcularGradoDeConfianzaUsuario(idBuscado);
    }
}
