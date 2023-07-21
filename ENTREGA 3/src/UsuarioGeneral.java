public class UsuarioGeneral {
    private String nombre;
    private String apellido;
    private Cuenta cuenta;
    private String correoElectronico;

    public UsuarioGeneral(String nombreUsuario, String apellidoUsuario, Cuenta cuentaUsuario, String correoElectronicoUsuario) {
        this.nombre = nombreUsuario;
        this.apellido = apellidoUsuario;
        this.cuenta = cuentaUsuario;
        this.correoElectronico = correoElectronicoUsuario;
    }
}
