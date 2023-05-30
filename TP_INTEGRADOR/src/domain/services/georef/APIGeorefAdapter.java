package domain.services.georef;

import domain.services.georef.entidadesMolde.Municipio;
import domain.services.georef.entidadesMolde.Provincia;

import java.io.IOException;
import java.util.List;

//interfaz para traer los datos de la api porque podria ser implementada de distintas formas
public interface APIGeorefAdapter {

    //falta listaDepartamentos()

    List<Provincia> listaProvincias() throws IOException;

    List<Municipio> listaMunicipios(int provinciaId) throws IOException;
}
