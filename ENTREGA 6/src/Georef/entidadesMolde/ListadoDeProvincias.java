package Georef.entidadesMolde;

import java.util.List;

public class ListadoDeProvincias {
    //atributos en publico porque son clasees molde que va utilizar Retrofit después
    public int cantidad;
    public int incio;
    public Parametro parametros;
    public int total;
    public List<Provincia> provincias;

    //los query params que puedo pedir
    private class Parametro {
        public List<String> campos;
    }
}
