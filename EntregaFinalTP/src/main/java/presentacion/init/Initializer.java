package presentacion.init;

import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;


public class Initializer implements WithSimplePersistenceUnit {

    public static void init() {
        new Initializer()
                .iniciarTransaccion()
                //.permisos()
                //.roles()
                .commitearTransaccion();
    }

    private Initializer iniciarTransaccion() {
        entityManager().getTransaction().begin();
        return this;
    }

    private Initializer commitearTransaccion() {
        entityManager().getTransaction().commit();
        return this;
    }

    /*
    private Initializer permisos() {
        String[][] permisos = {
                { "Ver servicios", "ver_servicios" },
                { "Crear servicios", "crear_servicios" },
                { "Editar servicios", "editar_servicios" },
                { "Eliminar servicios", "eliminar_servicios" },
        };

        for(String[] unPermiso: permisos) {
            Permiso permiso = new Permiso();
            permiso.setNombre(unPermiso[0]);
            permiso.setNombreInterno(unPermiso[1]);
            entityManager().persist(permiso);
        }

        return this;
    }

    private interface BuscadorDePermisos extends WithSimplePersistenceUnit{
        default Permiso buscarPermisoPorNombre(String nombre) {
            return (Permiso) entityManager()
                    .createQuery("from " + Permiso.class.getName() + " where nombreInterno = :nombre")
                    .setParameter("nombre", nombre)
                    .getSingleResult();
        }
    }

    private Initializer roles() {
        BuscadorDePermisos buscadorDePermisos = new BuscadorDePermisos() {};

        Rol administrador = new Rol();
        administrador.setNombre("Administrador");
        administrador.setTipo(TipoRol.ADMINISTRADOR);
        administrador.agregarPermisos(
                buscadorDePermisos.buscarPermisoPorNombre("crear_servicios")
        );
        entityManager().persist(administrador);

        Rol consumidor = new Rol();
        consumidor.setNombre("Consumidor");
        consumidor.setTipo(TipoRol.NORMAL);
        consumidor.agregarPermisos(
                buscadorDePermisos.buscarPermisoPorNombre("ver_servicios")
        );
        entityManager().persist(consumidor);

        Rol prestador = new Rol();
        prestador.setNombre("Prestador");
        prestador.setTipo(TipoRol.NORMAL);
        prestador.agregarPermisos(
                buscadorDePermisos.buscarPermisoPorNombre("ver_servicios")
        );
        entityManager().persist(prestador);

        return this;
    }*/
}