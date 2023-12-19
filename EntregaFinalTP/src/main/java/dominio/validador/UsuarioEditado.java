package dominio.validador;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioEditado {
    private Integer id;
    private String nombre;
    private String apellido;
    private String email;
    private String contrasenia;
}
