package presentacion.controllers;

import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;
import io.javalin.http.Context;
import dominio.usuariosycomunidades.UsuarioGeneral;

public abstract class Controller implements WithSimplePersistenceUnit {

    protected UsuarioGeneral usuarioLogueado(Context ctx) {
        if(ctx.sessionAttribute("usuario_id") == null)
            return null;
        return entityManager()
                .find(UsuarioGeneral.class, Long.parseLong(ctx.sessionAttribute("usuario_id")));
    }
}