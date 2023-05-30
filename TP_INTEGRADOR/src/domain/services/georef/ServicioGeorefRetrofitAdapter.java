package domain.services.georef;

import domain.services.georef.entidadesMolde.Municipio;
import domain.services.georef.entidadesMolde.Provincia;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

//clase que trae los datos de la api con retrofit
public class ServicioGeorefRetrofitAdapter implements APIGeorefAdapter {
    private static int maximaCantidadRegistrosDefault = 200;
    private String urlApi = "https://apis.datos.gob.ar/georef/api/";
    private Retrofit retrofit;

    public ServicioGeorefRetrofitAdapter() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(urlApi)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    //falta listaDepartamentos()

    @Override
    public List<Provincia> listaProvincias() throws IOException {
        GeorefService georefservice = this.retrofit.create(GeorefService.class);
        Call<List<Provincia>> requestProvincias = georefservice.provincias();
        Response<List<Provincia>> responseProvincias = requestProvincias.execute();
        return responseProvincias.body();
    }

    @Override
    public List<Municipio> listaMunicipios(int provinciaId) throws IOException {
        GeorefService georefservice = this.retrofit.create(GeorefService.class);
        Call<List<Municipio>> requestMunicipios = georefservice.municipios(provinciaId);
        Response<List<Municipio>> responseMunicipios = requestMunicipios.execute();
        return responseMunicipios.body();

    }

}
