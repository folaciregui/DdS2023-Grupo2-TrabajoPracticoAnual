package persistencia.repositories;


import dominio.entidades.Entidad;
import dominio.validador.Cuenta;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;

import javax.persistence.EntityTransaction;
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
}
