package Ranking;

import java.util.List;

public abstract class TipoDeRanking {

    public abstract List<InformeIncidente> generarRanking(List<InformeIncidente> listaInformes);
}
