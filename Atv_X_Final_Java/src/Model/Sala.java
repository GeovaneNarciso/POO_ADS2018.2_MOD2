package Model;

import java.util.ArrayList;
import java.util.List;

public class Sala {
    private static int idEstatico = 200;
    private String id;
    private int maxRodadas;
    private int maxJogadores;
    private List<Usuario> jogadores = new ArrayList<>();
    private List categorias = new ArrayList();
    private Partida partida;

    public Sala(int maxRodadas, int maxJogadores) {
        Sala.idEstatico += 1;
        this.id = Integer.toString(idEstatico);
        this.maxRodadas = maxRodadas;
        this.maxJogadores = maxJogadores;
    }

    public String getId() {
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

    public List<Usuario> getJogadores() {
        return jogadores;
    }

    public List getCategorias() {
        return categorias;
    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }

    public boolean addJogador(Usuario jogador) {
        if (jogadores.size() != maxJogadores) {
            this.jogadores.add(jogador);
            return true;
        }else
            return false;
    }
}
