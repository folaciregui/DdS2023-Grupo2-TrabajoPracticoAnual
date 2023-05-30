package georef.entidadesMolde;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Departamento {

    //TODO verificar bien esta clase molde en el json
    public String nombre;
    public int id;
    public Municipio municipio;

    public Departamento() {
    }

    public Departamento(String nombre, int id, Municipio municipio) {
        this.nombre = nombre;
        this.id = id;
        this.municipio = municipio;
    }
}
