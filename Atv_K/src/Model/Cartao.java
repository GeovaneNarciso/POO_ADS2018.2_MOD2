package Model;

import java.util.ArrayList;

public class Cartao {
    private String titulo;
    private ArrayList<String> etiquetas = new ArrayList<>();
    private ArrayList<String> comentarios = new ArrayList<>();

    public Cartao(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public ArrayList<String> getEtiquetas() {
        return etiquetas;
    }

    public ArrayList<String> getComentarios() {
        return comentarios;
    }
}
