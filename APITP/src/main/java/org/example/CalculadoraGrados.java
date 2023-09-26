package org.example;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class CalculadoraGrados {
    private List<Incidente> repoIncidentes;
    private List<Usuario> repoUsuarios;
    private List<Comunidad> repoComunidad;
    private Usuario usuarioAnalizado;

    public void aperturaFraudulenta(){
        for (Incidente incidente : repoIncidentes) {
            if(incidente.tiempoAbiertoMenorA(180) && incidente.mismoCreadorCerrador()){
                usuarioAnalizado = incidente.getUsuarioCerrador();
                usuarioAnalizado.actualizar_puntos(-0.2);
                usuarioAnalizado.setMalandra(true);
            }
            if(usuarioAnalizado.isMalandra()){
                usuarioAnalizado.setMalandra(false);
            } else {
                usuarioAnalizado.actualizar_puntos(0.5);
            }
        }
    }
    public void cierreFraudulento(){
        //analizar cierre de los incidentes del usuario
        // buscar monitoreable
        // analizar incidentes del monitoreable con 3minutos de apertura de diferencia
        // restar puntos
        for (Usuario unUsuario : repoUsuarios) {
            List<Incidente> incidentesCerrados = unUsuario.getActividadIncidentes().stream().filter(incidente -> incidente.getEstaCerrado()).toList();
            for (Incidente incidenteAnalizado : incidentesCerrados) {
                Monitoreable monitoreable = incidenteAnalizado.getMonitoreable();
                for (Incidente otroIncidente: monitoreable.getIncidentes()){
                    if((this.comparacionTiempoIncidentes(incidenteAnalizado, otroIncidente, 180))){
                        unUsuario.actualizar_puntos(-0.2);
                        unUsuario.setMalandra(true);
    //                    return; puede o no ir para que no le saquen por cada apertura de incidente similar
                    }
                }
                if(unUsuario.isMalandra()){
                    unUsuario.setMalandra(false);
                } else{
                    unUsuario.actualizar_puntos(0.5);
                }

            }
        }

    }
    public void puntuarComunidad(){
        for(Comunidad comunidadAnalizada : repoComunidad){
            double promedio =0;
            for (Usuario usuario : comunidadAnalizada.getUsuarios()) {
                promedio += usuario.getNivelConfianza().getNivelNumerico();
            }
            promedio /=comunidadAnalizada.getUsuarios().size();
        }
    }
    public void actualizacionSemanal(){
        this.aperturaFraudulenta();
        this.cierreFraudulento();
        this.puntuarComunidad();
    }
    public boolean comparacionTiempoIncidentes(Incidente incidenteUno,Incidente incidenteDos, double segundos){
        LocalDateTime cierreUno = incidenteUno.getFechaCierre();
        LocalDateTime aperturaDos = incidenteDos.getFechaInicio();
        return Duration.between(aperturaDos,cierreUno).getSeconds() < segundos;
    }
}