package Ranking;

import java.util.List;

public class RankingsIncidente {
    private List<InformeIncidente> informes;
    private TipoDeRanking tipoDeRanking;

    public void generarSegunCriterio(){
        //void???
        tipoDeRanking.generarRanking(informes);
    }
}
