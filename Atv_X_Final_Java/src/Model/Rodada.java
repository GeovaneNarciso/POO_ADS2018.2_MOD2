package Model;

public class Rodada {
    private int tempo;
    private char letraSorteada;
    private Pontuacao pontoParcial;

    public Rodada(int tempo, char letraSorteada, Pontuacao pontoParcial) {
        this.tempo = tempo;
        this.letraSorteada = letraSorteada;
        this.pontoParcial = pontoParcial;
    }

    public int getTempo() {
        return tempo;
    }

    public char getLetraSorteada() {
        return letraSorteada;
    }

    public Pontuacao getPontoParcial() {
        return pontoParcial;
    }
}
