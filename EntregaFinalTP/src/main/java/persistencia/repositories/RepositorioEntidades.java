package persistencia.repositories;

import dominio.entidades.EmpresaPrestadora;
import dominio.entidades.Entidad;
import dominio.entidades.OrganismoDeControl;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;

import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.Objects;

public class RepositorioEntidades implements WithSimplePersistenceUnit {

    RepositorioEmpPrestadora repositorioEmpPrestadora = new RepositorioEmpPrestadora();
    RepositorioOrgControl repositorioOrgControl = new RepositorioOrgControl();
    public void agregar(Entidad entidad){
        EntityTransaction tx = entityManager().getTransaction();
        tx.begin();
        entityManager().persist(entidad); // INSERT INTO ...
        tx.commit();
    }

    public void guardarTodas(List<Entidad> entidades){
        for (Entidad e : entidades) {
            if(!this.existeEmpresaPrestadora(e) && !this.existeOrganismoControl(e)){
                // creo ambos
                repositorioOrgControl.agregar(e.getOrganismoDeControl());
                repositorioEmpPrestadora.agregar(e.getEmpresaPrestadora());
            }
            else if(this.existeEmpresaPrestadora(e) && !this.existeOrganismoControl(e)){
                // creo org control
                repositorioOrgControl.agregar(e.getOrganismoDeControl());
            }
            else if(!this.existeEmpresaPrestadora(e) && this.existeOrganismoControl(e)){
                // creo empresa prestadora
                repositorioEmpPrestadora.agregar(e.getEmpresaPrestadora());
            }
            else if(this.existeEmpresaPrestadora(e) && this.existeOrganismoControl(e)){
                // TODO
            }
            this.agregar(e);

        }
    }

    public boolean existeEmpresaPrestadora(Entidad e){
        List<EmpresaPrestadora> empresasPrestadoras = repositorioEmpPrestadora.buscarTodos();
        EmpresaPrestadora ep_entidad = e.getEmpresaPrestadora();

        for(EmpresaPrestadora ep : empresasPrestadoras){
            if(Objects.equals(ep_entidad.getNombre(), ep.getNombre())){
                return true;
            }
        }
        return false;
    }

    public boolean existeOrganismoControl(Entidad e){
        List<OrganismoDeControl> organismoDeControls = repositorioOrgControl.buscarTodos();
        OrganismoDeControl oc_entidad = e.getOrganismoDeControl();

        for(OrganismoDeControl oc : organismoDeControls){
            if(Objects.equals(oc_entidad.getNombre(), oc.getNombre())){
                return true;
            }
        }
        return false;

    }
    public void eliminar(Entidad entidad){

    }
    public void modificar(Entidad entidad){

    }
    public void buscarPorId(Integer id){

    }
    public List<Entidad> buscarTodos(){
        return entityManager().createQuery("from " + Entidad.class.getName()).getResultList();
    }

}
