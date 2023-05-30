
import georef.ServicioGeoref;
import georef.ServicioGeorefRetrofitAdapter;
import georef.entidadesMolde.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;



public class GeorefTest {
    ListadoDeProvincias listaProvinciasArgentina;
    ListadoDeMunicipios listaMunicipiosDeBuenosAires;
    ListadoDeDepartamentos listaDepartamentosDeBuenosAires;

    @BeforeEach
    public void init() throws IOException {
        ServicioGeoref servicioGeoref = ServicioGeoref.instancia();
        servicioGeoref.setAdapter(new ServicioGeorefRetrofitAdapter());
        listaProvinciasArgentina = servicioGeoref.listaProvincias();
        listaMunicipiosDeBuenosAires = servicioGeoref.listaMunicipios(06);
        listaDepartamentosDeBuenosAires = servicioGeoref.listaDepartamentos(06);
    }

    @Test
    @DisplayName("Listado Provincias de Argentina")
    public void listadoProvincias() {
        for (Provincia provincia : listaProvinciasArgentina.provincias) {
            System.out.println(provincia.nombre);
        }
        Assertions.assertTrue(true);
    }

    //TODO falta ver eso de que solo me trae algunos
    @Test
    @DisplayName("Listado Municipios de Buenos Aires")
    public void listadoMunicipiosBsAs() {
        for (Municipio municipio : listaMunicipiosDeBuenosAires.municipios) {
            System.out.println(municipio.nombre);
        }
        Assertions.assertTrue(true);
    }

    //TODO falta ver eso de que solo me trae algunos
    @Test
    @DisplayName("Listado Departamentos de Buenos Aires")
    public void listadoDepartamentosBsAs() {
        for (Departamento departamento : listaDepartamentosDeBuenosAires.departamentos) {
            System.out.println(departamento.nombre);
        }
        Assertions.assertTrue(true);
    }
}
