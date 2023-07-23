package Ranking;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class RankingDePromedios extends TipoDeRanking{
    @Override
    public List<InformeIncidente> generarRanking(List<InformeIncidente> listaInformes){
      
        List<IncidenteInactivo> listaIncidentesInactivos = listaInformes.stream()
            .map(InformeIncidente::getEntidadAsociada) // Obtener la entidad asociada de cada informe
            .flatMap(entidad -> entidad.getMonitoreables().stream()) // Obtener todas las listas de monitoreables y combinarlas en una sola lista
            .flatMap(monitoreable -> monitoreable.getIncidentesInactivos().stream()) // Obtener todos los incidentes inactivos y combinarlos en una sola lista
            .collect(Collectors.toList()); // Recolectar en una lista
        // Lista con todos los incidentes inactivos asociado a cada una de las entidades

        // calculo del promedio de diferencia en minutos por entidad
        for (Entidad entidad : listaIncidentesInactivos) {
            List<IncidenteInactivo> incidentesInactivosEntidad = entidad.getIncidentesInactivos();
            int totalDiferenciaEnMinutos = 0;

            for (IncidenteInactivo incidente : incidentesInactivosEntidad) {
                LocalDateTime fechaInicio = incidente.getFechaInicio();
                LocalDateTime fechaCierre = incidente.getFechaCierre();

                long diferenciaEnMinutos = fechaInicio.until(fechaCierre, ChronoUnit.MINUTES);
                totalDiferenciaEnMinutos += diferenciaEnMinutos;
            }

            double promedioDiferenciaEnMinutos = totalDiferenciaEnMinutos / (double) incidentesInactivosEntidad.size();
            entidad.setPromedioCierreIncidentes(promedioDiferenciaEnMinutos);
        } //cada entidad tiene el promedio asociado

         // Ahora para ordenar la lista de informes según el promedio 
        Collections.sort(listaInformes, new Comparator<InformeIncidente>() {
            @Override
            public int compare(InformeIncidente informe1, InformeIncidente informe2) {
                // Comparar los informes según el promedio 
                double promedio1 = informe1.getEntidadAsociada().getPromedioCierreIncidentes();
                double promedio2 = informe2.getEntidadAsociada().getPromedioCierreIncidentes();
                return Double.compare(promedio2, promedio1);
            }
        });

        return listaInformes;
    }

}

  


// Ahora, listaInformes contiene los informes ordenados por su promedio de diferencia en minutos en orden descendente


   
        


   
