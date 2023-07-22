package EntidadesYEstablecimientos;

public abstract class Entidad {
    private EmpresaPrestadora empresaPrestadora;
    private OrganismoDeControl organismoDeControl;
    private List<InformeIncidente> informes;
    private Double PromedioCierreIncidentes;

    public void actualizacionDatos(EmpresaPrestadora empresaPrestadora) {
        //TODO
        return;
    }

    public void actualizacionDatos(OrganismoDeControl organismoDeControl) {
        //TODO
        return;
    }

    public List<Monitoreable> getMonitoreables(){
    }
    public Double getPromedioCierreIncidentes(){
        return this.PromedioCierreIncidentes;
    }
    public void setPromedioCierreIncidentes(Double promedio){
        this.PromedioCierreIncidentes = promedio,
    }
}