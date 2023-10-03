package com.example.hibernate.dominio;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.example.hibernate.persistencia.RepoComunidades;
import com.example.hibernate.persistencia.RepoIncidentes;
import com.example.hibernate.persistencia.RepoUsuarios;

import static com.example.hibernate.dominio.ClasificacionConfianza.*;

public class CalculadoraGrados {

    private static RepoIncidentes repoIncidentes;
    private static RepoUsuarios repoUsuarios;
    private List<Comunidad> repoComunidad;
    private Usuario usuarioAnalizado;

    public static NivelConfianza calcularGradoDeConfianzaUsuario(int idUsuario) {
        List<Incidente> incidentes = repoIncidentes.obtenerIncidentesPorUsuario(idUsuario);

        NivelConfianza nivel = new NivelConfianza();
        double gradoDeConfianza = 5.0; // deberia estar inicializado afuera capaz
        boolean debeInactivarse = false;

        LocalDateTime horaActual = LocalDateTime.now();

        // Apertura fraudulenta
        for (Incidente incidente : incidentes) {
            LocalDateTime apertura = incidente.getFechaInicio();
            LocalDateTime cierre = incidente.getFechaCierre();

            long duracionEnMinutos = Duration.between(apertura, cierre).toMinutes();

            if (duracionEnMinutos < 3) {
                gradoDeConfianza -= 0.2;
            }
        }

        // El usuario abrio o cerro algún incidente
        if (haRealizadoAccionesEstaSemana(idUsuario)) {
            gradoDeConfianza += 0.5;
        }

        nivel.setNivelNumerico(gradoDeConfianza);

        if(gradoDeConfianza < 2){
            nivel.setClasificacion(NOCONFIABLE);
            debeInactivarse = true;
        } else if (gradoDeConfianza >= 2 || gradoDeConfianza <= 3) {
            nivel.setClasificacion(CONRESERVAS);
        } else if (gradoDeConfianza > 3 || gradoDeConfianza <= 5) {
            nivel.setClasificacion(CONFIABLENIVEL1);
        } else if (gradoDeConfianza > 5) {
            nivel.setClasificacion(CONFIABLENIVEL2);
        }

        // encontrar el usuario y setearle el valor

        return nivel;

    }

    private static boolean haRealizadoAccionesEstaSemana(int idUsuario) {
        LocalDateTime fechaActual = LocalDateTime.now();

        LocalDateTime inicioSemana = fechaActual.with(DayOfWeek.SUNDAY);

        LocalDateTime finSemana = fechaActual.with(DayOfWeek.SATURDAY);

        Usuario usuarioAnalizado = repoUsuarios.getUsuario(idUsuario);

        List<Incidente> listaIncidentes = usuarioAnalizado.getActividadIncidentes();

        if(!listaIncidentes.isEmpty()){
            return true;
        }else {
            return false;
        }

    }

    public static NivelConfianza calcularGradoDeConfianzaComunidad(int idComunidad) {
        List<Usuario> usuarios = repoUsuarios.obtenerUsuariosPorComunidad(idComunidad);

        double sumaGrados = 0.0;
        int totalUsuarios = usuarios.size();
        boolean debeInactivarse = false;

        NivelConfianza gradoUsuario;
        for (Usuario usuario : usuarios) {
            gradoUsuario = calcularGradoDeConfianzaUsuario(usuario.getId());
            sumaGrados += gradoUsuario.getNivelNumerico();
        }

        double promedio = sumaGrados / totalUsuarios;

        int usuariosConReservas = contarUsuariosConReservas(usuarios);
        NivelConfianza gradoComunidad = new NivelConfianza();
        double valor = promedio - (0.2 * usuariosConReservas);
        gradoComunidad.setNivelNumerico(valor);

        if(valor < 2){
            gradoComunidad.setClasificacion(NOCONFIABLE);
            debeInactivarse = true;
        } else if (valor >= 2 || valor <= 3) {
            gradoComunidad.setClasificacion(CONRESERVAS);
        } else if (valor > 3 || valor <= 5) {
            gradoComunidad.setClasificacion(CONFIABLENIVEL1);
        } else if (valor > 5) {
            gradoComunidad.setClasificacion(CONFIABLENIVEL2);
        }

        return gradoComunidad;
    }

    private static int contarUsuariosConReservas(List<Usuario> usuarios) {
        int count = 0;
        for (Usuario usuario : usuarios) {
            if (usuario.getNivelConfianza().getNivelNumerico() <= 3.0) {
                count++;
            }
        }
        return count;
    }


    public List<Incidente> getRepoIncidentes() {
        return (List<Incidente>) repoIncidentes;
    }

    public void setRepoIncidentes(List<Incidente> repoIncidentes) {
        this.repoIncidentes = (RepoIncidentes) repoIncidentes;
    }

    public List<Usuario> getRepoUsuarios() {
        return (List<Usuario>) repoUsuarios;
    }

    public void setRepoUsuarios(List<Usuario> repoUsuarios) {
        this.repoUsuarios = (RepoUsuarios) repoUsuarios;
    }

    public List<Comunidad> getRepoComunidad() {
        return repoComunidad;
    }

    public void setRepoComunidad(List<Comunidad> repoComunidad) {
        this.repoComunidad = repoComunidad;
    }

    public Usuario getUsuarioAnalizado() {
        return usuarioAnalizado;
    }

    public void setUsuarioAnalizado(Usuario usuarioAnalizado) {
        this.usuarioAnalizado = usuarioAnalizado;
    }


    /*
    public void aperturaFraudulenta(){
        for (Incidente incidente : repoIncidentes) {
            if(incidente.tiempoAbiertoMenorA(180) && incidente.mismoCreadorCerrador()){
                this.setUsuarioAnalizado(incidente.getUsuarioCerrador());
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
            List<Incidente> incidentesCerrados = unUsuario.getActividadIncidentes().stream().filter(incidente -> incidente.getEstaCerrado()).collect(Collectors.toList());

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
    */
}