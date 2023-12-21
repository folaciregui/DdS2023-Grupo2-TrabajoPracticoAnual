package persistencia.repositories;

import dominio.entidades.Entidad;
import dominio.entidades.Establecimiento;
import dominio.servicios.Estado;
import dominio.servicios.Incidente;
import dominio.servicios.Servicio;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RepositorioIncidentes implements WithSimplePersistenceUnit {

    private RepositorioEstablecimientos repositorioEstablecimientos = new RepositorioEstablecimientos();
    private RepositorioServicios repositorioServicios = new RepositorioServicios();

    public void agregar(Incidente incidente){
        EntityTransaction tx = entityManager().getTransaction();
        tx.begin();
        entityManager().persist(incidente); // INSERT INTO ...
        tx.commit();
    }
    public void mergear(Incidente incidente){
        EntityTransaction tx = entityManager().getTransaction();
        tx.begin();
        Incidente incidenteGestionado = entityManager().merge(incidente);
        entityManager().persist(incidenteGestionado);
        tx.commit();
    }
    public List<Incidente> buscarTodos(){
        return entityManager().createQuery("from " + Incidente.class.getName()).getResultList();
    }

    public List<Incidente> buscarPorEntidadEstablecimiento(Integer entidadId, Integer establecimientoId) {

        List<Establecimiento> establecimientosPorEntidad = this.repositorioEstablecimientos.buscarPorEntidad(entidadId);

        List<Servicio> servicios = this.repositorioServicios.buscarTodos();
        List<Servicio> serviciosFiltrados = new ArrayList<>();

        for(Servicio s : servicios){
            for(Establecimiento e : establecimientosPorEntidad){
                if(s.getEstablecimiento() == e && Objects.equals(e.getId(), establecimientoId)){
                    serviciosFiltrados.add(s);
                }
            }
        }

        List<Incidente> incidentes = this.buscarTodos();
        List<Incidente> incidentesFiltrados = new ArrayList<>();

        for(Incidente i : incidentes){
            for(Servicio s : serviciosFiltrados){
                if(i.getServicio() == s && i.getEstado() == Estado.ABIERTO){
                    incidentesFiltrados.add(i);
                }
            }
        }

        return incidentesFiltrados;
    }

    public Incidente buscarPorId(Integer incidenteId) {
        CriteriaBuilder cb = entityManager().getCriteriaBuilder();
        CriteriaQuery<Incidente> criteriaQuery = cb.createQuery(Incidente.class);
        Root<Incidente> root = criteriaQuery.from(Incidente.class);

        criteriaQuery
                .select(root)
                .where(
                        cb.and(
                                cb.equal(root.get("id"), incidenteId)
                        )
                );
        return entityManager().createQuery(criteriaQuery).getSingleResult();
    }

    public void actualizarEstadoIncidente(Incidente incidente) {

        EntityTransaction tx = entityManager().getTransaction();
        tx.begin();

        Incidente incidenteEnBaseDeDatos = entityManager().find(Incidente.class, incidente.getId());
        if (incidenteEnBaseDeDatos != null) {
            incidenteEnBaseDeDatos.setEstado(Estado.CERRADO);

            entityManager().merge(incidenteEnBaseDeDatos);
            tx.commit();

        }
    }

    public List<Incidente> buscarTodosLosAbiertos() {
        List<Incidente> incidentes = entityManager().createQuery("from " + Incidente.class.getName()).getResultList();

        List<Incidente> incidentesFiltrados = new ArrayList<>();

        for(Incidente i : incidentes){
            if(i.getEstado() == Estado.ABIERTO){
                incidentesFiltrados.add(i);
            }
        }
        return incidentesFiltrados;
    }

    public Integer buscarMayorId() {
        Integer mayorId = 0;
        List<Incidente> incidentes = this.buscarTodos();

        for(Incidente i : incidentes){
            if(i.getId() > mayorId){
                mayorId = i.getId();
            }
        }
        System.out.println("el mayor id es " + mayorId);
        return mayorId;
    }
}
