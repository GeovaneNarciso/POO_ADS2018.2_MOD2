package Model;

import java.util.ArrayList;
import java.util.List;

public class Sala {
    private static int idEstatico = 200;
    private int id;
    private int maxRodadas;
    private int maxJogadores;
    private Jogador dono;
    private List<Jogador> jogadores = new ArrayList<>();
    private ArrayList categorias;
    private Partida partida;

    public Sala(Jogador dono, int maxRodadas, int maxJogadores, int tempoRodada, ArrayList categorias) {
        Sala.idEstatico += 1;
        this.id = idEstatico;
        this.maxRodadas = maxRodadas;
        this.maxJogadores = maxJogadores;
        this.dono = dono;
        this.jogadores.add(dono);
        this.categorias = categorias;
    }

    public int getId() {
        return id;
    }

    public int getMaxRodadas() {
        return maxRodadas;
    }

    public void setMaxRodadas(int maxRodadas) {
        this.maxRodadas = maxRodadas;
    }

    public int getMaxJogadores() {
        return maxJogadores;
    }

    public void setMaxJogadores(int maxJogadores) {
        this.maxJogadores = maxJogadores;
    }

    public Jogador getDono() {
        return dono;
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public ArrayList getCategorias() {
        return categorias;
    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }

    public boolean addJogador(Jogador jogador) {
        if (jogadores.size() != maxJogadores) {
            this.jogadores.add(jogador);
            return true;
        }else
            return false;
    }

}
