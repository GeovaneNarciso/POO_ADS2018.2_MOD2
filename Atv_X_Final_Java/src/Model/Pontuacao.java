package Model;

public class Pontuacao {

    private String nomeJogador;
    private int pontos;

    public Pontuacao(String nomeJogador, int pontos) {
        this.nomeJogador = nomeJogador;
        this.pontos = pontos;
    }

    public String getNomeJogador() {
        return nomeJogador;
    }

    public int getPontos() {
        return pontos;
    }
}
