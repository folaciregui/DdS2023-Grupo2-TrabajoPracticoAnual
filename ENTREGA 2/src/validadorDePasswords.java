import java.io.*;
import java.net.*;
import java.util.Objects;
import java.util.Scanner;
public class validadorDePasswords {

    public static int validarRobustez(String password) throws IOException {
        
        if (password.length() <= 12 ){
            return CodigoDeError.E_POCOS_CARACTERES;
        }
        String mayuscula = "(.*[A-Z].*)";
        if (!password.matches(mayuscula)){
            return CodigoDeError.E_MAYUSCULAS;
        }
        String minuscula = "(.*[a-z].*)";
        if (!password.matches(minuscula)){
            return CodigoDeError.E_MINUSCULAS;
        }
        String numeros = "(.*[0-9].*)";
        if (!password.matches(numeros)){
            return CodigoDeError.E_NUMERO;
        }
        String caracteresEspeciales = "(.*[@#$%].*$)";
        if (!password.matches(caracteresEspeciales)){
            return CodigoDeError.E_CARACTER_ESPECIAL;
        }

        URL passComunes = new URL("https://raw.githubusercontent.com/OWASP/passfault/master/wordlists/wordlists/10k-worst-passwords.txt");
        try(Scanner buscadorDePass = new Scanner(passComunes.openStream())) {
            while(buscadorDePass.hasNextLine()) {
                String passEncontrada = buscadorDePass.nextLine();
                if(Objects.equals(passEncontrada, password)) {
                    return CodigoDeError.E_CONTRASENA_DEBIL;
                }
            }
        }
        catch (IOException e){
            return CodigoDeError.E_RECURSO;
        }

        return CodigoDeError.EXITO;


    }

}
