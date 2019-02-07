package Model;

import java.util.ArrayList;
import java.util.List;

public class Partida {
    private ArrayList jogadores;
    private List<Pontuacao> ranking = new ArrayList<>();
    private Rodada rodada;

    public Partida(ArrayList jogadores, Rodada rodada) {
        this.jogadores = jogadores;
        this.rodada = rodada;
    }

    public ArrayList getJogadores() {
        return jogadores;
    }

    public List<Pontuacao> getRanking() {
        return ranking;
    }

    public Rodada getRodada() {
        return rodada;
    }
}
