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

    public String perguntaToString() {
        int num = 1;
        String perguntaToString = " --- " + this.titulo + "\n";
        for(Opcao o : opcoes) {
            perguntaToString += num + " - " + o.getDescricao() + "\n";
            num += 1;
        }
        if(!obrigatoria)
            perguntaToString += "0 - Branco.";
        return perguntaToString;
    }
}
