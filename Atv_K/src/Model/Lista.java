package Model;

import java.util.ArrayList;

public class Lista {
    private String titulo;
    private ArrayList<Cartao> cartoes = new ArrayList<>();

    public Lista(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }
}
