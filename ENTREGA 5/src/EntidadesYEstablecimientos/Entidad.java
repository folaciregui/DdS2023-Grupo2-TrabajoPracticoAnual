package EntidadesYEstablecimientos;

import Servicios.Incidente;
import Servicios.Monitoreable;
import Ranking.*;

import java.util.List;
@Entity
public abstract class Entidad {
    @Column
    private EmpresaPrestadora empresaPrestadora;
    @Column
    private OrganismoDeControl organismoDeControl;
    @Column
    private List<InformeIncidente> informes;
    @Column
    private Double PromedioCierreIncidentes;
    @Column
    private int cantidadIncidentes;
    @Id
    private Long id_Entidad;

    public int getCantidadIncidentes(){
        return cantidadIncidentes;
    }
    public void setCantidadIncidentes(int nuevaCantidad){
        this.cantidadIncidentes = nuevaCantidad;
    }
    public List<Monitoreable> getMonitoreables(){
        return null;
    }
    public Double getPromedioCierreIncidentes(){
        return this.PromedioCierreIncidentes;
    }
    public void setPromedioCierreIncidentes(Double promedio){
        this.PromedioCierreIncidentes = promedio;
    }

    public EmpresaPrestadora getEmpresaPrestadora() {
        return empresaPrestadora;
    }

    public void setEmpresaPrestadora(EmpresaPrestadora empresaPrestadora) {
        this.empresaPrestadora = empresaPrestadora;
    }

    public OrganismoDeControl getOrganismoDeControl() {
        return organismoDeControl;
    }

    public void setOrganismoDeControl(OrganismoDeControl organismoDeControl) {
        this.organismoDeControl = organismoDeControl;
    }

    public abstract List<Incidente> getIncidentesInactivos();
    public List<InformeIncidente> getInformes() {
        return informes;
    }

    public void setInformes(List<InformeIncidente> informes) {
        this.informes = informes;
    }
}