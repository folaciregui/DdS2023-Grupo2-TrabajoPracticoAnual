package georef;

import georef.entidadesMolde.*;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

//clase que trae los datos de la api con retrofit
public class ServicioGeorefRetrofitAdapter implements APIGeorefAdapter {
    private static final int maximaCantidadRegistrosDefault = 200;
    private final String urlApi = "https://apis.datos.gob.ar/georef/api/";
    private final Retrofit retrofit;

    public ServicioGeorefRetrofitAdapter() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(urlApi)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    //falta listaDepartamentos()

    @Override
    public ListadoDeProvincias listaProvincias() throws IOException {
        GeorefService georefservice = this.retrofit.create(GeorefService.class);
        Call<ListadoDeProvincias> requestProvincias = georefservice.provincias();
        Response<ListadoDeProvincias> responseProvincias = requestProvincias.execute();
        return responseProvincias.body();
    }

    @Override
    public ListadoDeMunicipios listaMunicipios(int provinciaId) throws IOException {
        GeorefService georefservice = this.retrofit.create(GeorefService.class);
        Call<ListadoDeMunicipios> requestMunicipios = georefservice.municipios(provinciaId);
        Response<ListadoDeMunicipios> responseMunicipios = requestMunicipios.execute();
        return responseMunicipios.body();
    }

    @Override
    public ListadoDeDepartamentos listaDepartamentos(int provinciaId) throws IOException {
        GeorefService georefservice = this.retrofit.create(GeorefService.class);
        Call<ListadoDeDepartamentos> requestDepartamentos = georefservice.departamentos(provinciaId);
        Response<ListadoDeDepartamentos> responseDepartamentos = requestDepartamentos.execute();
        return responseDepartamentos.body();
    }

}
