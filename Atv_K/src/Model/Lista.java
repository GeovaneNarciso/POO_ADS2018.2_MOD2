package Model;

import java.util.ArrayList;

public class Lista {
    private String titulo;
    private boolean arquivada = false;
    private ArrayList<Cartao> cartoes = new ArrayList<>();

    public Lista(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public ArrayList<Cartao> getCartoes() {
        return cartoes;
    }

    public boolean estaArquivada() {
        return arquivada;
    }

    public void setArquivada(boolean arquivada) {
        this.arquivada = arquivada;
    }
}
