package controllers;

import java.util.Arrays;
import io.javalin.http.Context;
import java.util.List;

public class EntidadController {

    public static void getEntidades(Context ctx) {
        // Lógica para obtener las entidades desde tu backend
        // Por ejemplo:
        List<String> listaDeEntidades = obtenerListaDeEntidades();

        // Devolver las entidades como JSON
        ctx.json(listaDeEntidades);
    }

    private static List<String> obtenerListaDeEntidades() {
        // Lógica para obtener las entidades desde tu base de datos o en memoria
        // Por ejemplo:
        return List.of("Entidad1", "Entidad2", "Entidad3");
    }
}

