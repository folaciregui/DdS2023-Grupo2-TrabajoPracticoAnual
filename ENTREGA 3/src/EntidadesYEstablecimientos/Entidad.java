package EntidadesYEstablecimientos;

import Servicios.Monitoreable;
import Ranking.*;

import java.util.List;

public abstract class Entidad {
    private EmpresaPrestadora empresaPrestadora;
    private OrganismoDeControl organismoDeControl;
    private List<InformeIncidente> informes;
    private Double PromedioCierreIncidentes;


    public List<Monitoreable> getMonitoreables(){
    }
    public Double getPromedioCierreIncidentes(){
        return this.PromedioCierreIncidentes;
    }
    public void setPromedioCierreIncidentes(Double promedio){
        this.PromedioCierreIncidentes = promedio,
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