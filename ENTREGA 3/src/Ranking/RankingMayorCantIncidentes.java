package Ranking;

import EntidadesYEstablecimientos.Entidad;
import Servicios.Estado;
import Servicios.Incidente;
import Servicios.Monitoreable;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class RankingMayorCantIncidentes extends TipoDeRanking {

    @Override
    public List<InformeIncidente> generarRanking(List<InformeIncidente> listaInformes) { //no se si esto no deberia ser de tipo List<Entidad>
        List<Entidad> entidades = listaInformes.stream().map(InformeIncidente::getEntidadAsociada).collect(Collectors.toList()); //lista de entidades a rankear
        for (Entidad entidadEvaluada :entidades) {
            int cantidadIncidentesValidosEntidad = 0;
            List<Monitoreable> monitoreables = entidadEvaluada.getMonitoreables();
            for (Monitoreable monitoreable : monitoreables){
                List<Incidente> incidentesMonitoreable = new ArrayList<>();
                List<Incidente> incidentes = monitoreable.getIncidentesTotales();
                for (Incidente incidente : incidentes){
                    if (incidentesMonitoreable.isEmpty()){
                        incidentesMonitoreable.add(incidente);
                    } else{
                        LocalDateTime inicioIncidenteIngresante = incidente.getFechaInicio();
                        if (incidentesMonitoreable.stream().noneMatch(incidenteAgregado -> incidenteAgregado.getEstado().equals(Estado.ABIERTO) && 24<this.calculadoraDiferencia(inicioIncidenteIngresante,incidenteAgregado.getFechaInicio()))){
                            incidentesMonitoreable.add(incidente);
                        }
                    }
                }
                cantidadIncidentesValidosEntidad =cantidadIncidentesValidosEntidad + incidentesMonitoreable.size();
            }
            entidadEvaluada.setCantidadIncidentes(cantidadIncidentesValidosEntidad);
        }
        listaInformes.sort((informe1, informe2) -> {
            // Comparar los informes según el promedio
            Integer cantidadIncidentesUno = informe1.getEntidadAsociada().getCantidadIncidentes();
            Integer cantidadIncidentesDos = informe2.getEntidadAsociada().getCantidadIncidentes();
            return Integer.compare(cantidadIncidentesDos, cantidadIncidentesUno);
        });
        return listaInformes;
    }
    public long calculadoraDiferencia(LocalDateTime tiempoIngresante, LocalDateTime tiempoIngresadoAlready){ //no creo que corresponda tenerlo aca, despues vemos donde meterlo
        return ChronoUnit.HOURS.between(tiempoIngresante, tiempoIngresadoAlready);
    }
}
