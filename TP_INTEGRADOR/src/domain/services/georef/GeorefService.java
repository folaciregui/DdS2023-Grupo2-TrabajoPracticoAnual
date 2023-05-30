package domain.services.georef;

import domain.services.georef.entidadesMolde.Municipio;
import domain.services.georef.entidadesMolde.Provincia;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

//interfaz que utiliza retrofit para matchear con la api, se definen las request http que pueden ir a georef despues de la url base
public interface GeorefService {

    //falta departamentos

    @GET("municipios")
    Call<List<Municipio>> municipios(@Query("provincia") int provinciaId);

    @GET("provincias")
    Call<List<Provincia>> provincias();

}
