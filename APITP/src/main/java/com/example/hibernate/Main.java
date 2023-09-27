package com.example.hibernate;
import com.example.hibernate.utils.BDUtils;
import javax.persistence.EntityManager;
import com.example.hibernate.dominio.*;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!");
        CalculadoraGrados calcuSemanal = new CalculadoraGrados();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo-hibernate-PU");
        EntityManager em = emf.createEntityManager();
        System.out.printf("Hello and welcomliuokikuiue!");
        List<Object> idsUsuario = em.createQuery("SELECT pb.id FROM Usuario pb").getResultList();
        List<Usuario> usuarios = new ArrayList<>();
        for (Object id : idsUsuario) {
            Usuario usuarioCreado = new Usuario();
            usuarioCreado.setId((int) id);
            usuarios.add(usuarioCreado);
        }
        List<Object> idsIncidente = em.createQuery("SELECT pb.id FROM Incidente pb").getResultList();
        List<Incidente> incidentes = new ArrayList<>();
        for (Object id : idsIncidente) {
            Incidente incidenteCreado = new Incidente();
            incidenteCreado.setId((int) id);
            String consulta ="SELECT i.fechaCierre FROM Incidente i WHERE i.id = :id";
            incidenteCreado.setFechaCierre((LocalDateTime) em.createQuery(consulta).getResultList().get(0));
            String consultados ="SELECT i.fechaCierre FROM Incidente i WHERE i.id = :id";
            incidenteCreado.setFechaInicio((LocalDateTime) em.createQuery(consultados).getResultList().get(0));
            String consultatres ="SELECT i.creador FROM Incidente i WHERE i.id = :id";
            int id_usuario_creador = (int) em.createQuery(consultatres).getResultList().get(0);
            for (Usuario usuarioConsiderado: usuarios){
                if (id_usuario_creador==usuarioConsiderado.getId()){
                    incidenteCreado.setUsuarioCreador(usuarioConsiderado);
                    return;
                }
            }
            String consultacuatro ="SELECT i.cerrador FROM Incidente i WHERE i.id = :id";
            int id_usuario_cerrador = (int) em.createQuery(consultacuatro).getResultList().get(0);
            for (Usuario usuarioConsiderado: usuarios){
                if (id_usuario_creador==usuarioConsiderado.getId()){
                    incidenteCreado.setUsuarioCreador(usuarioConsiderado);
                    return;
                }
            }
            incidentes.add(incidenteCreado);
        }
        List<Object> idsComunidades = em.createQuery("SELECT pb.id FROM Incidente pb").getResultList();
        List<Comunidad> comunidades = new ArrayList<>();
        for (Object id : idsComunidades) {
            Comunidad comunidadCreada= new Comunidad();
            List<Usuario> usuariosTemporales = new ArrayList<>();
            comunidadCreada.setId((int) id);
            String consultatres ="SELECT i.miembro FROM Incidente i WHERE i.id = :id";
            List<Integer> ids_miembros = (List<Integer>) em.createQuery(consultatres).getResultList();
            for (Usuario usuarioConsiderado: usuarios){
                {
                    for(int id_miembro : ids_miembros){
                        if(id_miembro == usuarioConsiderado.getId()){
                            usuariosTemporales.add(usuarioConsiderado);
                        }
                    }
                }
            }
            comunidadCreada.setUsuarios(usuariosTemporales);
        }
        calcuSemanal.setRepoUsuarios(usuarios);
        calcuSemanal.setRepoIncidentes(incidentes);
        calcuSemanal.setRepoComunidad(comunidades);
        calcuSemanal.actualizacionSemanal();
        em.close();
        emf.close();
    }
}



// Crear el EntityManagerFactory

// Ahora puedes utilizar em para realizar operaciones de persistencia
// ...

// No olvides cerrar el EntityManager y el EntityManagerFactory cuando termines
