import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Ingrese nombre de usuario:"); 
            String usuario = scanner.nextLine();
            System.out.println("Ingrese contraseña:"); 
            String contraseña = scanner.nextLine();
            int resultado = validadorDePasswords.validarRobustez(contraseña);
            String error = MensajeDeError.convertirCodigoDeError(resultado);
            
            System.out.println("Resultado de la validación: " + error);
        }

    
    }
}



