package dominio.usuariosycomunidades;

import io.javalin.security.RouteRole;

public enum TipoRol implements RouteRole {
    ADMINISTRADOR,
    NORMAL,
}