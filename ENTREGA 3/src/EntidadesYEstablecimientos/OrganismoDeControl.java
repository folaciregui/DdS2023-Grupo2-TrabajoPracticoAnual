package EntidadesYEstablecimientos;
import UsuariosYComunidades.*;
import UsuariosYComunidades.UsuarioEmpresarial;

public class OrganismoDeControl {
    private String nombre;
    private Integer cuit;
    private UsuarioEmpresarial personaACargo;
    public OrganismoDeControl(String nombrePersona, Integer cuitPersona, UsuarioEmpresarial persona) {
        this.setCuit(cuitPersona);
        this.setNombre(nombrePersona);
        this.setPersonaACargo(persona);
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCuit(Integer cuit) {
        this.cuit = cuit;
    }

    public void setPersonaACargo(UsuarioEmpresarial personaACargo) {
        this.personaACargo = personaACargo;
    }
}