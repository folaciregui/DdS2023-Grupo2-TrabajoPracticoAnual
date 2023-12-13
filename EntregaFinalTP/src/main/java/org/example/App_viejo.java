package org.example;

//import dominio.Alumno;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;

public class App_viejo implements WithSimplePersistenceUnit {

    public static void main(String[] args) {
        new App_viejo().start();
    }

    private void start(){
        System.out.println("START");
    }

    // PRUEBAS CON ALUMNO
    /*
    private void recuperarTodos(){
        List<Alumno> alumnos = entityManager().createQuery("from " + Alumno.class.getName()).getResultList();

        List<String> nombres = alumnos.stream()
                .map(Alumno::getNombre)  // Utiliza el método getNombre para extraer el atributo nombre
                .collect(Collectors.toList());

        // Imprime los nombres
        System.out.println(nombres);
    }

    private void recuperarAlumnoPorNombre(){
        Alumno unAlumno = (Alumno) entityManager()
                .createQuery("from " + Alumno.class.getName() + " where nombre = :nombre")
                .setParameter("nombre", "juan jo")
                .getSingleResult();
        System.out.println(unAlumno.getNombre()); // si estoy segura que es un unico resultado
    }
    private void recuperarAlumnoPorId(){
        Alumno alumno = entityManager().find(Alumno.class, 1);
        System.out.println(alumno.getNombre());
    }

    private Alumno recuperarAlumnoPorId(Integer id){
        Alumno alumno = entityManager().find(Alumno.class, id);
        System.out.println(alumno.getNombre());
        return alumno;
    }

    private void guardarAlumno(){
        Alumno unAlumno = new Alumno();
        unAlumno.setNombre("maria");
        unAlumno.setPromedio(8);

        EntityTransaction tx = entityManager().getTransaction();
        tx.begin();
        entityManager().persist(unAlumno); // INSERT INTO ...
        tx.commit();
    }

    private void modificarAlumno(){
        EntityTransaction tx = entityManager().getTransaction();
        tx.begin();

        Alumno alumnoAModificar = recuperarAlumnoPorId(1);

        if (alumnoAModificar != null) {

            alumnoAModificar.setNombre("Juan Jose");

            entityManager().merge(alumnoAModificar); // UPDATE...
            tx.commit();
        } else {
            System.out.println("Alumno con ID 1 no encontrado");
            tx.rollback();
        }
    }

    public void eliminarAlumnoPorId(int id) {
        EntityTransaction tx = entityManager().getTransaction();
        tx.begin();

        // Recupera el alumno por su ID
        Alumno alumnoAEliminar = entityManager().find(Alumno.class, id);

        // Verifica si se encontró el alumno
        if (alumnoAEliminar != null) {
            // Elimina el alumno
            entityManager().remove(alumnoAEliminar);
            tx.commit();
        } else {
            System.out.println("Alumno con ID " + id + " no encontrado");
            tx.rollback();
        }
    }*/
}

