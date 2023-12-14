package persistencia.repositories;

import dominio.usuariosycomunidades.Comunidad;
import dominio.usuariosycomunidades.Membresia;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class RepositorioMembresias implements WithSimplePersistenceUnit {



    public void agregar(Membresia membresia){
        EntityTransaction tx = entityManager().getTransaction();
        tx.begin();
        entityManager().persist(membresia); // INSERT INTO ...
        tx.commit();
    }
    public List<Membresia> buscarTodos(){
        return entityManager().createQuery("from " + Membresia.class.getName()).getResultList();
    }


    public List<Membresia> buscarPorUsuario(Integer id) {
        CriteriaBuilder cb = entityManager().getCriteriaBuilder();
        CriteriaQuery<Membresia> criteriaQuery = cb.createQuery(Membresia.class);
        Root<Membresia> root = criteriaQuery.from(Membresia.class);

        criteriaQuery
                .select(root)
                .where(
                        cb.and(
                                cb.equal(root.get("usuario"), id)
                        )
                );
        return entityManager().createQuery(criteriaQuery).getResultList();
    }
}
