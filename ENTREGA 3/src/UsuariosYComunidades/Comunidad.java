package UsuariosYComunidades;

public class Comunidad {
    private List<Membresia> miembros;
    private List<Incidente> incidentesNotificables;
    
    public void alta(Membresia unMiembro){
        //toDO
    }

    public void baja(Membresia unMiembro){
        miembros.remove(unMiembro);
    }

    public void modificacion(){
        // no hay suficiente informacion
    }

    public void sugerirRevision(){
        //toDO con Hasura
    }

    public void notificarMiembros(){
        // toDo no es requerimiento entrega3
    }

    public void actualizarIncidentesNotificables(){
        //toDO no es requerimiento entrega3
    }
}
