import java.io.FileInputStream;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;

public class FirebaseAuthentication {
    public static void main(String[] args) {
        String currentWorkingDir = System.getProperty("user.dir");
        String pathToCredentials = currentWorkingDir + "/DdS2023-Grupo2-TrabajoPracticoAnual/ENTREGA 3/config/config-file.json";

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(new FileInputStream(pathToCredentials)))
                .setDatabaseUrl("https://tp-dds-sistema-monitoreo.firebaseio.com")
                .build();
    //inicializa la configuracion para firebase
        FirebaseApp.initializeApp(options);
    }

    // Método para autenticar al usuario utilizando el token de Firebase ID
    public static void authenticateUser(String idToken) {
        try {
            FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(idToken);
            String uid = decodedToken.getUid();
            // El usuario es autenticado con éxito, manejar esa info aca
        } catch (FirebaseAuthException e) {
            // La autenticación fallo, manejar el error aca
            e.printStackTrace();
        }
    }
}

