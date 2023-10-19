package org.example;

public class CalculadoraGrados {
    private List<Incidente> repoIncidentes;
    private List<Usuarioi> repoUsuarios;
    private List<Comunidad> repoComunidad;
    private Usuarioi usuarioAnalizado;

    public void aperturaFraudulenta(){
        for (Incidente incidente : repoIncidentes) {
            if(incidente.tiempoAbiertoMenorA(180) && incidente.mismoCreadorCerrador()){
                usuarioAnalizado = incidente.getUsuarioCerrador()
                usuarioAnalizado.actualizar_puntos(-0.2);
            }
        }
    }
    public void cierreFraudulento(){
        //analizar cierre de los incidentes del usuario
        // buscar monitoreable
        // analizar incidentes del monitoreable con 3minutos de apertura de diferencia
        // restar puntos
        for (Usuario unUsuario : repoUsuarios) {
            for (Usuario unUsuario : unUsuario) {

            }
        }

    }

}