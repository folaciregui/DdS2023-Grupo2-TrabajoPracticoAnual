package domain.services.georef;

import domain.services.georef.entidadesMolde.Municipio;
import domain.services.georef.entidadesMolde.Provincia;

import java.io.IOException;
import java.util.List;

//la clase posta a la que voy a llamar para traer las listas de departamentos, municipios y provincias
public class ServicioGeoref {
    private static ServicioGeoref instancia = null;
    private APIGeorefAdapter adapter;


    private ServicioGeoref() {
        adapter = new ServicioGeorefRetrofitAdapter();
    }

    public void setAdapter(APIGeorefAdapter adapter) {
        this.adapter = adapter;
    }

    public static ServicioGeoref instancia(){
        if(instancia== null){
            instancia = new ServicioGeoref();
        }
        return instancia;
    }

    public List<Provincia> listaProvincias() {
        try {
            return this.adapter.listaProvincias();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Municipio> listaMunicipios(int provinciaId) {
        try {
            return this.adapter.listaMunicipios(provinciaId);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
