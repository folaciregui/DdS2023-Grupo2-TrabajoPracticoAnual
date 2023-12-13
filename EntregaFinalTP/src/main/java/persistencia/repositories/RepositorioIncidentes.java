package persistencia.repositories;

import dominio.entidades.Entidad;
import dominio.servicios.Incidente;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;

import javax.persistence.EntityTransaction;
import java.util.List;

public class RepositorioIncidentes implements WithSimplePersistenceUnit {


    public void agregar(Incidente incidente){
        EntityTransaction tx = entityManager().getTransaction();
        tx.begin();
        entityManager().persist(incidente); // INSERT INTO ...
        tx.commit();
    }
    public List<Incidente> buscarTodos(){
        return entityManager().createQuery("from " + Incidente.class.getName()).getResultList();
    }
}
