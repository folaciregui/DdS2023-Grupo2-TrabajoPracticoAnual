package Georef.entidadesMolde;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Municipio {

    public String nombre;
    public int id;
    public Provincia provincia;

    public Municipio() {
    }

    public Municipio(String nombre, int id, Provincia provincia) {
        this.nombre = nombre;
        this.id = id;
        this.provincia = provincia;
    }
}