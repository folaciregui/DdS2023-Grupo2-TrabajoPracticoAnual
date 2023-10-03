package com.example.hibernate.persistencia;

import com.example.hibernate.dominio.CalculadoraGrados;
import com.example.hibernate.dominio.Comunidad;
import com.example.hibernate.dominio.NivelConfianza;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


import java.util.List;

public class RepoComunidades {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo-hibernate-PU");
    EntityManager em = emf.createEntityManager();


    public List<Comunidad> obtenerTodas() {

        TypedQuery<Comunidad> query = em.createQuery("SELECT u FROM Comunidad u", Comunidad.class);

        return query.getResultList();

        //context.json(usuarios);
    }

    public NivelConfianza obtenerGradoDeConfianzaPorComunidad(Integer idBuscado) {
        return CalculadoraGrados.calcularGradoDeConfianzaComunidad(idBuscado);
    }
}
