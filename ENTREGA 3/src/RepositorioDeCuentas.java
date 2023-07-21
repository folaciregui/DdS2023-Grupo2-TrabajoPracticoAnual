import java.util.List;
import java.util.Optional;

public class RepositorioDeCuentas {
    private List<Cuenta> cuentas;

    public RepositorioDeCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public Cuenta buscarCuenta(String nombreIdentificador) throws Exception {
        Optional<Cuenta> cuentaOptional = cuentas.stream()
                .filter(cuenta -> cuenta.getNombreIdentificador().equals(nombreIdentificador))
                .findFirst();

        if (cuentaOptional.isPresent()) {
            return cuentaOptional.get();
        } else {
            throw new Exception();
        }
    }

}
