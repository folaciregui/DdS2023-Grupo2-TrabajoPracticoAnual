package persistencia.repositories;

import dominio.servicios.Incidente;
import dominio.servicios.IncidentesNotificables;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;

import javax.persistence.EntityTransaction;
import java.util.List;

public class RepositorioIncidentesNotificables implements WithSimplePersistenceUnit {

    public void agregar(IncidentesNotificables incidentesNotificables){
        EntityTransaction tx = entityManager().getTransaction();
        tx.begin();
        entityManager().persist(incidentesNotificables); // INSERT INTO ...
        tx.commit();
    }
    public List<IncidentesNotificables> buscarTodos(){
        return entityManager().createQuery("from " + IncidentesNotificables.class.getName()).getResultList();
    }

}
