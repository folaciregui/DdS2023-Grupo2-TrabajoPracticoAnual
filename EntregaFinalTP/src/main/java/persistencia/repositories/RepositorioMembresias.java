package persistencia.repositories;

import dominio.usuariosycomunidades.Comunidad;
import dominio.usuariosycomunidades.Membresia;
import dominio.usuariosycomunidades.RolDeImpacto;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.sound.midi.MetaMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
                                cb.equal(root.get("usuario").get("id"), id)
                        )
                );
        return entityManager().createQuery(criteriaQuery).getResultList();
        /*
        List<Membresia> membresias = this.buscarTodos();
        List<Membresia> membresiasFiltradas = new ArrayList<>();

        for(Membresia m : membresias){
            if(Objects.equals(m.getUsuario().getId(), id)){
                membresiasFiltradas.add(m);
            }
        }

        return membresiasFiltradas;*/
    }


    public Membresia encontrarMembresia(Integer usuarioId, Integer comunidadId, RolDeImpacto rol) {
        CriteriaBuilder cb = entityManager().getCriteriaBuilder();
        CriteriaQuery<Membresia> criteriaQuery = cb.createQuery(Membresia.class);
        Root<Membresia> root = criteriaQuery.from(Membresia.class);

        criteriaQuery
                .select(root)
                .where(
                        cb.and(
                                cb.equal(root.get("usuario").get("id"), usuarioId),
                                cb.equal(root.get("comunidad").get("id"), comunidadId)
                        )
                );

        return entityManager().createQuery(criteriaQuery).getSingleResult();


    }

    public void cambiarRol(Membresia membresia) {
        EntityTransaction tx = entityManager().getTransaction();
        tx.begin();

        if(membresia.getRolDeImpacto() == RolDeImpacto.AFECTADO){
            membresia.setRolDeImpacto(RolDeImpacto.OBSERVADOR);
        }
        else if(membresia.getRolDeImpacto() == RolDeImpacto.OBSERVADOR){
            membresia.setRolDeImpacto(RolDeImpacto.AFECTADO);
        }

        entityManager().merge(membresia);
        tx.commit();
    }
}
