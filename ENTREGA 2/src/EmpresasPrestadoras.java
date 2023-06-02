public class EmpresasPrestadoras {
    private String nombre;
    private Integer cuit;
    private UsuarioEmpresarial personaACargo;
    public EmpresasPrestadoras(String nombrePersona, Integer cuitPersona, UsuarioEmpresarial persona) {
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
