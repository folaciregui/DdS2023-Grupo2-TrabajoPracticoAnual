package georef;

import georef.entidadesMolde.*;

import java.io.IOException;

//la clase posta a la que voy a llamar para traer las listas de departamentos, municipios y provincias
public class ServicioGeoref {
    private static ServicioGeoref instancia = null;
    private APIGeorefAdapter adapter;

    //seteo retrofit como default
    private ServicioGeoref() {
        adapter = new ServicioGeorefRetrofitAdapter();
    }

    //pero si quiero puedo cambiar Retrofit por otra biblioteca
    public void setAdapter(APIGeorefAdapter adapter) {
        this.adapter = adapter;
    }

    public static ServicioGeoref instancia(){
        if(instancia== null){
            instancia = new ServicioGeoref();
        }
        return instancia;
    }

    public ListadoDeProvincias listaProvincias() {
        try {
            return this.adapter.listaProvincias();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public ListadoDeMunicipios listaMunicipios(int provinciaId) {
        try {
            return this.adapter.listaMunicipios(provinciaId);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public ListadoDeDepartamentos listaDepartamentos(int provinciaId) {
        try {
            return this.adapter.listaDepartamentos(provinciaId);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
