import java.io.*;
import java.net.*;
import java.util.Objects;
import java.util.Scanner;
public class validadorDePasswords {

    public boolean validarRobustez(String password) throws IOException {
        boolean esRobusta = true;
        if (password.length() >= 12 )
        {
            System.out.println("La password debe tener mas de 12 caracteres");
            esRobusta = false;
        }
        String mayuscula = "(.*[A-Z].*)";
        if (!password.matches(mayuscula))
        {
            System.out.println("La password debe tener al menos un caracter en mayuscula");
            esRobusta = false;
        }
        String minuscula = "(.*[a-z].*)";
        if (!password.matches(minuscula))
        {
            System.out.println("La password debe tener al menos un caracter en minuscula");
            esRobusta = false;
        }
        String numeros = "(.*[0-9].*)";
        if (!password.matches(numeros))
        {
            System.out.println("La password debe tener al menos un numero");
            esRobusta = false;
        }
        String caracteresEspeciales = "(.*[@#$%].*$)";
        if (!password.matches(caracteresEspeciales))
        {
            System.out.println("La password debe tener al menos alguno de los siguientes caracteres: @#$%");
            esRobusta = false;
        }

            URL passComunes = new URL("https://raw.githubusercontent.com/OWASP/passfault/master/wordlists/wordlists/10k-worst-passwords.txt");
            Scanner buscadorDePass = new Scanner(passComunes.openStream());
            while(buscadorDePass.hasNextLine()) {
            String passEncontrada = buscadorDePass.nextLine();
            if(Objects.equals(passEncontrada, password)) {
                System.out.println("La password es demasiado comun");
                esRobusta = false;
            }
            }
        return esRobusta;

    }

}
