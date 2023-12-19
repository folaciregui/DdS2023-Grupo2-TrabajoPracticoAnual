package persistencia.repositories;

import dominio.entidades.EmpresaPrestadora;
import dominio.usuariosycomunidades.UsuarioGeneral;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;

import javax.persistence.EntityTransaction;
import java.util.List;

public class RepositorioUsuariosGenerales implements WithSimplePersistenceUnit, ICrudRepository {


    public Object buscarPorCorreoElectronico(String correo) {
        return entityManager().find(UsuarioGeneral.class, correo);
    }

    public Integer buscar(UsuarioGeneral usuarioGeneral){
        return entityManager().find(UsuarioGeneral.class, usuarioGeneral.getId()).getId();
    }

    @Override
    public List<UsuarioGeneral> buscarTodos() {

        return entityManager().createQuery("from " + UsuarioGeneral.class.getName()).getResultList();
    }

    @Override
    public Object buscar(Long id) {
        return null;
    }

    public UsuarioGeneral buscarPorId(Integer id) {
        return entityManager().find(UsuarioGeneral.class, id);
    }

    public UsuarioGeneral buscarPorEmail(String email){
        return entityManager().find(UsuarioGeneral.class, email);
    }

    @Override
    public void guardar(Object o) {
        EntityTransaction tx = entityManager().getTransaction();
        if(!tx.isActive())
            tx.begin();

        entityManager().persist(o);
        tx.commit();
    }

    @Override
    public void actualizar(Object o) {

    }

    @Override
    public void eliminar(Object o) {

    }

    public void actualizarPerfil(UsuarioGeneral usuarioGeneral) {
        EntityTransaction tx = entityManager().getTransaction();
        tx.begin();
        entityManager().merge(usuarioGeneral);
        tx.commit();
    }
}
