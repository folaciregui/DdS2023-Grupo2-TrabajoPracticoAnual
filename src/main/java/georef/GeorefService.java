package georef;

import georef.entidadesMolde.*;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

//interfaz que utiliza retrofit para matchear con la api, se definen las request http que pueden ir a georef despues de la url base
public interface GeorefService {

    //falta departamentos

    @GET("provincias")
    Call<ListadoDeProvincias> provincias();

    @GET("provincias")
    Call<ListadoDeProvincias> provincias (@Query("campos") String campos);

    @GET("municipios")
    Call<ListadoDeMunicipios> municipios (@Query("provincia") int provinciaId);

    @GET("departamentos")
    Call<ListadoDeDepartamentos> departamentos (@Query("provincia") int provinciaId);
}
