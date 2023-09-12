package com.example.hibernate;
import com.example.hibernate.dominio.*;

import com.example.hibernate.utils.BDUtils;
import java.time.LocalDateTime;
import static java.util.Arrays.asList;
import java.util.List;
import javax.persistence.EntityManager;

public class DemoFinal {

    public static void main(String[] args) {

        EntityManager em = BDUtils.getEntityManager();
        BDUtils.comenzarTransaccion(em);

//        try {
            UsuarioGeneral marcos = new UsuarioGeneral();
            Organizacion cocaCola = new Organizacion();
            UsuarioGeneral lucas = new UsuarioGeneral();
            UsuarioGeneral tomas = new UsuarioGeneral();
            //Insert

//        } catch (Exception e) {
//            BDUtils.rollback(em);
//            return;
//        }

        //Update
        marcos.setNombre("Marcos"); //Entidad administrada -> detecta cambios
        marcos.setApellido("Fernandez");
        marcos.setCorreoElectonico("marcos@gmail.com");
        marcos.setEmpresaInteres(cocaCola);
        cocaCola.setNombre("Coca Cola");
        cocaCola.setPersonaACargo(lucas);
        lucas.setApellido("Beltram");
        lucas.setNombre("Lucas");
        em.persist(marcos);
        em.persist(cocaCola);
        em.persist(lucas);
        em.persist(tomas);
        System.out.println("ID MARCOS: " + marcos.getId());
        System.out.println("ID COCA COLA: " + cocaCola.getId());
        System.out.println("ID LUCAS: " + lucas.getId());


        List<UsuarioGeneral> personas = em
                // equivalente a: select * from persona where persona.nombre = 'Julian'
                .createQuery("select p from UsuarioGeneral p where p.nombre = ?1", UsuarioGeneral.class) //ojo, query no tipada
                .setParameter(1, "Lucas")
                .getResultList();

        System.out.println(personas);

        //Delete
        em.remove(tomas);

        BDUtils.commit(em);
    }

}
