package presentacion.handlers;

import dominio.rankings.RankingsIncidente;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;
import persistencia.repositories.RepositorioRankings;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GetRankingsHandler implements Handler {

    private RepositorioRankings repositorioRankings;

    public GetRankingsHandler(){
        this.repositorioRankings = new RepositorioRankings();
    }


    @Override
    public void handle(@NotNull Context context) throws Exception {
        String tipoDeRankingString = context.pathParam("tipoDeRanking");

        List<RankingsIncidente> rankings = this.repositorioRankings.buscarTodos();

        //System.out.println(tipoDeRankingString);

        List<RankingsIncidente> rankingsFiltradoss = rankings.stream()
                .filter(ranking -> ranking.getTipoDeRanking().name().equals(tipoDeRankingString))
                .collect(Collectors.toList());

        //System.out.println("la lista tiene " + rankingsFiltrados.size() + " rankings");

        context.json(rankingsFiltradoss);
    }
}
