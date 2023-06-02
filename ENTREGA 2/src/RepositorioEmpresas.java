import java.util.ArrayList;
import java.util.List;

public class RepositorioEmpresas {
    private List<OrganismoDeControl> organismosDeControl;
    private List<EmpresasPrestadoras> empresasPrestadoras;

    public RepositorioEmpresas() {
        this.organismosDeControl = new ArrayList<>();
        this.empresasPrestadoras = new ArrayList<>();
    }

    public void agregarOrganismoDeControl(OrganismoDeControl nuevoOrganismo) {
        organismosDeControl.add(nuevoOrganismo);
    }

    public void agregarPrestadora(EmpresasPrestadoras nuevaPrestadora) {
        empresasPrestadoras.add(nuevaPrestadora);
    }
}
