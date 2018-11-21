package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public List<Cartao> getCartoes() {
        return Collections.unmodifiableList(cartoes);
    }

    public boolean estaArquivada() {
        return arquivada;
    }

    public void setArquivada(boolean arquivada) {
        this.arquivada = arquivada;
    }

    public void addCartao(String titulo) {
        this.cartoes.add(new Cartao(titulo));
    }

    public void rmCartao(int indexC) {
        this.cartoes.remove(indexC);
    }
}
