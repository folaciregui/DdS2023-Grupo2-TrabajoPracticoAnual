package persistencia.repositories;

import dominio.entidades.Entidad_X_Establecimiento;
import dominio.servicios.Servicio;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class RepositorioServicios implements WithSimplePersistenceUnit {

    public List<Servicio> buscarTodos(){
        return entityManager().createQuery("from " + Servicio.class.getName()).getResultList();
    }


    public List<Servicio> buscarPorEstablecimiento(Integer establecimientoId) {
        CriteriaBuilder cb = entityManager().getCriteriaBuilder();
        CriteriaQuery<Servicio> criteriaQuery = cb.createQuery(Servicio.class);
        Root<Servicio> root = criteriaQuery.from(Servicio.class);

        criteriaQuery
                .select(root)
                .where(
                        cb.and(
                                cb.equal(root.get("establecimiento"), establecimientoId)
                        )
                );
        return entityManager().createQuery(criteriaQuery).getResultList();
    }
}
