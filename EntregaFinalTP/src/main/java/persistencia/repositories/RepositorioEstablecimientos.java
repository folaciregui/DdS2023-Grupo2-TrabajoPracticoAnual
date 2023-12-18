package persistencia.repositories;

import dominio.entidades.Entidad_X_Establecimiento;
import dominio.entidades.Establecimiento;
import dominio.usuariosycomunidades.Membresia;
import dominio.usuariosycomunidades.UsuarioGeneral;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class RepositorioEstablecimientos implements WithSimplePersistenceUnit {
    public List<Establecimiento> buscarTodos(){
        return entityManager().createQuery("from " + Establecimiento.class.getName()).getResultList();
    }

    public List<Establecimiento> buscarPorEntidad(Integer entidadId) {
        CriteriaBuilder cb = entityManager().getCriteriaBuilder();
        CriteriaQuery<Entidad_X_Establecimiento> criteriaQuery = cb.createQuery(Entidad_X_Establecimiento.class);
        Root<Entidad_X_Establecimiento> root = criteriaQuery.from(Entidad_X_Establecimiento.class);

        criteriaQuery
                .select(root)
                .where(
                        cb.and(
                                cb.equal(root.get("entidad"), entidadId)
                        )
                );
        List<Entidad_X_Establecimiento> establecimientosFiltradosPorEntidad = entityManager().createQuery(criteriaQuery).getResultList();

        List<Establecimiento> establecimientos = new ArrayList<>();

        for(Entidad_X_Establecimiento ee : establecimientosFiltradosPorEntidad){
            establecimientos.add(this.buscarPorId(ee));
        }

        return establecimientos;
    }

    public Establecimiento buscarPorId(Entidad_X_Establecimiento ee){
        Integer id_establecimiento = ee.getEstablecimiento().getId();
        return entityManager().find(Establecimiento.class, id_establecimiento);
    }
}
