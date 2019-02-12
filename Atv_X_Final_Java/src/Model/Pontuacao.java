package Model;

public class Pontuacao {

    private int idJogador;
    private int pontos;

    public Pontuacao(int nomeJogador, int pontos) {
        this.idJogador = nomeJogador;
        this.pontos = pontos;
    }

    public int getIdJogador() {
        return idJogador;
    }

    public int getPontos() {
        return pontos;
    }
}
