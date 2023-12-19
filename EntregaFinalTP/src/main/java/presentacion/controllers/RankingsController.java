package presentacion.controllers;

import dominio.rankings.RankingsIncidente;
import dominio.rankings.TipoDeRanking;
import dominio.servicios.Incidente;
import io.javalin.http.Context;
import persistencia.repositories.RepositorioRankings;
import presentacion.handlers.ICrudViewsHandler;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class RankingsController extends Controller implements ICrudViewsHandler {

    private RepositorioRankings repositorioRankings = null;

    public RankingsController(RepositorioRankings repositorioRankings){
        this.repositorioRankings = repositorioRankings;
    }

    public void filtrarRankings(Context context) throws Exception {
        String tipoDeRankingString = context.formParam("tipoDeRanking");
        //TipoDeRanking tipoDeRanking = TipoDeRanking.valueOf(tipoDeRankingString);

        List<RankingsIncidente> rankings = this.repositorioRankings.buscarTodos();

        List<RankingsIncidente> rankingsFiltrados = rankings.stream()
                .filter(ranking -> ranking.getTipoDeRanking().name().equals(tipoDeRankingString))
                .collect(Collectors.toList());

        ordenarPorPosicion(rankingsFiltrados);
        ordenarPorFecha(rankingsFiltrados);

        Map<String, Object> model = new HashMap<>();
        model.put("rankingsFiltrados", rankingsFiltrados);
        context.render("rankingsFiltrados.hbs", model);
    }

    private void ordenarPorPosicion(List<RankingsIncidente> rankingsFiltrados) {
        Comparator<RankingsIncidente> comparadorPorPosicion = Comparator.comparingInt(RankingsIncidente::getPosicion);

        rankingsFiltrados.sort(comparadorPorPosicion);
    }

    private void ordenarPorFecha(List<RankingsIncidente> rankingsFiltrados) {
        Comparator<RankingsIncidente> comparadorPorFecha = Comparator.comparing(RankingsIncidente::getFecha);

        rankingsFiltrados.sort(comparadorPorFecha);
    }

    @Override
    public void index(Context context) {

    }

    @Override
    public void show(Context context) {

    }

    @Override
    public void create(Context context) {

    }

    @Override
    public void save(Context context) {

    }

    @Override
    public void edit(Context context) {

    }

    @Override
    public void update(Context context) {

    }

    @Override
    public void delete(Context context) {

    }


}
