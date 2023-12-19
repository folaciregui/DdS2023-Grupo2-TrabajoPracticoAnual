package persistencia.repositories;


import dominio.entidades.Entidad;
import dominio.servicios.Incidente;
import dominio.validador.Cuenta;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;

import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class RepositorioCuentas implements WithSimplePersistenceUnit {

    public void guardar(Cuenta cuenta){
        Cuenta unaCuenta = new Cuenta();

        EntityTransaction tx = entityManager().getTransaction();
        tx.begin();
        entityManager().persist(unaCuenta); // INSERT INTO ...
        tx.commit();
    }

    public List<Cuenta> buscarTodos(){
        return entityManager().createQuery("from " + Cuenta.class.getName()).getResultList();
    }

    public Cuenta buscarPorUsuario(Integer id) {
        CriteriaBuilder cb = entityManager().getCriteriaBuilder();
        CriteriaQuery<Cuenta> criteriaQuery = cb.createQuery(Cuenta.class);
        Root<Cuenta> root = criteriaQuery.from(Cuenta.class);

        criteriaQuery
                .select(root)
                .where(
                        cb.and(
                                cb.equal(root.get("usuarioGeneral").get("id"), id)
                        )
                );
        return entityManager().createQuery(criteriaQuery).getSingleResult();
    }
}
