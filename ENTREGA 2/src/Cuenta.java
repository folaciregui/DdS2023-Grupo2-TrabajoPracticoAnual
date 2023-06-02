public class Cuenta {
    private UsuarioGeneral usuario;
    private String nombreIdentificador;
    private String password;

    public Cuenta(UsuarioGeneral usuario, String nombreIdentificador, String password) {
        this.usuario = usuario;
        this.nombreIdentificador = nombreIdentificador;
        this.password = password;
    }

    public String getNombreIdentificador() {
        return nombreIdentificador;
    }
}
