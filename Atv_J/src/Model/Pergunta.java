package Model;

import java.util.ArrayList;

public class Pergunta {
    private String titulo;
    private boolean obrigatoria;
    private ArrayList<Opcao> opcoes = new ArrayList<>();

    public Pergunta(String titulo, boolean obrigatoria, ArrayList<String> opcoes){
        this.titulo = titulo;
        this.obrigatoria = obrigatoria;
        for(String op : opcoes){
            this.opcoes.add(new Opcao(op));
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean ehObrigatoria() {
        return obrigatoria;
    }

    public ArrayList<Opcao> getOpcoes() {
        return opcoes;
    }
}
