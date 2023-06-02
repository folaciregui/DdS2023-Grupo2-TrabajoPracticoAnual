import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class Cargador {
    private RepositorioDeCuentas repoCuentas;
    private RepositorioEmpresas repoEmpresas;
    public Cargador(RepositorioDeCuentas repoCuentas) { //constructor para tener asegurado el repo cargado
        this.repoCuentas = repoCuentas;
        this.repoEmpresas = new RepositorioEmpresas();
    }
    public RepositorioEmpresas cargarRepoEmpresasConCSV(String direccionDelCsv) throws Exception {
        try (FileReader fileReader = new FileReader(direccionDelCsv);
             CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT)) {
            String nombreIdentificador;
            OrganismoDeControl nuevoOrganismo;
            EmpresasPrestadoras nuevaPrestadora;
            TipoOrganismo tipoOrganismo;
            for (CSVRecord csvRecord : csvParser) {
                String tipoOrganismoCSV = csvRecord.get("TipoOrganismo");
                try {
                    tipoOrganismo = TipoOrganismo.valueOf(tipoOrganismoCSV);
                } catch (IllegalArgumentException e) {
                    // El valor del CSV no coincide con ningún valor del enum
                    continue; // Saltar al siguiente registro del CSV
                }
                String nombreOrganismo = csvRecord.get("NombreOrganismo");
                Integer cuit = Integer.parseInt(csvRecord.get("CUIT"));
                String nombrePersona = csvRecord.get("NombrePersonaACargo");
                String apellidoPersona = csvRecord.get("ApellidoPersonaACargo");
                String correoElectronico = csvRecord.get("CorreoElectronico");
                nombreIdentificador = csvRecord.get("IdentificadorCuentaOrgDeControl");
                TipoDeNotificacion tipoNotif = TipoDeNotificacion.valueOf(csvRecord.get("TipoNotificacion"));
                FrecuenciaDeNotificacion frecNotif = FrecuenciaDeNotificacion.valueOf(csvRecord.get("FrecuenciaNotificacion"));

                //compruebo si existe la cuenta
                try {
                    Cuenta cuenta = repoCuentas.buscarCuenta(nombreIdentificador);
                    UsuarioEmpresarial personaACargo = new UsuarioEmpresarial(nombrePersona, apellidoPersona, cuenta, correoElectronico, tipoNotif, frecNotif);

                    if (tipoOrganismo == TipoOrganismo.PRESTADORA) {
                        nuevaPrestadora = new EmpresasPrestadoras(nombreOrganismo, cuit, personaACargo);
                       repoEmpresas.agregarPrestadora(nuevaPrestadora);
                    } else if (tipoOrganismo == TipoOrganismo.ORGCONTROL) {
                        nuevoOrganismo = new OrganismoDeControl(nombreOrganismo, cuit, personaACargo);
                        repoEmpresas.agregarOrganismoDeControl(nuevoOrganismo);
                    }
                } catch (Exception e) {
                    throw e;
                }
            }
        } catch (IOException e) {
                throw e;
            }
            return repoEmpresas;
    }
}

