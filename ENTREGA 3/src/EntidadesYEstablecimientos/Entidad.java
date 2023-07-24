package EntidadesYEstablecimientos;

import Servicios.Monitoreable;
import Ranking.*;

import java.util.List;

public abstract class Entidad {
    private EmpresaPrestadora empresaPrestadora;
    private OrganismoDeControl organismoDeControl;
    private List<InformeIncidente> informes;
    private Double PromedioCierreIncidentes;
    private int cantidadIncidentes;

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

    public List<InformeIncidente> getInformes() {
        return informes;
    }

    public void setInformes(List<InformeIncidente> informes) {
        this.informes = informes;
    }
}