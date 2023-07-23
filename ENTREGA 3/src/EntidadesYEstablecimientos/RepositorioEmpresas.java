package EntidadesYEstablecimientos;

import java.util.ArrayList;
import java.util.List;

public class RepositorioEmpresas {
    private List<OrganismoDeControl> organismosDeControl;
    private List<EmpresaPrestadora> empresasPrestadoras;

    public RepositorioEmpresas() {
        this.organismosDeControl = new ArrayList<>();
        this.empresasPrestadoras = new ArrayList<>();
    }

    public void agregarOrganismoDeControl(OrganismoDeControl nuevoOrganismo) {
        organismosDeControl.add(nuevoOrganismo);
    }

    public void agregarPrestadora(EmpresaPrestadora nuevaPrestadora) {
        empresasPrestadoras.add(nuevaPrestadora);
    }
}
