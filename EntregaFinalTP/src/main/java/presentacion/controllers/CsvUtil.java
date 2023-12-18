package presentacion.controllers;

import dominio.entidades.EmpresaPrestadora;
import dominio.entidades.Entidad;
import dominio.entidades.OrganismoDeControl;
import dominio.entidades.TipoDeEntidad;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvUtil {

    //private static BufferedReader lector;
    private static String linea;
    private static String[] partes = null;

    public static List<Entidad> parseCsv(String pathArchivo) throws IOException {
        List<Entidad> entidades = new ArrayList<>();

        try (BufferedReader lector = new BufferedReader(new FileReader(pathArchivo))){
            //lector = new BufferedReader(new FileReader(inputStream));
            while((linea = lector.readLine()) != null){
                partes = linea.split(";");
                Entidad entidad = new Entidad();
                entidad.setNombre(partes[0]);

                EmpresaPrestadora empresaPrestadora = new EmpresaPrestadora();
                empresaPrestadora.setNombre(partes[1]);
                empresaPrestadora.setCuit(partes[2]);
                entidad.setEmpresaPrestadora(empresaPrestadora);

                OrganismoDeControl organismoDeControl = new OrganismoDeControl();
                organismoDeControl.setNombre(partes[3]);
                organismoDeControl.setCuit(partes[4]);
                entidad.setOrganismoDeControl(organismoDeControl);

                entidad.setTipoDeEntidad(TipoDeEntidad.valueOf(partes[5]));

                entidades.add(entidad);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error al leer el archivo CSV", e);
        }


        /*try (Reader reader = new Reader(new InputStreamReader(inputStream))) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                if (line.length == 3) {
                    Empleado empleado = new Empleado();
                    empleado.setNombre(line[0]);
                    empleado.setApellido(line[1]);
                    empleado.setDni(line[2]);
                    empleados.add(empleado);
                } else {
                    // Manejar líneas con formato incorrecto
                }
            }
        }*/

        return entidades;
    }
}
