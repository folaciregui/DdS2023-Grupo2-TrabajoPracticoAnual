package persistencia.repositories;

import dominio.entidades.Entidad;
import dominio.rankings.RankingsIncidente;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;

import javax.persistence.EntityTransaction;
import java.util.List;

public class RepositorioRankings implements WithSimplePersistenceUnit {

    public void agregar(RankingsIncidente ranking){
        EntityTransaction tx = entityManager().getTransaction();
        tx.begin();
        entityManager().persist(ranking); // INSERT INTO ...
        tx.commit();
    }
    public List<RankingsIncidente> buscarTodos(){
        return entityManager().createQuery("from " + RankingsIncidente.class.getName()).getResultList();
    }
}
