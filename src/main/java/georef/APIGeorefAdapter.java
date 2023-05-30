package georef;

import georef.entidadesMolde.*;

import java.io.IOException;

//interfaz para traer los datos de la api porque podria ser implementada con distintas bibliotecas
public interface APIGeorefAdapter {

    ListadoDeProvincias listaProvincias() throws IOException;

    ListadoDeMunicipios listaMunicipios(int provinciaId) throws IOException;

    ListadoDeDepartamentos listaDepartamentos(int provinciaId) throws IOException;
}
