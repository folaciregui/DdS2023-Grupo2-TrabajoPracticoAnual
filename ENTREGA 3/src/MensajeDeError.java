public class MensajeDeError {
    public static String convertirCodigoDeError(int codError) {
        switch (codError) {
            case CodigoDeError.E_POCOS_CARACTERES:
                return "La password debe tener mas de 12 caracteres.";
            case CodigoDeError.E_MAYUSCULAS:
                return "La password debe tener al menos un caracter en mayuscula.";
            case CodigoDeError.E_MINUSCULAS:
                return "La password debe tener al menos un caracter en minuscula.";
            case CodigoDeError.E_NUMERO:
                return "La password debe tener al menos un numero.";
            case CodigoDeError.E_CARACTER_ESPECIAL:
                return "La password debe tener al menos alguno de los siguientes caracteres: @#$%";    
            case CodigoDeError.E_CONTRASENA_DEBIL:
                return "La password es demasiado comun.";
            case CodigoDeError.E_RECURSO:
                return "Ocurrió un error al abrir o leer el recurso.";
            case CodigoDeError.EXITO:
                return "Se pudo registrar el usuario correctamente.";
        }
        return null;
    }
}
