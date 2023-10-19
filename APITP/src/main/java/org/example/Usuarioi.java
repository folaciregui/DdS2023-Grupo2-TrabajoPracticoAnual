package org.example;

public class Usuarioi {
    private int usuario;
    //agregamos lista de incidentes
    private NivelConfianza nivelConfianza = new NivelConfianza();
    private List<Incidente> actividadIncidentes;

    //hacer builder o inicializar
    public void actualizar_puntos(double puntos){
        nivelConfianza.calcularpuntos(puntos);
    }
    public void setNivelConfianza(NivelConfianza nivelConfianza) {
        this.nivelConfianza = nivelConfianza;

    public NivelConfianza getNivelConfianza() {
        return nivelConfianza;
    }
}
