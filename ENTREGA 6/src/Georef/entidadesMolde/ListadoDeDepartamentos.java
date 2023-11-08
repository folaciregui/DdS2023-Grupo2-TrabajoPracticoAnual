package Georef.entidadesMolde;

import java.util.List;

public class ListadoDeDepartamentos {
    //atributos en publico porque son clasees molde que va utilizar Retrofit después
    public int cantidad;
    public int incio;
    public Parametro parametros;
    public int total;
    public List<Departamento> departamentos;

    private class Parametro {
        public List<String> campos;
        public int max;
        public List<String> provincia;
    }
}