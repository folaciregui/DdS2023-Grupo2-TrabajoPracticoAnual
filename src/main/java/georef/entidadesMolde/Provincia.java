package georef.entidadesMolde;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Provincia {
    //TODO verificar bien esta clase molde en el json
    public int id;
    public String nombre;

    public Provincia() {
    }

    public Provincia(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}
