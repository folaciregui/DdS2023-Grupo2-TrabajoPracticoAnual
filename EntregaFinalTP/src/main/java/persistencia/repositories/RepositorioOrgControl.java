package persistencia.repositories;

import dominio.entidades.EmpresaPrestadora;
import dominio.entidades.Entidad;
import dominio.entidades.OrganismoDeControl;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;

import javax.persistence.EntityTransaction;
import java.util.List;

public class RepositorioOrgControl implements WithSimplePersistenceUnit {

    public void agregar(OrganismoDeControl organismoDeControl){
        //Entidad unaEntidad = new Entidad();
        //unaEntidad.setNombre("Supermercado");

        EntityTransaction tx = entityManager().getTransaction();
        tx.begin();
        entityManager().persist(organismoDeControl); // INSERT INTO ...
        tx.commit();
    }
    public List<OrganismoDeControl> buscarTodos(){
        return entityManager().createQuery("from " + OrganismoDeControl.class.getName()).getResultList();
    }
}
