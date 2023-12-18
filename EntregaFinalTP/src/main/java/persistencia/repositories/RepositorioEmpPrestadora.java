package persistencia.repositories;

import dominio.entidades.EmpresaPrestadora;
import dominio.entidades.Entidad;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;

import javax.persistence.EntityTransaction;
import java.util.List;

public class RepositorioEmpPrestadora implements WithSimplePersistenceUnit {


    public void agregar(EmpresaPrestadora empresaPrestadora){
        //Entidad unaEntidad = new Entidad();
        //unaEntidad.setNombre("Supermercado");

        EntityTransaction tx = entityManager().getTransaction();
        tx.begin();
        entityManager().persist(empresaPrestadora); // INSERT INTO ...
        tx.commit();
    }

    public List<EmpresaPrestadora> buscarTodos(){
        return entityManager().createQuery("from " + EmpresaPrestadora.class.getName()).getResultList();
    }
}
