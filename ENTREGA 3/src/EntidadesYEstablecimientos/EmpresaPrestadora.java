package EntidadesYEstablecimientos;

import UsuariosYComunidades.UsuarioEmpresarial;
import Servicios.*;
import UsuariosYComunidades.UsuarioPersonal;

public class EmpresaPrestadora {
    private String nombre;
    private Integer cuit;
    private UsuarioEmpresarial personaACargo;
    private Entidad entidadAsociada;
    public EmpresaPrestadora(String nombrePersona, Integer cuitPersona, UsuarioEmpresarial persona) {
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

    public Incidente registrarIncidente(Monitoreable unMonitoreable, UsuarioPersonal unUsuario){
        return new Incidente(unMonitoreable, unUsuario);
    }

    public void solicitarInforme(){
        //TODO

        return;
    }
}
